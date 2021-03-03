package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.controller.MenuController;
import com.hh.his.graduationproject.model.entity.Menu;
import com.hh.his.graduationproject.model.vo.MenuVO;
import com.hh.his.graduationproject.model.vo.condition.MenuCondition;

import java.util.List;

public interface MenuService {

    /**
     * 通过工号获取相应菜单
     * @param username
     * @return
     */
    List<Menu> getMenusByUsername(String username);

    /**
     * 通过角色编号获取相应菜单
     * @param roleId
     * @return
     */
    List<Menu> getMenusByRoleId(Integer roleId);

    /**
     * 获取全部菜单
     * @return
     */
    List<Menu> getAllMenus();


    PageInfo<MenuVO> getAllMenusByPage(Integer pageNum, MenuCondition condition);

    /**
     * 获取全部菜单并附带角色信息
     * @return
     */
    List<Menu> getAllMenusWithRole();

    /**
     * 通过角色id获取菜单id
     * @param roleId
     * @return
     */
    List<Integer> getMenuIdsByRoleId(Integer roleId);

    /**
     * 更新角色与菜单的关系
     * @param roleId
     * @param memuIds
     * @return
     */
    boolean updateMenuRole(Integer roleId, Integer[] memuIds);


    int addMenu(MenuVO menuVO) throws Exception;

    int updateMenu(MenuVO menuVO);

    int delMenu(Integer id) throws Exception;

}
