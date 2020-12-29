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
    private Integer bid;

    /**
     * 病房号主键
     */
    private InpatientWard ward;

    /**
     * 病床状态
     */
    private Integer bedStatus;

}
