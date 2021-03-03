package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.MedicalApplianceMapper;
import com.hh.his.graduationproject.model.entity.MedicalAppliance;
import com.hh.his.graduationproject.model.vo.condition.ApplianceConditionVO;
import com.hh.his.graduationproject.service.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApplianceServiceImpl implements ApplianceService {

    @Autowired
    private MedicalApplianceMapper applianceMapper;

    @Override
    public PageInfo<MedicalAppliance> findAppliance(Integer pageNum, ApplianceConditionVO conditionVO) {

        PageHelper.startPage(pageNum,11);
        List<MedicalAppliance> appliances = applianceMapper.select(conditionVO);
        PageInfo<MedicalAppliance> pageInfo = new PageInfo<>(appliances);
        return pageInfo;
    }

    @Override
    public int addAppliance(MedicalAppliance medicalAppliance) {
        medicalAppliance.setStatus(0);
        int insert = applianceMapper.insert(medicalAppliance);
        return insert;
    }

    @Override
    public int updateStatus(Integer status,Integer id,String remarks) {
        int i = applianceMapper.updateStatusById(status, id,remarks);
        return i;
    }

    @Override
    public int update(MedicalAppliance record) {
        int update = applianceMapper.update(record);
        return update;
    }

    @Override
    public int deleteById(Integer id) {
        int i = applianceMapper.deleteById(id);
        return i;
    }
}
