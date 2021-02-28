package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.Patient;
import com.hh.his.graduationproject.model.vo.PatientVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * PatientBeanConverter
 */
@Mapper
public interface PatientConverter {

    PatientConverter INSTANCE = Mappers.getMapper(PatientConverter.class);


    @Mapping(target = "nativePlace",expression = "java(patient.getProvince() + patient.getCity())")
    @Mapping(source = "nation",target = "nation")
    PatientVO doToVo(Patient patient);

    List<PatientVO> toVOList(List<Patient> patients);

}
