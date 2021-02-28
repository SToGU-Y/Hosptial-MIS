package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.InpatientWard;
import com.hh.his.graduationproject.model.vo.WardAddVO;
import com.hh.his.graduationproject.model.vo.condition.WardConditionVO;
import com.hh.his.graduationproject.model.vo.WardUpdateVO;
import com.hh.his.graduationproject.model.vo.WardVO;

import java.util.List;


public interface WardService {

    //PageInfo<WardVO> findAllWardByPage(Integer pageNum);

    PageInfo<WardVO> findWardByCondition(Integer pageNum,WardConditionVO wardConditionVO);

    Boolean addWard(WardAddVO wardAddVO);

    Boolean delWard(Integer id);

    Boolean updateWard(WardUpdateVO wardUpdateVO);

    List<InpatientWard> getWardByDept(String deptId);
}
