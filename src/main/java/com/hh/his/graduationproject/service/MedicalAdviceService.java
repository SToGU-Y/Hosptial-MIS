package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.MedicalAdvice;
import com.hh.his.graduationproject.model.vo.MedicalAdviceQueryVO;
import com.hh.his.graduationproject.model.vo.MedicalAdviceVO;
import com.hh.his.graduationproject.model.vo.condition.AdviceConditionVO;
import com.hh.his.graduationproject.model.vo.condition.AdviceExecuteConditionVO;
import com.hh.his.graduationproject.model.vo.condition.AdviceReviewConditionVO;
import com.hh.his.graduationproject.model.vo.condition.InpatientInformationConditionVO;


import java.util.List;

public interface MedicalAdviceService {


    PageInfo<MedicalAdviceQueryVO> getByUsername(Integer pageNum, AdviceConditionVO conditionVO);

    PageInfo findAdmissionByConditions(Integer pageNum, InpatientInformationConditionVO inpatientInformationConditionVO);

    int saveAdvice(List<MedicalAdviceVO> medicalAdvice) throws Exception;

    int sentAdvice(List<MedicalAdviceVO> medicalAdvice) throws Exception;

    int updateStatus(Integer status,List<MedicalAdviceQueryVO> medicalAdvice) throws Exception;

    int updateAdvice(MedicalAdviceQueryVO medicalAdviceQueryVO);

    int deleteAdvice(List<MedicalAdviceQueryVO> medicalAdviceQueryVOS);

    PageInfo<MedicalAdviceQueryVO> getAllAdvice(Integer pageNum, AdviceReviewConditionVO conditionVO);

    PageInfo<MedicalAdviceQueryVO> getPassAdvice(Integer pageNum, AdviceExecuteConditionVO conditionVO);
}
