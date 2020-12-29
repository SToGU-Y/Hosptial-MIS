package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drug {

    private Integer medId;

    private String medNo;
    private String medName;
    private Integer medNum;
    private String medDetail;
    private BigDecimal medPrice;

}
