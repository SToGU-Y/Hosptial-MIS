package com.hh.his.graduationproject.service;

import com.hh.his.graduationproject.model.dto.LoginDTO;
import com.hh.his.graduationproject.model.entity.Staff;

public interface LoginService {

    /**
     * 账号登录
     * @param loginDTO
     * @return
     */
    Staff login(LoginDTO loginDTO);

}
