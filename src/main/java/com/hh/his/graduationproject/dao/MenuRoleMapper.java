package com.hh.his.graduationproject.dao;


import org.apache.ibatis.annotations.Param;

public interface MenuRoleMapper {

    int deleteByRid(@Param("rid") Integer rid);

    int insertRecord(@Param("rid") Integer rid,@Param("mids") Integer[] mids);

    int insert(@Param("rid") Integer rid,@Param("mid") Integer mid);

    int deleteByMid(@Param("mid")Integer mid);
}
