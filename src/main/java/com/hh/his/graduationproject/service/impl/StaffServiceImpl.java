package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.StaffMapper;
import com.hh.his.graduationproject.model.entity.Staff;
import com.hh.his.graduationproject.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 员工管理业务
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;


}
