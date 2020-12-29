package com.hh.his.graduationproject.controller;

import com.alibaba.fastjson.JSON;
import com.hh.his.graduationproject.config.VerificationCode;
import com.hh.his.graduationproject.model.vo.LoginVO;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.service.LoginService;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
    public Result Login(@RequestBody LoginVO loginVO){
        System.out.println(loginVO);
        Staff staff = loginService.login(loginVO);
        if (staff == null){
            return Result.ERROR("不存在此账号！");
        }
        return Result.OK("OK");
    }

    @RequestMapping(value = "/verifyCode",method = RequestMethod.GET)
    public void verifyCode(HttpServletResponse resp) throws IOException {

        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        VerificationCode.setVerifyCode(text.toLowerCase());
        VerificationCode.output(image,resp.getOutputStream());

    }

}
