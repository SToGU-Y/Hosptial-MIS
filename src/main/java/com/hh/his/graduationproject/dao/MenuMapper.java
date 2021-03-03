package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.Menu;
import com.hh.his.graduationproject.model.vo.MenuVO;
import com.hh.his.graduationproject.model.vo.condition.MenuCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import javax.annotation.security.PermitAll;
import java.util.List;

public interface MenuMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(@Param("menu") MenuVO record);

    int insertSelective(Menu record);

    Integer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(@Param("menu") MenuVO record);

    int updateByPrimaryKey(Menu record);

    int  selectById(@Param("id")Integer id);

    int delete(@Param("id")Integer id);

    List<Menu> getMenusByUsername(@Param("username") String username);

    List<Menu> getMenusByRoleId(@Param("roleId")Integer roleId);

    List<MenuVO> getAllMenusByPage(@Param("condition") MenuCondition condition);

    List<Menu> getAllMenus();

    List<Menu> getAllMenusWithRole();

    List<Integer> getMidsByRid(Integer rid);
}
