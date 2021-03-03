package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.LeaveRecord;
import com.hh.his.graduationproject.model.vo.LeaveRecordVO;
import com.hh.his.graduationproject.model.vo.condition.LeaveRecordCondition;
import com.hh.his.graduationproject.service.LeaveRecordService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaveRecord")
public class LeaveRecordController {

    @Autowired
    private LeaveRecordService leaveRecordService;

    @SystemLogController(description = "添加出院小结")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody LeaveRecord leaveRecord){
        try {
            int i = leaveRecordService.addRecord(leaveRecord);
            if (i == 0){
                return Result.ERROR("添加失败");
            }else{
                return Result.OK("添加成功");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }

    @SystemLogController(description = "出院小结查询")
    @RequestMapping(value = "/getLeaveRecord",method = RequestMethod.GET)
    public Result getLeaveRecord(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                 LeaveRecordCondition condition){
        try {
            PageInfo leaveRecord = leaveRecordService.getLeaveRecord(pageNum, condition);
            return Result.OK(leaveRecord);
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

    @SystemLogController(description = "删除出院小结")
    @RequestMapping(value = "/delLeaveRecord",method = RequestMethod.POST)
    public Result delete(@RequestBody List<LeaveRecordVO> leaveRecordVO){
        try {
            int leaveRecord = leaveRecordService.deleteLeaveRecord(leaveRecordVO);
            if (leaveRecord == 0){
                return Result.ERROR("没有删除");
            }else {
                return Result.OK("成功删除"+leaveRecord+"条数据");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }
    }

    @SystemLogController(description = "出院小结更改")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody LeaveRecordVO leaveRecordVO){
        try {
            int i = leaveRecordService.updateRecord(leaveRecordVO);
            if (i == 0){
                return Result.ERROR("更新失败");
            }else{
                return Result.OK("更新成功");
            }
        }catch (Exception e){
            return Result.ERROR("错误信息:"+e.getMessage());
        }

    }

}
