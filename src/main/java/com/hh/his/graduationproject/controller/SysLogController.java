package com.hh.his.graduationproject.controller;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.model.entity.SysLog;
import com.hh.his.graduationproject.service.SysLogService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping(value = "/getAllLog",method = RequestMethod.GET)
    public Result getAllLog(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                            String logDateStart,String logDateEnd){
        try {
            PageInfo<SysLog> all = sysLogService.getAll(pageNum, logDateStart, logDateEnd);
            if (all.getTotal() == 0){
                return Result.ERROR("暂无数据");
            }else {
                return Result.OK(all);
            }
        }catch (Exception e){
            return Result.ERROR("错误信息："+e.getMessage());
        }

    }

}
