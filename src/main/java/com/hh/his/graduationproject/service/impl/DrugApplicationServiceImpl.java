package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.CostMapper;
import com.hh.his.graduationproject.dao.DrugApplicationMapper;
import com.hh.his.graduationproject.dao.DrugMapper;
import com.hh.his.graduationproject.dao.InpatientInformationMapper;
import com.hh.his.graduationproject.model.entity.Cost;
import com.hh.his.graduationproject.model.entity.Drug;
import com.hh.his.graduationproject.model.vo.ApplyJson;
import com.hh.his.graduationproject.model.vo.DrugApplicationVO;
import com.hh.his.graduationproject.model.vo.LeaveVO;
import com.hh.his.graduationproject.model.vo.condition.DrugApplyCondition;
import com.hh.his.graduationproject.service.DrugApplicationService;
import com.hh.his.graduationproject.utils.bean.CostConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DrugApplicationServiceImpl implements DrugApplicationService {

    @Autowired
    private DrugApplicationMapper drugApplicationMapper;

    @Autowired
    private DrugMapper drugMapper;

    @Autowired
    private InpatientInformationMapper informationMapper;

    @Autowired
    private CostMapper costMapper;

    @Override
    public PageInfo<DrugApplicationVO> getApply(Integer pageNum, DrugApplyCondition condition) {
        PageHelper.startPage(pageNum,10);
        List<DrugApplicationVO> drugApplicationVOS = drugApplicationMapper.selectAll(condition);
        PageInfo pageInfo = new PageInfo(drugApplicationVOS);
        return pageInfo;
    }

    @Override
    public PageInfo<DrugApplicationVO> getApply2(Integer pageNum, DrugApplyCondition condition) {
        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("apply_date");
        List<DrugApplicationVO> drugApplicationVOS = drugApplicationMapper.selectAll2(condition);
        PageInfo pageInfo = new PageInfo(drugApplicationVOS);
        return pageInfo;
    }

    @Override
    public PageInfo<DrugApplicationVO> getApply3(Integer pageNum, DrugApplyCondition condition) {
        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("offer_date desc");
        List<DrugApplicationVO> drugApplicationVOS = drugApplicationMapper.selectAll3(condition);
        PageInfo pageInfo = new PageInfo(drugApplicationVOS);
        return pageInfo;
    }

    @Override
    public int apply(ApplyJson applyJson) {
        int i= 0;
        List<DrugApplicationVO> selectiveList = applyJson.getSelectiveList();
        for (DrugApplicationVO drugApplication: selectiveList) {
            drugApplication.setOperator(applyJson.getOperator());
            drugApplication.setApplyDate(new Date());
            drugApplication.setStatus(1);
            i = i + drugApplicationMapper.updateStatus(drugApplication);
        }
        return i;
    }

    @Override
    public int cancelApply(ApplyJson applyJson) {
        int i= 0;
        List<DrugApplicationVO> selectiveList = applyJson.getSelectiveList();
        for (DrugApplicationVO drugApplication: selectiveList) {
            drugApplication.setOperator(null);
            drugApplication.setStatus(0);
            drugApplication.setApplyDate(null);
            i = i + drugApplicationMapper.updateStatus(drugApplication);
        }
        return i;
    }

    @Override
    public int offer(ApplyJson applyJson){
        int i= 0;
        List<DrugApplicationVO> selectiveList = applyJson.getSelectiveList();
        Drug drug = null;
        for (DrugApplicationVO drugApplication: selectiveList) {
            drug = drugMapper.selectByDrugNo(drugApplication.getDrugNo());
            if (drug.getDrugNum()-drugApplication.getDrugRequireNumber()<=0){
                continue;
            }
            drug.setDrugNum(drug.getDrugNum()-drugApplication.getDrugRequireNumber());
            drugMapper.updateDrugNum(drug);
            drugApplication.setOfferOperator(applyJson.getOperator());
            drugApplication.setOfferDate(new Date());
            drugApplication.setStatus(2);
            i = i + drugApplicationMapper.updateStatus(drugApplication);
        }
        return i;
    }

    @Override
    public int deleteApply(List<DrugApplicationVO> list) {
        int i = 0;
        for (DrugApplicationVO drugApplication:list) {
           i = i + drugApplicationMapper.delete(drugApplication.getDrugApplicationId());
        }
        return i;
    }

    @Override
    public int insertApply(DrugApplicationVO drugApplicationVO) throws Exception {
        Drug drug = drugMapper.selectByDrugNo(drugApplicationVO.getDrugNo());
        if (drug == null){
            throw new Exception("不存在该药品");
        }
        LeaveVO leaveVO = informationMapper.selectByAdmissionNumber2(drugApplicationVO.getAdmissionNumber());
        if (leaveVO == null){
            throw new Exception("该住院号错误");
        }
        drugApplicationVO.setAdmissionId(leaveVO.getAdmissionId());
        drugApplicationVO.setApplyDate(new Date());
        drugApplicationVO.setStatus(1);
        List<DrugApplicationVO> ma = new ArrayList<>();
        ma.add(drugApplicationVO);
        int insert = drugApplicationMapper.insert(ma);
        Cost cost = CostConverter.INSTANCE.drugApplicationToCost(drugApplicationVO);
        costMapper.insert(cost);
        return insert;
    }


}
