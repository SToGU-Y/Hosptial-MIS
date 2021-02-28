package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.*;
import com.hh.his.graduationproject.model.vo.DeptSelectVO;
import com.hh.his.graduationproject.model.vo.InpatientInformationVO;
import com.hh.his.graduationproject.model.vo.condition.WardConditionVO;
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
    private CostItemTypeService costItemTypeService;


    @SystemLogController(description = "获取科室")
    @RequestMapping(value = "/getDept",method = RequestMethod.GET)
    public Result getDept(){
        List<DeptSelectVO> allDept = deptService.findAllDept();
        return Result.OK(allDept);
    }

    @SystemLogController(description = "获取付款类型")
    @RequestMapping(value = "/getPayment",method = RequestMethod.GET)
    public Result getPayment(){
        List<PaymentType> paymentType = paymentTypeService.findAllPaymentType();
        return Result.OK(paymentType);
    }

    @SystemLogController(description = "获取综合通用信息")
    @RequestMapping(value = "/getCommon",method = RequestMethod.GET)
    public Result getCommon(){
        Map<String,Object> result = new HashMap<>();
        List<Nation> allNation = nationService.findAllNation();
        List<DeptSelectVO> allDept = deptService.findAllDept();
        List<PatientType> allPatientType = patientTypeService.findAllPatientType();
        List<PaymentType> allPaymentType = paymentTypeService.findAllPaymentType();
        result.put("nationList",allNation);
        result.put("deptList",allDept);
        result.put("patientTypeList",allPatientType);
        result.put("paymentTypeList",allPaymentType);
        return Result.OK(result);
    }

    @SystemLogController(description = "获取民族信息")
    @RequestMapping(value = "/getNationList",method = RequestMethod.GET)
    public Result getNationList(){
        List<Nation> allNation = nationService.findAllNation();
        return Result.OK(allNation);
    }

    @SystemLogController(description = "获取全部住院信息")
    @RequestMapping(value = "/getInpatient",method = RequestMethod.GET)
    public Result getInpatient(){
        List<InpatientInformationVO> allAdmission = inpatientService.findAllAdmission();
        return Result.OK(allAdmission);
    }

    @SystemLogController(description = "获取费用项类型")
    @RequestMapping(value = "/getCostItemType",method = RequestMethod.GET)
    public Result getCostItemType(){
        List<CostItemType> all = costItemTypeService.getAll();
        return Result.OK(all);
    }


}
