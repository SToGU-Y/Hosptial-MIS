package com.hh.his.graduationproject.controller;

import com.hh.his.graduationproject.config.SystemLogController;
import com.hh.his.graduationproject.config.VerificationCode;
import com.hh.his.graduationproject.service.LoginService;
import com.hh.his.graduationproject.utils.RedisUtil;
import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登陆Controller
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     *  登录
     */
    @SystemLogController(description = "登录验证")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result Login(){
        return Result.OK("登录成功！");
    }

    @SystemLogController(description = "注销")
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public Result logout(){
        return Result.OK("注销成功！");
    }

    @RequestMapping(value = "/verifyCode",method = RequestMethod.GET)
    public void verifyCode(HttpServletRequest request,HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        String ip = request.getRemoteHost();
        redisUtil.set(ip,text.toLowerCase());
        VerificationCode.output(image,resp.getOutputStream());
    }
}
