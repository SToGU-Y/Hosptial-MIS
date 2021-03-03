package com.hh.his.graduationproject.utils;

import com.hh.his.graduationproject.model.entity.Staff;
import org.springframework.security.core.context.SecurityContextHolder;

public class StaffUtils {

    public static Staff getCurrentStaff(){
        return ((Staff) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
