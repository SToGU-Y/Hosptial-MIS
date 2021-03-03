package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.Bed;
import com.hh.his.graduationproject.model.entity.Dept;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.entity.InpatientWard;
import com.hh.his.graduationproject.model.entity.InpatientWardType;
import com.hh.his.graduationproject.model.entity.Patient;
import com.hh.his.graduationproject.model.vo.BedSelectVO;
import com.hh.his.graduationproject.model.vo.BedVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-01T22:37:35+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class BedConverterImpl implements BedConverter {

    @Override
    public BedSelectVO toVO(Bed bed) {
        if ( bed == null ) {
            return null;
        }

        BedSelectVO bedSelectVO = new BedSelectVO();

        bedSelectVO.setDeptName( bedWardDeptDeptName( bed ) );
        bedSelectVO.setWid( bedWardWid( bed ) );
        Integer wardBedNum = bedWardWardBedNum( bed );
        if ( wardBedNum != null ) {
            bedSelectVO.setWardBedNum( String.valueOf( wardBedNum ) );
        }
        bedSelectVO.setIwtType( bedWardWardTypeIwtType( bed ) );
        bedSelectVO.setWardId( bedWardWardId( bed ) );
        bedSelectVO.setIwtPrice( bedWardWardTypeIwtPrice( bed ) );
        bedSelectVO.setId( bed.getId() );
        bedSelectVO.setBid( bed.getBid() );
        if ( bed.getBedStatus() != null ) {
            bedSelectVO.setBedStatus( String.valueOf( bed.getBedStatus() ) );
        }

        return bedSelectVO;
    }

    @Override
    public BedVO toVO(InpatientInformation information) {
        if ( information == null ) {
            return null;
        }

        BedVO bedVO = new BedVO();

        bedVO.setWid( informationWardWid( information ) );
        bedVO.setPname( informationPatientPname( information ) );
        bedVO.setAdmissionNumber( information.getAdmissionNumber() );
        bedVO.setAdmissionId( information.getId() );
        bedVO.setBedStatus( informationBedBedStatus( information ) );
        bedVO.setIwtType( informationWardWardTypeIwtType( information ) );
        bedVO.setWardId( informationWardWardId( information ) );
        bedVO.setId( informationBedId( information ) );
        bedVO.setBid( informationBedBid( information ) );
        bedVO.setDeptName( information.getDeptName() );

        return bedVO;
    }

    @Override
    public List<BedSelectVO> toVOs(List<Bed> bedList) {
        if ( bedList == null ) {
            return null;
        }

        List<BedSelectVO> list = new ArrayList<BedSelectVO>( bedList.size() );
        for ( Bed bed : bedList ) {
            list.add( toVO( bed ) );
        }

        return list;
    }

    @Override
    public List<BedVO> toVOList(List<InpatientInformation> list) {
        if ( list == null ) {
            return null;
        }

        List<BedVO> list1 = new ArrayList<BedVO>( list.size() );
        for ( InpatientInformation inpatientInformation : list ) {
            list1.add( toVO( inpatientInformation ) );
        }

        return list1;
    }

    private String bedWardDeptDeptName(Bed bed) {
        if ( bed == null ) {
            return null;
        }
        InpatientWard ward = bed.getWard();
        if ( ward == null ) {
            return null;
        }
        Dept dept = ward.getDept();
        if ( dept == null ) {
            return null;
        }
        String deptName = dept.getDeptName();
        if ( deptName == null ) {
            return null;
        }
        return deptName;
    }

    private Integer bedWardWid(Bed bed) {
        if ( bed == null ) {
            return null;
        }
        InpatientWard ward = bed.getWard();
        if ( ward == null ) {
            return null;
        }
        Integer wid = ward.getWid();
        if ( wid == null ) {
            return null;
        }
        return wid;
    }

    private Integer bedWardWardBedNum(Bed bed) {
        if ( bed == null ) {
            return null;
        }
        InpatientWard ward = bed.getWard();
        if ( ward == null ) {
            return null;
        }
        Integer wardBedNum = ward.getWardBedNum();
        if ( wardBedNum == null ) {
            return null;
        }
        return wardBedNum;
    }

    private String bedWardWardTypeIwtType(Bed bed) {
        if ( bed == null ) {
            return null;
        }
        InpatientWard ward = bed.getWard();
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

    private Integer bedWardWardId(Bed bed) {
        if ( bed == null ) {
            return null;
        }
        InpatientWard ward = bed.getWard();
        if ( ward == null ) {
            return null;
        }
        Integer wardId = ward.getWardId();
        if ( wardId == null ) {
            return null;
        }
        return wardId;
    }

    private BigDecimal bedWardWardTypeIwtPrice(Bed bed) {
        if ( bed == null ) {
            return null;
        }
        InpatientWard ward = bed.getWard();
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

    private String informationPatientPname(InpatientInformation inpatientInformation) {
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

    private Integer informationBedBedStatus(InpatientInformation inpatientInformation) {
        if ( inpatientInformation == null ) {
            return null;
        }
        Bed bed = inpatientInformation.getBed();
        if ( bed == null ) {
            return null;
        }
        Integer bedStatus = bed.getBedStatus();
        if ( bedStatus == null ) {
            return null;
        }
        return bedStatus;
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

    private Integer informationWardWardId(InpatientInformation inpatientInformation) {
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

    private Integer informationBedBid(InpatientInformation inpatientInformation) {
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
}
