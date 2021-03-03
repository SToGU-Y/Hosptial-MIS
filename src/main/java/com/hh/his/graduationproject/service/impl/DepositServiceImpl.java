package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.CostMapper;
import com.hh.his.graduationproject.dao.DepositMapper;
import com.hh.his.graduationproject.dao.InpatientInformationMapper;
import com.hh.his.graduationproject.model.entity.Deposit;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.vo.DepositQueryVO;
import com.hh.his.graduationproject.model.vo.condition.DepositAddJSON;
import com.hh.his.graduationproject.model.vo.condition.DepositRefundConditionVO;
import com.hh.his.graduationproject.model.vo.DepositUpdateVO;
import com.hh.his.graduationproject.model.vo.condition.InpatientInformationConditionVO;
import com.hh.his.graduationproject.model.vo.condition.QueryCondition;
import com.hh.his.graduationproject.service.DepositService;
import com.hh.his.graduationproject.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DepositServiceImpl implements DepositService {

    @Autowired
    private DepositMapper depositMapper;

    @Autowired
    private CostMapper costMapper;

    @Autowired
    private InpatientInformationMapper informationMapper;

    @Override
    public int depositReturn(DepositUpdateVO updateVO) {

        int count = costMapper.countCostByAdmissionId(updateVO.getAdmissionId());
        if (count>0){
            return 0;
        }

        Deposit deposit = new Deposit();
        deposit.setDesId(updateVO.getDesId());
        deposit.setSid(updateVO.getOperator());
        deposit.setDateRefund(new Date());

        int refund = depositMapper.refund(deposit);

        return refund;
    }

    @Override
    public PageInfo<Deposit> getAllRefund(Integer pageNum, DepositRefundConditionVO conditionVO) {
        PageHelper.startPage(pageNum,12);
        List<Deposit> deposits = depositMapper.selectRefund(conditionVO);
        PageInfo pageInfo = new PageInfo(deposits);
        return pageInfo;
    }

    @Override
    public int payDeposit(Deposit deposit) {
        deposit.setDatePay(new Date());
        int pay = depositMapper.pay(deposit);
        return pay;
    }

    @Override
    public int deleteDeposit(List<DepositQueryVO> deposits) {
        int i = 0;
        for (DepositQueryVO deposit: deposits){
            i = i+depositMapper.deleteByDesId(deposit.getDesId());
        }
        return i;
    }

    @Override
    public int delRefundDeposit(List<Deposit> deposits) {
        int i = 0;
        for (Deposit deposit: deposits){
            i = i+depositMapper.deleteByDesId(deposit.getDesId());
        }
        return i;
    }

    @Override
    public int addDeposit(DepositAddJSON depositAddJSON) throws Exception {
        InpatientInformationConditionVO inpatientInformationConditionVO = new InpatientInformationConditionVO();
        inpatientInformationConditionVO.setAdmissionNumber(depositAddJSON.getAdmissionNumber());
        List<InpatientInformation> inpatientInformations = informationMapper.selectAdmissionByConditions(inpatientInformationConditionVO);
        if (inpatientInformations.isEmpty()){
            throw new Exception("该住院号目前并无在院");
        }
        Deposit deposit = new Deposit();
        deposit.setDatePay(new Date());
        deposit.setPaymentType(depositAddJSON.getPaymentType());
        deposit.setDesIsRefund(0);
        deposit.setStatus(1);
        deposit.setDesId(KeyUtil.createID());
        deposit.setSid(depositAddJSON.getOperator());
        deposit.setDeposit(new BigDecimal(depositAddJSON.getDeposit()));
        deposit.setId(inpatientInformations.get(0).getId());

        int i = depositMapper.insertDeposit(deposit);

        return i;
    }

    @Override
    public PageInfo<DepositQueryVO> depositQuery(Integer pageNum, QueryCondition condition) throws Exception {
        if (condition.getPid().equals("") && condition.getAdmissionNumber().equals("")){
            throw new Exception("请填写搜索条件");
        }
        PageHelper.startPage(pageNum,10);
        List<DepositQueryVO> depositQueryVOS = depositMapper.depositQuery(condition);
        PageInfo pageInfo = new PageInfo(depositQueryVOS);
        return pageInfo;
    }


}
