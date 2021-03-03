package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillCondition {

    private String operator;
    private String admissionNumber;
    private String payDateStart;
    private String payDateEnd;


}
