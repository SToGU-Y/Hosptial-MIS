package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nation {

    /**
     * 民族编号
     */
    private Integer no;

    /**
     * 民族名称
     */
    private String nationName;
}
