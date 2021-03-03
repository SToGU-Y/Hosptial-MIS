package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositQueryVO {

    private String desId;
    private Integer admissionId;
    private String medicalNumber;
    private String admissionNumber;
    private String pid;
    private String pname;
    private Integer age;
    private BigDecimal deposit;
    private Integer depositStatus;
    private Date datePay;
    private String paymentType;
    private String operator;
    private String sex;
    private String ptName;
    private String deptName;
    private String iwardId;
    private String bid;
    private Date dateOfAdmission;

}
