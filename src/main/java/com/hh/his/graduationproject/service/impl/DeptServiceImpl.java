package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.DeptMapper;
import com.hh.his.graduationproject.model.entity.Dept;
import com.hh.his.graduationproject.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAllDept() {
        List<Dept> allDept = deptMapper.findAllDept();
        return allDept;
    }
}
