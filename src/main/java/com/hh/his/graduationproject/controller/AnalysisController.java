package com.hh.his.graduationproject.controller;

import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.service.AnalysisService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @RequestMapping(value = "/getInpatient",method = RequestMethod.GET)
    public Result getInpatient(String date,String date2){
        try {
            List<InpatientAnalysis> inpatient = analysisService.getInpatient(date,date2);
            return Result.OK(inpatient);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @RequestMapping(value = "/getLeave",method = RequestMethod.GET)
    public Result getLeave(String date,String date2){
        try {
            List<InpatientAnalysis> inpatient = analysisService.getLeave(date,date2);
            return Result.OK(inpatient);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @RequestMapping(value = "/getPeopleMessage",method = RequestMethod.GET)
    public Result getPeopleMessage(){
        try {
            PeopleJSON peopleMessage = analysisService.getPeopleMessage();
            return Result.OK(peopleMessage);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @RequestMapping(value = "/getMoneyMessage",method = RequestMethod.GET)
    public Result getMoneyMessage(){
        try {
            MoneyJSON moneyMessage = analysisService.getMoneyMessage();
            return Result.OK(moneyMessage);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @RequestMapping(value = "/getMonthMessage",method = RequestMethod.GET)
    public Result getMonthMessage(String date){
        try {
            List<Map<String, String>> monthMessage = analysisService.getMonthMessage(date);
            return Result.OK(monthMessage);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @RequestMapping(value = "/getDeposit",method = RequestMethod.GET)
    public Result getDeposit(String date,String date1){
        try {
            List<MoneyAnalysis> deposit = analysisService.getDeposit(date, date1);
            return Result.OK(deposit);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @RequestMapping(value = "/getBill",method = RequestMethod.GET)
    public Result getBill(String date,String date1){
        try {
            List<MoneyAnalysis> bill = analysisService.getBill(date, date1);
            return Result.OK(bill);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @RequestMapping(value = "/getStatisticsMonth",method = RequestMethod.GET)
    public Result getStatisticsMonth(String date){
        try {
            List<StatisticsMonth> statisticsMonth = analysisService.getStatisticsMonth(date);
            return Result.OK(statisticsMonth);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }



    @RequestMapping(value = "/getLeaveSex",method = RequestMethod.GET)
    public Result getLeaveSex(String date,String date1){
        try {
            List<SexJSON> leaveSex = analysisService.getLeaveSex(date, date1);
            return Result.OK(leaveSex);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @RequestMapping(value = "/getInpatientSex",method = RequestMethod.GET)
    public Result getInpatientSex(String date,String date1){
        try {
            List<SexJSON> inpatientSex = analysisService.getInpatientSex(date, date1);
            return Result.OK(inpatientSex);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

}
