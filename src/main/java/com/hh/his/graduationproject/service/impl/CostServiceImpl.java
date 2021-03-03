package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.CostMapper;
import com.hh.his.graduationproject.dao.DepositMapper;
import com.hh.his.graduationproject.model.entity.Cost;
import com.hh.his.graduationproject.model.entity.Deposit;
import com.hh.his.graduationproject.model.vo.InformationWithCost;
import com.hh.his.graduationproject.model.vo.QueryCostVO;
import com.hh.his.graduationproject.model.vo.condition.QueryCondition;
import com.hh.his.graduationproject.service.CostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class CostServiceImpl implements CostService {

    @Autowired
    private CostMapper costMapper;

    @Autowired
    private DepositMapper depositMapper;


    @Override
    public int addCostRecord(Cost cost) {
        cost.setCostDate(new Date());
        BigDecimal costNum = new BigDecimal(cost.getCostNum());
        cost.setCostSum(cost.getCostPrice().multiply(costNum));
        int insert = costMapper.insert(cost);
        return insert;
    }

    @Override
    public List<Cost> getCostByAdmissionId(Integer admissionId,String date1,String date2) {
        List<Cost> costs = costMapper.selectByAdmissionId(admissionId,date1,date2);
        return costs;
    }

    @Override
    public int delCost(List<Cost> costList) {
        int i = 0;
        if (!costList.isEmpty()){
            for (Cost cost : costList){
                i = i+ costMapper.delete(cost.getCostId());
            }
        }
        return i;
    }

    @Override
    public PageInfo<QueryCostVO> QueryCost(Integer pageNum, QueryCondition condition) throws Exception {
        if (condition.getAdmissionNumber().equals("") && condition.getPid().equals("")){
            throw new Exception("请输入查询条件");
        }
        PageHelper.startPage(pageNum,10);
        List<QueryCostVO> list = costMapper.costQuery(condition);

        List<Deposit> deposits = null;
        List<Cost> costs = null;
        for(QueryCostVO queryCostVO : list){
            BigDecimal ye = new BigDecimal(0);
            BigDecimal hf = new BigDecimal(0);
            deposits = depositMapper.selectDepositById(queryCostVO.getId());
            if (!deposits.isEmpty()){
                for (Deposit deposit : deposits){
                    if (deposit.getStatus() == 1 && deposit.getDesIsRefund() == 0){
                        ye = ye.add(deposit.getDeposit());
                    }
                }
            }
            queryCostVO.setDeposit(ye);
            costs = costMapper.selectByAdmissionId(queryCostVO.getId(),"","");
            if (!costs.isEmpty()){
                for (Cost cost : costs){
                    hf = hf.add(cost.getCostSum());
                }
            }
            queryCostVO.setCostSum(hf);
        }

        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
