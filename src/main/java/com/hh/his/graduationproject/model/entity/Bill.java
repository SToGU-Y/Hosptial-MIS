package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    private Integer id;

    private String costId;
    private String sId;
    private BigDecimal sum;
    private Timestamp date;
    private Integer paymentNo;

}
