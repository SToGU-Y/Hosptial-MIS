package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.Dept;
import com.hh.his.graduationproject.model.vo.DeptSelectVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DeptConverter {

    DeptConverter INSTANCE = Mappers.getMapper(DeptConverter.class);

    DeptSelectVO toSelectVO(Dept dept);

    List<DeptSelectVO> toSelectVOList(List<Dept> depts);

}
