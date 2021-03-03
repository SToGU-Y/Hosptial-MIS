package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.Bill;
import com.hh.his.graduationproject.model.vo.BillVO;
import com.hh.his.graduationproject.model.vo.ReportVO;
import com.hh.his.graduationproject.model.vo.condition.BillCondition;
import com.hh.his.graduationproject.model.vo.condition.ReportCondition;

import java.util.List;

public interface BillService {

    String addBill(Bill bill);

    PageInfo<BillVO> getAllBill(Integer pageNum, BillCondition condition);

    int deleteBill(List<BillVO> list);

    List<ReportVO> getReport(ReportCondition condition);

}
