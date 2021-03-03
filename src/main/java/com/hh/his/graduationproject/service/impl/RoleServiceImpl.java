package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.MenuRoleMapper;
import com.hh.his.graduationproject.dao.RoleMapper;
import com.hh.his.graduationproject.dao.StaffRoleMapper;
import com.hh.his.graduationproject.model.entity.Menu;
import com.hh.his.graduationproject.model.entity.MenuRole;
import com.hh.his.graduationproject.model.entity.Role;
import com.hh.his.graduationproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private StaffRoleMapper staffRoleMapper;

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Override
    public List<Role> getRoles() {
        List<Role> allRoles = roleMapper.getAllRoles();
        return allRoles;
    }

    @Override
    public PageInfo getRolesByPage(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Role> allRoles = roleMapper.getAllRoles();
        PageInfo pageInfo = new PageInfo(allRoles);
        return pageInfo;
    }

    @Override
    public int addRole(Role role) {
        int insert = roleMapper.insert(role);
        return insert;
    }

    @Override
    public int deleteRole(Integer roleId) {
        staffRoleMapper.deleteByRoleId(roleId);
        menuRoleMapper.deleteByRid(roleId);
        int i = roleMapper.deleteByPrimaryKey(roleId);
        return i;
    }
}
