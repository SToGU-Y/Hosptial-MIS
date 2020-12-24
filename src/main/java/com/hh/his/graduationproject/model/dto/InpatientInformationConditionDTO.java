package com.hh.his.graduationproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 映射前端传来的JSON
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpatientInformationConditionDTO extends PatientConditionDTO{

    /**
     * 科室
     */
    private String deptId;

    /**
     * 住院号
     */
    private String[] admissionNumber;
}
