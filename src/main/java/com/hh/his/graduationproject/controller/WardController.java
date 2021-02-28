package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.InpatientWard;
import com.hh.his.graduationproject.model.vo.WardAddVO;
import com.hh.his.graduationproject.model.vo.WardTypeVO;
import com.hh.his.graduationproject.model.entity.InpatientWardType;
import com.hh.his.graduationproject.model.vo.WardUpdateVO;
import com.hh.his.graduationproject.model.vo.WardVO;
import com.hh.his.graduationproject.model.vo.condition.WardConditionVO;
import com.hh.his.graduationproject.service.WardService;
import com.hh.his.graduationproject.service.WardTypeService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ward")
public class WardController {

    @Autowired
    private WardTypeService wardTypeService;

    @Autowired
    private WardService wardService;

    @SystemLogController(description = "添加病房类型")
    @RequestMapping(value = "/addType",method = RequestMethod.POST)
    public Result addType(@RequestBody WardTypeVO wardTypeVO){
        if (wardTypeService.addWardType(wardTypeVO)) {
            return Result.OK();
        }else {
            return Result.ERROR("插入失败");
        }
    }

    @SystemLogController(description = "更新病房类型信息")
    @RequestMapping(value = "/updateType",method = RequestMethod.POST)
    public Result updateType(@RequestBody InpatientWardType wardType){
        if (wardTypeService.updateWardType(wardType)) {
            return Result.OK("更改成功!");
        }
        return Result.ERROR("更改失败！");
    }

    @SystemLogController(description = "删除病房类型")
    @RequestMapping(value = "/delType",method = RequestMethod.DELETE)
    public Result delType(@RequestParam("iwtId")Integer iwtId){
        if (wardTypeService.delWardType(iwtId)){
            return Result.OK("删除成功！");
        }else {
            return Result.ERROR("删除失败，请先删除该病房下的所有病床！");
        }
    }

    @SystemLogController(description = "添加病房")
    @RequestMapping(value = "/addWard",method = RequestMethod.POST)
    public Result addWard(@RequestBody WardAddVO wardAddVO){
        try{
            if (wardService.addWard(wardAddVO)){
                return Result.OK("添加成功");
            }else {
                return Result.ERROR("添加失败(病房号或者科室号重复)！");
            }
        }catch (Exception e){
            return Result.ERROR("数据有误，添加失败");
        }
    }

    @SystemLogController(description = "删除病房")
    @RequestMapping(value = "/delWard",method = RequestMethod.DELETE)
    public Result delWard(@RequestParam("id")Integer id){
        if (wardService.delWard(id)){
            return Result.OK("删除成功！");
        }else {
            return Result.ERROR("删除失败,请先删除该病房下的病床!");
        }
    }

    @SystemLogController(description = "更新病房")
    @RequestMapping(value = "/updateWard",method = RequestMethod.POST)
    public Result updateWard(@RequestBody WardUpdateVO wardUpdateVO){
        if (wardService.updateWard(wardUpdateVO)){
            return Result.OK("更新成功！");
        }else {
            return Result.ERROR("更新失败！");
        }
    }

    @SystemLogController(description = "通过科室获得相应病房信息")
    @RequestMapping("/getWardByDept")
    public Result getWardByDept(String deptId){
        List<InpatientWard> wardByDept = wardService.getWardByDept(deptId);
        return Result.OK(wardByDept);
    }

    @SystemLogController(description = "查询病房信息")
    @RequestMapping(value = "/getWardByCondition",method = RequestMethod.GET)
    public Result getWardByCondition(@RequestParam(required = false,defaultValue = "1",value = "pageNum") Integer pageNum
            , WardConditionVO wardConditionVO){
        PageInfo<WardVO> wardByCondition = wardService.findWardByCondition(pageNum, wardConditionVO);
        return Result.OK(wardByCondition);
    }

    @SystemLogController(description = "获取病房类型")
    @RequestMapping(value = "/getType",method = RequestMethod.GET)
    public Result getType(){
        List<InpatientWardType> allWardType = wardTypeService.findAllWardType();
        return Result.OK(allWardType);
    }

    @SystemLogController(description = "获取病房类型（分页）")
    @RequestMapping(value = "/getTypeByPage",method = RequestMethod.GET)
    public Result getTypeByPage(@RequestParam(required = false,defaultValue = "1",value = "pageNum") Integer pageNum){
        PageInfo<InpatientWardType> allWardType = wardTypeService.findAllWardTypeByPage(pageNum);
        return Result.OK(allWardType);
    }

}
