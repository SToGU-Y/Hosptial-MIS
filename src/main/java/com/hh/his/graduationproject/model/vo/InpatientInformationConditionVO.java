package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 映射前端传来的JSON
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpatientInformationConditionVO extends PatientConditionVO {

    /**
     * 科室
     */
    private String deptId;

    /**
     * 住院号
     */
    private String[] admissionNumber;

}
