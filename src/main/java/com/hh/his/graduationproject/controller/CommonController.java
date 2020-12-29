package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.*;
import com.hh.his.graduationproject.model.vo.InpatientInformationVO;
import com.hh.his.graduationproject.model.vo.WardConditionVO;
import com.hh.his.graduationproject.model.vo.WardVO;
import com.hh.his.graduationproject.service.*;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private NationService nationService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private PaymentTypeService paymentTypeService;

    @Autowired
    private PatientTypeService patientTypeService;

    @Autowired
    private InpatientService inpatientService;

    @Autowired
    private WardService wardService;

    @Autowired
    private WardTypeService wardTypeService;


    @RequestMapping(value = "/getDept",method = RequestMethod.GET)
    public Result getDept(){
        List<Dept> allDept = deptService.findAllDept();
        return Result.OK(allDept);
    }

    @RequestMapping(value = "/getCommon",method = RequestMethod.GET)
    public Result getCommon(){
        Map<String,Object> result = new HashMap<>();
        List<Nation> allNation = nationService.findAllNation();
        List<Dept> allDept = deptService.findAllDept();
        List<PatientType> allPatientType = patientTypeService.findAllPatientType();
        List<PaymentType> allPaymentType = paymentTypeService.findAllPaymentType();
        result.put("nationList",allNation);
        result.put("deptList",allDept);
        result.put("patientTypeList",allPatientType);
        result.put("paymentTypeList",allPaymentType);
        return Result.OK(result);
    }


    @RequestMapping(value = "/getInpatient",method = RequestMethod.GET)
    public Result getInpatient(){
        List<InpatientInformationVO> allAdmission = inpatientService.findAllAdmission();
        return Result.OK(allAdmission);
    }

    @RequestMapping(value = "/getType",method = RequestMethod.GET)
    public Result getType(){
        List<InpatientWardType> allWardType = wardTypeService.findAllWardType();
        return Result.OK(allWardType);
    }

    @RequestMapping(value = "/getTypeByPage",method = RequestMethod.GET)
    public Result getTypeByPage(@RequestParam(required = false,defaultValue = "1",value = "pageNum") Integer pageNum){
        PageInfo<InpatientWardType> allWardType = wardTypeService.findAllWardTypeByPage(pageNum);
        return Result.OK(allWardType);
    }

   /* @RequestMapping(value = "/getWardByPage",method = RequestMethod.GET)
    public Result getWardByPage(@RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum){
        PageInfo<WardVO> allWard = wardService.findAllWardByPage(pageNum);
        return Result.OK(allWard);
    }*/

    @RequestMapping(value = "/getWardByCondition",method = RequestMethod.GET)
    public Result getWardByCondition(@RequestParam(required = false,defaultValue = "1",value = "pageNum") Integer pageNum
            ,WardConditionVO wardConditionVO){
       // System.out.println(wardConditionVO);
        PageInfo<WardVO> wardByCondition = wardService.findWardByCondition(pageNum, wardConditionVO);
        return Result.OK(wardByCondition);
    }


}
