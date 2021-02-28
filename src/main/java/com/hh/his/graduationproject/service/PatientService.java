package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.dto.PatientUpdateDTO;
import com.hh.his.graduationproject.model.entity.Patient;
import com.hh.his.graduationproject.model.vo.condition.PatientConditionVO;
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
    PageInfo<PatientVO> findPatientsByConditions(Integer pageNum, PatientConditionVO conditionDTO);

    Patient findPatientByPid(String pid);

    int updatePatient(PatientUpdateDTO patient);

    int deletePatientByPid(List<PatientVO> list) throws Exception;
}
