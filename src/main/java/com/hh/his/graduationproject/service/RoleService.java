package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoles();

    PageInfo getRolesByPage(Integer pageNum);

    int addRole(Role role);

    int deleteRole(Integer roleId);
}
