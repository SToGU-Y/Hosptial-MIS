package com.hh.his.graduationproject.controller;

import com.hh.his.graduationproject.model.dto.InpatientInformationConditionDTO;
import com.hh.his.graduationproject.model.dto.InpatientInformationDTO;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class InpatientRegisterController {



    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result insertPatient(InpatientInformationDTO inpatientInformationDTO){

        return null;
    }

    @RequestMapping(value = "/getInformationByCondition",method = RequestMethod.GET)
    public Result getInformationByCondition(InpatientInformationConditionDTO inpatientInformationConditionDTO){

        return null;
    }
}
