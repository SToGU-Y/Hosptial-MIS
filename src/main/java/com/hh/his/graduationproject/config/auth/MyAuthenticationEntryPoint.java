package com.hh.his.graduationproject.config.auth;

import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未授权处理器
 */
@Component
public class MyAuthenticationEntryPoint extends JSONAuthentication implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response
                         ,AuthenticationException authException) throws IOException, ServletException {

        System.out.println("----------进入MyAuthenticationEntryPoint-----------");

        Result data = Result.ERROR("访问此资源需要完全身份验证("+authException.getMessage()+")");
        this.writeJSON(request,response,data);
    }
}
