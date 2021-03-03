package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 病房添加视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardAddVO {

    private String deptId;
    private Integer wardId;
    private Integer iwtId;

}
