package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationWithCost {


    private Integer id;
    private String medicalNumber;
    private String admissionNumber;
    private String pname;
    private String ptName;
    private BigDecimal deposit;
    private BigDecimal costSum;
    private String deptName;
    private String iwardId;
    private String bid;
    private String pid;
    private String sex;
    private Integer age;
    private Timestamp birth;
    private String regAddr;
    private String tel;
    private Timestamp dateOfAdmission;
    private Timestamp dateOfDischarge;
    private Integer status;

}
