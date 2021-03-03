package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdviceExecuteConditionVO {

    private String madvSentTimeFrom;
    private String madvSentTimeTo;
    private String admissionNumber;
    private String name;
    private Integer status;
    private String madvType;
    private String deptName;
}
