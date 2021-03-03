package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.model.vo.condition.StaffConditionVO;
import com.hh.his.graduationproject.service.StaffService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @SystemLogController(description = "获取员工信息")
    @RequestMapping(value = "/getStaff",method = RequestMethod.GET)
    public Result getStaff(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                           StaffConditionVO conditionVO){
        PageInfo<StaffVO> staffs = staffService.getStaffByCondition(pageNum, conditionVO);
        return Result.OK(staffs);
    }

    @SystemLogController(description = "通过工号获取员工信息，用于员工信息更改")
    @RequestMapping(value = "/getStaffByUsername",method = RequestMethod.GET)
    public Result getStaffByUsername(String username){
        try{

        }catch (Exception e){

        }
        StaffUpdateVO staff = staffService.getStaffByUsername(username);
        return Result.OK(staff);
    }

    @SystemLogController(description = "通过工号获取员工信息，用于查看个人信息")
    @RequestMapping(value = "/getStaffByUsername2",method = RequestMethod.GET)
    public Result getStaffByUsername2(String username){
        try {
            Staff staff = staffService.getStaffByUsername2(username);
            return Result.OK(staff);
        }catch (Exception e){
            return Result.ERROR("错误信息："+e.getMessage());
        }
    }

    @SystemLogController(description = "更改员工信息")
    @RequestMapping(value = "/updateStaff",method = RequestMethod.POST)
    public Result updateStaff(@RequestBody StaffUpdateVO staff){
        try {
            int i = staffService.updateStaff(staff);
            if (i != 1) {
                return Result.ERROR("更新失败");
            }
            return Result.OK("更新成功");
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @SystemLogController(description = "删除员工信息")
    @RequestMapping(value = "/delStaff",method = RequestMethod.DELETE)
    public Result delStaff(String username){
        int i = staffService.delStaff(username);
        if (i == 0){
            return Result.ERROR("删除失败");
        }else {
            return Result.OK("删除成功");
        }
    }

    @SystemLogController(description = "新增员工信息")
    @RequestMapping(value = "/addStaff",method = RequestMethod.POST)
    public Result addStaff(@RequestBody StaffAddVO staffAddVO){
        try {
            int i = staffService.insertStaff(staffAddVO);
            if (i != 1){
                return Result.ERROR("添加失败");
            }else {
                return Result.OK("添加成功");
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @SystemLogController(description = "重置员工密码")
    @RequestMapping(value = "/resetPW",method = RequestMethod.POST)
    public Result resetPW(@RequestBody LoginVO loginVO){
        try {
            int i = staffService.resetPassword(loginVO);
            if (i==0){
                return Result.ERROR("重置密码失败");
            }else {
                return Result.OK("重置密码成功");
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @SystemLogController(description = "重置员工密码")
    @RequestMapping(value = "/updatePW",method = RequestMethod.POST)
    public Result updatePW(@RequestBody PasswordUpdate passwordUpdate){
        try {
            int i = staffService.updatePW(passwordUpdate);
            if (i==0){
                return Result.ERROR("修改密码失败");
            }else {
                return Result.OK("修改密码成功");
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }
}
