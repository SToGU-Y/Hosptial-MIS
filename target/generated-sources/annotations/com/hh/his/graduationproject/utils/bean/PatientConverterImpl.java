package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.Patient;
import com.hh.his.graduationproject.model.vo.PatientVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-29T11:53:36+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class PatientConverterImpl implements PatientConverter {

    @Override
    public PatientVO doToVo(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientVO patientVO = new PatientVO();

        patientVO.setNation( patient.getNation() );
        patientVO.setPid( patient.getPid() );
        patientVO.setPname( patient.getPname() );
        patientVO.setSex( patient.getSex() );
        patientVO.setNationality( patient.getNationality() );
        patientVO.setAge( patient.getAge() );
        patientVO.setBirth( patient.getBirth() );
        patientVO.setBorn( patient.getBorn() );
        patientVO.setMarried( patient.getMarried() );
        patientVO.setTel( patient.getTel() );
        patientVO.setRegAddr( patient.getRegAddr() );
        patientVO.setCurrAddr( patient.getCurrAddr() );
        patientVO.setContact( patient.getContact() );
        patientVO.setConRel( patient.getConRel() );
        patientVO.setConTel( patient.getConTel() );

        return patientVO;
    }
}
