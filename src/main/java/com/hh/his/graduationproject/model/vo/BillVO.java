package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillVO {

    private String billId;
    private Integer admissionId;
    private String admissionNumber;
    private String operator;
    private BigDecimal deposit;
    private BigDecimal costSum;
    private BigDecimal pay;
    private Date date;
    private String paymentType;


}
