package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.dto.BedAddDTO;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.model.vo.condition.BedConditionVO;
import com.hh.his.graduationproject.model.vo.condition.BedSelectConditionVO;
import com.hh.his.graduationproject.service.BedService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bed")
public class BedController {

    @Autowired
    private BedService bedService;

    @SystemLogController(description = "获取空病床")
    @RequestMapping(value = "/getNullBed",method = RequestMethod.GET)
    public Result getNullBed(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                             BedSelectConditionVO selectConditionVO){
        PageInfo<BedSelectVO> beds = bedService.findNullBed(pageNum, selectConditionVO);
        return Result.OK(beds);
    }

    @SystemLogController(description = "选择病床")
    @RequestMapping(value = "/selectBed",method = RequestMethod.POST)
    public Result selectBed(@RequestBody InpatientBedAddVO addVO){
        int i = bedService.updateAdmission(addVO);
        if (i!=1){
            return Result.ERROR("选择失败");
        }
        return Result.OK("选择成功");
    }

    @SystemLogController(description = "更换病床")
    @RequestMapping(value = "/changeBed",method = RequestMethod.POST)
    public Result changeBed(@RequestBody InpatientBedChangeVO changeVO){
        bedService.BedChange(changeVO);
        return Result.OK("更换成功");
    }

    @SystemLogController(description = "退病床")
    @RequestMapping(value = "/returnBed",method = RequestMethod.POST)
    public Result returnBed(@RequestBody ReturnBedVO returnBedVO){
        int i = bedService.returnBed(returnBedVO);
        if ( i == 1 ){
            return Result.OK("退床成功");
        }else {
            return Result.ERROR("退床失败");
        }
    }

    @SystemLogController(description = "获取所有病床信息")
    @RequestMapping(value = "/getAllBed",method = RequestMethod.GET)
    public Result getAllBed(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                            BedConditionVO conditionVO){
        PageInfo<BedVO> bed = bedService.findAllBed(pageNum, conditionVO);
        return Result.OK(bed);
    }

    @SystemLogController(description = "获取非空闲的病床")
    @RequestMapping(value = "/getAllBedNotNull",method = RequestMethod.GET)
    public Result getAllBedNotNull(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                            BedConditionVO conditionVO){
        PageInfo<BedVO> bed = bedService.findBedNotNull(pageNum, conditionVO);
        return Result.OK(bed);
    }

    @SystemLogController(description = "添加病床")
    @RequestMapping(value = "/addBed",method = RequestMethod.POST)
    public Result addBed(@RequestBody BedAddDTO bed){
        try {
            bedService.addBed(bed);
            return Result.OK();
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }

    }

    @SystemLogController(description = "删除病床")
    @RequestMapping(value = "/delBed",method = RequestMethod.DELETE)
    public Result delBed(@RequestParam("id") Integer id){
        int i = bedService.delBed(id);
        if ( i == 1 ){
            return Result.OK("删除成功");
        }else {
            return Result.ERROR("删除失败");
        }
    }


}
