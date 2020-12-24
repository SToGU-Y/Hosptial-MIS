package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientType {

    /**
     * 病人性质编号
     */
    private Integer ptId;

    /**
     * 病人性质类型
     */
    private String ptName;

}
