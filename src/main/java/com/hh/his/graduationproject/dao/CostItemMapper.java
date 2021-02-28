package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.CostItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CostItemMapper {

    List<CostItem> selectByConditions(@Param("costItem") CostItem costItem);

    CostItem selectByCostItemNo(@Param("costItemNo")String costItemNo);

    List<CostItem> selectAll(@Param("costItem")CostItem costItem);

    int update(@Param("costItem")CostItem item);

    int delete(@Param("costItemNo") String costItemNo);

    int insert(@Param("costItem") CostItem costItem);
}
