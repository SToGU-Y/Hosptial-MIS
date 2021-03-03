package com.hh.his.graduationproject.service;

import com.hh.his.graduationproject.model.vo.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AnalysisService {

    List<InpatientAnalysis> getInpatient(String date,String date2);

    List<InpatientAnalysis> getLeave(String date,String date2);

    List<SexJSON> getInpatientSex(String date,String date2);

    List<SexJSON> getLeaveSex(String date,String date2);

    PeopleJSON getPeopleMessage();

    MoneyJSON getMoneyMessage();

    List<MoneyAnalysis> getDeposit(String date,String date2);

    List<MoneyAnalysis> getBill(String date,String date2);

    List<StatisticsMonth> getStatisticsMonth(String date);

    List<Map<String,String>> getMonthMessage(String date);

}
