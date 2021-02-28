package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAppliance {

    private Integer id;

    private String manufacturer;
    private String no;
    private String name;
    private Integer status;
    private String type;
    private String details;
    private String remarks;

}
