package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.*;
import com.hh.his.graduationproject.model.dto.InpatientAddDTO;
import com.hh.his.graduationproject.model.dto.InpatientUpdateDTO;
import com.hh.his.graduationproject.model.entity.Cost;
import com.hh.his.graduationproject.model.entity.Deposit;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.entity.Patient;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.model.vo.condition.*;
import com.hh.his.graduationproject.service.InpatientService;
import com.hh.his.graduationproject.utils.KeyUtil;
import com.hh.his.graduationproject.utils.bean.InpatientInformationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class InpatientServiceImpl implements InpatientService {

    @Autowired
    private InpatientInformationMapper mapper;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private DepositMapper depositMapper;

    @Autowired
    private CostMapper costMapper;

    @Autowired
    private BillMapper billMapper;

    @Autowired
    private DrugApplicationMapper drugApplicationMapper;

    @Autowired
    private MedicalRecordMapper recordMapper;

    @Autowired
    private MedicalAdviceMapper medicalAdviceMapper;

    @Autowired
    private LeaveRecordMapper leaveRecordMapper;


    @Transactional
    @Override
    public int addInpatientRecord(InpatientInformationAddVO addVO) throws Exception {
        InpatientAddDTO addDTO = InpatientInformationConverter.INSTANCE.toDTO(addVO);
        Patient patient = InpatientInformationConverter.INSTANCE.toPatient(addVO);
        Deposit deposit = InpatientInformationConverter.INSTANCE.toDeposit(addVO);

        //转换一下数据类型，确保金额精确
        BigDecimal bigDecimal = new BigDecimal(addVO.getDeposit());
        if (deposit.getStatus() == 1){
            deposit.setDatePay(new Date());
            deposit.setPaymentType(addVO.getPayment());
        }else {
            deposit.setPaymentType("");
            deposit.setDatePay(null);
        }
        deposit.setDeposit(bigDecimal);
        deposit.setDesIsRefund(0);

        deposit.setDesId(KeyUtil.createID());  //生成押金号
        addDTO.setStatus(0);//0表示住院状态 1表示出院状态

        //判断病人是否已经存储过
        Patient check = patientMapper.findPatientByPid(patient.getPid());
        //如果没有就插入
        if (check == null){
           int i =  patientMapper.insertPatient(patient);
            if (i==0){
                System.out.println("病人插入失败");
            }
        }else {
            //如果有就更新信息，因为有可能会更新
            patientMapper.updatePatient(patient);
        }

        //这里先判断一下是否有相同病人已经在住院，不能再次住院两次
        InpatientInformationConditionVO conditionVO = new InpatientInformationConditionVO();
        conditionVO.setPid(addVO.getPid());
        List<InpatientInformation> list = mapper.selectAdmissionByConditions(conditionVO);
        if (!list.isEmpty()){
            throw new Exception("该病人已住院");
        }
        //如果没有住院再添加
        List<InpatientInformation> list2 = mapper.selectAdmissionByPid(addVO.getPid());
        if (list2.isEmpty()){
            addDTO.setAdmissionNumber(KeyUtil.createID()); //生成住院号
        }else {
            addDTO.setAdmissionNumber(list2.get(0).getAdmissionNumber());
        }

        addDTO.setDateOfAdmission(new Date());  //设置一下入院日期
        int i = mapper.insertInpatient(addDTO); //插入数据库

        //重新取出来，为了获取主键
        InpatientInformation information =
                mapper.selectAdmissionByDateAndAdNumber(addDTO.getDateOfAdmission(),
                        addDTO.getAdmissionNumber());
        //给押金设置一下对应的住院信息主键
        deposit.setId(information.getId());

        //插入押金
        int j = depositMapper.insertDeposit(deposit);
        if (j==0){
            throw new Exception("押金插入失败");
        }
        return i;
    }

    @Override
    public List<InpatientInformationVO> findAllAdmission() {
        List<InpatientInformation> allAdmission = mapper.findAllAdmission();
        List<InpatientInformationVO> all = InpatientInformationConverter.INSTANCE.doToVoList(allAdmission);
        return all;
    }

    @Override
    public PageInfo<InpatientInformationVO> findAdmissionByConditions(Integer pageNum,InpatientInformationConditionVO conditionVO) {
        List<InpatientInformation> inpatientInformations = mapper.selectAdmissionByConditions(conditionVO);
        PageInfo<InpatientInformation> page1 = new PageInfo<>(inpatientInformations);
        long total = page1.getTotal();

        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("ii_date_admission desc");
        List<InpatientInformation> ii = mapper.selectAdmissionByConditions(conditionVO);
        List<InpatientInformationVO> all = InpatientInformationConverter.INSTANCE.doToVoList(ii);
        PageInfo<InpatientInformationVO> page2 = new PageInfo(all);
        page2.setTotal(total);

        return page2;
    }

    @Override
    public PageInfo<InpatientInformationVO> findCanLeave(Integer pageNum, InpatientInformationConditionVO conditionVO) {
        List<InpatientInformation> m = mapper.selectCanLeave(conditionVO);
        PageInfo<InpatientInformation> page1 = new PageInfo<>(m);
        long total = page1.getTotal();

        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("ii_date_admission desc");
        List<InpatientInformation> ii = mapper.selectCanLeave(conditionVO);
        List<InpatientInformationVO> all = InpatientInformationConverter.INSTANCE.doToVoList(ii);
        PageInfo<InpatientInformationVO> page2 = new PageInfo(all);
        page2.setTotal(total);

        return page2;
    }

    @Override
    public PageInfo<DepositQueryVO> findWithDeposit(Integer pageNum, DepositAddCondition conditionVO) {
        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("datePay desc");
        List<DepositQueryVO> depositQueryVOS = mapper.selectWithDeposit(conditionVO);
        PageInfo pageInfo = new PageInfo(depositQueryVOS);
        return pageInfo;
    }

    @Override
    public PageInfo<DepositQueryVO> findWithDeposit2(Integer pageNum, DepositAddCondition conditionVO) {
        PageHelper.startPage(pageNum,10);
        List<DepositQueryVO> depositQueryVOS = mapper.selectWithDeposit2(conditionVO);
        PageInfo pageInfo = new PageInfo(depositQueryVOS);
        return pageInfo;
    }

    @Override
    public PageInfo<DepositQueryVO> findWithDeposit3(Integer pageNum, InpatientInformationConditionVO conditionVO) {
        PageHelper.startPage(pageNum,10);
        List<DepositQueryVO> depositQueryVOS = mapper.selectWithDeposit3(conditionVO);
        PageInfo pageInfo = new PageInfo(depositQueryVOS);
        return pageInfo;
    }

    @Override
    public InpatientUpdateVO findAdmissionById(Integer id) {
        InpatientInformation information = mapper.selectAdmissionById(id);
        List<Deposit> deposits = depositMapper.selectDepositById(id);
        Deposit deposit;
        if (deposits.isEmpty()){
            deposit = new Deposit();
        }else {
            deposit = deposits.get(deposits.size() - 1);
        }
        InpatientUpdateVO updateVO = InpatientInformationConverter.INSTANCE.doToUpdateVO(information,deposit);
        return updateVO;
    }

    @Override
    public void updateAdmission(InpatientUpdateVO updateVO) {
        Patient patient = InpatientInformationConverter.INSTANCE.toPatient(updateVO);
        InpatientUpdateDTO updateDTO = InpatientInformationConverter.INSTANCE.toDTO(updateVO);
        patientMapper.updatePatient(patient);
        mapper.updateAdmission(updateDTO);
    }

    /**
     * 用于选择病床
     * @param
     * @return
     */
    @Override
    public PageInfo<BedPatientSelectVO> findAdmissionByDept(Integer pageNum, BedPatientSelectConditionVO conditionVO) {

        List<InpatientInformation> forTotal = mapper.selectAdmissionByDept(conditionVO);
        PageInfo pageInfo = new PageInfo(forTotal);
        long total = pageInfo.getTotal();

        PageHelper.startPage(pageNum,9);
        List<InpatientInformation> admission = mapper.selectAdmissionByDept(conditionVO);
        List<BedPatientSelectVO> selectVO = InpatientInformationConverter.INSTANCE.toBedSelectVOList(admission);
        PageInfo<BedPatientSelectVO> pageInfo1 = new PageInfo<>(selectVO);
        pageInfo1.setTotal(total);

        return pageInfo1;
    }

    @Override
    public PageInfo<BedChangePatientSelectVO> findAdmissionByDept2(Integer pageNum, BedPatientSelectConditionVO conditionVO) {
        List<InpatientInformation> forTotal = mapper.selectAdmissionByDept2(conditionVO);
        PageInfo pageInfo = new PageInfo(forTotal);
        long total = pageInfo.getTotal();

        PageHelper.startPage(pageNum,9);
        List<InpatientInformation> admission = mapper.selectAdmissionByDept2(conditionVO);
        System.out.println(admission);
        List<BedChangePatientSelectVO> selectVO = InpatientInformationConverter.INSTANCE.toBedChangeVOList(admission);
        PageInfo<BedChangePatientSelectVO> pageInfo1 = new PageInfo<>(selectVO);
        pageInfo1.setTotal(total);

        return pageInfo1;
    }

    @Override
    public int deleteRegister(Integer admissionId) {
        List<Deposit> deposits = depositMapper.selectDepositById(admissionId);
        if (!deposits.isEmpty()){
            for(Deposit deposit: deposits){
                if (deposit.getDesIsRefund() == 0 && deposit.getStatus() == 1){
                    return 3;
                }
            }
        }
        for (Deposit deposit : deposits){
            if (deposit.getStatus() == 0){
                depositMapper.deleteByDesId(deposit.getDesId());
            }
        }
        int i = mapper.deleteById(admissionId);
        return i;
    }

    @Override
    public int deleteLeave(List<LeaveQueryVO> list) {
        int i = 0;
        for (LeaveQueryVO lqv: list){
            costMapper.deleteByAdmissionId(lqv.getId());
            depositMapper.deleteByAdmissionId(lqv.getId());
            recordMapper.delete(lqv.getId());
            leaveRecordMapper.deleteByAdmissionId(lqv.getId());
            drugApplicationMapper.deleteByAdmissionId(lqv.getId());
            medicalAdviceMapper.deleteByAdmissionId(lqv.getId());
            billMapper.deleteByAdmissionId(lqv.getId());
            i = i + mapper.deleteById(lqv.getId());
        }
        return i;
    }

    @Override
    public PageInfo getWithCost(Integer pageNum, CostQueryCondition conditionVO) {
        PageHelper.startPage(pageNum,10);
        List<InformationWithCost> informationWithCosts = mapper.selectWithCost(conditionVO);

        List<Deposit> deposits = null;
        List<Cost> costs = null;
        for(InformationWithCost informationWithCost : informationWithCosts){
            BigDecimal ye = new BigDecimal(0);
            BigDecimal hf = new BigDecimal(0);
            deposits = depositMapper.selectDepositById(informationWithCost.getId());
            if (!deposits.isEmpty()){
                for (Deposit deposit : deposits){
                    if (deposit.getStatus() == 1 && deposit.getDesIsRefund() == 0){
                        ye = ye.add(deposit.getDeposit());
                    }
                }
            }
            informationWithCost.setDeposit(ye);
            costs = costMapper.selectByAdmissionId(informationWithCost.getId(),"","");
            if (!costs.isEmpty()){
                for (Cost cost : costs){
                    hf = hf.add(cost.getCostSum());
                }
            }
            informationWithCost.setCostSum(hf);
        }

        PageInfo pageInfo = new PageInfo(informationWithCosts);
        return pageInfo;
    }

    @Override
    public LeaveVO getByAdmissionNumber(String admissionNumber) throws Exception {
        LeaveVO leaveVO = mapper.selectByAdmissionNumber(admissionNumber);

        if (leaveVO == null){
            throw new Exception("住院号错误或未获出院证明");
        }

        BigDecimal ye = new BigDecimal(0);
        BigDecimal hf = new BigDecimal(0);
        BigDecimal yf = new BigDecimal(0);
        List<Deposit> deposits = depositMapper.selectDepositById(leaveVO.getAdmissionId());
        if (!deposits.isEmpty()){
                for (Deposit deposit : deposits){
                    if (deposit.getStatus() == 1 && deposit.getDesIsRefund() == 0){
                        ye = ye.add(deposit.getDeposit());
                    }
                }
            }
            leaveVO.setDeposit(ye);
        List<Cost> costs = costMapper.selectByAdmissionId(leaveVO.getAdmissionId(),"","");
        if (!costs.isEmpty()){
            for (Cost cost : costs){
                hf = hf.add(cost.getCostSum());
            }
        }
        leaveVO.setCostSum(hf);
        if (leaveVO.getPtName().equals("自费")){
            yf = hf.subtract(ye);
        }else if (leaveVO.getPtName().equals("居民医保")){
            hf = hf.multiply(new BigDecimal(0.95));
            yf = hf.subtract(ye);
        }else if (leaveVO.getPtName().equals("职工医保")){
            hf = hf.multiply(new BigDecimal(0.85));
            yf = hf.subtract(ye);
        }else if (leaveVO.getPtName().equals("新农保")){
            hf = hf.multiply(new BigDecimal(0.90));
            yf = hf.subtract(ye);
        }

        leaveVO.setPay(yf);

        return leaveVO;
    }

    @Override
    public PageInfo<LeaveQueryVO> getLeaveVO(Integer pageNum, InpatientInformationConditionVO conditionVO) {
        List<InpatientInformation> m = mapper.selectLeaveAdmission(conditionVO);
        PageInfo<InpatientInformation> page1 = new PageInfo<>(m);
        long total = page1.getTotal();

        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("ii_date_admission desc");
        List<InpatientInformation> ii = mapper.selectLeaveAdmission(conditionVO);
        List<LeaveQueryVO> all = InpatientInformationConverter.INSTANCE.toLeaveQueryVOList(ii);
        PageInfo<LeaveQueryVO> page2 = new PageInfo(all);
        page2.setTotal(total);

        return page2;
    }

    @Override
    public PageInfo<QueryInpatientVO> queryInpatient(Integer pageNum, QueryCondition condition) throws Exception {
        if (condition.getAdmissionNumber().equals("") && condition.getPid().equals("")){
            throw new Exception("请填写搜索条件");
        }
        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("ii_date_admission desc");
        List<QueryInpatientVO> ii = mapper.queryInpatient(condition);
        PageInfo<QueryInpatientVO> page = new PageInfo(ii);
        return page;
    }


}
