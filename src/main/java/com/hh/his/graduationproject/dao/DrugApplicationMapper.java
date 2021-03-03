package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.vo.DrugApplicationVO;
import com.hh.his.graduationproject.model.vo.condition.DrugApplyCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugApplicationMapper {

    List<DrugApplicationVO> selectAll3(@Param("condition") DrugApplyCondition condition);

    List<DrugApplicationVO> selectAll2(@Param("condition") DrugApplyCondition condition);

    int updateStatus(@Param("apply")DrugApplicationVO drugApplicationVO);

    int updateDept(@Param("dept")String olddept,@Param("dept1")String newdept1);

    List<DrugApplicationVO> selectAll(@Param("condition") DrugApplyCondition condition);

    int insert(@Param("list") List<DrugApplicationVO> drugApplicationVO);

    int delete(@Param("id")Integer id);

    int deleteByAdmissionId(@Param("id")Integer id);

}
