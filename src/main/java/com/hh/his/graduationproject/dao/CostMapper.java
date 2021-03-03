package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.Cost;
import com.hh.his.graduationproject.model.vo.QueryCostVO;
import com.hh.his.graduationproject.model.vo.condition.QueryCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CostMapper {

    List<Cost> selectAll();

    List<Cost> selectByAdmissionId(@Param("admissionId")Integer admissionId,@Param("date1")String date1,@Param("date2")String date2);

    int countCostByAdmissionId(@Param("admissionId")Integer admissionId);

    int insert(@Param("cost")Cost cost);

    int insertBatch(@Param("list")List<Cost> costs);

    int delete(@Param("costId")Integer costId);

    int deleteByAdmissionId(@Param("admissionId")Integer admissionId);

    /**
     * 信息查询的费用查询
     * @param condition
     * @return
     */
    List<QueryCostVO> costQuery(@Param("condition") QueryCondition condition);
}
