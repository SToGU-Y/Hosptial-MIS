package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.PatientMapper;
import com.hh.his.graduationproject.model.vo.PatientConditionVO;
import com.hh.his.graduationproject.model.entity.Patient;
import com.hh.his.graduationproject.model.vo.PatientVO;
import com.hh.his.graduationproject.service.PatientService;
import com.hh.his.graduationproject.utils.bean.PatientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

/**
 * 病人管理业务
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;

    /**
     * 查询所有病人
     * @return
     */
    public List<PatientVO> findPatients() {
        List<Patient> patients = patientMapper.findPatients();
        List<PatientVO> patientVos = new ArrayList<PatientVO>();
        for(Patient patient : patients){
            PatientVO patientVO = PatientConverter.INSTANCE.doToVo(patient);
            patientVO.setNativePlace(patient.getProvince()+patient.getCity());
            patientVos.add(patientVO);
        }
        return patientVos;
    }

    /**
     * 按条件查询病人信息
     * @param conditionDTO
     * @return
     */
    @Override
    public List<PatientVO> findPatientsByConditions(PatientConditionVO conditionDTO) {
        List<Patient> patients = patientMapper.findPatientsByConditions(conditionDTO);
        List<PatientVO> patientVos = new ArrayList<PatientVO>();
        for(Patient patient : patients){
            PatientVO patientVO = PatientConverter.INSTANCE.doToVo(patient);
            patientVO.setNativePlace(patient.getProvince()+patient.getCity());
            patientVos.add(patientVO);
        }
        return patientVos;
    }

}
