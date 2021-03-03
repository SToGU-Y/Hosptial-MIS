package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositAddJSON {

    private String admissionNumber;
    private String operator;
    private String deposit;
    private String paymentType;
}
