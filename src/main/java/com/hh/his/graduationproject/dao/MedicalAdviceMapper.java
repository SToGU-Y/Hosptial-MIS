package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.vo.MedicalAdviceQueryVO;
import com.hh.his.graduationproject.model.vo.MedicalAdviceVO;
import com.hh.his.graduationproject.model.vo.condition.AdviceConditionVO;
import com.hh.his.graduationproject.model.vo.condition.AdviceExecuteConditionVO;
import com.hh.his.graduationproject.model.vo.condition.AdviceReviewConditionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicalAdviceMapper {

    /**
     * 查待审核的医嘱
     * @param conditionVO
     * @return
     */
    List<MedicalAdviceQueryVO> selectAll(@Param("condition")AdviceReviewConditionVO conditionVO);

    /**
     * 查通过审核的医嘱
     * @param conditionVO
     * @return
     */
    List<MedicalAdviceQueryVO> selectAllPass(@Param("condition") AdviceExecuteConditionVO conditionVO);

    /**
     * 批量插入医嘱
     * @param status
     * @param advice
     * @return
     */
    int insertBatch(@Param("status")Integer status,@Param("list") List<MedicalAdviceVO> advice);

    /**
     * 通过工号查医嘱
     * @param conditionVO
     * @return
     */
    List<MedicalAdviceQueryVO> selectByUsername(@Param("condition") AdviceConditionVO conditionVO);

    /**
     * 查可以申请发药的医嘱
     * @return
     */
    List<MedicalAdviceQueryVO> selectDrugApply();

    /**
     * 修改医嘱的状态
     * @param status
     * @param adviceQueryVO
     * @return
     */
    int updateStatus(@Param("status") Integer status,@Param("advice")MedicalAdviceQueryVO adviceQueryVO);

    /**
     * 更改医嘱
     * @param advice
     * @return
     */
    int updateAdvice(@Param("advice") MedicalAdviceQueryVO advice);


    int updateDept(@Param("dept")String olddept,@Param("dept1")String newdept1);

    /**
     * 删除医嘱
     * @param advice
     * @return
     */
    int deleteAdvice(@Param("advice") MedicalAdviceQueryVO advice);

    /**
     * 重置医嘱状态（已执行->待执行）
     * @return
     */
    int reset();

    List<MedicalAdviceQueryVO> selectByAdmissionId(@Param("admissionId") Integer admissionId);

    int stop(@Param("advice") MedicalAdviceQueryVO advice);

    int deleteByAdmissionId(Integer admissionId);
}
