package com.hh.his.graduationproject.dao;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.Deposit;
import com.hh.his.graduationproject.model.vo.DepositQueryVO;
import com.hh.his.graduationproject.model.vo.ReportVO;
import com.hh.his.graduationproject.model.vo.condition.DepositRefundConditionVO;
import com.hh.his.graduationproject.model.vo.condition.QueryCondition;
import com.hh.his.graduationproject.model.vo.condition.ReportCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface DepositMapper {

    /**
     * 插入押金
     * @param deposit
     * @return
     */
    int insertDeposit(@Param("deposit")Deposit deposit);

    /**
     * 通过住院主键找对应押金记录
     * @param id
     * @return
     */
    List<Deposit> selectDepositById(@Param("id")Integer id);

    /**
     * 查询退款记录
     * @param conditionVO
     * @return
     */
    List<Deposit> selectRefund(@Param("deposit")DepositRefundConditionVO conditionVO);


    /**
     * 退款
     * @param deposit
     * @return
     */
    int refund(@Param("deposit") Deposit deposit);

    /**
     * 补交押金
     * @param deposit
     * @return
     */
    int pay(@Param("deposit")Deposit deposit);

    int deleteByDesId(@Param("desId")String desId);

    int deleteByAdmissionId(@Param("admissionId")Integer admissionId);

    List<DepositQueryVO> depositQuery(@Param("condition")QueryCondition condition);

    List<ReportVO> getReportDeposit(@Param("condition") ReportCondition condition);
}
