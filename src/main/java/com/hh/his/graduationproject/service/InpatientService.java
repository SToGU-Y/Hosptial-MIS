package com.hh.his.graduationproject.service;

import com.hh.his.graduationproject.model.vo.InpatientInformationVO;

import java.util.List;

public interface InpatientService {

    List<InpatientInformationVO> findAllAdmission();
}
