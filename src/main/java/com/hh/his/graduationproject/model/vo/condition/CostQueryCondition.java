package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostQueryCondition {

    private String pid;

    private String pname;

    private String deptName;

    private String admissionNumber;

    private Integer status;

}
