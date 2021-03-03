package com.hh.his.graduationproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientUpdateDTO {

    private String oldpid;

    private String pid;

    private String pname;

    private String sex;

    private String nationality;

    private String nation;

    private Timestamp birth;

    private String tel;

    private String born;

    private String married;

    private String regAddr;

    private String currAddr;

    private String province;

    private String city;

    private String contact;

    private String conRel;

    private String conTel;


}
