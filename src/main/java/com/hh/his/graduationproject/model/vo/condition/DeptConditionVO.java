package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 科室查询条件
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptConditionVO {

    private String deptId;
    private String deptName;
    private String director;

}
