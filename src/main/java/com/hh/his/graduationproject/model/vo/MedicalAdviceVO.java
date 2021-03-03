package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAdviceVO {

    private Integer madvId;
    private Integer admissionId;
    private Date madvStartDate;
    private String madvStartTime;
    private String madvOperationNo;
    private String madvOperationType;
    private String madvOperation;
    private Date madvEndDate;
    private Date madvEndTime;
    private String madvDoctor;
    private String madvUnit;
    private String madvDose;
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
