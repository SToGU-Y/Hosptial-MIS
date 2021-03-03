package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRecordVO {

    private Integer id;
    private Integer admissionId;
    private String admissionNumber;
    private String pid;
    private String ptName;
    private Date birth;
    private String sex;
    private String name;
    private String wardId;
    private String bid;
    private String deptName;
    private String age;
    private Date dateOfAdmission;
    private Date leaveDate;
    private String admission;
    private String admissionDiagnosis;
    private String diagnosisProcess;
    private String dischargeStatus;
    private String dischargeDiagnosis;
    private String dischargeAdvice;
    private String doctor;
    private String nurse;
    private Integer inpatientStatus;


}
