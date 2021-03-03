package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.MenuMapper;
import com.hh.his.graduationproject.dao.MenuRoleMapper;
import com.hh.his.graduationproject.model.entity.Menu;
import com.hh.his.graduationproject.model.vo.MenuVO;
import com.hh.his.graduationproject.model.vo.condition.MenuCondition;
import com.hh.his.graduationproject.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.dc.pr.PRError;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Override
    public List<Menu> getMenusByUsername(String username) {
        List<Menu> menusByUsername = menuMapper.getMenusByUsername(username);
        return menusByUsername;
    }

    @Override
    public List<Menu> getMenusByRoleId(Integer roleId) {
        List<Menu> menusByRoleId = menuMapper.getMenusByRoleId(roleId);
        return menusByRoleId;
    }

    @Override
    public List<Menu> getAllMenus() {
        List<Menu> allMenus = menuMapper.getAllMenus();
        return allMenus;
    }

    @Override
    public PageInfo<MenuVO> getAllMenusByPage(Integer pageNum, MenuCondition condition) {
        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("id");
        List<MenuVO> allMenusByPage = menuMapper.getAllMenusByPage(condition);
        PageInfo pageInfo = new PageInfo(allMenusByPage);
        return pageInfo;
    }


    @Override
    public List<Menu> getAllMenusWithRole() {
        List<Menu> allMenusWithRole = menuMapper.getAllMenusWithRole();
        return allMenusWithRole;
    }

    @Override
    public List<Integer> getMenuIdsByRoleId(Integer roleId) {
        List<Integer> midsByRid = menuMapper.getMidsByRid(roleId);
        return midsByRid;
    }

    @Override
    public boolean updateMenuRole(Integer roleId, Integer[] memuIds) {
        menuRoleMapper.deleteByRid(roleId);
        if (memuIds == null || memuIds.length == 0) {
            return true;
        }
        Integer result = menuRoleMapper.insertRecord(roleId,memuIds);
        return result==memuIds.length;
    }

    @Override
    public int addMenu(MenuVO menuVO) throws Exception {
        Integer integer = menuMapper.selectByPrimaryKey(menuVO.getId());
        if (integer>0){
            throw new Exception("编号重复");
        }
        int insert = menuMapper.insert(menuVO);
        menuRoleMapper.insert(menuVO.getRoleId(),menuVO.getId());
        return insert;
    }

    @Override
    public int updateMenu(MenuVO menuVO) {
        int i = menuMapper.updateByPrimaryKeySelective(menuVO);
        return i;
    }

    @Override
    public int delMenu(Integer id) throws Exception {
        if (menuMapper.selectById(id)>0){
            throw new Exception("当前菜单下有子菜单，无法删除");
        }
        menuRoleMapper.deleteByMid(id);
        int i = menuMapper.deleteByPrimaryKey(id);
        return i;
    }
}
