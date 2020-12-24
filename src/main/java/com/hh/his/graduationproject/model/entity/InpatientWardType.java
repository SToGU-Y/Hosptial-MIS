package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpatientWardType {

    private Integer iwtId;
    private String iwtType;
    private BigDecimal iwtPrice;

}
