package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.vo.ApplyJson;
import com.hh.his.graduationproject.model.vo.DrugApplicationVO;
import com.hh.his.graduationproject.model.vo.condition.DrugApplyCondition;

import java.util.List;

public interface DrugApplicationService {

    /**
     * 申请发药
     * @param pageNum
     * @param condition
     * @return
     */
    PageInfo<DrugApplicationVO> getApply(Integer pageNum, DrugApplyCondition condition);

    /**
     * 取消发药/药品发放
     * @param pageNum
     * @param condition
     * @return
     */
    PageInfo<DrugApplicationVO> getApply2(Integer pageNum, DrugApplyCondition condition);

    /**
     * 发药记录
     * @param pageNum
     * @param condition
     * @return
     */
    PageInfo<DrugApplicationVO> getApply3(Integer pageNum, DrugApplyCondition condition);

    int apply(ApplyJson applyJson);

    int cancelApply(ApplyJson applyJson);

    int offer(ApplyJson applyJson);

    int deleteApply(List<DrugApplicationVO> list);

    int insertApply(DrugApplicationVO drugApplicationVO) throws Exception;

}
