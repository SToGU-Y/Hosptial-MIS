package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {

    private Integer id;

    private String pId;
    private String sId;
    private String medicalHistory;
    private String drugAllergy;
    private String personalHistory;
    private String symptom;

}
