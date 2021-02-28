package com.hh.his.graduationproject.service;

import com.github.pagehelper.PageInfo;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.model.vo.*;
import com.hh.his.graduationproject.model.vo.condition.StaffConditionVO;

public interface StaffService {

    PageInfo<StaffVO> getStaffByCondition(Integer pageNum, StaffConditionVO conditionVO);

    int delStaff(String username);

    StaffUpdateVO getStaffByUsername(String username);

    Staff getStaffByUsername2(String username);

    int insertStaff(StaffAddVO staffAddVO) throws Exception;

    int updateStaff(StaffUpdateVO staffUpdateVO);

    int updatePW(PasswordUpdate passwordUpdate) throws Exception;

    int resetPassword(LoginVO loginVO) throws Exception;
}
