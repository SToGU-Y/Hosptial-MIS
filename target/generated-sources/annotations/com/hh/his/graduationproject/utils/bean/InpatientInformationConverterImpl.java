package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.Dept;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.entity.Patient;
import com.hh.his.graduationproject.model.entity.PatientType;
import com.hh.his.graduationproject.model.vo.InpatientInformationVO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-29T11:53:36+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class InpatientInformationConverterImpl implements InpatientInformationConverter {

    @Override
    public InpatientInformationVO doToVo(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }

        InpatientInformationVO inpatientInformationVO = new InpatientInformationVO();

        inpatientInformationVO.setDeptName( inpatientInformationDeptDeptName( inpatientInformation ) );
        inpatientInformationVO.setPname( inpatientInformationPatientPname( inpatientInformation ) );
        inpatientInformationVO.setSex( inpatientInformationPatientSex( inpatientInformation ) );
        inpatientInformationVO.setBirth( inpatientInformationPatientBirth( inpatientInformation ) );
        inpatientInformationVO.setPtName( inpatientInformationPatientTypePtName( inpatientInformation ) );
        inpatientInformationVO.setPid( inpatientInformationPatientPid( inpatientInformation ) );
        inpatientInformationVO.setTel( inpatientInformationPatientTel( inpatientInformation ) );
        inpatientInformationVO.setAge( inpatientInformationPatientAge( inpatientInformation ) );
        inpatientInformationVO.setRegAddr( inpatientInformationPatientRegAddr( inpatientInformation ) );
        inpatientInformationVO.setMedicalNumber( inpatientInformation.getMedicalNumber() );
        inpatientInformationVO.setAdmissionNumber( inpatientInformation.getAdmissionNumber() );
        inpatientInformationVO.setIwardId( inpatientInformation.getIwardId() );
        inpatientInformationVO.setBid( inpatientInformation.getBid() );
        inpatientInformationVO.setAdmittedDoc( inpatientInformation.getAdmittedDoc() );
        inpatientInformationVO.setAttendingDoc( inpatientInformation.getAttendingDoc() );
        inpatientInformationVO.setVisitingDoc( inpatientInformation.getVisitingDoc() );
        inpatientInformationVO.setDiagnosis01( inpatientInformation.getDiagnosis01() );
        inpatientInformationVO.setDiagnosis02( inpatientInformation.getDiagnosis02() );
        inpatientInformationVO.setDateOfAdmission( inpatientInformation.getDateOfAdmission() );

        return inpatientInformationVO;
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

    private String inpatientInformationDeptDeptName(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Dept dept = inpatientInformation.getDept();
        if ( dept == null ) {
            return null;
        }
        String deptName = dept.getDeptName();
        if ( deptName == null ) {
            return null;
        }
        return deptName;
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

    private String inpatientInformationPatientTypePtName(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        PatientType patientType = inpatientInformation.getPatientType();
        if ( patientType == null ) {
            return null;
        }
        String ptName = patientType.getPtName();
        if ( ptName == null ) {
            return null;
        }
        return ptName;
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

    private Integer inpatientInformationPatientAge(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Patient patient = inpatientInformation.getPatient();
        if ( patient == null ) {
            return null;
        }
        Integer age = patient.getAge();
        if ( age == null ) {
            return null;
        }
        return age;
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
}
