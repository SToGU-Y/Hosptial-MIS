package com.hh.his.graduationproject.task;

import com.hh.his.graduationproject.dao.DrugApplicationMapper;
import com.hh.his.graduationproject.dao.MedicalAdviceMapper;
import com.hh.his.graduationproject.dao.SysLogMapper;
import com.hh.his.graduationproject.model.entity.SysLog;
import com.hh.his.graduationproject.model.vo.DrugApplicationVO;
import com.hh.his.graduationproject.utils.bean.DrugConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
@Order(0)
public class MyScheduledTask {

    @Autowired
    private MedicalAdviceMapper adviceMapper;

    @Autowired
    private SysLogMapper sysLogMapper;


    @Scheduled(cron = "0 38 0 * * ?")
    public void scheduledTask(){

        int reset = adviceMapper.reset();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        SysLog sysLog=new SysLog();
        sysLog.setUri("定时任务1");//请求接口
        sysLog.setMethod("定时任务1");//请求方式
        sysLog.setMethodDescribe("定时任务1");//描述
        sysLog.setParams("更改了"+String.valueOf(reset));//参数信息
        sysLog.setUsername("定时任务1");//请求人
        sysLog.setIp("定时任务1");//ip
        sysLog.setCreateDate(df.format(new Date()));//请求时间
        sysLogMapper.insert(sysLog);
    }



}
