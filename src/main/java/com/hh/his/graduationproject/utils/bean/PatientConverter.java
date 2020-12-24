package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.Patient;
import com.hh.his.graduationproject.model.vo.PatientVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * PatientBeanConverter
 */
@Mapper
public interface PatientConverter {

    PatientConverter INSTANCE = Mappers.getMapper(PatientConverter.class);


    @Mapping(source = "nation",target = "nation")
    PatientVO doToVo(Patient patient);

}
