package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.model.vo.condition.*;

import java.util.List;

public interface InpatientService {

    int addInpatientRecord(InpatientInformationAddVO addVO) throws Exception;

    List<InpatientInformationVO> findAllAdmission();

    PageInfo<InpatientInformationVO> findAdmissionByConditions(Integer pageNum, InpatientInformationConditionVO conditionVO);

    /**
     * 可出院
     * @param pageNum
     * @param conditionVO
     * @return
     */
    PageInfo<InpatientInformationVO> findCanLeave(Integer pageNum, InpatientInformationConditionVO conditionVO);

    /**
     * 押金交付情况
     * @param pageNum
     * @param conditionVO
     * @return
     */
    PageInfo<DepositQueryVO> findWithDeposit(Integer pageNum, DepositAddCondition conditionVO);

    /**
     * 已交押金的
     * @param pageNum
     * @param conditionVO
     * @return
     */
    PageInfo<DepositQueryVO> findWithDeposit2(Integer pageNum,DepositAddCondition conditionVO);

    /**
     * 未交押金的
     * @param pageNum
     * @param conditionVO
     * @return
     */
    PageInfo<DepositQueryVO> findWithDeposit3(Integer pageNum,InpatientInformationConditionVO conditionVO);

    InpatientUpdateVO findAdmissionById(Integer id);

    void updateAdmission(InpatientUpdateVO updateVO);

    PageInfo<BedPatientSelectVO> findAdmissionByDept(Integer pageNum, BedPatientSelectConditionVO conditionVO);

    PageInfo<BedChangePatientSelectVO> findAdmissionByDept2(Integer pageNum,BedPatientSelectConditionVO conditionVO);

    /**
     * 取消住院
     * @param admissionId
     * @return
     */
    int deleteRegister(Integer admissionId);

    /**
     * 删除出院记录
     * @param list
     * @return
     */
    int deleteLeave(List<LeaveQueryVO> list);

    /**
     * 费用管理的费用查询模块
     * @param pageNum
     * @param conditionVO
     * @return
     */
    PageInfo<InformationWithCost> getWithCost(Integer pageNum, CostQueryCondition conditionVO);

    LeaveVO getByAdmissionNumber(String admissionNumber) throws Exception;

    PageInfo<LeaveQueryVO> getLeaveVO(Integer pageNum, InpatientInformationConditionVO conditionVO);

    PageInfo<QueryInpatientVO> queryInpatient(Integer pageNum,QueryCondition condition) throws Exception;
}
