package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.CostItemTypeMapper;
import com.hh.his.graduationproject.model.entity.CostItemType;
import com.hh.his.graduationproject.service.CostItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CostItemTypeServiceImpl implements CostItemTypeService {

    @Autowired
    private CostItemTypeMapper costItemTypeMapper;

    @Override
    public List<CostItemType> getAll() {
        List<CostItemType> costItemTypes = costItemTypeMapper.selectAll();
        return costItemTypes;
    }
}
