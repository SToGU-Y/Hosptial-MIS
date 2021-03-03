package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 住院信息更新视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpatientUpdateVO {

    private Integer id;
    /**
     * 身份证号
     */
    private String pid;

    /**
     * 姓名
     */
    private String pname;

    /**
     * 性别
     */
    private String sex;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 民族
     */
    private String nation;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 出生年月日
     */
    private Timestamp birth;

    /**
     * 电话
     */
    private String tel;

    /**
     * 出生地
     */
    private String born;

    /**
     * 婚况
     */
    private String married;

    /**
     * 户口地址
     */
    private String regAddr;

    /**
     * 居住地址
     */
    private String currAddr;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 紧急联系人姓名
     */
    private String contact;

    /**
     * 紧急联系人关系
     */
    private String conRel;

    /**
     * 紧急联系人电话
     */
    private String conTel;



    private String ptName;

    /**
     * 诊断1
     */
    private String diagnosis01;

    /**
     * 诊断2
     */
    private String diagnosis02;

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
     * 入住科室
     */
    private String deptName;

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
     * 医保登记号
     */
    private String medicalNumber;

    /**
     * 住院号
     */
    private String admissionNumber;


    /**
     * 预交押金金额
     */
    private String deposit;

    /**
     * 押金交付状态
     */
    private String status;

    /**
     * 押金交付方式
     */
    private String payment;


}
