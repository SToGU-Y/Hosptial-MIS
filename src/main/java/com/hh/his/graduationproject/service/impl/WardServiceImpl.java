package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.InpatientWardMapper;
import com.hh.his.graduationproject.model.entity.InpatientWard;
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



}
