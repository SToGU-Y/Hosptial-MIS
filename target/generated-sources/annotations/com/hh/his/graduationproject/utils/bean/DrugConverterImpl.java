package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.vo.DrugApplicationVO;
import com.hh.his.graduationproject.model.vo.MedicalAdviceQueryVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-01T22:37:35+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class DrugConverterImpl implements DrugConverter {

    @Override
    public DrugApplicationVO toDrugApplication(MedicalAdviceQueryVO medicalAdvice) {
        if ( medicalAdvice == null ) {
            return null;
        }

        DrugApplicationVO drugApplicationVO = new DrugApplicationVO();

        drugApplicationVO.setDrugNo( medicalAdvice.getMadvOperationNo() );
        drugApplicationVO.setDrugRequireNumber( medicalAdvice.getMadvFrequency() );
        drugApplicationVO.setDrugUnit( medicalAdvice.getMadvUnit() );
        drugApplicationVO.setDrugDose( medicalAdvice.getMadvDose() );
        drugApplicationVO.setDrugPrice( medicalAdvice.getMadvPrice() );
        drugApplicationVO.setDrugName( medicalAdvice.getMadvOperation() );
        drugApplicationVO.setDrugSpecifications( medicalAdvice.getMadvSpecifications() );
        drugApplicationVO.setDrugType( medicalAdvice.getMadvOperationType() );
        drugApplicationVO.setDrugRequireDept( medicalAdvice.getDeptName() );
        drugApplicationVO.setAdmissionId( medicalAdvice.getAdmissionId() );
        drugApplicationVO.setName( medicalAdvice.getName() );
        drugApplicationVO.setAdmissionNumber( medicalAdvice.getAdmissionNumber() );
        if ( medicalAdvice.getWardId() != null ) {
            drugApplicationVO.setWardId( Integer.parseInt( medicalAdvice.getWardId() ) );
        }
        if ( medicalAdvice.getBid() != null ) {
            drugApplicationVO.setBid( Integer.parseInt( medicalAdvice.getBid() ) );
        }
        drugApplicationVO.setDeptName( medicalAdvice.getDeptName() );

        drugApplicationVO.setStatus( 0 );

        return drugApplicationVO;
    }

    @Override
    public List<DrugApplicationVO> ListDrugApplication(List<MedicalAdviceQueryVO> medicalAdviceQueryVOS) {
        if ( medicalAdviceQueryVOS == null ) {
            return null;
        }

        List<DrugApplicationVO> list = new ArrayList<DrugApplicationVO>( medicalAdviceQueryVOS.size() );
        for ( MedicalAdviceQueryVO medicalAdviceQueryVO : medicalAdviceQueryVOS ) {
            list.add( toDrugApplication( medicalAdviceQueryVO ) );
        }

        return list;
    }
}
