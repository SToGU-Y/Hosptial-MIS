package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.dao.CostItemMapper;
import com.hh.his.graduationproject.dao.DrugMapper;
import com.hh.his.graduationproject.model.entity.CostItem;
import com.hh.his.graduationproject.model.entity.Drug;
import com.hh.his.graduationproject.model.vo.condition.DrugConditionVO;
import com.hh.his.graduationproject.service.CostItemService;
import com.hh.his.graduationproject.utils.bean.CostItemConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CostItemServiceImpl implements CostItemService {

    @Autowired
    private CostItemMapper costItemMapper;
    @Autowired
    private DrugMapper drugMapper;

    @Override
    public List<CostItem> getCostItemByCondition(CostItem costItem) {
        PageHelper.startPage(1,5);
        List<CostItem> costItems = costItemMapper.selectByConditions(costItem);

        DrugConditionVO conditionVO = new DrugConditionVO();
        conditionVO.setDrugName(costItem.getCostItemName());
        conditionVO.setDrugNo(costItem.getCostItemNo());

        PageHelper.startPage(1,5);
        List<Drug> drugs = drugMapper.selectAll(conditionVO);
        List<CostItem> costItems1 = CostItemConverter.INSTANCE.drugToCostItemList(drugs);
        costItems.addAll(costItems1);

        return costItems;
    }

    @Override
    public CostItem getCostItemByNo(String no) {
        //这里会涉及一个问题就是药品编号跟costItem编号相同时，取出来的是costItem。取不出药品
        CostItem costItem = costItemMapper.selectByCostItemNo(no);
        if (costItem == null){
            Drug drug = drugMapper.selectByDrugNo(no);
            costItem = CostItemConverter.INSTANCE.drugToCostItem(drug);
        }
        return costItem;
    }

    @Override
    public PageInfo<CostItem> selectAll(Integer pageNum,CostItem costItem) throws Exception {
        PageHelper.startPage(pageNum,10);
        List<CostItem> costItems = costItemMapper.selectAll(costItem);
        PageInfo pageInfo = new PageInfo(costItems);
        if (pageInfo.getTotal() == 0){
            throw new Exception("暂无数据！");
        }
        return pageInfo;
    }

    @Override
    public int delete(List<CostItem> costItems) {
        int i = 0;
        for (CostItem costItem : costItems){
            i = i +costItemMapper.delete(costItem.getCostItemNo());
        }
        return i;
    }

    @Override
    public int update(CostItem costItem) {
        int update = costItemMapper.update(costItem);
        return update;
    }

    @Override
    public int insert(CostItem costItem) {
        int insert = costItemMapper.insert(costItem);
        return insert;
    }


}
