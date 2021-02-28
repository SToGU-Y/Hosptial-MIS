package com.hh.his.graduationproject.service;

import com.hh.his.graduationproject.model.vo.LoginVO;
import com.hh.his.graduationproject.model.entity.Staff;

public interface LoginService {

    /**
     * 账号登录
     * @param
     * @return
     */
    Boolean checkLogin(String username, String password) throws Exception;

}
