package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.Bed;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.vo.BedSelectVO;
import com.hh.his.graduationproject.model.vo.BedVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BedConverter {

    BedConverter INSTANCE = Mappers.getMapper(BedConverter.class);


    @Mapping(target = "wid",source = "ward.wid")
    @Mapping(target = "wardBedNum",source = "ward.wardBedNum")
    @Mapping(target = "wardId",source = "ward.wardId")
    @Mapping(target = "iwtPrice",source = "ward.wardType.iwtPrice")
    @Mapping(target = "iwtType",source = "ward.wardType.iwtType")
    @Mapping(target = "deptName",source = "ward.dept.deptName")
    BedSelectVO toVO(Bed bed);

    @Mapping(target = "admissionId",source = "information.id")
    @Mapping(target = "wid",source = "information.ward.wid")
    @Mapping(target = "pname",source = "information.patient.pname")
    @Mapping(target = "admissionNumber",source = "information.admissionNumber")
    @Mapping(target = "bedStatus",source = "information.bed.bedStatus")
    @Mapping(target = "bid",source = "information.bed.bid")
    @Mapping(target = "iwtType",source = "information.ward.wardType.iwtType")
    @Mapping(target = "wardId",source = "information.ward.wardId")
    @Mapping(target = "id",source = "information.bed.id")
    BedVO toVO(InpatientInformation information);

    List<BedSelectVO> toVOs(List<Bed> bedList);

    List<BedVO> toVOList(List<InpatientInformation> list);
}
