package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.vo.RecordVO;
import org.apache.ibatis.annotations.Param;

public interface MedicalRecordMapper {

    RecordVO selectByAdmissionId(Integer admissionId);

    int insert(@Param("record") RecordVO record);

    int update(@Param("record") RecordVO recordVO);

    int delete(@Param("id") Integer id);

}
