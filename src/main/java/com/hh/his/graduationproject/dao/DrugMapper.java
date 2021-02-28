package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.Drug;
import com.hh.his.graduationproject.model.vo.condition.DrugConditionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugMapper {

    /**
     * 带查询条件查所有药品
     * @param conditionVO
     * @return
     */
    List<Drug> selectAll(@Param("condition")DrugConditionVO conditionVO);

    /**
     * 药品主键获取
     * @param drugId
     * @return
     */
    Drug selectById(@Param("drugId")Integer drugId);

    Drug selectByNo(@Param("drugNo")String drugNo);

    /**
     * 更新药品库存
     * @param drug
     * @return
     */
    int updateDrugNum(@Param("drug")Drug drug);

    /**
     * 通过药品编号查询药品
     */
    Drug selectByDrugNo(@Param("drugNo")String no);
}
