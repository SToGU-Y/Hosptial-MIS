package com.hh.his.graduationproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffAddDTO {

    private String username;
    private String staffName;
    private String password;
    private String deptName;
    private String staffAddr;
    private String identity;
    private String staffTel;
    private String staffSex;
    private String staffNation;
    private String staffMarried;
    private Date staffBirth;
    private Date entryTime;

}
