package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.vo.WardVO;


public interface WardService {

    PageInfo<WardVO> findAllWardByPage(Integer pageNum);

}
