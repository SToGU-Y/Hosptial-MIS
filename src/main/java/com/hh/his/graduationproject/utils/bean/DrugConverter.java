package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.vo.DrugApplicationVO;
import com.hh.his.graduationproject.model.vo.MedicalAdviceQueryVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DrugConverter {

    DrugConverter INSTANCE = Mappers.getMapper(DrugConverter.class);

    @Mapping(target = "drugNo",source = "madvOperationNo")
    @Mapping(target = "drugName",source = "madvOperation")
    @Mapping(target = "drugType",source = "madvOperationType")
    @Mapping(target = "drugSpecifications",source = "madvSpecifications")
    @Mapping(target = "drugDose",source = "madvDose")
    @Mapping(target = "drugUnit",source = "madvUnit")
    @Mapping(target = "status",expression = "java(0)")
    @Mapping(target = "drugPrice",source = "madvPrice")
    @Mapping(target = "drugRequireNumber",source = "madvFrequency")
    @Mapping(target = "drugRequireDept",source = "deptName")
    DrugApplicationVO toDrugApplication(MedicalAdviceQueryVO medicalAdvice);

    List<DrugApplicationVO> ListDrugApplication(List<MedicalAdviceQueryVO> medicalAdviceQueryVOS);
}
