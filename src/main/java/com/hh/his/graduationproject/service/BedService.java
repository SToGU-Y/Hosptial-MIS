package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.dto.BedAddDTO;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.model.vo.condition.BedConditionVO;
import com.hh.his.graduationproject.model.vo.condition.BedSelectConditionVO;

public interface BedService {

    PageInfo<BedSelectVO> findNullBed(Integer pageNum, BedSelectConditionVO conditionVO);

    int updateAdmission(InpatientBedAddVO addVO);

    int BedChange(InpatientBedChangeVO changeVO);

    PageInfo<BedVO> findAllBed(Integer pageNum, BedConditionVO conditionVO);

    PageInfo<BedVO> findBedNotNull(Integer pageNum,BedConditionVO conditionVO);

    void addBed(BedAddDTO bed) throws Exception;

    int delBed(Integer id);

    int returnBed(ReturnBedVO returnBed);
}
