package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 映射前端传来的JSON
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpatientInformationConditionVO{

    /**
     * 病人身份证号
     */
    private String pid;

    /**
     * 病人姓名
     */
    private String pname;

    /**
     * 科室
     */
    private String deptName;

    /**
     * 住院号
     */
    private String admissionNumber;

    private String admissionOfDateStart;

    private String admissionOfDateEnd;

}
