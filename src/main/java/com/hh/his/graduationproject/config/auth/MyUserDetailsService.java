package com.hh.his.graduationproject.config.auth;

import com.hh.his.graduationproject.dao.StaffMapper;
import com.hh.his.graduationproject.model.entity.Role;
import com.hh.his.graduationproject.model.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于用户加载和验证
 */

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private StaffMapper staffMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("-----------进入MyUserDetailsService---------");
        System.out.println("username:"+username);
        Staff staff = staffMapper.loadUserByUsername(username);
        if (staff == null){
            System.out.println("找不到该用户");
            throw new UsernameNotFoundException("找不到该用户");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : staff.getRoles()){
            SimpleGrantedAuthority auth = new SimpleGrantedAuthority(role.getRoleName());
            authorities.add(auth);
        }
        SysUser user = new SysUser(staff.getUsername(),staff.getPassword(),staff.getStaffName(),authorities);
        return user;
    }
}
