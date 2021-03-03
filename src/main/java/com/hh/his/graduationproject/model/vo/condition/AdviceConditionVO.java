package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdviceConditionVO {

    private Integer status;
    private String admissionNumber;
    private String name;
    private String username;
    private String madvType;

}
