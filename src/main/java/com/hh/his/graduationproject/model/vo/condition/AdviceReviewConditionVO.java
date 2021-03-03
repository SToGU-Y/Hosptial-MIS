package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdviceReviewConditionVO {

    private String madvSentTimeFrom;
    private String madvSentTimeTo;
    private String admissionNumber;
    private String name;
    private String username;
    private String madvType;
    private String deptName;

}
