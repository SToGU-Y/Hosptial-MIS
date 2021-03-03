package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 病床选择，点击选择病床已经选择病人的条件视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedPatientSelectConditionVO {

    private String deptName;
    private String pid;
    private String pname;
    private String admissionNumber;
}
