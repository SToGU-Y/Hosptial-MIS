package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostItem {

    private String costItemNo;
    private String costItemName;
    private BigDecimal costItemPrice;
    private String costItemType;
    private String costItemUnit;
    private String costItemSpecifications;
    private String costItemDose;

}
