package com.hh.his.graduationproject.config.auth;

import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理器
 */
@Component
public class MyAuthenticationFailureHandler extends JSONAuthentication implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        System.out.println("-----------进入MyAuthenticationFailureHandler---------");

        Result data  = Result.ERROR("登录失败!错误信息："+exception.getMessage());
        this.writeJSON(request,response,data);
    }
}
