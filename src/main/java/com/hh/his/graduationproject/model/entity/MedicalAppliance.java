package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAppliance {

    private Integer mId;

    private String mNo;
    private String mName;
    private Integer mStatus;
    private Integer mtId;
    private String mDetails;

}
