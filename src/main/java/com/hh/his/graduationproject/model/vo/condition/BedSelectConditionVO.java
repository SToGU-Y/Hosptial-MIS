package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 选择病床的条件查询视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedSelectConditionVO {

    private String deptId;
    private Integer iwtId;

}
