package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.CostItem;

import java.util.List;

public interface CostItemService {

    /**
     * 费用录入以及添加遗嘱时查询费用项（涉及将药品转换称费用项返回）
     * @param costItem
     * @return
     */
    List<CostItem> getCostItemByCondition(CostItem costItem);

    /**
     * 根据费用项编号去获取费用项信息
     * @param no
     * @return
     */
    CostItem getCostItemByNo(String no);


    /**
     * 查询所有消费项
     * @param pageNum
     * @param costItem
     * @return
     * @throws Exception
     */
    PageInfo<CostItem> selectAll(Integer pageNum,CostItem costItem) throws Exception;

    /**
     * 删除消费项
     * @return
     */
    int delete(List<CostItem> costItems);

    /**
     * 更新消费项
     * @param costItem
     * @return
     */
    int update(CostItem costItem);

    /**
     * 新增消费项
     * @param costItem
     * @return
     */
    int insert(CostItem costItem);


}
