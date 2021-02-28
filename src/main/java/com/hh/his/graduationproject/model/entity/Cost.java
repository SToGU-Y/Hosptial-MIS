package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cost {

    private Integer costId;
    private String costNo;
    private String costType;
    private String costName;
    private String costSpecifications;
    private BigDecimal costPrice;
    private Integer costNum;
    private String costDose;
    private String costUnit;
    private BigDecimal costSum;
    private Date costDate;
    private Integer admissionId;
    private String operator;

}
