package com.hh.his.graduationproject.service;

import com.hh.his.graduationproject.model.vo.PatientConditionVO;
import com.hh.his.graduationproject.model.vo.PatientVO;

import java.util.List;

public interface PatientService {

    /**
     * 查询所有病人
     * @return
     */
    List<PatientVO> findPatients();

    /**
     * 按条件查询病人
     * @param conditionDTO
     * @return
     */
    List<PatientVO> findPatientsByConditions(PatientConditionVO conditionDTO);
}
