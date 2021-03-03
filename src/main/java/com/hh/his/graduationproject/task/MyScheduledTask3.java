package com.hh.his.graduationproject.task;

import com.hh.his.graduationproject.dao.CostMapper;
import com.hh.his.graduationproject.dao.InpatientInformationMapper;
import com.hh.his.graduationproject.dao.InpatientWardMapper;
import com.hh.his.graduationproject.dao.SysLogMapper;
import com.hh.his.graduationproject.model.entity.Cost;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.entity.SysLog;
import com.hh.his.graduationproject.utils.bean.CostConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Order(1)
public class MyScheduledTask3 {

    @Autowired
    private CostMapper costMapper;

    @Autowired
    private InpatientInformationMapper informationMapper;

    @Autowired
    private SysLogMapper sysLogMapper;

    @Scheduled(cron = "0 1 0 * * ?")
    public void scheduledTask3(){

        List<InpatientInformation> inpatientInformations = informationMapper.AutomaticEntryOfBedFee();
        List<Cost> costs = CostConverter.INSTANCE.ListInpatient(inpatientInformations);
        int i = costMapper.insertBatch(costs);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        SysLog sysLog=new SysLog();
        sysLog.setUri("定时任务1");//请求接口
        sysLog.setMethod("定时任务1");//请求方式
        sysLog.setMethodDescribe("定时任务1");//描述
        sysLog.setParams("插入了"+String.valueOf(i)+"条数据");//参数信息
        sysLog.setUsername("定时任务1");//请求人
        sysLog.setIp("定时任务1");//ip
        sysLog.setCreateDate(df.format(new Date()));//请求时间
        sysLogMapper.insert(sysLog);
    }

}
