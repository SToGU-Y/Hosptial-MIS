package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.Role;
import com.hh.his.graduationproject.service.RoleService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @SystemLogController(description = "获取角色信息")
    @RequestMapping(value = "/getRoles",method = RequestMethod.GET)
    public Result getRoles(){
        try{
            List<Role> roles = roleService.getRoles();
            return Result.OK(roles);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }

    }

    @SystemLogController(description = "获取角色信息（分页）")
    @RequestMapping(value = "/getRolesByPage",method = RequestMethod.GET)
    public Result getRolesByPage(@RequestParam(required = false,defaultValue = "1")Integer pageNum){
        try{
            PageInfo rolesByPage = roleService.getRolesByPage(pageNum);
            return Result.OK(rolesByPage);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @SystemLogController(description = "添加角色")
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public Result addRole(@RequestBody Role role){
        try {
            int i = roleService.addRole(role);
            if (i==0){
                return Result.ERROR("添加失败");
            }else {
                return Result.OK("添加成功");
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @SystemLogController(description = "删除角色")
    @RequestMapping(value = "/delRole",method = RequestMethod.DELETE)
    public Result delRole(Integer roleId){
        try {
            int i = roleService.deleteRole(roleId);
            if (i==0){
                return Result.ERROR("删除失败");
            }else {
                return Result.OK("删除成功");
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

}
