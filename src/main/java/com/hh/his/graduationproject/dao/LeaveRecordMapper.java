package com.hh.his.graduationproject.dao;


import com.hh.his.graduationproject.model.entity.LeaveRecord;
import com.hh.his.graduationproject.model.vo.LeaveRecordVO;
import com.hh.his.graduationproject.model.vo.condition.LeaveRecordCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaveRecordMapper {

    int insert(@Param("record") LeaveRecord leaveRecord);

    List<LeaveRecordVO> selectByDoctor(@Param("condition")LeaveRecordCondition condition);

    int selectByAdmissionId(@Param("admissionId")Integer admissionId);

    int update(@Param("record") LeaveRecordVO leaveRecord);

    int deleteById(@Param("id")Integer id);

    int deleteByAdmissionId(@Param("id")Integer id);

}
