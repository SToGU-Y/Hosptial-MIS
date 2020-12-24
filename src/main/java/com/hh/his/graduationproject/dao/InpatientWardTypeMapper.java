package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.entity.InpatientWardType;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface InpatientWardTypeMapper {

    List<InpatientWardType> findAllWardType();

    void insertWardType(@Param("iwtType") String iwtType,@Param("iwtPrice") BigDecimal iwtPrice);

    void updateWardType(@Param("wardType")InpatientWardType wardType);

    void delWardType(@Param("iwtId")Integer iwtId);
}
