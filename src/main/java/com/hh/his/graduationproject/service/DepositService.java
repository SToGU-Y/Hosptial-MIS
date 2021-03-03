package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.Deposit;
import com.hh.his.graduationproject.model.vo.DepositQueryVO;
import com.hh.his.graduationproject.model.vo.condition.DepositAddJSON;
import com.hh.his.graduationproject.model.vo.condition.DepositRefundConditionVO;
import com.hh.his.graduationproject.model.vo.DepositUpdateVO;
import com.hh.his.graduationproject.model.vo.condition.QueryCondition;

import java.math.BigDecimal;
import java.util.List;


public interface DepositService {

    int depositReturn(DepositUpdateVO updateVO);

    PageInfo<Deposit> getAllRefund(Integer pageNum, DepositRefundConditionVO conditionVO);

    int payDeposit(Deposit deposit);

    int deleteDeposit(List<DepositQueryVO> deposits);

    int delRefundDeposit(List<Deposit> deposits);

    int addDeposit(DepositAddJSON depositAddJSON) throws Exception;

    PageInfo<DepositQueryVO> depositQuery(Integer pageNum, QueryCondition condition) throws Exception;

}
