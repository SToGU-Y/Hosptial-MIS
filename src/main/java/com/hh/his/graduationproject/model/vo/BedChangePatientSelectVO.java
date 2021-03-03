package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 点击更换病床之后的病人选择视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedChangePatientSelectVO {

    private Integer inpatientId;
    private String pid;
    private String pname;
    private String admissionNumber;
    private Integer wid;
    private Integer wardId;
    private Integer id;
    private Integer bid;

}
