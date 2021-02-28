package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.Bill;
import com.hh.his.graduationproject.model.vo.BillVO;
import com.hh.his.graduationproject.model.vo.ReportVO;
import com.hh.his.graduationproject.model.vo.condition.BillCondition;
import com.hh.his.graduationproject.model.vo.condition.ReportCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {

    List<BillVO> selectAllBill(@Param("condition")BillCondition condition);

    int insert(@Param("bill") Bill bill);

    int deleteByAdmissionId(@Param("admissionId")Integer admissionId);

    int deleteByBillId(@Param("billId")String billId);

    List<ReportVO> getReportBill(@Param("condition") ReportCondition condition);
}
