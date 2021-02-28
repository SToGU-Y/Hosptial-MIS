package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.Dept;
import com.hh.his.graduationproject.model.vo.condition.DeptConditionVO;
import com.hh.his.graduationproject.model.vo.DeptSelectVO;
import com.hh.his.graduationproject.model.vo.DeptUpdateVO;

import java.util.List;

public interface DeptService {

    List<DeptSelectVO> findAllDept();

    PageInfo<Dept> getDept(Integer pageNum, DeptConditionVO conditionVO);

    int updateDeptByDeptId(DeptUpdateVO dept) throws Exception;

    int deleteDeptByDeptId(String deptId);

    int addDept(Dept dept) throws Exception;
}
