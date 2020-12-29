package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
