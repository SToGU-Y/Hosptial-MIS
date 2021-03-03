package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.MedicalAdvice;
import com.hh.his.graduationproject.model.vo.InpatientInformationVO;
import com.hh.his.graduationproject.model.vo.MedicalAdviceQueryVO;
import com.hh.his.graduationproject.model.vo.MedicalAdviceVO;
import com.hh.his.graduationproject.model.vo.StatusResult;
import com.hh.his.graduationproject.model.vo.condition.AdviceConditionVO;
import com.hh.his.graduationproject.model.vo.condition.AdviceExecuteConditionVO;
import com.hh.his.graduationproject.model.vo.condition.AdviceReviewConditionVO;
import com.hh.his.graduationproject.model.vo.condition.InpatientInformationConditionVO;
import com.hh.his.graduationproject.service.MedicalAdviceService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/advice")
public class MedicalAdviceController {

    @Autowired
    private MedicalAdviceService medicalAdviceService;

    @SystemLogController(description = "通过工号获取相应医嘱信息")
    @RequestMapping(value = "/getAdviceByUsername",method = RequestMethod.GET)
    public Result getAdviceByUsername(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                      AdviceConditionVO conditionVO){
        PageInfo<MedicalAdviceQueryVO> byUsername = medicalAdviceService.getByUsername(pageNum, conditionVO);
        return Result.OK(byUsername);
    }

    @SystemLogController(description = "获取可添加医嘱的住院记录")
    @RequestMapping(value = "/getInformationByCondition",method = RequestMethod.GET)
    public Result getInformationByCondition(@RequestParam(required = false,defaultValue = "1")Integer pageNum , InpatientInformationConditionVO inpatientInformationConditionVO){
        PageInfo<InpatientInformationVO> admissionByConditions = medicalAdviceService.findAdmissionByConditions(pageNum, inpatientInformationConditionVO);
        return Result.OK(admissionByConditions);
    }

    @SystemLogController(description = "获取全部医嘱")
    @RequestMapping(value = "/getAllAdvice",method = RequestMethod.GET)
    public Result getAllAdvice(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                               AdviceReviewConditionVO conditionVO){
        PageInfo<MedicalAdviceQueryVO> allAdvice = medicalAdviceService.getAllAdvice(pageNum, conditionVO);
        return Result.OK(allAdvice);
    }

    @SystemLogController(description = "获取所有通过审核的医嘱")
    @RequestMapping(value = "/getAllAdvicePass",method = RequestMethod.GET)
    public Result getAllAdvicePass(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                   AdviceExecuteConditionVO conditionVO){
        PageInfo<MedicalAdviceQueryVO> passAdvice = medicalAdviceService.getPassAdvice(pageNum, conditionVO);
        return Result.OK(passAdvice);
    }

