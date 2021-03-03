package com.hh.his.graduationproject.model.vo.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRecordCondition {

    private String pid;

    private String pname;

    private String doctor;

    private String admissionNumber;

    private Integer status;

    private String leaveDateStart;

    private String leaveDateEnd;

}
