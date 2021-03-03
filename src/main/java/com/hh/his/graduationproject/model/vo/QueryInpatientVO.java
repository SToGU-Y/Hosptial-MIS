package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryInpatientVO {

    private Integer id;
    private String medicalNumber;
    private String admissionNumber;
    private String pid;
    private String pname;
    private String sex;
    private Integer age;
    private Timestamp birth;
    private String ptName;
    private String deptName;
    private String iwardId;
    private String bid;
    private String admittedDoc;
    private String attendingDoc;
    private String visitingDoc;
    private String diagnosis01;
    private String diagnosis02;
    private String regAddr;
    private String tel;
    private Timestamp dateOfAdmission;
    private Date dateOfDischarge;
    private Integer day;
    private Integer status;

}