    @SystemLogController(description = "保存医嘱，但不发送")
    @RequestMapping(value = "/saveAdvice",method = RequestMethod.POST)
    public Result saveAdvice(@RequestBody List<MedicalAdviceVO> medicalAdvice){
        try {
            int i = medicalAdviceService.saveAdvice(medicalAdvice);
            if (i==0){
                return Result.ERROR("保存失败");
            }else {
                return Result.OK("成功保存"+i+"条医嘱");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }

    @SystemLogController(description = "发送医嘱")
    @RequestMapping(value = "/sentAdvice",method = RequestMethod.POST)
    public Result sentAdvice(@RequestBody List<MedicalAdviceVO> medicalAdvice){
        try {
            int i = medicalAdviceService.sentAdvice(medicalAdvice);
            if (i==0){
                return Result.ERROR("发送失败");
            }else {
                return Result.OK("成功发送"+i+"条医嘱");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息："+e.getMessage());
        }

    }

    @SystemLogController(description = "医嘱状态改为发送状态")
    @RequestMapping(value = "/sentStatus",method = RequestMethod.POST)
    public Result sentStatus(@RequestBody List<MedicalAdviceQueryVO> medicalAdvice){
        try {
            int i = medicalAdviceService.updateStatus(1, medicalAdvice);
            if (i==0){
                return Result.ERROR("发送失败");
            }else {
                return Result.OK("成功发送"+i+"条医嘱");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息："+e.getMessage());
        }
    }

    @SystemLogController(description = "删除医嘱")
    @RequestMapping(value = "/deleteAdvice",method = RequestMethod.POST)
    public Result deleteAdvice(@RequestBody List<MedicalAdviceQueryVO > selectiveList){
        try {
            int i = medicalAdviceService.deleteAdvice(selectiveList);
            if (i == 0){
                return Result.ERROR("删除失败,只有未发送或者拒绝的医嘱可以删除");
            }else{
                return Result.OK("成功删除"+i+"条医嘱");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

    @SystemLogController(description = "停嘱")
    @RequestMapping(value = "/stopStatus",method = RequestMethod.POST)
    public Result stopStatus(@RequestBody StatusResult statusResult){
        try {
            Iterator<MedicalAdviceQueryVO> iterator = statusResult.getSelectiveList().iterator();
            while (iterator.hasNext()){
                iterator.next().setMadvEndDoctor(statusResult.getUsername());
            }
            int i = medicalAdviceService.updateStatus(4, statusResult.getSelectiveList());
            if (i==0){
                return Result.ERROR("停嘱失败,只有待执行和已执行的医嘱可以停嘱");
            }else {
                return Result.OK("成功停嘱"+i+"条");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

    @SystemLogController(description = "更改医嘱信息")
    @RequestMapping(value = "/updateAdvice",method = RequestMethod.POST)
    public Result updateAdvice(@RequestBody MedicalAdviceQueryVO medicalAdviceQueryVO){
        try {
            int i = medicalAdviceService.updateAdvice(medicalAdviceQueryVO);
            if (i==0){
                return Result.ERROR("更改失败");
            }else {
                return Result.OK("更改成功");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }

    @SystemLogController(description = "医嘱审核通过")
    @RequestMapping(value = "/passStatus",method = RequestMethod.POST)
    public Result passStatus(@RequestBody StatusResult statusResult){
        Iterator<MedicalAdviceQueryVO> iterator = statusResult.getSelectiveList().iterator();
        while (iterator.hasNext()){
            iterator.next().setMadvNurse(statusResult.getUsername());
        }
        try{
            int i = medicalAdviceService.updateStatus(2, statusResult.getSelectiveList());
            if (i==0){
                return Result.ERROR("审核失败");
            }else {
                return Result.OK("成功审核"+i+"条");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

    @SystemLogController(description = "拒绝医嘱，未通过审核")
    @RequestMapping(value = "/rejectStatus",method = RequestMethod.POST)
    public Result rejectStatus(@RequestBody StatusResult statusResult){
        for (MedicalAdviceQueryVO m:statusResult.getSelectiveList()) {
            m.setRemarks(statusResult.getRemarks());
            m.setMadvNurse(statusResult.getUsername());
        }
        System.out.println(statusResult.getSelectiveList());
        try{
            int i = medicalAdviceService.updateStatus(5, statusResult.getSelectiveList());
            if (i==0){
                return Result.ERROR("拒绝失败");
            }else {
                return Result.OK("成功拒绝"+i+"条");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }


    @SystemLogController(description = "执行医嘱")
    @RequestMapping(value = "/executeStatus",method = RequestMethod.POST)
    public Result executeStatus(@RequestBody StatusResult statusResult){
        try {
            Iterator<MedicalAdviceQueryVO> iterator = statusResult.getSelectiveList().iterator();
            while (iterator.hasNext()){
                iterator.next().setMadvExecuteNurse(statusResult.getUsername());
            }
            int i = medicalAdviceService.updateStatus(3, statusResult.getSelectiveList());
            if (i==0){
                return Result.ERROR("执行失败");
            }else {
                return Result.OK("成功执行"+i+"条");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

}
