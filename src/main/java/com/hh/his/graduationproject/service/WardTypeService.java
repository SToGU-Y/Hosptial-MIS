package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.vo.WardTypeVO;
import com.hh.his.graduationproject.model.entity.InpatientWardType;

import java.util.List;

public interface WardTypeService {

    PageInfo<InpatientWardType> findAllWardTypeByPage(Integer pageNum);

    List<InpatientWardType> findAllWardType();

    Boolean addWardType(WardTypeVO wardTypeVO);

    Boolean updateWardType(InpatientWardType wardType);

    Boolean delWardType(Integer iwtId);

}
