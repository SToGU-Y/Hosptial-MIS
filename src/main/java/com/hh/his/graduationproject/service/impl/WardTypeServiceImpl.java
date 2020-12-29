package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.InpatientWardTypeMapper;
import com.hh.his.graduationproject.model.vo.WardTypeVO;
import com.hh.his.graduationproject.model.entity.InpatientWardType;
import com.hh.his.graduationproject.service.WardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WardTypeServiceImpl implements WardTypeService {

    @Autowired
    private InpatientWardTypeMapper typeMapper;

    @Override
    public List<InpatientWardType> findAllWardType() {
        List<InpatientWardType> allWardType = typeMapper.findAllWardType();
        return allWardType;
    }

    @Override
    public PageInfo<InpatientWardType> findAllWardTypeByPage(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        List<InpatientWardType> allWardType = typeMapper.findAllWardType();
        PageInfo<InpatientWardType> pageInfo = new PageInfo<>(allWardType);
        return pageInfo;
    }

    @Override
    public Boolean addWardType(WardTypeVO wardTypeVO) {
        BigDecimal bigDecimal = new BigDecimal(wardTypeVO.getIwtPrice());
        if (typeMapper.insertWardType(wardTypeVO.getIwtType(),bigDecimal)>0) {
            return true;
        }else {
            return false;
        }
    }


    @Override
    public Boolean updateWardType(InpatientWardType wardType) {
        try {
            typeMapper.updateWardType(wardType);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delWardType(Integer iwtId) {
        try {
            typeMapper.delWardType(iwtId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
