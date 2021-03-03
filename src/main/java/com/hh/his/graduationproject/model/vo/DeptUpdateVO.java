package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 科室更新视图
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptUpdateVO {

    private String newDeptId;

    private String deptId;

    private String deptName;

    private String describe;

    private String director;
}
