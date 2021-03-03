package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositRefundConditionVO {

    private String desId;
    private String operator;
    private String refundDateStart;
    private String refundDateEnd;

}
