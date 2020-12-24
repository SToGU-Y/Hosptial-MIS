package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


public interface StaffMapper {

    /**
     * 用工号查询员工
     * @param sid
     * @return
     */
    Staff findBySid(@Param("sid") String sid);
}
