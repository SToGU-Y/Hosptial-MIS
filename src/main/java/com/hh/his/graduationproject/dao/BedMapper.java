package com.hh.his.graduationproject.dao;

import com.hh.his.graduationproject.model.dto.BedAddDTO;
import com.hh.his.graduationproject.model.dto.BedUpdateDTO;
import com.hh.his.graduationproject.model.entity.Bed;
import com.hh.his.graduationproject.model.vo.condition.BedSelectConditionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BedMapper {

    List<Bed> selectNullBed(@Param("condition") BedSelectConditionVO conditionVO);

    int updateBed(@Param("dto")BedUpdateDTO dto);

    Bed selectById(@Param("id")Integer id);

    int selectNotNullBedNumByWid(@Param("wid")Integer wid);

    int selectWardBedNumByWid(@Param("wid")Integer wid);

    int insertBed(@Param("bed") BedAddDTO bed);

    int delBedById(@Param("id")Integer id);

    List<Bed> selectBedByWid(@Param("wid")Integer wid);
}
