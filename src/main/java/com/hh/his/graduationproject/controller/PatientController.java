package com.hh.his.graduationproject.controller;

import com.hh.his.graduationproject.model.vo.PatientConditionVO;
import com.hh.his.graduationproject.model.vo.PatientVO;
import com.hh.his.graduationproject.service.PatientService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 病人管理Controller
 */
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * 获取所有住院病人信息
     */
    @RequestMapping(value = "/getPatient",method = RequestMethod.GET)
    public Result getPatient(){
        List<PatientVO> patients = patientService.findPatients();
        return Result.OK(patients);
    }

    @RequestMapping(value = "/getPatientByCondition",method = RequestMethod.GET)
    public Result getPatientByCondition(PatientConditionVO conditionDTO){
        System.out.println(conditionDTO.toString());
        List<PatientVO> patients = patientService.findPatientsByConditions(conditionDTO);
        return Result.OK(patients);
    }
}
