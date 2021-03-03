package com.hh.his.graduationproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardUpdateDTO {

    private Integer wid;
    private Integer wardId;
    private String deptId;
    private Integer wardBedNumber;
    private Integer wardStatus;
    private Integer wardType;
}
