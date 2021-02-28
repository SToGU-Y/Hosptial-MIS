package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.dto.InpatientAddDTO;
import com.hh.his.graduationproject.model.dto.InpatientUpdateDTO;
import com.hh.his.graduationproject.model.entity.Deposit;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.entity.Patient;
import com.hh.his.graduationproject.model.vo.*;
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


    @Mapping(source = "bed.bid",target = "bid")
    @Mapping(source = "ward.wardId",target = "iwardId")
    @Mapping(source = "patient.pid",target = "pid")
    @Mapping(source = "patient.pname",target = "pname")
    @Mapping(source = "patient.sex",target = "sex")
    @Mapping(source = "patient.birth",target = "birth")
    @Mapping(source = "deptName",target = "deptName")
    @Mapping(source = "patient.tel",target = "tel")
    @Mapping(source = "patient.regAddr",target = "regAddr")
    @Mapping(source = "ptName",target = "ptName")
    InpatientInformationVO doToVo(InpatientInformation inpatientInformation);

    @Mapping(source = "inpatientInformation.bed.bid",target = "bid")
    @Mapping(source = "inpatientInformation.ward.wardId",target = "iwardId")
    @Mapping(source = "inpatientInformation.id",target = "id")
    @Mapping(source = "deposit.paymentType",target = "payment")
    @Mapping(source = "deposit.status",target = "status")
    @Mapping(source = "deposit.deposit",target = "deposit")
    @Mapping(source = "inpatientInformation.patient.born",target = "born")
    @Mapping(source = "inpatientInformation.patient.nation",target = "nation")
    @Mapping(source = "inpatientInformation.patient.nationality",target = "nationality")
    @Mapping(source = "inpatientInformation.patient.city",target = "city")
    @Mapping(source = "inpatientInformation.patient.province",target = "province")
    @Mapping(source = "inpatientInformation.patient.pid",target = "pid")
    @Mapping(source = "inpatientInformation.patient.pname",target = "pname")
    @Mapping(source = "inpatientInformation.patient.sex",target = "sex")
    @Mapping(source = "inpatientInformation.patient.birth",target = "birth")
    @Mapping(source = "inpatientInformation.deptName",target = "deptName")
    @Mapping(source = "inpatientInformation.patient.tel",target = "tel")
    @Mapping(source = "inpatientInformation.patient.married",target = "married")
    @Mapping(source = "inpatientInformation.patient.contact",target = "contact")
    @Mapping(source = "inpatientInformation.patient.conRel",target = "conRel")
    @Mapping(source = "inpatientInformation.patient.conTel",target = "conTel")
    @Mapping(source = "inpatientInformation.patient.regAddr",target = "regAddr")
    @Mapping(source = "inpatientInformation.patient.currAddr",target = "currAddr")
    @Mapping(source = "inpatientInformation.ptName",target = "ptName")
    InpatientUpdateVO doToUpdateVO(InpatientInformation inpatientInformation, Deposit deposit);

    @Mapping(target = "status",ignore = true)
    @Mapping(target = "ptName",source = "ptName")
    InpatientAddDTO toDTO(InpatientInformationAddVO informationVO);

    InpatientUpdateDTO toDTO(InpatientUpdateVO updateVO);


    @Mapping(source = "id",target = "inpatientId")
    @Mapping(source = "patient.pid",target = "pid")
    @Mapping(source = "patient.pname",target = "pname")
    BedPatientSelectVO toBedSelectVO(InpatientInformation information);

    @Mapping(source = "information.ward.wardId",target = "wardId")
    @Mapping(source = "information.bed.bid",target = "bid")
    @Mapping(source = "information.bed.id",target = "id")
    @Mapping(source = "information.ward.wid",target = "wid")
    @Mapping(source = "information.id",target = "inpatientId")
    @Mapping(source = "information.patient.pid",target = "pid")
    @Mapping(source = "information.patient.pname",target = "pname")
    BedChangePatientSelectVO toBedChangeVO(InpatientInformation information);

    Patient toPatient(InpatientInformationAddVO informationVO);

    @Mapping(target = "paymentType",source = "payment")
    @Mapping(target = "deposit",ignore = true)
    Deposit toDeposit(InpatientInformationAddVO informationVO);


    Patient toPatient(InpatientUpdateVO updateVO);


    @Mapping(source = "bed.bid",target = "bid")
    @Mapping(source = "ward.wardId",target = "iwardId")
    @Mapping(source = "patient.pid",target = "pid")
    @Mapping(source = "patient.pname",target = "pname")
    @Mapping(source = "patient.sex",target = "sex")
    @Mapping(source = "patient.birth",target = "birth")
    @Mapping(source = "deptName",target = "deptName")
    @Mapping(source = "patient.tel",target = "tel")
    @Mapping(source = "patient.regAddr",target = "regAddr")
    @Mapping(source = "ptName",target = "ptName")
    @Mapping(source = "day",target = "day")
    LeaveQueryVO toLeaveQueryVO(InpatientInformation inpatientInformation);


    List<InpatientInformationVO> doToVoList(List<InpatientInformation> inpatientInformationList);

    List<BedPatientSelectVO> toBedSelectVOList(List<InpatientInformation> inpatientInformationList);

    List<BedChangePatientSelectVO> toBedChangeVOList(List<InpatientInformation> inpatientInformationList);

    List<LeaveQueryVO> toLeaveQueryVOList(List<InpatientInformation> inpatientInformation);

}
