package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.Role;
import com.hh.his.graduationproject.model.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StaffMapper {

    /**
     * 用工号查询员工
     * @param username
     * @return
     */
    Staff findByUsername(@Param("username") String username);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(@Param("record")Staff record);

    int insertSelective(@Param("record")Staff record);

    Staff selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(@Param("record") Staff record);

    int updateByPrimaryKey(@Param("record") Staff record);

    Staff loadUserByUsername(@Param("username") String username);

    List<Role> getStaffsRolesById(@Param("id") Integer id);

    List<Staff> getAllStaffs(@Param("keywords")String keywords);

    List<Staff> getAllStaffsExceptCurrentStaffs(@Param("id") Integer id);

    Integer updatePasswd(@Param("id") Integer id, @Param("encodePass") String encodePass);

}
