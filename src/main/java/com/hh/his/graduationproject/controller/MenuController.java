package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.Menu;
import com.hh.his.graduationproject.model.vo.MenuRoleJSON;
import com.hh.his.graduationproject.model.vo.MenuVO;
import com.hh.his.graduationproject.model.vo.condition.MenuCondition;
import com.hh.his.graduationproject.service.MenuService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @SystemLogController(description = "通过角色编号获取菜单")
    @RequestMapping(value = "/getMenuByRoleId",method = RequestMethod.GET)
    public Result getMenuByRole(Integer roleId){
        try {
            List<Menu> menusByRoleId = menuService.getMenusByRoleId(roleId);
            return Result.OK(menusByRoleId);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }

    }

    @SystemLogController(description = "根据工号获取当前用户的菜单")
    @RequestMapping(value = "/getMenuByUsername",method = RequestMethod.GET)
    public Result getMenuByUsername(String username){
        List<Menu> menusByUsername = menuService.getMenusByUsername(username);
        return Result.OK(menusByUsername);
    }

    @SystemLogController(description = "获取所有菜单")
    @RequestMapping(value = "/getAllMenus",method = RequestMethod.GET)
    public Result getAllMenus(){
        try {
            List<Menu> allMenus = menuService.getAllMenus();
            return Result.OK(allMenus);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @SystemLogController(description = "获取所有菜单(分页)")
    @RequestMapping(value = "/getAllMenusByPage",method = RequestMethod.GET)
    public Result getAllMenusByPage(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                    MenuCondition condition){
        try {
            PageInfo<MenuVO> allMenus = menuService.getAllMenusByPage(pageNum,condition);
            return Result.OK(allMenus);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @SystemLogController(description = "给角色分配菜单")
    @RequestMapping(value = "/MenuRoleChange",method = RequestMethod.POST)
    public Result MenuRoleChange(@RequestBody MenuRoleJSON menuRoleJSON){
        try {
            System.out.println(menuRoleJSON);
            boolean b = menuService.updateMenuRole(menuRoleJSON.getRoleId(), menuRoleJSON.getMenuIds());
            if (!b){
                return Result.ERROR("更改失败");
            }else {
                return Result.OK("更改成功");
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @RequestMapping(value = "/addMenu",method = RequestMethod.POST)
    public Result addMenu(@RequestBody MenuVO menuVO){
        try {
            int i = menuService.addMenu(menuVO);
            if (i == 0){
                return Result.ERROR("添加失败");
            }else {
                return Result.OK("添加成功");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

    @RequestMapping(value = "/updateMenu",method = RequestMethod.POST)
    public Result update(@RequestBody MenuVO menuVO){
        try {
            int i = menuService.updateMenu(menuVO);
            if (i == 0){
                return Result.ERROR("更改失败");
            }else {
                return Result.OK("更改成功");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

    @RequestMapping(value = "/delMenu",method = RequestMethod.DELETE)
    public Result delMenu(Integer id){
        try {
            int i = menuService.delMenu(id);
            if (i == 0){
                return Result.ERROR("删除失败");
            }else {
                return Result.OK("删除成功");
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }


}
