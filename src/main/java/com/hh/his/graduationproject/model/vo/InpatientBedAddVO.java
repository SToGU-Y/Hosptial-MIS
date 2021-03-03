package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接收前端选择病床
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpatientBedAddVO {

    private Integer id; //床位主键
    private Integer wid;//病房主键
    private Integer inpatientId;//住院信息主键

}
