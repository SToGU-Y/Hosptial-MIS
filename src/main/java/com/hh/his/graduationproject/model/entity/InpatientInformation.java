package com.hh.his.graduationproject.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InpatientInformation {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 操作人
     */
    private String sid;

    /**
     * 住院号
     */
    private String admissionNumber;

    /**
     * 病人身份证号
     */
    private Patient patient;

    /**
     * 病人性质
     */
    private PatientType patientType;

    /**
     * 诊断1
     */
    private String diagnosis01;

    /**
     * 诊断2
     */
    private String diagnosis02;

    /**
     * 入住科室
     */
    private Dept dept;

    /**
     * 收治医生
     */
    private String admittedDoc;

    /**
     * 主治医生
     */
    private String attendingDoc;

    /**
     * 主诊医生
     */
    private String visitingDoc;

    /**
     * 病房
     */
    private Integer iwardId;

    /**
     * 病床
     */
    private String bid;

    /**
     * 入院日期
     */
    private Timestamp dateOfAdmission;

    /**
     * 出院日期
     */
    private Timestamp dateOfDischarge;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 住院天数
     */
    private Integer day;

    /**
     * 医保登记号
     */
    private String medicalNumber;


}
