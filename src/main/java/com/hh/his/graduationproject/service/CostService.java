package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.Cost;
import com.hh.his.graduationproject.model.vo.QueryCostVO;
import com.hh.his.graduationproject.model.vo.condition.QueryCondition;

import java.util.List;

public interface CostService {

    int addCostRecord(Cost cost);

    List<Cost> getCostByAdmissionId(Integer admissionId,String date1,String date2);

    int delCost(List<Cost> costList);

    PageInfo<QueryCostVO> QueryCost(Integer pageNum, QueryCondition condition) throws Exception;
}
