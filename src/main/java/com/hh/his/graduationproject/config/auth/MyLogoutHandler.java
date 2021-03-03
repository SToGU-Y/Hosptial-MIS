package com.hh.his.graduationproject.config.auth;

import com.hh.his.graduationproject.utils.JwtTokenUtils;
import com.hh.his.graduationproject.utils.RedisUtil;
import com.hh.his.graduationproject.utils.result.Result;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 退出处理器
 */

public class MyLogoutHandler extends JSONAuthentication implements LogoutHandler {

    @Autowired
    private RedisUtil redisUtil;

    private static final String TOKEN_KEY =  "token_";

    @SneakyThrows
    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication) {

        String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER).replace(JwtTokenUtils.TOKEN_PREFIX,"");
        if (token != null){
            String username = JwtTokenUtils.getUsername(token);
            redisUtil.Hdel("token",TOKEN_KEY+username);
        }
        this.writeJSON(request,response, Result.OK("注销成功"));
    }

}
