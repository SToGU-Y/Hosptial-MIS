package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接受前端更换病床的信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpatientBedChangeVO {


    private Integer inpatientId;//住院信息主键
    private Integer id; //床位主键
    private Integer wid;//病房主键

    private Integer oldid;
    private Integer oldwid;

}
