package com.hh.his.graduationproject.config.auth;

import com.hh.his.graduationproject.utils.JwtTokenUtils;
import com.hh.his.graduationproject.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 认证过滤器
 */
public class MyAuthenticationFilter extends BasicAuthenticationFilter {


    public MyAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        System.out.println("-----------进入MyAuthenticationFilter---------");

        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        System.out.println(tokenHeader);
        //如果请求头没有Authoriztion信息就放行  放行去认证/login
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)){
            chain.doFilter(request,response);
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));

        super.doFilterInternal(request,response,chain);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader){
        //从header获取token
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
        String username = JwtTokenUtils.getUsername(token);
        System.out.println("username"+username);
        if (username != null){
            return new UsernamePasswordAuthenticationToken(username,null,new ArrayList<>());
        }
        return null;
    }

}
