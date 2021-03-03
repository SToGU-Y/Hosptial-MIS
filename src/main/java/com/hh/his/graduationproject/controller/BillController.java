package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.Bill;
import com.hh.his.graduationproject.model.vo.BillVO;
import com.hh.his.graduationproject.model.vo.InpatientUpdateVO;
import com.hh.his.graduationproject.model.vo.ReportVO;
import com.hh.his.graduationproject.model.vo.condition.BillCondition;
import com.hh.his.graduationproject.model.vo.condition.ReportCondition;
import com.hh.his.graduationproject.service.BillService;
import com.hh.his.graduationproject.service.InpatientService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private InpatientService inpatientService;

    @SystemLogController(description = "出院结算")
    @RequestMapping(value = "/addBill",method = RequestMethod.POST)
    public Result addBill(@RequestBody Bill bill){
        String s = billService.addBill(bill);
        return Result.OK(s);
    }

    @SystemLogController(description = "查询账单信息")
    @RequestMapping(value = "/getAllBill",method = RequestMethod.GET)
    public Result getAllBill(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                             BillCondition condition) {
        PageInfo<BillVO> allBill = billService.getAllBill(pageNum, condition);
        return Result.OK(allBill);
    }

    @SystemLogController(description = "删除账单信息")
    @RequestMapping(value = "/delBill",method = RequestMethod.POST)
    public Result delBill(@RequestBody List<BillVO> list){
        try {
            int i = billService.deleteBill(list);
            if (i == 0){
                return Result.ERROR("删除失败");
            }else {
                return Result.OK("成功删除"+i+"条");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }

    @SystemLogController(description = "报表生成")
    @RequestMapping(value = "/getReport",method = RequestMethod.GET)
    public Result getReport(ReportCondition condition){
        try {
            List<ReportVO> report = billService.getReport(condition);
            return Result.OK(report);
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }

    @RequestMapping(value = "/getBillReport",method = RequestMethod.GET)
    public Result getBillReport(Integer admissionId){
        try {
            InpatientUpdateVO admissionById = inpatientService.findAdmissionById(admissionId);
            return Result.OK(admissionById);
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

}
