package com.hh.his.graduationproject.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.DeptMapper;
import com.hh.his.graduationproject.dao.StaffMapper;
import com.hh.his.graduationproject.dao.StaffRoleMapper;
import com.hh.his.graduationproject.model.entity.Role;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.model.vo.condition.StaffConditionVO;
import com.hh.his.graduationproject.service.StaffService;
import com.hh.his.graduationproject.utils.bean.StaffConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 员工管理业务
 */
@Transactional
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private StaffRoleMapper staffRoleMapper;

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public PageInfo<StaffVO> getStaffByCondition(Integer pageNum, StaffConditionVO conditionVO) {
        List<Staff> forTotal = staffMapper.getStaffsWithAllByCondition(conditionVO);
        PageInfo<Staff> pageInfo = new PageInfo<>(forTotal);
        long total = pageInfo.getTotal();

        PageHelper.startPage(pageNum,11);
        PageHelper.orderBy("staff.username");
        List<Staff> staffs = staffMapper.getStaffsWithAllByCondition(conditionVO);

        List<StaffVO> staffVOS = StaffConverter.INSTANCE.toVOList(staffs);
        PageInfo pageInfo1 = new PageInfo(staffVOS);
        pageInfo1.setTotal(total);

        return pageInfo1;
    }

    @Override
    public int delStaff(String username) {
        Staff staff = staffMapper.selectByPrimaryKey(username);
        deptMapper.decreaseStaffNumberByDeptName(staff.getDeptName());
        int i = staffMapper.deleteByPrimaryKey(username);
        staffRoleMapper.deleteByUsername(username);
        return i;
    }

    @Override
    public StaffUpdateVO getStaffByUsername(String username) {
        Staff staff = staffMapper.selectByPrimaryKey(username);
        StaffUpdateVO updateVO = StaffConverter.INSTANCE.toUpdateVO(staff);
        List<Integer> list = new ArrayList<>();
        for(Role role : staff.getRoles()){
            list.add(role.getRoleId());
        }
        updateVO.setRole(list);
        return updateVO;
    }

    @Override
    public Staff getStaffByUsername2(String username) {
        Staff staff = staffMapper.selectByPrimaryKey(username);
        return staff;
    }

    @Override
    public int insertStaff(StaffAddVO staffAddVO) throws Exception{
        Staff staff = StaffConverter.INSTANCE.toDO(staffAddVO);
        int insert = staffMapper.insert(staff);
        staffRoleMapper.addRole(staff.getUsername(), staffAddVO.getRole());
        deptMapper.increaseStaffNumberByDeptName(staff.getDeptName());
        return insert;
    }

    @Override
    public int updateStaff(StaffUpdateVO staffUpdateVO) {
        Staff staff = staffMapper.findByUsername(staffUpdateVO.getUsername());
        if (!staff.getDeptName().equals(staffUpdateVO.getDeptName())){
            deptMapper.increaseStaffNumberByDeptName(staffUpdateVO.getDeptName());
            deptMapper.decreaseStaffNumberByDeptName(staff.getDeptName());
        }
        int i = staffMapper.updateByPrimaryKey(staffUpdateVO);
        staffRoleMapper.deleteByUsername(staffUpdateVO.getUsername());
        staffRoleMapper.addRole(staffUpdateVO.getUsername(),staffUpdateVO.getRole());
        return i;
    }

    @Override
    public int updatePW(PasswordUpdate passwordUpdate) throws Exception {
        Staff staff = staffMapper.selectByPrimaryKey(passwordUpdate.getUsername());
        //第一个是明文，第二个是密文
        boolean matches = new BCryptPasswordEncoder().matches(passwordUpdate.getOldpw(), staff.getPassword());
        int update = 0;
        if (matches){
            String password = new BCryptPasswordEncoder().encode(passwordUpdate.getNewpw());
            update = staffMapper.updatePassword(passwordUpdate.getUsername(),password);
        }else{
            throw new Exception("密码错误,修改失败");
        }
        return update;
    }

    @Override
    public int resetPassword(LoginVO loginVO) throws Exception {
        Staff staff = staffMapper.selectByPrimaryKey(loginVO.getUsername());
        if (staff ==null){
            throw new Exception("请输入正确的工号");
        }
        String password = new BCryptPasswordEncoder().encode(loginVO.getPassword());
        Integer integer = staffMapper.updatePassword(loginVO.getUsername(), password);
        return integer;
    }

}
