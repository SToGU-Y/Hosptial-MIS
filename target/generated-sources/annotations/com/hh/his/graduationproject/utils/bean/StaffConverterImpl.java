package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.Role;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.model.vo.StaffAddVO;
import com.hh.his.graduationproject.model.vo.StaffUpdateVO;
import com.hh.his.graduationproject.model.vo.StaffVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-01T22:37:35+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class StaffConverterImpl implements StaffConverter {

    @Override
    public StaffVO toVO(Staff staff) {
        if ( staff == null ) {
            return null;
        }

        StaffVO staffVO = new StaffVO();

        staffVO.setStaffBirth( staff.getStaffBirth() );
        staffVO.setDeptName( staff.getDeptName() );
        staffVO.setEntryTime( staff.getEntryTime() );
        staffVO.setUsername( staff.getUsername() );
        staffVO.setStaffName( staff.getStaffName() );
        staffVO.setPassword( staff.getPassword() );
        staffVO.setStaffAddr( staff.getStaffAddr() );
        staffVO.setIdNumber( staff.getIdNumber() );
        staffVO.setStaffTel( staff.getStaffTel() );
        staffVO.setStaffSex( staff.getStaffSex() );
        staffVO.setStaffNation( staff.getStaffNation() );
        staffVO.setStaffMarried( staff.getStaffMarried() );
        List<Role> list = staff.getRoles();
        if ( list != null ) {
            staffVO.setRoles( new ArrayList<Role>( list ) );
        }

        return staffVO;
    }

    @Override
    public Staff toDO(StaffAddVO staffAddVO) {
        if ( staffAddVO == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setUsername( staffAddVO.getUsername() );
        staff.setStaffName( staffAddVO.getStaffName() );
        staff.setDeptName( staffAddVO.getDeptName() );
        staff.setStaffAddr( staffAddVO.getStaffAddr() );
        staff.setIdNumber( staffAddVO.getIdNumber() );
        staff.setStaffTel( staffAddVO.getStaffTel() );
        staff.setStaffSex( staffAddVO.getStaffSex() );
        staff.setStaffNation( staffAddVO.getStaffNation() );
        staff.setStaffMarried( staffAddVO.getStaffMarried() );
        staff.setStaffBirth( staffAddVO.getStaffBirth() );

        staff.setPassword( new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(staffAddVO.getPassword()) );
        staff.setEntryTime( new java.util.Date() );

        return staff;
    }

    @Override
    public StaffUpdateVO toUpdateVO(Staff staff) {
        if ( staff == null ) {
            return null;
        }

        StaffUpdateVO staffUpdateVO = new StaffUpdateVO();

        staffUpdateVO.setStaffBirth( staff.getStaffBirth() );
        staffUpdateVO.setDeptName( staff.getDeptName() );
        staffUpdateVO.setUsername( staff.getUsername() );
        staffUpdateVO.setStaffName( staff.getStaffName() );
        staffUpdateVO.setStaffAddr( staff.getStaffAddr() );
        staffUpdateVO.setIdNumber( staff.getIdNumber() );
        staffUpdateVO.setStaffTel( staff.getStaffTel() );
        staffUpdateVO.setStaffSex( staff.getStaffSex() );
        staffUpdateVO.setStaffNation( staff.getStaffNation() );
        staffUpdateVO.setStaffMarried( staff.getStaffMarried() );

        return staffUpdateVO;
    }

    @Override
    public List<StaffVO> toVOList(List<Staff> staffList) {
        if ( staffList == null ) {
            return null;
        }

        List<StaffVO> list = new ArrayList<StaffVO>( staffList.size() );
        for ( Staff staff : staffList ) {
            list.add( toVO( staff ) );
        }

        return list;
    }
}
