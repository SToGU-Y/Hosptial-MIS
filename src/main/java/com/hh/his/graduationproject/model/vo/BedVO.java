package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 病床信息主视图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedVO {

    private Integer admissionId;
    private Integer wid;
    private Integer id;
    private String deptName;
    private Integer wardId;
    private String iwtType;
    private Integer bid;
    private Integer bedStatus;
    private String admissionNumber;
    private String pname;

}
