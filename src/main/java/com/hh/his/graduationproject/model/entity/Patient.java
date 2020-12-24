package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

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


}
