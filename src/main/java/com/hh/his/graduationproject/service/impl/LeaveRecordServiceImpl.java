package com.hh.his.graduationproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.dao.InpatientInformationMapper;
import com.hh.his.graduationproject.dao.LeaveRecordMapper;
import com.hh.his.graduationproject.model.entity.InpatientInformation;
import com.hh.his.graduationproject.model.entity.LeaveRecord;
import com.hh.his.graduationproject.model.vo.LeaveRecordVO;
import com.hh.his.graduationproject.model.vo.condition.LeaveRecordCondition;
import com.hh.his.graduationproject.service.LeaveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LeaveRecordServiceImpl implements LeaveRecordService {

    @Autowired
    private LeaveRecordMapper leaveRecordMapper;


    @Override
    public int addRecord(LeaveRecord leaveRecord) {
        int insert = leaveRecordMapper.insert(leaveRecord);
        return insert;
    }

    @Override
    public PageInfo getLeaveRecord(Integer pageNum, LeaveRecordCondition condition) {
        PageHelper.startPage(pageNum,10);
        PageHelper.orderBy("leave_date desc");
        List<LeaveRecordVO> leaveRecordVO =  leaveRecordMapper.selectByDoctor(condition);
        PageInfo pageInfo = new PageInfo(leaveRecordVO);
        return pageInfo;
    }

    @Override
    public int deleteLeaveRecord(List<LeaveRecordVO> leaveRecordVOS) {
        int i = 0;
        for (LeaveRecordVO leaveRecordVO : leaveRecordVOS){
            i = i + leaveRecordMapper.deleteById(leaveRecordVO.getId());
        }
        return i;
    }

    @Override
    public int updateRecord(LeaveRecordVO leaveRecordVO) {
        int update = leaveRecordMapper.update(leaveRecordVO);
        return update;
    }


}
