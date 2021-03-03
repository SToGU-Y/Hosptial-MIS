package com.hh.his.graduationproject.config.auth;


import com.hh.his.graduationproject.utils.result.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AuthenticationAccessDeniedHandler extends JSONAuthentication implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {

        System.out.println("----------进入AuthenticationAccessDeniedHandler-----------");

        Result data = Result.ERROR("权限不足："+e.getMessage());
        this.writeJSON(httpServletRequest,httpServletResponse,data);
    }

}
