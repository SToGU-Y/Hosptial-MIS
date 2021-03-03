package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugApplyCondition {

    private String deptName;
    private String admissionNumber;
    private String name;
    private String drugNo;
    private String drugName;

}
