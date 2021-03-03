package com.hh.his.graduationproject.dao;


import com.hh.his.graduationproject.model.entity.StaffRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StaffRoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(StaffRole record);

    int insertSelective(StaffRole record);

    StaffRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffRole record);

    int updateByPrimaryKey(StaffRole record);

    void deleteByUsername(String username);

    int deleteByRoleId(@Param("roleId") Integer roleId);

    Integer addRole(@Param("username") String username, @Param("rids") List<Integer> rids);
}
