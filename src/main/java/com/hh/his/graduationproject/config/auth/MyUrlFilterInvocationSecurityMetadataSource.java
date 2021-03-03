package com.hh.his.graduationproject.config.auth;

import com.hh.his.graduationproject.model.entity.Menu;
import com.hh.his.graduationproject.model.entity.Role;
import com.hh.his.graduationproject.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class MyUrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        System.out.println("---------------进入Source---------------------");
        //获取请求地址
        String requestUrl = ((FilterInvocation)object).getRequestUrl();
        System.out.println(requestUrl);
        if ("/login".equals(requestUrl) || requestUrl.contains("/verifyCode")){
            return null;
        }
        List<Menu> allMenu = menuService.getAllMenusWithRole();
        for (Menu menu : allMenu){
            if (antPathMatcher.match(menu.getUrl(),requestUrl) && menu.getRoles().size()>0) {
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getRoleName();
                }
                return SecurityConfig.createList(values);
            }
        }

        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
