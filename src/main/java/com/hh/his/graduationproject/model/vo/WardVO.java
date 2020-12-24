package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardVO {


    private String deptName;
    private Integer wardId;
    private String wardStatus;
    private String wardBedNum;
    private String iwtType;
    private BigDecimal iwtPrice;


}

