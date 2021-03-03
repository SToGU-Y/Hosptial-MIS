package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.Drug;
import com.hh.his.graduationproject.model.vo.condition.DrugConditionVO;

public interface DrugService {

    PageInfo<Drug> getAllDrug(Integer pageNum, DrugConditionVO conditionVO);

    Drug getDrugById(Integer drugId);

}
