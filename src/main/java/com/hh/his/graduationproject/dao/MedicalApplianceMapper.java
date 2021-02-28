package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.MedicalAppliance;
import com.hh.his.graduationproject.model.vo.condition.ApplianceConditionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicalApplianceMapper {

    List<MedicalAppliance> select(@Param("record") ApplianceConditionVO condition);

    int insert(@Param("record") MedicalAppliance record);

    int deleteById(@Param("id")Integer id);

    int update(@Param("record")MedicalAppliance record);

    int updateStatusById(@Param("status")Integer status, @Param("id") Integer id,@Param("remarks")String remarks);
}
