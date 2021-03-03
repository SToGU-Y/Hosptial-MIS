package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.Cost;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.entity.InpatientWard;
import com.hh.his.graduationproject.model.entity.InpatientWardType;
import com.hh.his.graduationproject.model.vo.DrugApplicationVO;
import com.hh.his.graduationproject.model.vo.MedicalAdviceQueryVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-01T22:39:09+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class CostConverterImpl implements CostConverter {

    @Override
    public Cost medicalAdviceToCost(MedicalAdviceQueryVO m) {
        if ( m == null ) {
            return null;
        }

        Cost cost = new Cost();

        cost.setCostUnit( m.getMadvUnit() );
        cost.setCostDose( m.getMadvDose() );
        cost.setCostNum( m.getMadvFrequency() );
        cost.setCostPrice( m.getMadvPrice() );
        cost.setOperator( m.getMadvExecuteNurse() );
        cost.setCostNo( m.getMadvOperationNo() );
        cost.setCostName( m.getMadvOperation() );
        cost.setCostSpecifications( m.getMadvSpecifications() );
        cost.setCostType( m.getMadvOperationType() );
        cost.setAdmissionId( m.getAdmissionId() );

        cost.setCostSum( new java.math.BigDecimal(m.getMadvFrequency()).multiply(m.getMadvPrice()) );
        cost.setCostDate( new java.util.Date() );

        return cost;
    }

    @Override
    public Cost drugApplicationToCost(DrugApplicationVO drugApplicationVO) {
        if ( drugApplicationVO == null ) {
            return null;
        }

        Cost cost = new Cost();

        cost.setCostUnit( drugApplicationVO.getDrugUnit() );
        cost.setCostDose( drugApplicationVO.getDrugDose() );
        cost.setCostNum( drugApplicationVO.getDrugRequireNumber() );
        cost.setCostPrice( drugApplicationVO.getDrugPrice() );
        cost.setOperator( drugApplicationVO.getOperator() );
        cost.setCostNo( drugApplicationVO.getDrugNo() );
        cost.setCostDate( drugApplicationVO.getApplyDate() );
        cost.setCostName( drugApplicationVO.getDrugName() );
        cost.setCostSpecifications( drugApplicationVO.getDrugSpecifications() );
        cost.setCostType( drugApplicationVO.getDrugType() );
        cost.setAdmissionId( drugApplicationVO.getAdmissionId() );

        cost.setCostSum( new java.math.BigDecimal(drugApplicationVO.getDrugRequireNumber()).multiply(drugApplicationVO.getDrugPrice()) );

        return cost;
    }

    @Override
    public Cost InpatientToCost(InpatientInformation information) {
        if ( information == null ) {
            return null;
        }

        Cost cost = new Cost();

        cost.setCostSum( informationWardWardTypeIwtPrice( information ) );
        cost.setCostName( informationWardWardTypeIwtType( information ) );
        cost.setAdmissionId( information.getId() );
        cost.setCostPrice( informationWardWardTypeIwtPrice( information ) );

        cost.setCostUnit( "天" );
        cost.setCostDate( new java.util.Date() );
        cost.setCostNum( 1 );
        cost.setCostType( "床位" );
        cost.setOperator( "系统" );

        return cost;
    }

    @Override
    public List<Cost> ListInpatient(List<InpatientInformation> list) {
        if ( list == null ) {
            return null;
        }

        List<Cost> list1 = new ArrayList<Cost>( list.size() );
        for ( InpatientInformation inpatientInformation : list ) {
            list1.add( InpatientToCost( inpatientInformation ) );
        }

        return list1;
    }

    @Override
    public List<Cost> ListMedicalAdvice(List<MedicalAdviceQueryVO> list) {
        if ( list == null ) {
            return null;
        }

        List<Cost> list1 = new ArrayList<Cost>( list.size() );
        for ( MedicalAdviceQueryVO medicalAdviceQueryVO : list ) {
            list1.add( medicalAdviceToCost( medicalAdviceQueryVO ) );
        }

        return list1;
    }

    private BigDecimal informationWardWardTypeIwtPrice(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        InpatientWard ward = inpatientInformation.getWard();
        if ( ward == null ) {
            return null;
        }
        InpatientWardType wardType = ward.getWardType();
        if ( wardType == null ) {
            return null;
        }
        BigDecimal iwtPrice = wardType.getIwtPrice();
        if ( iwtPrice == null ) {
            return null;
        }
        return iwtPrice;
    }

    private String informationWardWardTypeIwtType(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        InpatientWard ward = inpatientInformation.getWard();
        if ( ward == null ) {
            return null;
        }
        InpatientWardType wardType = ward.getWardType();
        if ( wardType == null ) {
            return null;
        }
        String iwtType = wardType.getIwtType();
        if ( iwtType == null ) {
            return null;
        }
        return iwtType;
    }
}
