package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugApplicationVO {

    private Integer drugApplicationId;
    private Integer admissionId;
    private String name;
    private String admissionNumber;
    private Integer wardId;
    private Integer bid;
    private String deptName;
    private String drugNo;
    private String drugName;
    private String drugRequireDept;
    private Integer drugRequireNumber;
    private BigDecimal drugPrice;
    private String drugSpecifications;
    private String drugDose;
    private String drugUnit;
    private Integer status;
    private String operator;
    private Date applyDate;
    private Date offerDate;
    private String offerOperator;
    private String drugType;

}
