package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.LeaveRecord;
import com.hh.his.graduationproject.model.vo.LeaveRecordVO;
import com.hh.his.graduationproject.model.vo.condition.LeaveRecordCondition;

import java.util.List;

public interface LeaveRecordService {

    int addRecord(LeaveRecord leaveRecord);

    PageInfo getLeaveRecord(Integer pageNum, LeaveRecordCondition condition);

    int deleteLeaveRecord(List<LeaveRecordVO> leaveRecordVOS);

    int updateRecord(LeaveRecordVO leaveRecordVO);

}
