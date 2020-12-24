package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostItem {

    private Integer citemId;

    private Integer citemType;
    private String citemName;
    private Timestamp citemDate;
    private Integer citemNum;
    private BigDecimal citemPrice;
    private BigDecimal citemCost;
    private String deptId;
    private String costId;

}
