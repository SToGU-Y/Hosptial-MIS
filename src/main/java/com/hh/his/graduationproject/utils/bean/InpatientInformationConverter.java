package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.vo.InpatientInformationVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Bean转换
 */
@Mapper
public interface InpatientInformationConverter {
    InpatientInformationConverter INSTANCE = Mappers.getMapper(InpatientInformationConverter.class);


    @Mapping(source = "patient.pid",target = "pid")
    @Mapping(source = "patient.pname",target = "pname")
    @Mapping(source = "patient.sex",target = "sex")
    @Mapping(source = "patient.age",target = "age")
    @Mapping(source = "patient.birth",target = "birth")
    @Mapping(source = "dept.deptName",target = "deptName")
    @Mapping(source = "patient.tel",target = "tel")
    @Mapping(source = "patient.regAddr",target = "regAddr")
    @Mapping(source = "patientType.ptName",target = "ptName")
    InpatientInformationVO doToVo(InpatientInformation inpatientInformation);


    List<InpatientInformationVO> doToVoList(List<InpatientInformation> inpatientInformationList);
}
