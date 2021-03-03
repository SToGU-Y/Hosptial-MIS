package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.*;
import com.hh.his.graduationproject.model.dto.BedUpdateDTO;
import com.hh.his.graduationproject.model.dto.WardUpdateDTO;
import com.hh.his.graduationproject.model.entity.Bill;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.vo.BillVO;
import com.hh.his.graduationproject.model.vo.MedicalAdviceQueryVO;
import com.hh.his.graduationproject.model.vo.ReportVO;
import com.hh.his.graduationproject.model.vo.condition.BillCondition;
import com.hh.his.graduationproject.model.vo.condition.ReportCondition;
import com.hh.his.graduationproject.service.BillService;
import com.hh.his.graduationproject.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    @Autowired
    private InpatientInformationMapper informationMapper;

    @Autowired
    private DepositMapper depositMapper;



    @Override
    public String addBill(Bill bill) {
        bill.setDate(new Date());
        bill.setBillId(KeyUtil.createID());
        int insert = billMapper.insert(bill);
        //将住院记录状态改为出院状态，同时将操作人添加进去
        informationMapper.leaveSuccess(bill.getAdmissionId(),bill.getOperator());


        if (insert == 0){
            return "操作错误";
        }else {
            return "出院成功";
        }
    }

    @Override
    public PageInfo<BillVO> getAllBill(Integer pageNum, BillCondition condition) {
        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("date desc");
        List<BillVO> billVOS = billMapper.selectAllBill(condition);
        PageInfo pageInfo = new PageInfo(billVOS);
        return pageInfo;
    }

    @Override
    public int deleteBill(List<BillVO> list) {
        int i = 0;
        for (BillVO billVO: list){
            i = i + billMapper.deleteByBillId(billVO.getBillId());
        }
        return i;
    }

    @Override
    public List<ReportVO> getReport(ReportCondition condition) {

        List<ReportVO> reportDeposit = depositMapper.getReportDeposit(condition);
        ReportVO report1 = new ReportVO();
        report1.setType("收预缴金");
        report1.setNumber(reportDeposit.size());
        BigDecimal sum = new BigDecimal(0);
        for (ReportVO reportVO: reportDeposit){
            sum = sum.add(reportVO.getSum());
        }
        report1.setSum(sum);
        report1.setList(reportDeposit);

        List<ReportVO> reportBill = billMapper.getReportBill(condition);
        ReportVO report2 = new ReportVO();
        report2.setType("结算总金额");
        report2.setNumber(reportBill.size());
        BigDecimal sum2 = new BigDecimal(0);
        for (ReportVO reportVO: reportBill){
            sum2 = sum2.add(reportVO.getSum());
        }
        report2.setSum(sum2);
        report2.setList(reportBill);
        List<ReportVO> result = new ArrayList<>();
        result.add(report1);
        result.add(report2);
        return result;
    }


}
