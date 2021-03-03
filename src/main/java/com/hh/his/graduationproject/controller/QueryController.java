package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.Cost;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.model.vo.condition.QueryCondition;
import com.hh.his.graduationproject.service.CostService;
import com.hh.his.graduationproject.service.DepositService;
import com.hh.his.graduationproject.service.InpatientService;
import com.hh.his.graduationproject.service.RecordService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private InpatientService inpatientService;

    @Autowired
    private CostService costService;

    @Autowired
    private DepositService depositService;

    @Autowired
    private RecordService recordService;


    @SystemLogController(description = "查询费用信息(病人自助)")
    @RequestMapping(value = "/queryCost",method = RequestMethod.GET)
    public Result queryCost(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                 QueryCondition condition){
        try {
            PageInfo<QueryCostVO> pageInfo = costService.QueryCost(pageNum, condition);
            if (pageInfo.getTotal() == 0){
                return Result.ERROR("找不到对应数据，请确认搜索条件无误");
            }else {
                return Result.OK(pageInfo);
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }

    }

    @SystemLogController(description = "查询费用明细(病人自助)")
    @RequestMapping(value = "/getCostByAdmissionId",method = RequestMethod.GET)
    public Result getCostByAdmissionId(Integer admissionId,String date1,String date2){
        List<Cost> costByAdmissionId = costService.getCostByAdmissionId(admissionId, date1, date2);
        return Result.OK(costByAdmissionId);
    }

    @SystemLogController(description = "查询押金信息(病人自助)")
    @RequestMapping(value = "/queryDeposit",method = RequestMethod.GET)
    public Result queryDeposit(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                               QueryCondition condition){
        try {
            PageInfo<DepositQueryVO> depositQueryVOPageInfo = depositService.depositQuery(pageNum, condition);
            if (depositQueryVOPageInfo.getTotal() == 0){
                return Result.ERROR("找不到对应数据，请确认搜索条件无误");
            }else {
                return Result.OK(depositQueryVOPageInfo);
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }

    }

    @SystemLogController(description = "查询住院记录(病人自助)")
    @RequestMapping(value = "/queryInpatient",method = RequestMethod.GET)
    public Result queryInpatient(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                 QueryCondition condition){
        try {
            PageInfo<QueryInpatientVO> informationPageInfo = inpatientService.queryInpatient(pageNum, condition);
            if (informationPageInfo.getTotal() == 0){
                return Result.ERROR("找不到对应数据，请确认搜索条件无误");
            }else {
                return Result.OK(informationPageInfo);
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

    @SystemLogController(description = "查询病历信息(病人自助)")
    @RequestMapping(value = "/queryRecord",method = RequestMethod.GET)
    public Result queryRecord(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                 QueryCondition condition){
        try {
            PageInfo<QueryInpatientVO> informationPageInfo = recordService.queryRecord(pageNum, condition);
            if (informationPageInfo.getTotal() == 0){
                return Result.ERROR("找不到对应数据，请确认搜索条件无误");
            }else {
                return Result.OK(informationPageInfo);
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }
    }

}
