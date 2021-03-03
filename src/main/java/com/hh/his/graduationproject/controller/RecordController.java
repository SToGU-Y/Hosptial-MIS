package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.vo.condition.InpatientInformationConditionVO;
import com.hh.his.graduationproject.model.vo.InpatientInformationVO;
import com.hh.his.graduationproject.model.vo.RecordVO;
import com.hh.his.graduationproject.service.RecordService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @SystemLogController(description = "通过住院主键获取相应病历信息")
    @RequestMapping(value = "/getRecordByAdmissionId",method = RequestMethod.GET)
    public Result getRecord(Integer admissionId){
        RecordVO record = recordService.getRecordByAdmissionId(admissionId);
        return Result.OK(record);
    }

    @SystemLogController(description = "添加病历")
    @RequestMapping(value = "/addRecord",method = RequestMethod.POST)
    public Result addRecord(@RequestBody RecordVO record){
        int i = recordService.addRecord(record);
        if (i==0){
            return Result.ERROR("添加失败");
        }else {
            return Result.OK("添加成功");
        }
    }

    @SystemLogController(description = "查询未书写病历的住院信息")
    @RequestMapping(value = "/getInformationByCondition",method = RequestMethod.GET)
    public Result getInformationByCondition(@RequestParam(required = false,defaultValue = "1")Integer pageNum ,
                                            InpatientInformationConditionVO inpatientInformationConditionVO){
        PageInfo<InpatientInformationVO> admissionByConditions = recordService.findAdmissionByConditions2(pageNum, inpatientInformationConditionVO);
        return Result.OK(admissionByConditions);
    }

    @SystemLogController(description = "查询已经书写了病历的住院信息")
    @RequestMapping(value = "/getInformationByCondition2",method = RequestMethod.GET)
    public Result getInformationByCondition2(@RequestParam(required = false,defaultValue = "1")Integer pageNum ,
                                            InpatientInformationConditionVO inpatientInformationConditionVO){
        PageInfo<InpatientInformationVO> admissionByConditions = recordService.findAdmissionByConditions(pageNum, inpatientInformationConditionVO);
        return Result.OK(admissionByConditions);
    }

    @SystemLogController(description = "更新病历信息")
    @RequestMapping(value = "/updateRecord",method = RequestMethod.POST)
    public Result updateRecord(@RequestBody RecordVO recordVO){
        int i = recordService.updateRecord(recordVO);
        if (i==0){
            return Result.ERROR("更新失败");
        }else {
            return Result.OK("更新成功");
        }
    }

    @SystemLogController(description = "删除病历信息")
    @RequestMapping(value = "/deleteRecord",method = RequestMethod.DELETE)
    public Result deleteRecord(Integer id){
        int i = recordService.deleteRecord(id);
        if (i == 0 ){
            return Result.ERROR("删除失败");
        }else {
            return Result.OK("删除成功");
        }
    }

}
