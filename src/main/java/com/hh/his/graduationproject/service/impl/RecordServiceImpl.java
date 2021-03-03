package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.InpatientInformationMapper;
import com.hh.his.graduationproject.dao.MedicalRecordMapper;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.vo.QueryInpatientVO;
import com.hh.his.graduationproject.model.vo.condition.InpatientInformationConditionVO;
import com.hh.his.graduationproject.model.vo.InpatientInformationVO;
import com.hh.his.graduationproject.model.vo.RecordVO;
import com.hh.his.graduationproject.model.vo.condition.QueryCondition;
import com.hh.his.graduationproject.service.RecordService;
import com.hh.his.graduationproject.utils.bean.InpatientInformationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RecordServiceImpl implements RecordService {

    @Autowired
    private MedicalRecordMapper recordMapper;

    @Autowired
    private InpatientInformationMapper mapper;

    @Override
    public RecordVO getRecordByAdmissionId(Integer admissionId) {
        RecordVO recordVO = recordMapper.selectByAdmissionId(admissionId);
        return recordVO;
    }

    @Override
    public PageInfo<InpatientInformationVO> findAdmissionByConditions(Integer pageNum, InpatientInformationConditionVO conditionVO) {
        List<InpatientInformation> inpatientInformations = mapper.selectAdmissionByConditions2(conditionVO);
        PageInfo<InpatientInformation> page1 = new PageInfo<>(inpatientInformations);
        long total = page1.getTotal();

        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("ii_date_admission desc");
        List<InpatientInformation> ii = mapper.selectAdmissionByConditions2(conditionVO);
        List<InpatientInformationVO> all = InpatientInformationConverter.INSTANCE.doToVoList(ii);
        PageInfo<InpatientInformationVO> page2 = new PageInfo(all);
        page2.setTotal(total);

        return page2;
    }

    @Override
    public PageInfo<QueryInpatientVO> queryRecord(Integer pageNum, QueryCondition condition) throws Exception {
        if (condition.getAdmissionNumber().equals("") && condition.getPid().equals("")){
            throw new Exception("请填写搜索条件");
        }

        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("ii_date_admission desc");
        List<QueryInpatientVO> ii = mapper.queryRecord(condition);
        PageInfo<QueryInpatientVO> page2 = new PageInfo(ii);

        return page2;
    }

    @Override
    public PageInfo<InpatientInformationVO> findAdmissionByConditions2(Integer pageNum, InpatientInformationConditionVO conditionVO) {
        List<InpatientInformation> inpatientInformations = mapper.selectAdmissionByConditions3(conditionVO);
        PageInfo<InpatientInformation> page1 = new PageInfo<>(inpatientInformations);
        long total = page1.getTotal();

        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("ii_date_admission desc");
        List<InpatientInformation> ii = mapper.selectAdmissionByConditions3(conditionVO);
        List<InpatientInformationVO> all = InpatientInformationConverter.INSTANCE.doToVoList(ii);
        PageInfo<InpatientInformationVO> page2 = new PageInfo(all);
        page2.setTotal(total);

        return page2;
    }

    @Override
    public int addRecord(RecordVO record) {
        record.setCreateTime(new Date());
        int insert = recordMapper.insert(record);
        return insert;
    }

    @Override
    public int updateRecord(RecordVO record) {
        int update = recordMapper.update(record);
        return update;
    }

    @Override
    public int deleteRecord(Integer id) {
        int delete = recordMapper.delete(id);
        return delete;
    }
}
