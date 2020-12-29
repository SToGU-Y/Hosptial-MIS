package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.InpatientWardMapper;
import com.hh.his.graduationproject.model.dto.WardAddDTO;
import com.hh.his.graduationproject.model.entity.InpatientWard;
import com.hh.his.graduationproject.model.vo.WardAddVO;
import com.hh.his.graduationproject.model.vo.WardConditionVO;
import com.hh.his.graduationproject.model.vo.WardUpdateVO;
import com.hh.his.graduationproject.model.vo.WardVO;
import com.hh.his.graduationproject.service.WardService;
import com.hh.his.graduationproject.utils.bean.WardConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardServiceImpl implements WardService {


    @Autowired
    private InpatientWardMapper wardMapper;


/*
    @Override
    public PageInfo<WardVO> findAllWardByPage(Integer pageNum) {
        List<InpatientWard> wards1 = wardMapper.findAllWard();
        PageInfo<InpatientWard> pageInfo = new PageInfo<>(wards1);
        int total = (int)pageInfo.getTotal();

        PageHelper.startPage(pageNum,11);
        PageHelper.orderBy("a.d_id,a.iward_id asc");
        List<InpatientWard> wards2 = wardMapper.findAllWard();
        List<WardVO> wardVOS = WardConverter.INSTANCE.doToVOs(wards2);
        PageInfo<WardVO> pageInfo2 = new PageInfo<>(wardVOS);

        pageInfo2.setTotal(total);

        return pageInfo2;
    }
*/

    @Override
    public PageInfo<WardVO> findWardByCondition(Integer pageNum,WardConditionVO wardConditionVO) {

        List<InpatientWard> wards1 = wardMapper.findWardsByCondition(wardConditionVO);
        PageInfo<InpatientWard> pageInfo = new PageInfo<>(wards1);
        int total = (int)pageInfo.getTotal();

        PageHelper.startPage(pageNum,11);
        PageHelper.orderBy("a.d_id,a.iward_id asc");
        List<InpatientWard> wards2 = wardMapper.findWardsByCondition(wardConditionVO);
        List<WardVO> wardVOS = WardConverter.INSTANCE.doToVOs(wards2);
        PageInfo<WardVO> pageInfo2 = new PageInfo<>(wardVOS);

        pageInfo2.setTotal(total);

        return pageInfo2;
    }

    @Override
    public Boolean addWard(WardAddVO wardAddVO) {
        int count = wardMapper.findWardByCondition(wardAddVO.getWardId(), wardAddVO.getDeptId());
        if (count>0){
            return false;
        }else {
            WardAddDTO wardAddDTO = WardConverter.INSTANCE.voToDTO(wardAddVO);
            wardAddDTO.setWardBedNum(0);
            wardAddDTO.setWardStatus(1);
            wardMapper.insertWard(wardAddDTO);
            return true;
        }
    }

    @Override
    public Boolean delWard(Integer id) {
        int count = wardMapper.findNullWardByCondition(id);
        if (count>0) {
            wardMapper.delWard(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean updateWard(WardUpdateVO wardUpdateVO) {
        try {
            System.out.println(wardUpdateVO);
            wardMapper.updateWard(wardUpdateVO);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
