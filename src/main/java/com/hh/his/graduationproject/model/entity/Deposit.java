package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deposit {

    /**
     * 押金号
     */
    private String desId;

    /**
     * 支付金额
     */
    private BigDecimal deposit;

    /**
     * 支付状态
     */
    private String status;

    /**
     * 支付方式
     */
    private Integer paymentNo;

    /**
     * 押金是否退还
     */
    private Integer desIsRefund;

    /**
     * 收款人
     */
    private String sid;

    /**
     * 住院主键
     */
    private Integer id;
}
