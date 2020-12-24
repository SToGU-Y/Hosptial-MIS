package com.hh.his.graduationproject.controller;

import com.alibaba.fastjson.JSON;
import com.hh.his.graduationproject.model.dto.LoginDTO;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.service.LoginService;
import com.hh.his.graduationproject.service.StaffService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登陆Controller
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;


    /**
     *  登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result Login(@RequestBody LoginDTO loginDTO){
        System.out.println(loginDTO);
        Staff staff = loginService.login(loginDTO);
        if (staff == null){
            return Result.ERROR("不存在此账号！");
        }
        return Result.OK(JSON.toJSONString(staff));
    }

}
