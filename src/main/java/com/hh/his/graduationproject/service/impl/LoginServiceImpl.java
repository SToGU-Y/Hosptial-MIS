package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.StaffMapper;
import com.hh.his.graduationproject.model.vo.LoginVO;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户校验
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StaffMapper staffMapper;

    /**
     * 登录业务
     * @param
     * @return
     */
    public Boolean checkLogin(String username,String password) throws Exception{
        System.out.println("----checkLogin-----");
        System.out.println("username="+username+",password="+password);
        Staff staff = staffMapper.checkLogin(username);
        if (staff == null){
            return false;
        }
        boolean flag = new BCryptPasswordEncoder().matches(password,staff.getPassword());
        if (!flag){
           return false;
        }
        return true;
    }
}
