package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpatientWard {

    private Dept dept;
    private Integer wardId;
    private Integer wardBedNum;
    private Integer wardStatus;
    private InpatientWardType wardType;

}
