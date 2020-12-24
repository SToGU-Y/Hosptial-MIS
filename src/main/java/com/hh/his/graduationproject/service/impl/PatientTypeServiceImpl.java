package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.PatientTypeMapper;
import com.hh.his.graduationproject.model.entity.PatientType;
import com.hh.his.graduationproject.service.PatientTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientTypeServiceImpl implements PatientTypeService {

    @Autowired
    private PatientTypeMapper patientTypeMapper;

    @Override
    public List<PatientType> findAllPatientType() {
        List<PatientType> allPatientType = patientTypeMapper.findAllPatientType();
        return allPatientType;
    }
}
