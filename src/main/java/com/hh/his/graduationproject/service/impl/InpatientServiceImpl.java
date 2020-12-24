package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.InpatientInformationMapper;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.vo.InpatientInformationVO;
import com.hh.his.graduationproject.service.InpatientService;
import com.hh.his.graduationproject.utils.bean.InpatientInformationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InpatientServiceImpl implements InpatientService {

    @Autowired
    private InpatientInformationMapper mapper;

    @Override
    public List<InpatientInformationVO> findAllAdmission() {
        List<InpatientInformation> allAdmission = mapper.findAllAdmission();
        List<InpatientInformationVO> all = InpatientInformationConverter.INSTANCE.doToVoList(allAdmission);
        return all;
    }
}
