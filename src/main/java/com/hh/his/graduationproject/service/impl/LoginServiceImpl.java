package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.StaffMapper;
import com.hh.his.graduationproject.model.vo.LoginVO;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
     * @param loginVO
     * @return
     */
    public Staff login(LoginVO loginVO) {
        System.out.println("loginVO="+loginVO);
        Staff staff = staffMapper.findByUsername(loginVO.getUsername());
        if (staff == null){
            return null;
        }else {
            if (staff.getPassword().equals(
                    new BCryptPasswordEncoder().encode(loginVO.getPassword()
                    ))) {
                return staff;
            } else {
                return null;
            }
        }
    }
}
