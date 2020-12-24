package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bed {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 床号
     */
    private String bid;

    /**
     * 病房号
     */
    private InpatientWard iwardId;

    /**
     * 病床状态
     */
    private Integer status;

    /**
     * 病床价格(元/晚)
     */
    private BigDecimal price;
}
