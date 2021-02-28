package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 病房查询条件视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardConditionVO {

    private String deptIdSelective;

    private Integer wardId;

    private Integer wardStatus;

}
