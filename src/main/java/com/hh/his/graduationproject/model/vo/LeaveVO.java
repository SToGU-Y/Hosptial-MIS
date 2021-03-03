package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveVO {

    private Integer admissionId;
    private String admissionNumber;
    private String name;
    private String ptName;
    private BigDecimal deposit;
    private BigDecimal costSum;
    private BigDecimal pay;

}
