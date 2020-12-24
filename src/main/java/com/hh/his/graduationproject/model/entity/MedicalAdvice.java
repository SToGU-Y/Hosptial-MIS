package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAdvice {

    private Integer madvId;

    private Integer madvtId;
    private String iiAdNumber;
}
