package com.hh.his.graduationproject.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.MedicalAppliance;
import com.hh.his.graduationproject.model.entity.MedicalApplianceType;
import com.hh.his.graduationproject.model.vo.EquipmentBorrow;
import com.hh.his.graduationproject.model.vo.condition.ApplianceConditionVO;
import com.hh.his.graduationproject.service.ApplianceService;
import com.hh.his.graduationproject.service.ApplianceTypeService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appliance")
public class ApplianceController {

    @Autowired
    private ApplianceService applianceService;

    @Autowired
    private ApplianceTypeService applianceTypeService;

    @SystemLogController(description = "获取器械类型")
    @RequestMapping(value = "/getApplianceType",method = RequestMethod.GET)
    public Result getApplianceType(){
        List<MedicalApplianceType> all = applianceTypeService.findAll();
        return Result.OK(all);
    }

    @SystemLogController(description = "获取器械")
    @RequestMapping(value = "/getAppliance",method = RequestMethod.GET)
    public Result getAppliance(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                               ApplianceConditionVO conditionVO){
        PageInfo<MedicalAppliance> appliance = applianceService.findAppliance(pageNum, conditionVO);
        return Result.OK(appliance);
    }


    @SystemLogController(description = "退还器械")
    @RequestMapping(value = "/returnEquipment",method = RequestMethod.POST)
    public Result returnEquipment(@RequestBody String id){
        JSONObject jsonObject = JSONObject.parseObject(id);
        Integer parse = jsonObject.getInteger("id");
        int status = applianceService.updateStatus(0, parse,"");
        if (status == 1){
            return Result.OK("退还成功");
        }else {
            return Result.ERROR("退还失败");
        }
    }

    @SystemLogController(description = "借出器械")
    @RequestMapping(value = "/borrowEquipment",method = RequestMethod.POST)
    public Result borrowEquipment(@RequestBody EquipmentBorrow equipmentBorrow){
        int status = applianceService.updateStatus(1, equipmentBorrow.getId(),equipmentBorrow.getRemarks());
        if (status == 1){
            return Result.OK("申请成功");
        }else {
            return Result.ERROR("申请失败");
        }
    }

    @SystemLogController(description = "更新器械")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody MedicalAppliance appliance){
        int update = applianceService.update(appliance);
        if (update == 1){
            return Result.OK("更改成功");
        }else {
            return Result.ERROR("更改失败");
        }
    }

    @SystemLogController(description = "通过id删除器械信息")
    @RequestMapping(value = "/deleteById",method = RequestMethod.DELETE)
    public Result delete(Integer id){
        int delete = applianceService.deleteById(id);
        if (delete == 1){
            return Result.OK("删除成功");
        }else {
            return Result.ERROR("删除失败");
        }
    }

    @SystemLogController(description = "登记器械")
    @RequestMapping(value = "/addEquipment",method = RequestMethod.POST)
    public Result addEquipment(@RequestBody MedicalAppliance appliance){
        int i = applianceService.addAppliance(appliance);
        if (i == 1){
            return Result.OK("登记成功");
        }else {
            return Result.ERROR("登记失败");
        }
    }

}
