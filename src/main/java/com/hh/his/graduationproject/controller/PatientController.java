package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.dto.PatientUpdateDTO;
import com.hh.his.graduationproject.model.entity.Patient;
import com.hh.his.graduationproject.model.vo.condition.PatientConditionVO;
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
    @SystemLogController(description = "获取所有病人信息")
    @RequestMapping(value = "/getPatient",method = RequestMethod.GET)
    public Result getPatient(){
        List<PatientVO> patients = patientService.findPatients();
        return Result.OK(patients);
    }

    @SystemLogController(description = "通过身份证获取病人信息")
    @RequestMapping(value = "/getPatientByPid",method = RequestMethod.GET)
    public Result getPatientByPid(String pid){
        Patient data = patientService.findPatientByPid(pid);
        return Result.OK(data);
    }

    @SystemLogController(description = "获取病人信息")
    @RequestMapping(value = "/getPatientByCondition",method = RequestMethod.GET)
    public Result getPatientByCondition(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                        PatientConditionVO conditionDTO){
        PageInfo<PatientVO> patients = patientService.findPatientsByConditions(pageNum, conditionDTO);
        return Result.OK(patients);
    }

    @SystemLogController(description = "更改病人信息")
    @RequestMapping(value = "/updatePatient",method = RequestMethod.POST)
    public Result updatePatient(@RequestBody PatientUpdateDTO patient){
        int i = patientService.updatePatient(patient);
        if (i != 1){
            return Result.ERROR("更改失败");
        }
        return Result.OK("更改成功");
    }

    @SystemLogController(description = "删除病人")
    @RequestMapping(value = "/delPatient",method = RequestMethod.POST)
    public Result delPatient(@RequestBody List<PatientVO> list){
        try {
            int i = patientService.deletePatientByPid(list);
            if ( i== 0){
                return Result.ERROR("删除失败");
            }else {
                return Result.OK("删除成功");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }
}
