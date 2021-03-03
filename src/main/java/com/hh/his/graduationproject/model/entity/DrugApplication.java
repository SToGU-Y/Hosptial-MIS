package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugApplication {

    private Integer drugApplicationId;
    private InpatientInformation admission;
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
