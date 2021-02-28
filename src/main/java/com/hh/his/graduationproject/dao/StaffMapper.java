package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.Role;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.model.vo.condition.StaffConditionVO;
import com.hh.his.graduationproject.model.vo.StaffUpdateVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StaffMapper {

    /**
     * 用工号查询员工
     * @param username
     * @return
     */
    Staff findByUsername(@Param("username") String username);

    int deleteByPrimaryKey(@Param("username") String username);

    int deleteByDeptName(@Param("deptName") String deptName);

    int insert(@Param("record")Staff record);

    int insertSelective(@Param("record")Staff record);

    Staff selectByPrimaryKey(@Param("username") String username);

    int updateByPrimaryKeySelective(@Param("record") Staff record);

    int updateByPrimaryKey(@Param("record") StaffUpdateVO record);

    Staff loadUserByUsername(@Param("username") String username);

    List<Role> getStaffsRolesByUsername(@Param("username") String username);

    List<Staff> getStaffsWithAllByCondition(@Param("condition")StaffConditionVO conditionVO);

    void updateDeptName(@Param("deptName")String deptName,@Param("oldDeptName")String oldDeptName);

    List<Staff> getAllStaffsExceptCurrentStaffs(@Param("username") String username);

    Integer updatePassword(@Param("username") String username, @Param("password") String password);

    Staff checkLogin(@Param("username") String username);
}
