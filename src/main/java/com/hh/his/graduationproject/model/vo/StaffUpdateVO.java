package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 员工更新页面视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffUpdateVO {

    private String username;
    private String staffName;
    private String deptName;
    private String staffAddr;
    private String idNumber;
    private String staffTel;
    private String staffSex;
    private String staffNation;
    private String staffMarried;
    private Date staffBirth;
    private List<Integer> role;

}
