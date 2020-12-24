package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentType {

    /**
     * 支付方式编号
     */
    private Integer paymentNo;

    /**
     * 支付方式(类型)名称
     */
    private String paymentType;
}
