package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAdviceQueryVO {

    private Integer madvId;
    private Integer admissionId;
    private String deptName;  //开嘱科室
    private String deptName2; //病人住院科室
    private String admissionNumber; //住院号
    private String name; //病人姓名
    private String wardId; //病房号
    private String bid; //病床号
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
    private Date madvSentTime;


}
