package com.hh.his.graduationproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardAddDTO {

    private String deptId;

    private Integer wardId;

    private Integer wardBedNum;

    private Integer wardStatus;

    private Integer wardType;

}
