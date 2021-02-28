package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {

    private Integer id;

    private InpatientInformation admissionId;
    private String operator;
    private String drugAllergy;
    private String historyOfPresentIllness;
    private String anamnesis;
    private String symptom;
    private Date createTime;

}
