package com.hh.his.graduationproject.controller;

import com.hh.his.graduationproject.model.vo.WardAddVO;
import com.hh.his.graduationproject.model.vo.WardTypeVO;
import com.hh.his.graduationproject.model.entity.InpatientWardType;
import com.hh.his.graduationproject.model.vo.WardUpdateVO;
import com.hh.his.graduationproject.service.WardService;
import com.hh.his.graduationproject.service.WardTypeService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ward")
public class WardController {

    @Autowired
    private WardTypeService wardTypeService;

    @Autowired
    private WardService wardService;

    @RequestMapping(value = "/addType",method = RequestMethod.POST)
    public Result addType(@RequestBody WardTypeVO wardTypeVO){
        if (wardTypeService.addWardType(wardTypeVO)) {
            return Result.OK();
        }else {
            return Result.ERROR("插入失败");
        }
    }

    @RequestMapping(value = "/updateType",method = RequestMethod.POST)
    public Result updateType(@RequestBody InpatientWardType wardType){
        if (wardTypeService.updateWardType(wardType)) {
            return Result.OK("更改成功!");
        }
        return Result.ERROR("更改失败！");
    }

    @RequestMapping(value = "/delType",method = RequestMethod.DELETE)
    public Result delType(@RequestParam("iwtId")Integer iwtId){
        if (wardTypeService.delWardType(iwtId)){
            return Result.OK("删除成功！");
        }else {
            return Result.ERROR("删除失败，请先删除该病房下的所有病床！");
        }
    }

    @RequestMapping(value = "/addWard",method = RequestMethod.POST)
    public Result addWard(@RequestBody WardAddVO wardAddVO){
        if (wardService.addWard(wardAddVO)){
            return Result.OK("添加成功");
        }else {
            return Result.ERROR("添加失败(病房号或者科室号重复)！");
        }
    }

    @RequestMapping(value = "/delWard",method = RequestMethod.DELETE)
    public Result delWard(@RequestParam("id")Integer id){
        if (wardService.delWard(id)){
            return Result.OK("删除成功！");
        }else {
            return Result.ERROR("删除失败,请先删除该病房下的病床!");
        }
    }

    @RequestMapping(value = "/updateWard",method = RequestMethod.POST)
    public Result updateWard(@RequestBody WardUpdateVO wardUpdateVO){
        if (wardService.updateWard(wardUpdateVO)){
            return Result.OK("更新成功！");
        }else {
            return Result.ERROR("更新失败！");
        }
    }


}
