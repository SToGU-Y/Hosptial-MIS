package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.*;
import com.hh.his.graduationproject.model.entity.Dept;
import com.hh.his.graduationproject.model.entity.InpatientWard;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.model.vo.condition.DeptConditionVO;
import com.hh.his.graduationproject.model.vo.DeptSelectVO;
import com.hh.his.graduationproject.model.vo.DeptUpdateVO;
import com.hh.his.graduationproject.model.vo.condition.StaffConditionVO;
import com.hh.his.graduationproject.service.DeptService;
import com.hh.his.graduationproject.utils.bean.DeptConverter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private StaffRoleMapper staffRoleMapper;

    @Autowired
    private InpatientWardMapper wardMapper;

    @Autowired
    private MedicalAdviceMapper adviceMapper;

    @Autowired
    private InpatientInformationMapper informationMapper;

    @Autowired
    private DrugApplicationMapper drugApplicationMapper;


    @Override
    public List<DeptSelectVO> findAllDept() {
        List<Dept> allDept = deptMapper.findAllDept();
        List<DeptSelectVO> deptSelectVOS = DeptConverter.INSTANCE.toSelectVOList(allDept);
        return deptSelectVOS;
    }

    @Override
    public PageInfo<Dept> getDept(Integer pageNum, DeptConditionVO conditionVO) {
        System.out.println(conditionVO);
        PageHelper.startPage(pageNum,11);
        List<Dept> dept = deptMapper.findDeptByCondition(conditionVO);
        PageInfo<Dept> pageInfo = new PageInfo<>(dept);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public int updateDeptByDeptId(DeptUpdateVO dept) throws Exception {
        Dept dept1 = deptMapper.selectByDeptId(dept.getDeptId());
        int i = deptMapper.updateByDeptId(dept);
        Dept dept2 = deptMapper.selectByDeptId(dept.getNewDeptId());
        if (!dept1.getDeptName().equals(dept2.getDeptName())){
            staffMapper.updateDeptName(dept2.getDeptName(),dept1.getDeptName());
            drugApplicationMapper.updateDept(dept1.getDeptName(),dept2.getDeptName());
            adviceMapper.updateDept(dept1.getDeptName(),dept2.getDeptName());
            informationMapper.updateDept(dept1.getDeptName(),dept2.getDeptName());
        }
        if (!dept.getDeptId().equals(dept.getNewDeptId())){
            wardMapper.updateWardDeptId(dept.getNewDeptId(),dept.getDeptId());
        }
        return i;
    }

    @Override
    public int deleteDeptByDeptId(String deptId) {
        Dept dept = deptMapper.selectByDeptId(deptId);
        StaffConditionVO conditionVO = new StaffConditionVO();
        conditionVO.setDeptName(dept.getDeptName());
        List<Staff> staffsWithAllByCondition = staffMapper.getStaffsWithAllByCondition(conditionVO);
        for (Staff staff: staffsWithAllByCondition){
            staffRoleMapper.deleteByUsername(staff.getUsername());
        }
        staffMapper.deleteByDeptName(dept.getDeptName());
        int i = deptMapper.deleteByDeptId(deptId);
        return i;
    }

    @Override
    public int addDept(Dept dept) throws Exception {
        dept.setStaffNumber(0);
        int i = deptMapper.insertDept(dept);
        return i;
    }
}
