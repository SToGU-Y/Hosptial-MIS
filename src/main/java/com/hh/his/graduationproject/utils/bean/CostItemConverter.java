package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.CostItem;
import com.hh.his.graduationproject.model.entity.Drug;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CostItemConverter {

    CostItemConverter INSTANCE = Mappers.getMapper(CostItemConverter.class);


    @Mapping(target = "costItemNo",source = "drugNo")
    @Mapping(target = "costItemName",source = "drugName")
    @Mapping(target = "costItemPrice",source = "drugPrice")
    @Mapping(target = "costItemType",source = "drugType")
    @Mapping(target = "costItemUnit",source = "drugUnit")
    @Mapping(target = "costItemSpecifications",source = "drugSpecifications")
    @Mapping(target = "costItemDose",source = "doseUnit")
    CostItem drugToCostItem(Drug drug);

    List<CostItem> drugToCostItemList(List<Drug> drugs);
}
