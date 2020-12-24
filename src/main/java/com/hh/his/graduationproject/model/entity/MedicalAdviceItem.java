package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAdviceItem {

    private Integer madvitemId;

    private Timestamp madvStartDate;
    private String madvOperation;
    private Timestamp madvEndDate;
    private String madvDoc;
    private Integer madvDose;
    private Integer madvAmount;
    private String madvUsage;
    private String madvWay;
    private BigDecimal madvPrice;

    private Integer madvId;

}
