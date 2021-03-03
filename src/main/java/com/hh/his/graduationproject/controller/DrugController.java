package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.Drug;
import com.hh.his.graduationproject.model.vo.ApplyJson;
import com.hh.his.graduationproject.model.vo.DrugApplicationVO;
import com.hh.his.graduationproject.model.vo.condition.DrugApplyCondition;
import com.hh.his.graduationproject.model.vo.condition.DrugConditionVO;
import com.hh.his.graduationproject.service.DrugApplicationService;
import com.hh.his.graduationproject.service.DrugService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/drug")
@RestController
public class DrugController {

    @Autowired
    private DrugService drugService;

    @Autowired
    private DrugApplicationService drugApplicationService;

    @SystemLogController(description = "获取全部药品信息")
    @RequestMapping(value = "/getAllDrug",method = RequestMethod.GET)
    public Result getAllDrug(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                             DrugConditionVO conditionVO){
        PageInfo<Drug> allDrug = drugService.getAllDrug(pageNum, conditionVO);
        return Result.OK(allDrug);
    }

    @SystemLogController(description = "药品发放")
    @RequestMapping(value = "/offerDrug",method = RequestMethod.POST)
    public Result offerDrug(@RequestBody ApplyJson applyJson){
        System.out.println(applyJson);
        try {
            int offer = drugApplicationService.offer(applyJson);
            if (offer == 0){
                return Result.ERROR("发药失败");
            }else {
                return Result.OK("成功发放"+offer+"条，如果库存不足则不发放!");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }


    @SystemLogController(description = "获取未申请药品信息")
    @RequestMapping(value = "/getApply",method = RequestMethod.GET)
    public Result getApply(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                           DrugApplyCondition condition){
        try {
            PageInfo<DrugApplicationVO> apply = drugApplicationService.getApply(pageNum, condition);
            return Result.OK(apply);
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }

    @SystemLogController(description = "查看已经申请的药品")
    @RequestMapping(value = "/getApply2",method = RequestMethod.GET)
    public Result getApply2(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                           DrugApplyCondition condition){
        try {
            PageInfo<DrugApplicationVO> apply = drugApplicationService.getApply2(pageNum, condition);
            return Result.OK(apply);
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }

    @SystemLogController(description = "已发放的药品记录")
    @RequestMapping(value = "/getApply3",method = RequestMethod.GET)
    public Result getApply3(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                            DrugApplyCondition condition){
        try {
            PageInfo<DrugApplicationVO> apply = drugApplicationService.getApply3(pageNum, condition);
            return Result.OK(apply);
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }

    @SystemLogController(description = "药品申请")
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public Result apply(@RequestBody ApplyJson applyJson){
        try {
            int apply = drugApplicationService.apply(applyJson);
            if (apply == 0){
                return Result.ERROR("申请失败");
            }else {
                return Result.OK("成功申请"+apply+"条");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

    @SystemLogController(description = "删除药品申请")
    @RequestMapping(value = "/deleteDrugApply",method = RequestMethod.POST)
    public Result deleteDrugApply(@RequestBody List<DrugApplicationVO> list){
        try {
            int i = drugApplicationService.deleteApply(list);
            if (i == 0){
                return Result.ERROR("删除失败");
            }else {
                return Result.OK("成功删除"+i+"条");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

    @SystemLogController(description = "取消药品申请")
    @RequestMapping(value = "/cancelApply",method = RequestMethod.POST)
    public Result cancelApply(@RequestBody ApplyJson applyJson){
        try {
            int apply = drugApplicationService.cancelApply(applyJson);
            if (apply == 0){
                return Result.ERROR("取消失败");
            }else {
                return Result.OK("成功取消申请"+apply+"条");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }


    @SystemLogController(description = "药品补申")
    @RequestMapping(value = "/applys",method = RequestMethod.POST)
    public Result applys(@RequestBody DrugApplicationVO drugApplicationVO){
        try {
            int i = drugApplicationService.insertApply(drugApplicationVO);
            if (i == 0){
                return Result.ERROR("补申失败");
            }else {
                return Result.OK("补申成功");
            }
        }catch (Exception e){
            return Result.ERROR(e.getMessage());
        }

    }

    @RequestMapping(value = "/getDrugById",method = RequestMethod.GET)
    public Result getDrugById(Integer drugId){
        try {
            Drug drugById = drugService.getDrugById(drugId);
            return Result.OK(drugById);
        }catch (Exception e){
            return Result.ERROR("找不到该药品");
        }
    }
}
