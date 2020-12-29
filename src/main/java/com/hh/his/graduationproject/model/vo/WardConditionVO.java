package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardConditionVO {

    private String deptIdSelective;

    private Integer wardId;

    private Integer wardStatus;

}
