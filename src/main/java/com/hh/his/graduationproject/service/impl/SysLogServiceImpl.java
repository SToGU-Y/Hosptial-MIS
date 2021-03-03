package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.SysLogMapper;
import com.hh.his.graduationproject.model.entity.SysLog;
import com.hh.his.graduationproject.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public PageInfo<SysLog> getAll(Integer pageNum,String start, String end) {
        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("create_date desc");
        List<SysLog> sysLogs = sysLogMapper.selectAll(start, end);
        PageInfo pageInfo = new PageInfo(sysLogs);
        return pageInfo;
    }

    @Override
    public void insertSysLog(SysLog sysLog) {
        sysLogMapper.insert(sysLog);
    }
}
