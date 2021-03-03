package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.dto.InpatientAddDTO;
import com.hh.his.graduationproject.model.dto.InpatientUpdateDTO;
import com.hh.his.graduationproject.model.dto.PidUpdate;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.model.vo.condition.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface InpatientInformationMapper {

    /**
     * 病床的动态条件查询
     * @param conditionVO
     * @return
     */
    List<BedVO> findBedByCondition(@Param("condition") BedConditionVO conditionVO);

    /**
     * 病床退还
     * @param conditionVO
     * @return
     */
    List<InpatientInformation> findBedByCondition2(@Param("condition") BedConditionVO conditionVO);

    /**
     * 查询全部的住院信息
     * @return
     */
    List<InpatientInformation> findAllAdmission();

    /**
     * 插入一条住院记录
     * @param addDTO
     * @return
     */
    int insertInpatient(@Param("addDTO") InpatientAddDTO addDTO);

    /**
     * 用于入院登记的查询
     * @param conditionVO
     * @return
     */
    List<InpatientInformation> selectAdmissionByConditions(@Param("conditionVO") InpatientInformationConditionVO conditionVO);

    /**
     * 用于病历查询的查询(查已经添加病历的)
     * @param conditionVO
     * @return
     */
    List<InpatientInformation> selectAdmissionByConditions2(@Param("conditionVO") InpatientInformationConditionVO conditionVO);

    /**
     * 用于病历查询的查询(查还没添加病历的)
     * @param conditionVO
     * @return
     */
    List<InpatientInformation> selectAdmissionByConditions3(@Param("conditionVO") InpatientInformationConditionVO conditionVO);

    List<InpatientInformation> AutomaticEntryOfBedFee();

    /**
     * 用于医嘱添加
     * @param conditionVO
     * @return
     */
    List<InpatientInformation> selectAdmissionByConditions4(@Param("conditionVO") InpatientInformationConditionVO conditionVO);

    /**
     * 押金情况
     * @param conditionVO
     * @return
     */
    List<DepositQueryVO> selectWithDeposit(@Param("conditionVO") DepositAddCondition conditionVO);

    /**
     * 押金情况(已交的)用于退款
     * @param conditionVO
     * @return
     */
    List<DepositQueryVO> selectWithDeposit2(@Param("conditionVO") DepositAddCondition conditionVO);

    /**
     * 押金情况(未交的)
     * @param conditionVO
     * @return
     */
    List<DepositQueryVO> selectWithDeposit3(@Param("conditionVO") InpatientInformationConditionVO conditionVO);

    /**
     * 费用查询
     * @param conditionVO
     * @return
     */
    List<InformationWithCost> selectWithCost(@Param("conditionVO") CostQueryCondition conditionVO);

    /**
     * 重用住院号
     * @param pid
     * @return
     */
    List<InpatientInformation> selectAdmissionByPid(@Param("pid") String pid);

    /**
     * 用于获取住院记录主键
     * @param dateOfAdmission
     * @param admissionNumber
     * @return
     */
    InpatientInformation selectAdmissionByDateAndAdNumber(@Param("dateOfAdmission")Date dateOfAdmission,@Param("admissionNumber")String admissionNumber);

    /**
     * 通过主键查询住院记录
     * @param id
     * @return
     */
    InpatientInformation selectAdmissionById(@Param("id")Integer id);

    /**
     * 更新住院记录信息
     * @param updateDTO
     * @return
     */
    int updateAdmission(@Param("record") InpatientUpdateDTO updateDTO);

    /**
     * 通过科室查询还没选择病床的住院记录
     * @param conditionVO
     * @return
     */
    List<InpatientInformation> selectAdmissionByDept(@Param("condition") BedPatientSelectConditionVO conditionVO);

    /**
     * 通过科室查询已经选择病床的住院记录
     * @param conditionVO
     * @return
     */
    List<InpatientInformation> selectAdmissionByDept2(@Param("condition") BedPatientSelectConditionVO conditionVO);

    /**
     * 用于选择病床后更新病床跟病房的信息
     * @param record
     * @return
     */
    int updateBedAndWard(@Param("record") InpatientBedAddVO record);

    /**
     * 更新身份证后的操作。
     */
    int updatePid(@Param("record")PidUpdate pidUpdate);

    int updateDept(@Param("dept")String olddept,@Param("dept1")String newdept1);

    /**
     * 取消入院
     * @param id
     * @return
     */
    int deleteById(@Param("admissionId")Integer id);

    /**
     * 可出院操作执行
     * @param admissionId
     * @return
     */
    int executeLeave(@Param("admissionId")Integer admissionId,@Param("dateOfDischarge")Date date,@Param("day")Integer day);

    /**
     * 查询可出院
     * @param conditionVO
     * @return
     */
    List<InpatientInformation> selectCanLeave(@Param("conditionVO") InpatientInformationConditionVO conditionVO);

    /**
     * 出院结算
     * @param admissionNumber
     * @return
     */
    LeaveVO selectByAdmissionNumber(@Param("admissionNumber") String admissionNumber);

    /**
     * 查住院
     * @param admissionNumber
     * @return
     */
    LeaveVO selectByAdmissionNumber2 (@Param("admissionNumber") String admissionNumber);

    /**
     * 出院操作
     * @param admissionId
     * @param username
     * @return
     */
    int leaveSuccess(@Param("admissionId")Integer admissionId,@Param("operator")String username);


    /**
     * 出院记录查询
     * @param conditionVO
     * @return
     */
    List<InpatientInformation> selectLeaveAdmission(@Param("conditionVO") InpatientInformationConditionVO conditionVO);

    /**
     * 信息查询的住院记录查询
     * @param condition
     * @return
     */
    List<QueryInpatientVO> queryInpatient(@Param("condition") QueryCondition condition);

    /**
     * 查询病历信息
     * @param condition
     * @return
     */
    List<QueryInpatientVO> queryRecord(@Param("condition")QueryCondition condition);

    List<InpatientAnalysis> analysisInpatient(@Param("DateStart")String date,@Param("DateEnd")String date2);

    List<InpatientAnalysis> analysisLeave(@Param("leaveDateStart")String date,@Param("leaveDateEnd")String date2);
}
