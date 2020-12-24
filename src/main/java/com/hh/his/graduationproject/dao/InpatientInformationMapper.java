package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.InpatientInformation;

import java.util.List;

public interface InpatientInformationMapper {

    List<InpatientInformation> findAllAdmission();
}
