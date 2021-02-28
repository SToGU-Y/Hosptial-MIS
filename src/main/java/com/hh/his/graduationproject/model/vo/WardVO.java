package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 病房信息视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardVO {

    private Integer wid;
    private String deptId;
    private String deptName;
    private Integer wardId;
    private String wardStatus;
    private String wardBedNum;
    private Integer iwtId;
    private String iwtType;
    private BigDecimal iwtPrice;

}

