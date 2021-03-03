package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.DrugMapper;
import com.hh.his.graduationproject.model.entity.Drug;
import com.hh.his.graduationproject.model.vo.condition.DrugConditionVO;
import com.hh.his.graduationproject.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public PageInfo<Drug> getAllDrug(Integer pageNum, DrugConditionVO conditionVO) {
        PageHelper.startPage(pageNum,11);
        List<Drug> drugs = drugMapper.selectAll(conditionVO);
        PageInfo pageInfo = new PageInfo(drugs);
        return pageInfo;
    }

   @Override
    public Drug getDrugById(Integer drugId) {
        Drug drug = drugMapper.selectById(drugId);
        return drug;
    }


}
