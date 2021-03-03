package com.hh.his.graduationproject.model.vo.condition;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 病床信息的条件查询视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedConditionVO {

    private String deptId;
    private Integer bid;
    private Integer bedStatus;
    private Integer iwtId;
    private String name;

}
