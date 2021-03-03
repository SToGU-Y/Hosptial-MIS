package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 病床选择的主页视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedSelectVO {


    private Integer id; //床位主键
    private Integer wid; //病房主键
    private Integer bid; //床位号
    private String deptName;
    private Integer wardId;
    private String bedStatus;
    private String wardBedNum;
    private String iwtType;
    private BigDecimal iwtPrice;

}
