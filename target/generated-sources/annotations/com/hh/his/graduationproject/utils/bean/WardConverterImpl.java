package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.dto.WardAddDTO;
import com.hh.his.graduationproject.model.entity.Dept;
import com.hh.his.graduationproject.model.entity.InpatientWard;
import com.hh.his.graduationproject.model.entity.InpatientWardType;
import com.hh.his.graduationproject.model.vo.WardAddVO;
import com.hh.his.graduationproject.model.vo.WardVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-29T11:53:36+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class WardConverterImpl implements WardConverter {

    @Override
    public WardVO doToVO(InpatientWard ward) {
        if ( ward == null ) {
            return null;
        }

        WardVO wardVO = new WardVO();

        wardVO.setDeptId( wardDeptDeptId( ward ) );
        wardVO.setDeptName( wardDeptDeptName( ward ) );
        wardVO.setIwtType( wardWardTypeIwtType( ward ) );
        wardVO.setIwtPrice( wardWardTypeIwtPrice( ward ) );
        wardVO.setIwtId( wardWardTypeIwtId( ward ) );
        wardVO.setId( ward.getId() );
        wardVO.setWardId( ward.getWardId() );
        if ( ward.getWardStatus() != null ) {
            wardVO.setWardStatus( String.valueOf( ward.getWardStatus() ) );
        }
        if ( ward.getWardBedNum() != null ) {
            wardVO.setWardBedNum( String.valueOf( ward.getWardBedNum() ) );
        }

        return wardVO;
    }

    @Override
    public WardAddDTO voToDTO(WardAddVO wardAddVO) {
        if ( wardAddVO == null ) {
            return null;
        }

        WardAddDTO wardAddDTO = new WardAddDTO();

        wardAddDTO.setWardType( wardAddVO.getIwtId() );
        wardAddDTO.setDeptId( wardAddVO.getDeptId() );
        wardAddDTO.setWardId( wardAddVO.getWardId() );

        return wardAddDTO;
    }

    @Override
    public List<WardVO> doToVOs(List<InpatientWard> wards) {
        if ( wards == null ) {
            return null;
        }

        List<WardVO> list = new ArrayList<WardVO>( wards.size() );
        for ( InpatientWard inpatientWard : wards ) {
            list.add( doToVO( inpatientWard ) );
        }

        return list;
    }

    private String wardDeptDeptId(InpatientWard inpatientWard) {
        if ( inpatientWard == null ) {
            return null;
        }
        Dept dept = inpatientWard.getDept();
        if ( dept == null ) {
            return null;
        }
        String deptId = dept.getDeptId();
        if ( deptId == null ) {
            return null;
        }
        return deptId;
    }

    private String wardDeptDeptName(InpatientWard inpatientWard) {
        if ( inpatientWard == null ) {
            return null;
        }
        Dept dept = inpatientWard.getDept();
        if ( dept == null ) {
            return null;
        }
        String deptName = dept.getDeptName();
        if ( deptName == null ) {
            return null;
        }
        return deptName;
    }

    private String wardWardTypeIwtType(InpatientWard inpatientWard) {
        if ( inpatientWard == null ) {
            return null;
        }
        InpatientWardType wardType = inpatientWard.getWardType();
        if ( wardType == null ) {
            return null;
        }
        String iwtType = wardType.getIwtType();
        if ( iwtType == null ) {
            return null;
        }
        return iwtType;
    }

    private BigDecimal wardWardTypeIwtPrice(InpatientWard inpatientWard) {
        if ( inpatientWard == null ) {
            return null;
        }
        InpatientWardType wardType = inpatientWard.getWardType();
        if ( wardType == null ) {
            return null;
        }
        BigDecimal iwtPrice = wardType.getIwtPrice();
        if ( iwtPrice == null ) {
            return null;
        }
        return iwtPrice;
    }

    private Integer wardWardTypeIwtId(InpatientWard inpatientWard) {
        if ( inpatientWard == null ) {
            return null;
        }
        InpatientWardType wardType = inpatientWard.getWardType();
        if ( wardType == null ) {
            return null;
        }
        Integer iwtId = wardType.getIwtId();
        if ( iwtId == null ) {
            return null;
        }
        return iwtId;
    }
}
