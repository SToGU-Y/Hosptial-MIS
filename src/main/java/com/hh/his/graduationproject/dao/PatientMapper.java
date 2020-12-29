package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.vo.PatientConditionVO;
import com.hh.his.graduationproject.model.entity.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {


    /**
     * 查询所有病人
     * @return
     */
    List<Patient> findPatients();

    /**
     * 按条件查询病人
     * @param conditionDTO
     * @return
     */
    List<Patient> findPatientsByConditions(@Param("conditionDTO") PatientConditionVO conditionDTO);
}
