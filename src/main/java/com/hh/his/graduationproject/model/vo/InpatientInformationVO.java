package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


/**
 * 住院信息视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpatientInformationVO {


    private Integer id;
    /**
     * 医保登记号
     */
    private String medicalNumber;

    /**
     * 住院号
     */
    private String admissionNumber;

    /**
     * 病人身份证
     */
    private String pid;

    /**
     * 病人姓名
     */
    private String pname;

    /**
     * 病人性别
     */
    private String sex;

    /**
     * 病人年龄
     */
    private Integer age;

    /**
     * 病人出生年月日
     */
    private Timestamp birth;

    /**
     * 病人性质
     */
    private String ptName;

    /**
     * 入住科室
     */
    private String deptName;

    /**
     * 病房
     */
    private String iwardId;

    /**
     * 病床
     */
    private String bid;

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
     * 诊断1
     */
    private String diagnosis01;

    /**
     * 诊断2
     */
    private String diagnosis02;

    /**
     * 病人户口地址
     */
    private String regAddr;

    /**
     * 病人联系电话
     */
    private String tel;

    /**
     * 入院日期
     */
    private Timestamp dateOfAdmission;



}
