package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drug {

    private Integer drugId;

    private String drugNo;
    private String drugName;
    private Integer drugNum;
    private String drugDetail;
    private BigDecimal drugPrice;
    private String drugSpecifications;
    private String drugUnit;
    private String doseUnit;
    private String drugType;

}
