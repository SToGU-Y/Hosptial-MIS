package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.Deposit;
import com.hh.his.graduationproject.model.vo.DepositQueryVO;
import com.hh.his.graduationproject.model.vo.condition.DepositAddJSON;
import com.hh.his.graduationproject.model.vo.condition.DepositRefundConditionVO;
import com.hh.his.graduationproject.model.vo.DepositUpdateVO;
import com.hh.his.graduationproject.service.DepositService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    private DepositService depositService;


    @SystemLogController(description = "押金退款")
    @RequestMapping(value = "/depositReturn",method = RequestMethod.POST)
    public Result depositReturn(@RequestBody DepositUpdateVO depositUpdateVO){
        int i = depositService.depositReturn(depositUpdateVO);
        if (i == 0){
            return Result.ERROR("已产生费用，无法退还");
        }else {
            return Result.OK("退款登记成功");
        }
    }

    @SystemLogController(description = "获取退款信息")
    @RequestMapping(value = "/getRefund",method = RequestMethod.GET)
    public Result getRefund(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                            DepositRefundConditionVO conditionVO){
        PageInfo<Deposit> allRefund = depositService.getAllRefund(pageNum,conditionVO);
        return Result.OK(allRefund);
    }

    @SystemLogController(description = "补交押金")
    @RequestMapping(value = "/payDeposit",method = RequestMethod.POST)
    public Result payDeposit(@RequestBody Deposit deposit){
        int i = depositService.payDeposit(deposit);
        if (i==0){
            return Result.ERROR("补交失败，详情请问管理员");
        }else {
            return Result.OK("补交成功");
        }
    }

    @SystemLogController(description = "费用预缴")
    @RequestMapping(value = "/addDeposit",method = RequestMethod.POST)
    public Result addDeposit(@RequestBody DepositAddJSON depositAddJSON){
        try{
            int i = depositService.addDeposit(depositAddJSON);
            if (i==0){
                return Result.ERROR("操作失败");
            }else {
                return Result.OK("预缴成功");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

    @SystemLogController(description = "删除押金单")
    @RequestMapping(value = "/delDeposit",method = RequestMethod.POST)
    public Result delDeposit(@RequestBody List<DepositQueryVO> deposits){
        try{
            int i = depositService.deleteDeposit(deposits);
            if (i==0){
                return Result.ERROR("删除失败");
            }else {
                return Result.OK("成功删除"+i+"条");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

    @SystemLogController(description = "删除退款单")
    @RequestMapping(value = "/delRefundDeposit",method = RequestMethod.POST)
    public Result delRefundDeposit(@RequestBody List<Deposit> deposits){
        try{
            int i = depositService.delRefundDeposit(deposits);
            if (i==0){
                return Result.ERROR("删除失败");
            }else {
                return Result.OK("成功删除"+i+"条");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

}
