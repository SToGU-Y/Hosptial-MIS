package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    /**
     * 员工工号
     */
    private String sid;

    /**
     * 员工姓名
     */
    private String sname;

    /**
     * 员工密码
     */
    private String spw;

    /**
     * 员工角色
     */
    private int rid;

    /**
     * 员工科室
     */
    private Dept dept;

}
