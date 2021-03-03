package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.Cost;
import com.hh.his.graduationproject.model.entity.CostItem;
import com.hh.his.graduationproject.service.CostItemService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costItem")
public class CostItemController {

    @Autowired
    private CostItemService costItemService;

    @SystemLogController(description = "获取消费项")
    @RequestMapping(value = "/getCostItem", method = RequestMethod.GET)
    public Result getCostItem(CostItem costItem){
        List<CostItem> costItemByCondition = costItemService.getCostItemByCondition(costItem);
        return Result.OK(costItemByCondition);
    }

    @SystemLogController(description = "通过编号获取消费项信息")
    @RequestMapping(value = "/getCostItemByNo",method = RequestMethod.GET)
    public Result getCostItemByNo(String costItemNo){
        try {
            CostItem costItemByNo = costItemService.getCostItemByNo(costItemNo);
            return Result.OK(costItemByNo);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @SystemLogController(description = "获取全部消费项")
    @RequestMapping(value = "/getCostItems",method = RequestMethod.GET)
    public Result getCostItem2(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                              CostItem costItem){
        try {
            PageInfo<CostItem> costItemPageInfo = costItemService.selectAll(pageNum, costItem);
            return Result.OK(costItemPageInfo);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }

    }

    @SystemLogController(description = "删除消费项")
    @RequestMapping(value = "/delCostItem",method = RequestMethod.POST)
    public Result delCostItem(@RequestBody List<CostItem> costItems){
        try {
            int delete = costItemService.delete(costItems);
            if (delete == 0){
                return Result.ERROR("删除失败");
            }else {
                return Result.OK("成功删除"+delete+"条数据");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息"+e.getMessage());
        }
    }

    @SystemLogController(description = "添加消费项")
    @RequestMapping(value = "/addCostItem",method = RequestMethod.POST)
    public Result addCostItem(@RequestBody CostItem costItem){
        try {
            int insert = costItemService.insert(costItem);
            if (insert == 0){
                return Result.ERROR("新增失败");
            }else {
                return Result.OK("添加成功");
            }
        }catch (Exception e){
            return Result.ERROR("请确认编号是否唯一");
        }
    }

    @SystemLogController(description = "更新消费项")
    @RequestMapping(value = "/updateCostItem",method = RequestMethod.POST)
    public Result updateCostItem(@RequestBody CostItem costItem){
        try {
            int update = costItemService.update(costItem);
            if (update == 0){
                return Result.ERROR("更新失败");
            }else {
                return Result.OK("更改成功");
            }
        }catch (Exception e){
            return Result.ERROR("请填写正确");
        }
    }


}
