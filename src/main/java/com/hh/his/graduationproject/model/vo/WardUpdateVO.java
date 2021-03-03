package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 病房更新页面视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardUpdateVO {

    private Integer wid;
    private Integer wardId;
    private String deptId;
    private Integer iwtId;


}
