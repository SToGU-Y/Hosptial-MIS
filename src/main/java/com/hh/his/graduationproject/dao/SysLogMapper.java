package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysLogMapper {

    List<SysLog> selectAll(@Param("logDateStart")String start,@Param("logDateEnd")String end);

    void insert(@Param("log") SysLog sysLog);
}
