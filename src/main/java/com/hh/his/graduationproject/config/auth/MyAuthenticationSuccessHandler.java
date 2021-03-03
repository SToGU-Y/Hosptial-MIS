package com.hh.his.graduationproject.config.auth;

import com.hh.his.graduationproject.model.entity.Menu;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.service.MenuService;
import com.hh.his.graduationproject.utils.JwtTokenUtils;
import com.hh.his.graduationproject.utils.RedisUtil;
import com.hh.his.graduationproject.utils.result.Result;
import javafx.scene.input.TouchEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于认证成功处理器
 */
@Component
public class MyAuthenticationSuccessHandler extends JSONAuthentication implements AuthenticationSuccessHandler {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        System.out.println("-----------进入MyAuthenticationSuccessHandler---------");
        //认证成功后，得到认证成功的用户信息
        SysUser userDetails = (SysUser) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);


        String token = redisUtil.hget("token","token_"+userDetails.getUsername());
        //安全性可以进一步提高的
        if (token == null){
            System.out.println("初次登录,生成TOKEN");
            token = JwtTokenUtils.createToken(userDetails);
            System.out.println("token ="+token);
            redisUtil.hset("token","token_"+userDetails.getUsername(),token);
        }else {
            System.out.println("不是初次登录了,检查一下token有效性");
            boolean expiration = JwtTokenUtils.isExpiration(token);
            System.out.println("expiration :"+expiration);
            if (expiration){
                token = JwtTokenUtils.createToken(userDetails);
                redisUtil.hset("token","token_"+userDetails.getUsername(),token);
                System.out.println("token已更新");
            }
        }

        List<Menu> meuns = menuService.getMenusByUsername(userDetails.getUsername());

        Map<String,Object> map = new HashMap<>();
        map.put("username",userDetails.getUsername());
        map.put("name",userDetails.getName());
        map.put("auth",userDetails.getAuthorities());
        map.put("menus",meuns);
        map.put("token",token);

        Result data = Result.OK(map);

        this.writeJSON(request,response,data);
    }


}
