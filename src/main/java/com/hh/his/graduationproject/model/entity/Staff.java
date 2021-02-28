package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff{

    private String username;
    private String staffName;
    private String password;
    private String deptName;
    private String staffAddr;
    private String idNumber;
    private String staffTel;
    private String staffSex;
    private String staffNation;
    private String staffMarried;
    private Date staffBirth;
    private Date entryTime;
    private List<Role> roles;

}
