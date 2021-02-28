package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.Dept;
import com.hh.his.graduationproject.model.vo.condition.DeptConditionVO;
import com.hh.his.graduationproject.model.vo.DeptUpdateVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {

    List<Dept> findAllDept();

    List<Dept> findDeptByCondition(@Param("condition") DeptConditionVO conditionVO);

    Dept selectByDeptId(@Param("deptId")String deptId);

    int updateByDeptId(@Param("dept") DeptUpdateVO dept);

    int deleteByDeptId(@Param("deptId")String deptId);

    int insertDept(@Param("dept")Dept dept);

    void decreaseStaffNumberByDeptName(@Param("deptName")String deptName);

    void  increaseStaffNumberByDeptName(@Param("deptName") String deptName);
}
