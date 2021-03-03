package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.*;
import com.hh.his.graduationproject.model.dto.BedUpdateDTO;
import com.hh.his.graduationproject.model.dto.WardUpdateDTO;
import com.hh.his.graduationproject.model.entity.Cost;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.model.vo.condition.AdviceConditionVO;
import com.hh.his.graduationproject.model.vo.condition.AdviceExecuteConditionVO;
import com.hh.his.graduationproject.model.vo.condition.AdviceReviewConditionVO;
import com.hh.his.graduationproject.model.vo.condition.InpatientInformationConditionVO;
import com.hh.his.graduationproject.service.MedicalAdviceService;
import com.hh.his.graduationproject.utils.bean.CostConverter;
import com.hh.his.graduationproject.utils.bean.DrugConverter;
import com.hh.his.graduationproject.utils.bean.InpatientInformationConverter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class MedicalAdviceServiceImpl implements MedicalAdviceService {

    @Autowired
    private MedicalAdviceMapper adviceMapper;

    @Autowired
    private DrugApplicationMapper drugApplicationMapper;

    @Autowired
    private CostMapper costMapper;

    @Autowired
    private InpatientInformationMapper informationMapper;

    @Autowired
    private BedMapper bedMapper;

    @Autowired
    private InpatientWardMapper wardMapper;

    @Autowired
    private LeaveRecordMapper leaveRecordMapper;

    @Override
    public PageInfo<MedicalAdviceQueryVO> getByUsername(Integer pageNum,AdviceConditionVO conditionVO) {
        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("madv_start_date desc");
        List<MedicalAdviceQueryVO> medicalAdviceQueryVOS = adviceMapper.selectByUsername(conditionVO);
        PageInfo pageInfo = new PageInfo(medicalAdviceQueryVOS);
        return pageInfo;
    }

    @Override
    public PageInfo findAdmissionByConditions(Integer pageNum, InpatientInformationConditionVO conditionVO) {
        List<InpatientInformation> inpatientInformations = informationMapper.selectAdmissionByConditions4(conditionVO);
        PageInfo<InpatientInformation> page1 = new PageInfo<>(inpatientInformations);
        long total = page1.getTotal();

        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("ii_date_admission desc");
        List<InpatientInformation> ii = informationMapper.selectAdmissionByConditions4(conditionVO);
        List<InpatientInformationVO> all = InpatientInformationConverter.INSTANCE.doToVoList(ii);
        PageInfo<InpatientInformationVO> page2 = new PageInfo(all);
        page2.setTotal(total);

        return page2;
    }

    @Override
    public int saveAdvice(List<MedicalAdviceVO> medicalAdvice) throws Exception {

        int i = adviceMapper.insertBatch(0, medicalAdvice);
        return i;
    }

    @Override
    public int sentAdvice(List<MedicalAdviceVO> medicalAdvice) throws Exception {

        Iterator<MedicalAdviceVO> iterator = medicalAdvice.iterator();
        while (iterator.hasNext()){
            iterator.next().setMadvSentTime(new Date());
        }
        int i = adviceMapper.insertBatch(1, medicalAdvice);
        return i;
    }

    @Override
    public int updateStatus(Integer status,List<MedicalAdviceQueryVO> medicalAdvice) throws Exception {
        if (status == 1){
            for (MedicalAdviceQueryVO ma: medicalAdvice){
                if (ma.getStatus() !=0){
                    throw new Exception("已发送的医嘱不可再次发送！");
                }
                ma.setMadvSentTime(new Date());
            }
        }
        if (status == 4){
            for (MedicalAdviceQueryVO m:medicalAdvice) {
                if (m.getStatus() != 2 && m.getStatus() != 3){
                    return 0;
                }
                m.setMadvEndDate(new Date());
                m.setMadvEndTime(new Date());
            }
        }
        if (status == 2){
            List<MedicalAdviceQueryVO> ma = new ArrayList<>();
            for (MedicalAdviceQueryVO m:medicalAdvice) {
                m.setRemarks("");
                if (m.getMadvOperationType().equals("西药") || m.getMadvOperationType().equals("中药")){
                    ma.add(m);
                }
            }
            if (!ma.isEmpty()) {
                List<DrugApplicationVO> drugApplicationVOS = DrugConverter.INSTANCE.ListDrugApplication(ma);
                drugApplicationMapper.insert(drugApplicationVOS);
            }
        }
        int i=0;
        if (status == 3){
            for (MedicalAdviceQueryVO m:medicalAdvice) {
                if (m.getMadvOperationNo().equals("cy")) {
                    int i1 = leaveRecordMapper.selectByAdmissionId(m.getAdmissionId());
                    if (i1 == 0){
                        throw new Exception("医生尚未填写出院小结，无法出院");
                    }
                }
            }
        }
        for (MedicalAdviceQueryVO advice: medicalAdvice){
            i = i + adviceMapper.updateStatus(status, advice);
        }
        if (status == 3){
            List<Cost> costs = CostConverter.INSTANCE.ListMedicalAdvice(medicalAdvice);
            int i1 = costMapper.insertBatch(costs);
            if (i1 != i ){
                throw new Exception("费用未完整录入");
            }
            for (MedicalAdviceQueryVO m:medicalAdvice){
                if (m.getMadvOperationNo().equals("cy")){
                    //如果是出院医嘱的话
                    InpatientInformation inpatientInformation = informationMapper.selectAdmissionById(m.getAdmissionId());
                    // 计算住院天数
                    int day = getBetweenDay(inpatientInformation.getDateOfAdmission(),new Date());
                    //将住院记录状态改为待出院，填写出院日期与住院天数
                    informationMapper.executeLeave(m.getAdmissionId(),new Date(),day);

                    //停嘱医生 跟 停嘱时间也是在出院的时候进行修改
                    MedicalAdviceQueryVO ma = new MedicalAdviceQueryVO();
                    ma.setMadvEndDoctor(m.getMadvDoctor());
                    ma.setMadvEndDate(new Date());
                    ma.setMadvEndTime(new Date());
                    ma.setAdmissionId(m.getAdmissionId());

                    //将该病人的所有医嘱停嘱，避免多收费用
                    adviceMapper.stop(ma);

                    BedUpdateDTO bedUpdateDTO = new BedUpdateDTO();
                    bedUpdateDTO.setId(inpatientInformation.getBed().getId());
                    bedUpdateDTO.setBedStatus(0);
                    bedMapper.updateBed(bedUpdateDTO);

                    WardUpdateDTO wardUpdateDTO = new WardUpdateDTO();
                    wardUpdateDTO.setWid(inpatientInformation.getWard().getWid());
                    wardUpdateDTO.setWardStatus(0);
                    wardMapper.updateWardWithDTO(wardUpdateDTO);
                    
                }
            }
        }

        return i;
    }

    @Override
    public int updateAdvice(MedicalAdviceQueryVO medicalAdviceQueryVO) {
        int i = adviceMapper.updateAdvice(medicalAdviceQueryVO);
        return i;
    }

    @Override
    public int deleteAdvice(List<MedicalAdviceQueryVO> medicalAdviceQueryVOS) {
        for(MedicalAdviceQueryVO adviceQueryVO: medicalAdviceQueryVOS){
            if (adviceQueryVO.getStatus() != 0 || adviceQueryVO.getStatus() !=5){
                return 0;
            }
        }
        int i =0;
        for (MedicalAdviceQueryVO advice: medicalAdviceQueryVOS) {
            i = i + adviceMapper.deleteAdvice(advice);
        }
        return i;
    }

    @Override
    public PageInfo<MedicalAdviceQueryVO> getAllAdvice(Integer pageNum, AdviceReviewConditionVO conditionVO) {
        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("admissionNumber");
        List<MedicalAdviceQueryVO> medicalAdviceQueryVOS = adviceMapper.selectAll(conditionVO);
        PageInfo pageInfo = new PageInfo(medicalAdviceQueryVOS);
        return pageInfo;
    }

    @Override
    public PageInfo<MedicalAdviceQueryVO> getPassAdvice(Integer pageNum, AdviceExecuteConditionVO conditionVO) {
        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("madv_sent_time desc");
        List<MedicalAdviceQueryVO> medicalAdviceQueryVOS = adviceMapper.selectAllPass(conditionVO);
        PageInfo pageInfo = new PageInfo(medicalAdviceQueryVOS);
        return pageInfo;
    }


    public static int getBetweenDay(Date date1, Date date2) {
        Calendar d1 = new GregorianCalendar();
        d1.setTime(date1);
        Calendar d2 = new GregorianCalendar();
        d2.setTime(date2);
        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
        System.out.println("days=" + days);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }

}
