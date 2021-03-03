package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.Cost;
import com.hh.his.graduationproject.service.CostService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cost")
public class CostController {

    @Autowired
    private CostService costService;

    @SystemLogController(description = "费用录入")
    @RequestMapping(value = "/addCost",method = RequestMethod.POST)
    public Result addCost(@RequestBody Cost cost){
        try {
            int i = costService.addCostRecord(cost);
            if (i == 0){
                return Result.ERROR("录入失败");
            }else {
                return Result.OK("录入成功");
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @SystemLogController(description = "查看费用明细")
    @RequestMapping(value = "/getCostByAdmissionId",method = RequestMethod.GET)
    public Result getCostByAdmissionId(Integer admissionId,String date1,String date2){
        List<Cost> costByAdmissionId = costService.getCostByAdmissionId(admissionId, date1, date2);
        return Result.OK(costByAdmissionId);
    }

    @SystemLogController(description = "删除费用")
    @RequestMapping(value = "/delCost",method = RequestMethod.POST)
    public Result delCost(@RequestBody List<Cost> costs){
        int i = costService.delCost(costs);
        if (i == 0){
            return Result.ERROR("删除失败");
        }else {
            return Result.OK("删除成功");
        }
    }


}
