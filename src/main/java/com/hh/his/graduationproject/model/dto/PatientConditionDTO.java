package com.hh.his.graduationproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientConditionDTO {

    /**
     * 病人身份证号
     */
    private String pid;

    /**
     * 病人姓名
     */
    private String pname;

}
