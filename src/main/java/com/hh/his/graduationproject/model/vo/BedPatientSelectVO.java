package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 点击选择病床之后展示的病人信息VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedPatientSelectVO {

    private Integer inpatientId;
    private String pid;
    private String pname;
    private String admissionNumber;

}
