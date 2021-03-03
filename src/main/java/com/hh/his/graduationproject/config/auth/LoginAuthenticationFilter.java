package com.hh.his.graduationproject.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hh.his.graduationproject.service.LoginService;
import com.hh.his.graduationproject.utils.RedisUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 过滤器
 * 用于获取前端username和password
 * 进行认证
 */
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }


    /**
     * 获取前端传来的账号密码
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        System.out.println("-----------进入LoginAuthenticationFilter---------");

        if (request.getContentType().contains(MediaType.APPLICATION_JSON_VALUE) ||
                request.getContentType().contains(MediaType.APPLICATION_JSON_UTF8_VALUE)) {
            Map<String, String> loginData = new HashMap<>();
            try {
                //获取前端传过来的数据，因为是前后端分离所以要这样取值，
                //并且这样取值过后，后面（Controller）再也无法取值，所以需要重新写入
                loginData = new ObjectMapper()
                        .readValue(request.getInputStream(), Map.class);
            } catch (Exception e) {

            }finally {
                //检验验证码
                String ip = request.getRemoteHost();
                String code = loginData.get("code");
                if (redisUtil.get(ip) == null){
                    throw new AuthenticationServiceException("验证码过期,请重新获取验证码");
                }
                if (!redisUtil.get(ip).equals(code.toLowerCase())) {
                    throw new AuthenticationServiceException("验证码不正确");
                }
            }
            String username = loginData.get(getUsernameParameter());
            String password = loginData.get(getPasswordParameter());
            if (username == null) {
                username = "";
            }
            if (password == null) {
                password = "";
            }
            System.out.println(password + "-" + username);
            //检验账户密码
            if (!loginService.checkLogin(username,password)){
                throw new AuthenticationServiceException("密码或账号错误");
            }
            //巨坑！因为在配置类里面设置了passEncoder了，所以这里直接写password就可以了
            UsernamePasswordAuthenticationToken authRequest =
                    new UsernamePasswordAuthenticationToken(username, password);
            setDetails(request, authRequest);
            return super.getAuthenticationManager().authenticate(authRequest);
        } else {
            String ip = request.getRemoteHost();
            Boolean flag = !redisUtil.get(ip).equals(request.getParameter("code").toLowerCase());
            if (!flag) {
                throw new AuthenticationServiceException("验证码不正确");
            }
            if (!loginService.checkLogin(request.getParameter("username"),request.getParameter("password"))){
                throw new AuthenticationServiceException("密码或账号错误");
            }
            return super.attemptAuthentication(request, response);
        }

    }


    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }

}
