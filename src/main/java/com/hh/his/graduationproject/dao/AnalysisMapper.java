package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.vo.MoneyAnalysis;
import com.hh.his.graduationproject.model.vo.SexJSON;
import com.hh.his.graduationproject.model.vo.StatisticsMonth;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AnalysisMapper {

    List<SexJSON> selectInpatientSex(@Param("date") String date,@Param("date1")String date1);

    List<SexJSON> selectLeaveSex(@Param("date")String date,@Param("date1")String date1);

    int findTodayInpatient(@Param("today") String today);

    int findTotalInpatient();

    int findTodayLeave(@Param("today") String today);

    int findTotalLeave();

    BigDecimal findTodayDeposit(@Param("today") String today);

    BigDecimal findTotalDeposit();

    BigDecimal findTodayBill(@Param("today")String today);

    BigDecimal findTotalBill();

    List<MoneyAnalysis> analysisDeposit(@Param("date") String date,@Param("date1")String date1);

    List<MoneyAnalysis> analysisBill(@Param("date") String date,@Param("date1")String date1);

    List<StatisticsMonth> statisticsMonth(@Param("date")String date);

    List<HashMap<String,Object>> MonthlyHospitalization(@Param("date")String date);

    List<HashMap<String,Object>> MonthlyDischarged(@Param("date")String date);
}
