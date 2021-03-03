package com.hh.his.graduationproject.model.vo;

import com.hh.his.graduationproject.model.entity.InpatientInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordVO {

    private Integer id;

    private String admissionId;
    private String complaint;
    private String operator;
    private String drugAllergy;
    private String historyOfPresentIllness;
    private String anamnesis;
    private String symptom;
    private Date createTime;

}
