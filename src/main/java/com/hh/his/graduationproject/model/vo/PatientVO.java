package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 病人信息视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientVO {

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
     * 病人国籍
     */
    private String nationality;

    /**
     * 病人民族
     */
    private String nation;


    /**
     * 病人出生年月日
     */
    private Timestamp birth;

    /**
     * 病人出生地
     */
    private String born;

    /**
     * 病人婚况
     */
    private String married;

    /**
     * 病人联系电话
     */
    private String tel;

    /**
     * 病人户口地址
     */
    private String regAddr;

    /**
     * 病人现居住地址
     */
    private String currAddr;

    /**
     * 病人籍贯
     */
    private String nativePlace;

    /**
     * 病人紧急联系人姓名
     */
    private String contact;

    /**
     * 病人紧急联系人关系
     */
    private String conRel;

    /**
     * 病人紧急联系人联系电话
     */
    private String conTel;



}
