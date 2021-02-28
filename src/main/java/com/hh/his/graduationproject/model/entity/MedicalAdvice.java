package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAdvice {

    private Integer madvId;
    private InpatientInformation amission;
    private Date madvStartDate;
    private Timestamp madvStartTime;
    private String madvOperationNo;
    private String madvOperation;
    private String madvOperationType;
    private Date madvEndDate;
    private Timestamp madvEndTime;
    private String madvDoctor;
    private Integer madvDose;
    private Integer madvFrequency;
    private String madvUsage;
    private String madvSpecifications;
    private String entrustment;
    private BigDecimal madvPrice;
    private Integer status;
    private String madvNurse;
    private String madvExecuteNurse;
    private String madvEndDoctor;
    private String madvType;
    private String remarks;
    private String deptName;
    private Date madvSentTime;
}
