package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.dto.PatientUpdateDTO;
import com.hh.his.graduationproject.model.vo.condition.PatientConditionVO;
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

    /**
     * 通过身份证查询病人
     * @param pid
     * @return
     */
    Patient findPatientByPid(@Param("pid") String pid);

    /**
     * 插入新的病患信息
     * @param patient
     * @return
     */
    int insertPatient(@Param("patient")Patient patient);

    /**
     * 更新病患信息
     * @param patient
     * @return
     */
    int updatePatient(@Param("patient")Patient patient);

    int updatePatientWithPid(@Param("patient") PatientUpdateDTO patient);

    /**
     * 通过身份证删除病人
     * @param pid
     * @return
     */
    int deletePatientByPid(@Param("pid")String pid);

}
