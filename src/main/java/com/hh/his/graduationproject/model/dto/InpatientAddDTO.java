package com.hh.his.graduationproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpatientAddDTO {

    private String sid;
    private String admissionNumber;
    private Integer age;
    private String pid;
    private String ptName;
    private String diagnosis01;
    private String diagnosis02;
    private String deptName;
    private String admittedDoc;
    private String attendingDoc;
    private String visitingDoc;
    private Date dateOfAdmission;
    private String medicalNumber;
    private Integer status;

}
