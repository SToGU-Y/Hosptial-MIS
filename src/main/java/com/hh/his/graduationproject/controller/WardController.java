package com.hh.his.graduationproject.controller;

import com.hh.his.graduationproject.model.dto.WardTypeDTO;
import com.hh.his.graduationproject.model.entity.InpatientWardType;
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
    public Result addType(@RequestBody WardTypeDTO wardTypeDTO){
        if (wardTypeService.addWardType(wardTypeDTO)) {
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



}
