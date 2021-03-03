package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.MedicalApplianceTypeMapper;
import com.hh.his.graduationproject.model.entity.MedicalApplianceType;
import com.hh.his.graduationproject.service.ApplianceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApplianceTypeServiceImpl implements ApplianceTypeService {

    @Autowired
    private MedicalApplianceTypeMapper applianceTypeMapper;


    @Override
    public List<MedicalApplianceType> findAll() {
        List<MedicalApplianceType> applianceTypes = applianceTypeMapper.selectAll();
        return applianceTypes;
    }
}
