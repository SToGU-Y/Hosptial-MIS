package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.vo.QueryInpatientVO;
import com.hh.his.graduationproject.model.vo.condition.InpatientInformationConditionVO;
import com.hh.his.graduationproject.model.vo.InpatientInformationVO;
import com.hh.his.graduationproject.model.vo.RecordVO;
import com.hh.his.graduationproject.model.vo.condition.QueryCondition;


public interface RecordService {

    /**
     * 通过住院记录主键获取相应的病历
     * @param admissionId
     * @return
     */
    RecordVO getRecordByAdmissionId(Integer admissionId);

    /**
     * 用于查看病历的住院记录查询（查已添加的）
     * @param pageNum
     * @param conditionVO
     * @return
     */
    PageInfo<InpatientInformationVO> findAdmissionByConditions(Integer pageNum, InpatientInformationConditionVO conditionVO);

    PageInfo<QueryInpatientVO> queryRecord(Integer pageNum, QueryCondition condition) throws Exception;

    /**
     * 用于查看病历的住院记录查询（查没添加的）
     * @param pageNum
     * @param conditionVO
     * @return
     */
    PageInfo<InpatientInformationVO> findAdmissionByConditions2(Integer pageNum, InpatientInformationConditionVO conditionVO);

    /**
     * 添加病历
     * @param record
     * @return
     */
    int addRecord(RecordVO record);

    /**
     * 更新病历
     * @return
     */
    int updateRecord(RecordVO record);


    /**
     * 删除病历
     * @return
     */
    int deleteRecord(Integer id);
}
