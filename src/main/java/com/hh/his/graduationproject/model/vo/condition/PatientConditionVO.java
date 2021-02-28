package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 病患查询条件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientConditionVO {

    /**
     * 病人身份证号
     */
    private String pid;

    /**
     * 病人姓名
     */
    private String pname;

}
