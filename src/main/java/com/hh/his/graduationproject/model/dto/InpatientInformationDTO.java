package com.hh.his.graduationproject.model.dto;

import com.hh.his.graduationproject.model.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 映射前端传来的JSON
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InpatientInformationDTO extends Patient {

    /**
     * 诊断1
     */
    private String diagnosis01;

    /**
     * 诊断2
     */
    private String diagnosis02;

    /**
     * 收治医生
     */
    private String admittedDoc;

    /**
     * 主治医生
     */
    private String attendingDoc;

    /**
     * 主诊医生
     */
    private String visitingDoc;

    /**
     * 入住科室
     */
    private String deptId;

    /**
     * 病房
     */
    private Integer iwardId;

    /**
     * 病床
     */
    private String bid;

    /**
     * 入院日期
     */
    private Timestamp dateOfAdmission;

    /**
     * 出院日期
     */
    private Timestamp dateOfDischarge;

    /**
     * 医保登记号
     */
    private String medicalNumber;

    /**
     * 住院号
     */
    private String admissionNumber;

    /**
     * 操作人(办入院者)
     */
    private String sid;

    /**
     * 预交押金金额
     */
    private BigDecimal deposit;

    /**
     * 押金交付状态
     */
    private String status;

    /**
     * 押金交付方式
     */
    private String payment;


}
