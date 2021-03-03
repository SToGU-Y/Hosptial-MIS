package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.MedicalAppliance;
import com.hh.his.graduationproject.model.vo.condition.ApplianceConditionVO;

public interface ApplianceService {

    PageInfo<MedicalAppliance> findAppliance(Integer pageNum, ApplianceConditionVO conditionVO);

    int addAppliance(MedicalAppliance medicalAppliance);

    int updateStatus(Integer status,Integer id,String remarks);

    int update(MedicalAppliance record);

    int deleteById(Integer id);

}
