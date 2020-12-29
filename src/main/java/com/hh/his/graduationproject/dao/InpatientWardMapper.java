package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.dto.WardAddDTO;
import com.hh.his.graduationproject.model.entity.InpatientWard;
import com.hh.his.graduationproject.model.vo.WardConditionVO;
import com.hh.his.graduationproject.model.vo.WardUpdateVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InpatientWardMapper {

    /**
     * 查询病房
     * @param id
     * @return
     */
    int findWardByCondition(@Param("wardId")Integer wardId,@Param("deptId")String deptId);

    /**
     * 查询病房List
     * @param wardConditionVO
     * @return
     */
    List<InpatientWard> findWardsByCondition(@Param("wardConditionVO") WardConditionVO wardConditionVO);

    /**
     * 插入新病房
     * @param wardAddDTO
     * @return
     */
    int insertWard(@Param("wardAddDTO")WardAddDTO wardAddDTO);

    /**
     * 删除病房
     * @param id
     */
    void delWard(@Param("id")Integer id);

    /**
     * 更新病房信息
     * @param wardUpdateVO
     */
    void updateWard(@Param("wardUpdateVO")WardUpdateVO wardUpdateVO);

    /**
     * 查询空病房
     * @param id
     * @return
     */
    int findNullWardByCondition(@Param("id")Integer id);
}
