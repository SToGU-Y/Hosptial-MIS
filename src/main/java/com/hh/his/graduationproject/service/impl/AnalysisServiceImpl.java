package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.AnalysisMapper;
import com.hh.his.graduationproject.dao.InpatientInformationMapper;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private InpatientInformationMapper informationMapper;

    @Autowired
    private AnalysisMapper analysisMapper;

    @Override
    public List<InpatientAnalysis> getInpatient(String date, String date2) {
        List<InpatientAnalysis> inpatientAnalyses = informationMapper.analysisInpatient(date,date2);
        return inpatientAnalyses;
    }


    @Override
    public List<InpatientAnalysis> getLeave(String date, String date2) {
        List<InpatientAnalysis> inpatientAnalyses = informationMapper.analysisLeave(date, date2);
        return inpatientAnalyses;
    }

    @Override
    public List<SexJSON> getInpatientSex(String date, String date2) {
        List<SexJSON> sexJSONS = analysisMapper.selectInpatientSex(date, date2);
        return sexJSONS;
    }

    @Override
    public List<SexJSON> getLeaveSex(String date, String date2) {
        List<SexJSON> sexJSONS = analysisMapper.selectLeaveSex(date,date2);
        return sexJSONS;
    }

    @Override
    public PeopleJSON getPeopleMessage() {

        PeopleJSON peopleJSON = new PeopleJSON();
        int todayInpatient = analysisMapper.findTodayInpatient(new Date());
        int todayLeave = analysisMapper.findTodayLeave(new Date());
        int totalInpatient = analysisMapper.findTotalInpatient();
        int totalLeave = analysisMapper.findTotalLeave();
        peopleJSON.setTodayInpatient(todayInpatient);
        peopleJSON.setTodayLeave(todayLeave);
        peopleJSON.setTotalInpatient(totalInpatient);
        peopleJSON.setTotalLeave(totalLeave);
        return peopleJSON;
    }

    @Override
    public MoneyJSON getMoneyMessage() {
        BigDecimal todayDeposit = analysisMapper.findTodayDeposit(new Date());
        if (todayDeposit == null){
            todayDeposit = new BigDecimal(0);
        }
        BigDecimal totalDeposit = analysisMapper.findTotalDeposit();
        if (totalDeposit == null){
            totalDeposit = new BigDecimal(0);
        }
        BigDecimal todayBill = analysisMapper.findTodayBill(new Date());
        if (todayBill == null){
            todayBill = new BigDecimal(0);
        }
        BigDecimal totalBill = analysisMapper.findTotalBill();
        if (totalBill == null){
            totalBill = new BigDecimal(0);
        }
        MoneyJSON moneyJSON = new MoneyJSON(todayDeposit,totalDeposit,todayBill,totalBill);
        return moneyJSON;
    }

    @Override
    public List<MoneyAnalysis> getDeposit(String date, String date2) {
        List<MoneyAnalysis> moneyAnalyses = analysisMapper.analysisDeposit(date, date2);
        return moneyAnalyses;
    }

    @Override
    public List<MoneyAnalysis> getBill(String date, String date2) {
        List<MoneyAnalysis> moneyAnalyses = analysisMapper.analysisBill(date, date2);
        return moneyAnalyses;
    }

    @Override
    public List<StatisticsMonth> getStatisticsMonth(String date) {
        List<StatisticsMonth> statisticsMonths = analysisMapper.statisticsMonth(date);
        return statisticsMonths;
    }

    @Override
    public List<Map<String,String>> getMonthMessage(String date) {
        List<HashMap<String, Object>> maps = analysisMapper.MonthlyHospitalization(date);
        List<HashMap<String, Object>> maps1 = analysisMapper.MonthlyDischarged(date);
        Map<String, Long> map = new HashMap<>();
        Map<String, Long> map1 = new HashMap<>();
        if (maps != null && !maps.isEmpty()){
            for (HashMap<String, Object> hashMap : maps) {
                String key = null;
                Long value = null;
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if ("月份".equals(entry.getKey())) {
                        key = entry.getValue()+"月";
                    } else if ("住院人数".equals(entry.getKey())) {
                        value = (Long) entry.getValue();
                    }
                }
                map.put(key, value);
            }
        }
        if (maps1 != null && !maps1.isEmpty()){
            for (HashMap<String, Object> hashMap : maps1) {
                String key = null;
                Long value = null;
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if ("月份".equals(entry.getKey())) {
                        key = entry.getValue()+"月";
                    } else if ("出院人数".equals(entry.getKey())) {
                        value =  (Long)entry.getValue();
                    }
                }
                map1.put(key, value);
            }
        }


        List<Map<String,String>> list = new ArrayList<>();

        if (map.size()>=map1.size()){
            for (Map.Entry<String,Long> entry: map.entrySet()){
                Map<String,String> map2 = new HashMap<>();
                map2.put("月份",entry.getKey());
                map2.put("住院",String.valueOf(entry.getValue()));
                map2.put("出院","0");
                list.add(map2);
            }
            for (Map.Entry<String,Long> entry: map1.entrySet()){
                for (Map map2 : list){
                    if (map2.containsValue(entry.getKey())){
                        map2.put("出院",String.valueOf(entry.getValue()));
                    }
                }
                if (!map.containsKey(entry.getKey())){
                    Map<String,String> map2 = new HashMap<>();
                    map2.put("月份",entry.getKey());
                    map2.put("出院",String.valueOf(entry.getValue()));
                    map2.put("住院","0");
                    list.add(map2);
                }
            }

        }else{
            for (Map.Entry<String,Long> entry: map1.entrySet()){
                Map<String,String> map2 = new HashMap<>();
                map2.put("月份",entry.getKey());
                map2.put("出院",String.valueOf(entry.getValue()));
                map2.put("住院","0");
                list.add(map2);
            }
            for (Map.Entry<String,Long> entry: map.entrySet()){
                for (Map map2 : list){
                    if (map2.containsValue(entry.getKey())){
                        map2.put("住院",entry.getValue());
                    }
                }
                if (!map1.containsKey(entry.getKey())){
                    Map<String,String> map2 = new HashMap<>();
                    map2.put("月份",entry.getKey());
                    map2.put("住院",String.valueOf(entry.getValue()));
                    map2.put("出院","0");
                    list.add(map2);
                }
            }
        }
        return list;
    }


}
