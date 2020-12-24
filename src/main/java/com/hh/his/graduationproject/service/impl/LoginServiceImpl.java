package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.StaffMapper;
import com.hh.his.graduationproject.model.dto.LoginDTO;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录功能业务
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private StaffMapper staffMapper;

    /**
     * 登录业务
     * @param loginDTO
     * @return
     */
    public Staff login(LoginDTO loginDTO) {
        Staff staff = staffMapper.findBySid(loginDTO.getSid());
        if (staff == null){
            return null;
        }else {
            if (staff.getSpw().equals(loginDTO.getSpw())) {
                return staff;
            } else {
                return null;
            }
        }
    }
}
