package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyJSON {

    private BigDecimal todayDeposit;
    private BigDecimal totalDeposit;
    private BigDecimal todayBill;
    private BigDecimal totalBill;

}
