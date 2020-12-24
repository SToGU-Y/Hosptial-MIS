package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.InpatientWard;
import com.hh.his.graduationproject.model.vo.WardVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WardConverter {

    WardConverter  INSTANCE = Mappers.getMapper(WardConverter.class);

    @Mapping(target = "deptName",source = "dept.deptName")
    @Mapping(target = "iwtType",source = "wardType.iwtType")
    @Mapping(target = "iwtPrice",source = "wardType.iwtPrice")
    WardVO doToVO(InpatientWard ward);


    List<WardVO> doToVOs(List<InpatientWard> wards);

}
