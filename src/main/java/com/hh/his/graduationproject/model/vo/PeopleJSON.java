package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleJSON {

    private Integer todayInpatient;
    private Integer totalInpatient;
    private Integer todayLeave;
    private Integer totalLeave;

}
