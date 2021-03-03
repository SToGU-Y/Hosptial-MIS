package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.model.vo.StaffAddVO;
import com.hh.his.graduationproject.model.vo.StaffUpdateVO;
import com.hh.his.graduationproject.model.vo.StaffVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StaffConverter {

    StaffConverter INSTANCE = Mappers.getMapper(StaffConverter.class);


    @Mapping(target = "entryTime",source = "entryTime")
    @Mapping(target = "staffBirth",source = "staffBirth")
    @Mapping(target = "deptName",source = "deptName")
    StaffVO toVO(Staff staff);

    @Mapping(target = "password",expression = "java( new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(staffAddVO.getPassword()) )")
    @Mapping(target = "roles" ,ignore = true)
    @Mapping(target = "entryTime",expression = "java(new java.util.Date())")
    Staff toDO(StaffAddVO staffAddVO);

    @Mapping(target = "role",ignore = true)
    @Mapping(target = "staffBirth",source = "staffBirth")
    @Mapping(target = "deptName",source = "deptName")
    StaffUpdateVO toUpdateVO(Staff staff);

    List<StaffVO> toVOList(List<Staff> staffList);

}
