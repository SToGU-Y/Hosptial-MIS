package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.Dept;
import com.hh.his.graduationproject.model.vo.condition.DeptConditionVO;
import com.hh.his.graduationproject.model.vo.DeptUpdateVO;
import com.hh.his.graduationproject.service.DeptService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @SystemLogController(description = "获取科室详情信息")
    @RequestMapping(value = "/getDept",method = RequestMethod.GET)
    public Result getDept(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                          DeptConditionVO vo){
        PageInfo deptList = deptService.getDept(pageNum,vo);
        return Result.OK(deptList);
    }

    @SystemLogController(description = "添加科室")
    @RequestMapping(value = "/addDept",method = RequestMethod.POST)
    public Result addDept(@RequestBody Dept dept){
        try {
            int i = deptService.addDept(dept);
            if (i == 1){
                return Result.OK("添加成功");
            }else {
                return Result.ERROR("添加失败");
            }
        }catch (Exception e){
            return Result.ERROR("科室编号/名称已存在");
        }
    }

    @SystemLogController(description = "通过科室编号更新科室")
    @RequestMapping(value = "/updateDeptByDeptId",method = RequestMethod.POST)
    public Result updateDeptByDeptId(@RequestBody DeptUpdateVO dept){
        try {
            int i = deptService.updateDeptByDeptId(dept);
            if (i == 1){
                return Result.OK("更新成功！");
            }else {
                return Result.ERROR("无需更新");
            }
        }catch (Exception e){
            return Result.ERROR("错误操作");
        }
    }

    @SystemLogController(description = "通过编号删除科室")
    @RequestMapping(value = "/delDeptByDeptId",method = RequestMethod.DELETE)
    public Result delDeptByDeptId(String deptId){
        int i = deptService.deleteDeptByDeptId(deptId);
        if (i==1){
            return Result.OK("删除成功！");
        }else {
            return Result.ERROR("删除失败！");
        }
    }

}
