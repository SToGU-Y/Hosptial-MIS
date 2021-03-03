package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.Cost;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.vo.DrugApplicationVO;
import com.hh.his.graduationproject.model.vo.MedicalAdviceQueryVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CostConverter {

    CostConverter INSTANCE = Mappers.getMapper(CostConverter.class);

    @Mapping(target = "costNo",source = "madvOperationNo")
    @Mapping(target = "costType",source = "madvOperationType")
    @Mapping(target = "costName",source = "madvOperation")
    @Mapping(target = "costSpecifications",source = "madvSpecifications")
    @Mapping(target = "costNum",source = "madvFrequency")
    @Mapping(target = "costDose",source = "madvDose")
    @Mapping(target = "costUnit",source = "madvUnit")
    @Mapping(target = "costPrice",source = "madvPrice")
    @Mapping(target = "costSum",expression = "java( new java.math.BigDecimal(m.getMadvFrequency()).multiply(m.getMadvPrice()) )")
    @Mapping(target = "costDate",expression = "java(new java.util.Date())")
    @Mapping(target = "admissionId",source = "admissionId")
    @Mapping(target = "operator",source = "madvExecuteNurse")
    Cost medicalAdviceToCost(MedicalAdviceQueryVO m);

    @Mapping(target = "costSum",expression = "java( new java.math.BigDecimal(drugApplicationVO.getDrugRequireNumber()).multiply(drugApplicationVO.getDrugPrice()) )")
    @Mapping(target = "costDose",source = "drugDose")
    @Mapping(target = "admissionId",source = "admissionId")
    @Mapping(target = "costNo",source = "drugNo")
    @Mapping(target = "costType",source = "drugType")
    @Mapping(target = "costName",source = "drugName")
    @Mapping(target = "costPrice",source = "drugPrice")
    @Mapping(target = "costSpecifications",source = "drugSpecifications")
    @Mapping(target = "costNum",source = "drugRequireNumber")
    @Mapping(target = "costUnit",source = "drugUnit")
    @Mapping(target = "costDate",source = "applyDate")
    @Mapping(target = "operator",source = "operator")
    Cost drugApplicationToCost(DrugApplicationVO drugApplicationVO);

    @Mapping(target = "costType",constant = "床位")
    @Mapping(target = "costSum",source = "ward.wardType.iwtPrice")
    @Mapping(target = "admissionId",source = "id")
    @Mapping(target = "costName",source = "ward.wardType.iwtType")
    @Mapping(target = "costPrice",source = "ward.wardType.iwtPrice")
    @Mapping(target = "costNum",expression = "java(1)")
    @Mapping(target = "costUnit",constant = "天")
    @Mapping(target = "costDate",expression = "java(new java.util.Date())")
    @Mapping(target = "operator",constant = "系统")
    Cost InpatientToCost(InpatientInformation information);

    List<Cost> ListInpatient(List<InpatientInformation> list);

    List<Cost> ListMedicalAdvice(List<MedicalAdviceQueryVO> list);
}
