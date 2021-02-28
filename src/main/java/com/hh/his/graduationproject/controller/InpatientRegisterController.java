package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.model.vo.condition.BedPatientSelectConditionVO;
import com.hh.his.graduationproject.model.vo.condition.CostQueryCondition;
import com.hh.his.graduationproject.model.vo.condition.DepositAddCondition;
import com.hh.his.graduationproject.model.vo.condition.InpatientInformationConditionVO;
import com.hh.his.graduationproject.service.InpatientService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class InpatientRegisterController {

    @Autowired
    private InpatientService inpatientService;

    @SystemLogController(description = "入院登记")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result insertPatient(@RequestBody InpatientInformationAddVO inpatientInformationAddVO){
        System.out.println(inpatientInformationAddVO);
        try {
            int record = inpatientService.addInpatientRecord(inpatientInformationAddVO);
            if (record == 1) {
                return Result.OK("登记成功！");
            }else {
                return  Result.ERROR("登记失败!");
            }
        }catch (Exception e){
            return Result.ERROR("登记失败!失败原因："+e.getMessage());
        }
    }

    @SystemLogController(description = "查询住院信息")
    @RequestMapping(value = "/getInformationByCondition",method = RequestMethod.GET)
    public Result getInformationByCondition(@RequestParam(required = false,defaultValue = "1")Integer pageNum , InpatientInformationConditionVO inpatientInformationConditionVO){
        PageInfo<InpatientInformationVO> admissionByConditions = inpatientService.findAdmissionByConditions(pageNum, inpatientInformationConditionVO);
        return Result.OK(admissionByConditions);
    }

    @SystemLogController(description = "查询可出院信息")
    @RequestMapping(value = "/getInformationCanLeave",method = RequestMethod.GET)
    public Result getInformationCanLeave(@RequestParam(required = false,defaultValue = "1")Integer pageNum , InpatientInformationConditionVO inpatientInformationConditionVO){
        PageInfo<InpatientInformationVO> admissionByConditions = inpatientService.findCanLeave(pageNum, inpatientInformationConditionVO);
        return Result.OK(admissionByConditions);
    }

    @SystemLogController(description = "通过主键获取对应住院信息")
    @RequestMapping(value = "/getInformationById",method = RequestMethod.GET)
    public Result getInformationById(Integer id){
        InpatientUpdateVO admissionById = inpatientService.findAdmissionById(id);
        return Result.OK(admissionById);
    }

    @SystemLogController(description = "更改住院信息")
    @RequestMapping(value = "/updateAdmission",method = RequestMethod.POST)
    public Result updateAdmission(@RequestBody InpatientUpdateVO updateVO){
        inpatientService.updateAdmission(updateVO);
        return Result.OK("更改成功！");
    }

    @SystemLogController(description = "通过科室获取对应住院记录,用于选择病床")
    @RequestMapping(value = "/getInformationByDept",method = RequestMethod.GET)
    public Result getInformationByDept(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                       BedPatientSelectConditionVO conditionVO){
        PageInfo pageInfo = inpatientService.findAdmissionByDept(pageNum,conditionVO);
        return Result.OK(pageInfo);
    }

    @SystemLogController(description = "通过科室查询对应住院记录，用于更换病床")
    @RequestMapping(value = "/getInformationByDept2",method = RequestMethod.GET)
    public Result getInformationByDept2(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                       BedPatientSelectConditionVO conditionVO){
        PageInfo pageInfo = inpatientService.findAdmissionByDept2(pageNum,conditionVO);
        if (pageInfo.getTotal() == 0){
            return Result.ERROR("暂无数据");
        }else {
            return Result.OK(pageInfo);
        }
    }


    @SystemLogController(description = "查询所有押金情况")
    @RequestMapping(value = "/getInformationWithDeposit",method = RequestMethod.GET)
    public Result getInformationWithDeposit(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                            DepositAddCondition conditionVO){
        PageInfo<DepositQueryVO> withDeposit = inpatientService.findWithDeposit(pageNum, conditionVO);
        return Result.OK(withDeposit);
    }

    @SystemLogController(description = "查询可退押金信息")
    @RequestMapping(value = "/getInformationWithDeposit2",method = RequestMethod.GET)
    public Result getInformationWithDeposit2(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                            DepositAddCondition conditionVO){
        PageInfo<DepositQueryVO> withDeposit = inpatientService.findWithDeposit2(pageNum, conditionVO);
        return Result.OK(withDeposit);
    }

    @SystemLogController(description = "押金补交查询")
    @RequestMapping(value = "/getInformationWithDeposit3",method = RequestMethod.GET)
    public Result getInformationWithDeposit3(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                             InpatientInformationConditionVO conditionVO){
        PageInfo<DepositQueryVO> withDeposit = inpatientService.findWithDeposit3(pageNum, conditionVO);
        return Result.OK(withDeposit);
    }

    @SystemLogController(description = "取消入院")
    @RequestMapping(value = "/deleteRegister",method = RequestMethod.DELETE)
    public Result deleteRegister(Integer admissionId){
        try{
            int i = inpatientService.deleteRegister(admissionId);
            if (i == 3) {
                return Result.ERROR("押金未退，无法操作");
            }else if (i == 1){
                return Result.OK("取消成功");
            }else {
                return Result.ERROR("操作失败");
            }
        }catch (Exception e){
            return Result.ERROR("无法取消，请确认未产生住院费用");
        }

    }

    @SystemLogController(description = "费用查询")
    @RequestMapping(value = "/getInformationWithCost",method = RequestMethod.GET)
    public Result getInformationWithCost(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                         CostQueryCondition conditionVO){
        try {
            PageInfo<InformationWithCost> withCost = inpatientService.getWithCost(pageNum, conditionVO);
            return Result.OK(withCost);
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }

    }

    @SystemLogController(description = "住院号查询住院记录")
    @RequestMapping(value = "/getByAdmissionNumber",method = RequestMethod.GET)
    public Result getByAdmissionNumber(String admissionNumber){
        try {
            LeaveVO byAdmissionNumber = inpatientService.getByAdmissionNumber(admissionNumber);
            return Result.OK(byAdmissionNumber);
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }

    @SystemLogController(description = "获取出院信息")
    @RequestMapping(value = "/getLeaveAdmission",method = RequestMethod.GET)
    public Result getByAdmissionNumber(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                       InpatientInformationConditionVO conditionVO){
        try {
            PageInfo<LeaveQueryVO> leaveVO = inpatientService.getLeaveVO(pageNum, conditionVO);
            return Result.OK(leaveVO);
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }

    @SystemLogController(description = "删除出院记录")
    @RequestMapping(value = "/delLeaveAdmission",method = RequestMethod.POST)
    public Result delLeavaAdmission(@RequestBody List<LeaveQueryVO> list){
        try {
            int i = inpatientService.deleteLeave(list);
            if (i == 0){
                return Result.ERROR("未删除成功");
            }else {
                return Result.OK("成功删除"+i+"条数据");
            }
        }catch (Exception e){
            return Result.ERROR("操作有误，请检查后重试");
        }
    }


}
