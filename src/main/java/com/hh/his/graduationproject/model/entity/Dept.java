package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

    /**
     * 科室编号
     */
    private String deptId;

    /**
     * 科室名称
     */
    private String deptName;

}
