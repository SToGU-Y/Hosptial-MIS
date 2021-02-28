package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.dto.InpatientAddDTO;
import com.hh.his.graduationproject.model.dto.InpatientUpdateDTO;
import com.hh.his.graduationproject.model.entity.Bed;
import com.hh.his.graduationproject.model.entity.Deposit;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.entity.InpatientWard;
import com.hh.his.graduationproject.model.entity.Patient;
import com.hh.his.graduationproject.model.vo.BedChangePatientSelectVO;
import com.hh.his.graduationproject.model.vo.BedPatientSelectVO;
import com.hh.his.graduationproject.model.vo.InpatientInformationAddVO;
import com.hh.his.graduationproject.model.vo.InpatientInformationVO;
import com.hh.his.graduationproject.model.vo.InpatientUpdateVO;
import com.hh.his.graduationproject.model.vo.LeaveQueryVO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-23T21:54:37+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class InpatientInformationConverterImpl implements InpatientInformationConverter {

    @Override
    public InpatientInformationVO doToVo(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }

        InpatientInformationVO inpatientInformationVO = new InpatientInformationVO();

        inpatientInformationVO.setDeptName( inpatientInformation.getDeptName() );
        inpatientInformationVO.setPname( inpatientInformationPatientPname( inpatientInformation ) );
        inpatientInformationVO.setSex( inpatientInformationPatientSex( inpatientInformation ) );
        inpatientInformationVO.setBirth( inpatientInformationPatientBirth( inpatientInformation ) );
        inpatientInformationVO.setPtName( inpatientInformation.getPtName() );
        inpatientInformationVO.setPid( inpatientInformationPatientPid( inpatientInformation ) );
        inpatientInformationVO.setTel( inpatientInformationPatientTel( inpatientInformation ) );
        Integer wardId = inpatientInformationWardWardId( inpatientInformation );
        if ( wardId != null ) {
            inpatientInformationVO.setIwardId( String.valueOf( wardId ) );
        }
        Integer bid = inpatientInformationBedBid( inpatientInformation );
        if ( bid != null ) {
            inpatientInformationVO.setBid( String.valueOf( bid ) );
        }
        inpatientInformationVO.setRegAddr( inpatientInformationPatientRegAddr( inpatientInformation ) );
        inpatientInformationVO.setId( inpatientInformation.getId() );
        inpatientInformationVO.setMedicalNumber( inpatientInformation.getMedicalNumber() );
        inpatientInformationVO.setAdmissionNumber( inpatientInformation.getAdmissionNumber() );
        inpatientInformationVO.setAge( inpatientInformation.getAge() );
        inpatientInformationVO.setAdmittedDoc( inpatientInformation.getAdmittedDoc() );
        inpatientInformationVO.setAttendingDoc( inpatientInformation.getAttendingDoc() );
        inpatientInformationVO.setVisitingDoc( inpatientInformation.getVisitingDoc() );
        inpatientInformationVO.setDiagnosis01( inpatientInformation.getDiagnosis01() );
        inpatientInformationVO.setDiagnosis02( inpatientInformation.getDiagnosis02() );
        if ( inpatientInformation.getDateOfAdmission() != null ) {
            inpatientInformationVO.setDateOfAdmission( new Timestamp( inpatientInformation.getDateOfAdmission().getTime() ) );
        }

        return inpatientInformationVO;
    }

    @Override
    public InpatientUpdateVO doToUpdateVO(InpatientInformation inpatientInformation, Deposit deposit) {
        if ( inpatientInformation == null && deposit == null ) {
            return null;
        }

        InpatientUpdateVO inpatientUpdateVO = new InpatientUpdateVO();

        if ( inpatientInformation != null ) {
            inpatientUpdateVO.setDeptName( inpatientInformation.getDeptName() );
            inpatientUpdateVO.setNation( inpatientInformationPatientNation( inpatientInformation ) );
            inpatientUpdateVO.setCity( inpatientInformationPatientCity( inpatientInformation ) );
            inpatientUpdateVO.setConTel( inpatientInformationPatientConTel( inpatientInformation ) );
            inpatientUpdateVO.setConRel( inpatientInformationPatientConRel( inpatientInformation ) );
            inpatientUpdateVO.setPtName( inpatientInformation.getPtName() );
            inpatientUpdateVO.setPid( inpatientInformationPatientPid( inpatientInformation ) );
            inpatientUpdateVO.setRegAddr( inpatientInformationPatientRegAddr( inpatientInformation ) );
            inpatientUpdateVO.setProvince( inpatientInformationPatientProvince( inpatientInformation ) );
            inpatientUpdateVO.setContact( inpatientInformationPatientContact( inpatientInformation ) );
            inpatientUpdateVO.setTel( inpatientInformationPatientTel( inpatientInformation ) );
            inpatientUpdateVO.setId( inpatientInformation.getId() );
            inpatientUpdateVO.setPname( inpatientInformationPatientPname( inpatientInformation ) );
            inpatientUpdateVO.setBorn( inpatientInformationPatientBorn( inpatientInformation ) );
            inpatientUpdateVO.setSex( inpatientInformationPatientSex( inpatientInformation ) );
            inpatientUpdateVO.setBirth( inpatientInformationPatientBirth( inpatientInformation ) );
            inpatientUpdateVO.setIwardId( inpatientInformationWardWardId( inpatientInformation ) );
            inpatientUpdateVO.setNationality( inpatientInformationPatientNationality( inpatientInformation ) );
            inpatientUpdateVO.setCurrAddr( inpatientInformationPatientCurrAddr( inpatientInformation ) );
            Integer bid = inpatientInformationBedBid( inpatientInformation );
            if ( bid != null ) {
                inpatientUpdateVO.setBid( String.valueOf( bid ) );
            }
            inpatientUpdateVO.setMarried( inpatientInformationPatientMarried( inpatientInformation ) );
            inpatientUpdateVO.setAge( inpatientInformation.getAge() );
            inpatientUpdateVO.setDiagnosis01( inpatientInformation.getDiagnosis01() );
            inpatientUpdateVO.setDiagnosis02( inpatientInformation.getDiagnosis02() );
            inpatientUpdateVO.setAdmittedDoc( inpatientInformation.getAdmittedDoc() );
            inpatientUpdateVO.setAttendingDoc( inpatientInformation.getAttendingDoc() );
            inpatientUpdateVO.setVisitingDoc( inpatientInformation.getVisitingDoc() );
            if ( inpatientInformation.getDateOfAdmission() != null ) {
                inpatientUpdateVO.setDateOfAdmission( new Timestamp( inpatientInformation.getDateOfAdmission().getTime() ) );
            }
            if ( inpatientInformation.getDateOfDischarge() != null ) {
                inpatientUpdateVO.setDateOfDischarge( new Timestamp( inpatientInformation.getDateOfDischarge().getTime() ) );
            }
            inpatientUpdateVO.setMedicalNumber( inpatientInformation.getMedicalNumber() );
            inpatientUpdateVO.setAdmissionNumber( inpatientInformation.getAdmissionNumber() );
        }
        if ( deposit != null ) {
            inpatientUpdateVO.setPayment( deposit.getPaymentType() );
            if ( deposit.getDeposit() != null ) {
                inpatientUpdateVO.setDeposit( deposit.getDeposit().toString() );
            }
            if ( deposit.getStatus() != null ) {
                inpatientUpdateVO.setStatus( String.valueOf( deposit.getStatus() ) );
            }
        }

        return inpatientUpdateVO;
    }

    @Override
    public InpatientAddDTO toDTO(InpatientInformationAddVO informationVO) {
        if ( informationVO == null ) {
            return null;
        }

        InpatientAddDTO inpatientAddDTO = new InpatientAddDTO();

        inpatientAddDTO.setPtName( informationVO.getPtName() );
        inpatientAddDTO.setSid( informationVO.getSid() );
        inpatientAddDTO.setAdmissionNumber( informationVO.getAdmissionNumber() );
        inpatientAddDTO.setAge( informationVO.getAge() );
        inpatientAddDTO.setPid( informationVO.getPid() );
        inpatientAddDTO.setDiagnosis01( informationVO.getDiagnosis01() );
        inpatientAddDTO.setDiagnosis02( informationVO.getDiagnosis02() );
        inpatientAddDTO.setDeptName( informationVO.getDeptName() );
        inpatientAddDTO.setAdmittedDoc( informationVO.getAdmittedDoc() );
        inpatientAddDTO.setAttendingDoc( informationVO.getAttendingDoc() );
        inpatientAddDTO.setVisitingDoc( informationVO.getVisitingDoc() );
        inpatientAddDTO.setDateOfAdmission( informationVO.getDateOfAdmission() );
        inpatientAddDTO.setMedicalNumber( informationVO.getMedicalNumber() );

        return inpatientAddDTO;
    }

    @Override
    public InpatientUpdateDTO toDTO(InpatientUpdateVO updateVO) {
        if ( updateVO == null ) {
            return null;
        }

        InpatientUpdateDTO inpatientUpdateDTO = new InpatientUpdateDTO();

        inpatientUpdateDTO.setId( updateVO.getId() );
        inpatientUpdateDTO.setAge( updateVO.getAge() );
        inpatientUpdateDTO.setPid( updateVO.getPid() );
        inpatientUpdateDTO.setPtName( updateVO.getPtName() );
        inpatientUpdateDTO.setDiagnosis01( updateVO.getDiagnosis01() );
        inpatientUpdateDTO.setDiagnosis02( updateVO.getDiagnosis02() );
        inpatientUpdateDTO.setDeptName( updateVO.getDeptName() );
        inpatientUpdateDTO.setAdmittedDoc( updateVO.getAdmittedDoc() );
        inpatientUpdateDTO.setAttendingDoc( updateVO.getAttendingDoc() );
        inpatientUpdateDTO.setVisitingDoc( updateVO.getVisitingDoc() );
        inpatientUpdateDTO.setMedicalNumber( updateVO.getMedicalNumber() );

        return inpatientUpdateDTO;
    }

    @Override
    public BedPatientSelectVO toBedSelectVO(InpatientInformation information) {
        if ( information == null ) {
            return null;
        }

        BedPatientSelectVO bedPatientSelectVO = new BedPatientSelectVO();

        bedPatientSelectVO.setInpatientId( information.getId() );
        bedPatientSelectVO.setPid( inpatientInformationPatientPid( information ) );
        bedPatientSelectVO.setPname( inpatientInformationPatientPname( information ) );
        bedPatientSelectVO.setAdmissionNumber( information.getAdmissionNumber() );

        return bedPatientSelectVO;
    }

    @Override
    public BedChangePatientSelectVO toBedChangeVO(InpatientInformation information) {
        if ( information == null ) {
            return null;
        }

        BedChangePatientSelectVO bedChangePatientSelectVO = new BedChangePatientSelectVO();

        bedChangePatientSelectVO.setWid( informationWardWid( information ) );
        bedChangePatientSelectVO.setPname( inpatientInformationPatientPname( information ) );
        bedChangePatientSelectVO.setInpatientId( information.getId() );
        bedChangePatientSelectVO.setPid( inpatientInformationPatientPid( information ) );
        bedChangePatientSelectVO.setWardId( inpatientInformationWardWardId( information ) );
        bedChangePatientSelectVO.setId( informationBedId( information ) );
        bedChangePatientSelectVO.setBid( inpatientInformationBedBid( information ) );
        bedChangePatientSelectVO.setAdmissionNumber( information.getAdmissionNumber() );

        return bedChangePatientSelectVO;
    }

    @Override
    public Patient toPatient(InpatientInformationAddVO informationVO) {
        if ( informationVO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setPid( informationVO.getPid() );
        patient.setPname( informationVO.getPname() );
        patient.setSex( informationVO.getSex() );
        patient.setNationality( informationVO.getNationality() );
        patient.setNation( informationVO.getNation() );
        patient.setBirth( informationVO.getBirth() );
        patient.setTel( informationVO.getTel() );
        patient.setBorn( informationVO.getBorn() );
        patient.setMarried( informationVO.getMarried() );
        patient.setRegAddr( informationVO.getRegAddr() );
        patient.setCurrAddr( informationVO.getCurrAddr() );
        patient.setProvince( informationVO.getProvince() );
        patient.setCity( informationVO.getCity() );
        patient.setContact( informationVO.getContact() );
        patient.setConRel( informationVO.getConRel() );
        patient.setConTel( informationVO.getConTel() );

        return patient;
    }

    @Override
    public Deposit toDeposit(InpatientInformationAddVO informationVO) {
        if ( informationVO == null ) {
            return null;
        }

        Deposit deposit = new Deposit();

        deposit.setPaymentType( informationVO.getPayment() );
        if ( informationVO.getStatus() != null ) {
            deposit.setStatus( Integer.parseInt( informationVO.getStatus() ) );
        }
        deposit.setSid( informationVO.getSid() );

        return deposit;
    }

    @Override
    public Patient toPatient(InpatientUpdateVO updateVO) {
        if ( updateVO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setPid( updateVO.getPid() );
        patient.setPname( updateVO.getPname() );
        patient.setSex( updateVO.getSex() );
        patient.setNationality( updateVO.getNationality() );
        patient.setNation( updateVO.getNation() );
        patient.setBirth( updateVO.getBirth() );
        patient.setTel( updateVO.getTel() );
        patient.setBorn( updateVO.getBorn() );
        patient.setMarried( updateVO.getMarried() );
        patient.setRegAddr( updateVO.getRegAddr() );
        patient.setCurrAddr( updateVO.getCurrAddr() );
        patient.setProvince( updateVO.getProvince() );
        patient.setCity( updateVO.getCity() );
        patient.setContact( updateVO.getContact() );
        patient.setConRel( updateVO.getConRel() );
        patient.setConTel( updateVO.getConTel() );

        return patient;
    }

    @Override
    public LeaveQueryVO toLeaveQueryVO(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }

        LeaveQueryVO leaveQueryVO = new LeaveQueryVO();

        leaveQueryVO.setDeptName( inpatientInformation.getDeptName() );
        leaveQueryVO.setPname( inpatientInformationPatientPname( inpatientInformation ) );
        leaveQueryVO.setSex( inpatientInformationPatientSex( inpatientInformation ) );
        leaveQueryVO.setBirth( inpatientInformationPatientBirth( inpatientInformation ) );
        leaveQueryVO.setPtName( inpatientInformation.getPtName() );
        leaveQueryVO.setPid( inpatientInformationPatientPid( inpatientInformation ) );
        leaveQueryVO.setTel( inpatientInformationPatientTel( inpatientInformation ) );
        Integer wardId = inpatientInformationWardWardId( inpatientInformation );
        if ( wardId != null ) {
            leaveQueryVO.setIwardId( String.valueOf( wardId ) );
        }
        Integer bid = inpatientInformationBedBid( inpatientInformation );
        if ( bid != null ) {
            leaveQueryVO.setBid( String.valueOf( bid ) );
        }
        leaveQueryVO.setDay( inpatientInformation.getDay() );
        leaveQueryVO.setRegAddr( inpatientInformationPatientRegAddr( inpatientInformation ) );
        leaveQueryVO.setId( inpatientInformation.getId() );
        leaveQueryVO.setMedicalNumber( inpatientInformation.getMedicalNumber() );
        leaveQueryVO.setAdmissionNumber( inpatientInformation.getAdmissionNumber() );
        leaveQueryVO.setAge( inpatientInformation.getAge() );
        leaveQueryVO.setAdmittedDoc( inpatientInformation.getAdmittedDoc() );
        leaveQueryVO.setAttendingDoc( inpatientInformation.getAttendingDoc() );
        leaveQueryVO.setVisitingDoc( inpatientInformation.getVisitingDoc() );
        leaveQueryVO.setDiagnosis01( inpatientInformation.getDiagnosis01() );
        leaveQueryVO.setDiagnosis02( inpatientInformation.getDiagnosis02() );
        if ( inpatientInformation.getDateOfAdmission() != null ) {
            leaveQueryVO.setDateOfAdmission( new Timestamp( inpatientInformation.getDateOfAdmission().getTime() ) );
        }
        leaveQueryVO.setDateOfDischarge( inpatientInformation.getDateOfDischarge() );

        return leaveQueryVO;
    }

    @Override
    public List<InpatientInformationVO> doToVoList(List<InpatientInformation> inpatientInformationList) {
        if ( inpatientInformationList == null ) {
            return null;
        }

        List<InpatientInformationVO> list = new ArrayList<InpatientInformationVO>( inpatientInformationList.size() );
        for ( InpatientInformation inpatientInformation : inpatientInformationList ) {
            list.add( doToVo( inpatientInformation ) );
        }

        return list;
    }

    @Override
    public List<BedPatientSelectVO> toBedSelectVOList(List<InpatientInformation> inpatientInformationList) {
        if ( inpatientInformationList == null ) {
            return null;
        }

        List<BedPatientSelectVO> list = new ArrayList<BedPatientSelectVO>( inpatientInformationList.size() );
        for ( InpatientInformation inpatientInformation : inpatientInformationList ) {
            list.add( toBedSelectVO( inpatientInformation ) );
        }

        return list;
    }

    @Override
    public List<BedChangePatientSelectVO> toBedChangeVOList(List<InpatientInformation> inpatientInformationList) {
        if ( inpatientInformationList == null ) {
            return null;
        }

        List<BedChangePatientSelectVO> list = new ArrayList<BedChangePatientSelectVO>( inpatientInformationList.size() );
        for ( InpatientInformation inpatientInformation : inpatientInformationList ) {
            list.add( toBedChangeVO( inpatientInformation ) );
        }

        return list;
    }

    @Override
    public List<LeaveQueryVO> toLeaveQueryVOList(List<InpatientInformation> inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }

        List<LeaveQueryVO> list = new ArrayList<LeaveQueryVO>( inpatientInformation.size() );
        for ( InpatientInformation inpatientInformation1 : inpatientInformation ) {
            list.add( toLeaveQueryVO( inpatientInformation1 ) );
        }

        return list;
    }

    private String inpatientInformationPatientPname(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String pname = patient.getPname();
        if ( pname == null ) {
            return null;
        }
        return pname;
    }

    private String inpatientInformationPatientSex(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String sex = patient.getSex();
        if ( sex == null ) {
            return null;
        }
        return sex;
    }

    private Timestamp inpatientInformationPatientBirth(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        Timestamp birth = patient.getBirth();
        if ( birth == null ) {
            return null;
        }
        return birth;
    }

    private String inpatientInformationPatientPid(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String pid = patient.getPid();
        if ( pid == null ) {
            return null;
        }
        return pid;
    }

    private String inpatientInformationPatientTel(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String tel = patient.getTel();
        if ( tel == null ) {
            return null;
        }
        return tel;
    }

    private Integer inpatientInformationWardWardId(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        InpatientWard ward = inpatientInformation.getWard();
        if ( ward == null ) {
            return null;
        }
        Integer wardId = ward.getWardId();
        if ( wardId == null ) {
            return null;
        }
        return wardId;
    }

    private Integer inpatientInformationBedBid(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Bed bed = inpatientInformation.getBed();
        if ( bed == null ) {
            return null;
        }
        Integer bid = bed.getBid();
        if ( bid == null ) {
            return null;
        }
        return bid;
    }

    private String inpatientInformationPatientRegAddr(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String regAddr = patient.getRegAddr();
        if ( regAddr == null ) {
            return null;
        }
        return regAddr;
    }

    private String inpatientInformationPatientNation(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String nation = patient.getNation();
        if ( nation == null ) {
            return null;
        }
        return nation;
    }

    private String inpatientInformationPatientCity(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String city = patient.getCity();
        if ( city == null ) {
            return null;
        }
        return city;
    }

    private String inpatientInformationPatientConTel(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String conTel = patient.getConTel();
        if ( conTel == null ) {
            return null;
        }
        return conTel;
    }

    private String inpatientInformationPatientConRel(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String conRel = patient.getConRel();
        if ( conRel == null ) {
            return null;
        }
        return conRel;
    }

    private String inpatientInformationPatientProvince(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String province = patient.getProvince();
        if ( province == null ) {
            return null;
        }
        return province;
    }

    private String inpatientInformationPatientContact(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String contact = patient.getContact();
        if ( contact == null ) {
            return null;
        }
        return contact;
    }

    private String inpatientInformationPatientBorn(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String born = patient.getBorn();
        if ( born == null ) {
            return null;
        }
        return born;
    }

    private String inpatientInformationPatientNationality(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String nationality = patient.getNationality();
        if ( nationality == null ) {
            return null;
        }
        return nationality;
    }

    private String inpatientInformationPatientCurrAddr(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String currAddr = patient.getCurrAddr();
        if ( currAddr == null ) {
            return null;
        }
        return currAddr;
    }

    private String inpatientInformationPatientMarried(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        String married = patient.getMarried();
        if ( married == null ) {
            return null;
        }
        return married;
    }

    private Integer informationWardWid(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        InpatientWard ward = inpatientInformation.getWard();
        if ( ward == null ) {
            return null;
        }
        Integer wid = ward.getWid();
        if ( wid == null ) {
            return null;
        }
        return wid;
    }

    private Integer informationBedId(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Bed bed = inpatientInformation.getBed();
        if ( bed == null ) {
            return null;
        }
        Integer id = bed.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
