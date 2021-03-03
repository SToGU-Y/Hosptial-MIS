package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工条件查询视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffConditionVO {

    private String deptName;
    private String username;
    private String staffName;
    private String idNumber;

}
