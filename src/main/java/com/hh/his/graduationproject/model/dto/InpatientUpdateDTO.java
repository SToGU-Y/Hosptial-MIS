package com.hh.his.graduationproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpatientUpdateDTO {

    private Integer id;
    private Integer age;
    private String pid;
    private String ptName;
    private String diagnosis01;
    private String diagnosis02;
    private String deptName;
    private String admittedDoc;
    private String attendingDoc;
    private String visitingDoc;
    private String medicalNumber;

}
