package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.SysLog;

public interface SysLogService {

    PageInfo<SysLog> getAll(Integer pageNum,String start,String end);

    void insertSysLog(SysLog sysLog);

}
