package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRecord {

    private Integer id;
    private Integer admissionId;
    private String admission;
    private String admissionDiagnosis;
    private String diagnosisProcess;
    private String dischargeStatus;
    private String dischargeDiagnosis;
    private String dischargeAdvice;
    private String doctor;
    private Date leaveDate;

}
