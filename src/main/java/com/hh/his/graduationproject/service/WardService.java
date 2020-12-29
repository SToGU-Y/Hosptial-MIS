package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.InpatientWard;
import com.hh.his.graduationproject.model.vo.WardAddVO;
import com.hh.his.graduationproject.model.vo.WardConditionVO;
import com.hh.his.graduationproject.model.vo.WardUpdateVO;
import com.hh.his.graduationproject.model.vo.WardVO;


public interface WardService {

    //PageInfo<WardVO> findAllWardByPage(Integer pageNum);

    PageInfo<WardVO> findWardByCondition(Integer pageNum,WardConditionVO wardConditionVO);

    Boolean addWard(WardAddVO wardAddVO);

    Boolean delWard(Integer id);

    Boolean updateWard(WardUpdateVO wardUpdateVO);
}
