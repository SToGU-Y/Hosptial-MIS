package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.CostItem;
import com.hh.his.graduationproject.model.entity.Drug;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-01T22:37:35+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class CostItemConverterImpl implements CostItemConverter {

    @Override
    public CostItem drugToCostItem(Drug drug) {
        if ( drug == null ) {
            return null;
        }

        CostItem costItem = new CostItem();

        costItem.setCostItemSpecifications( drug.getDrugSpecifications() );
        costItem.setCostItemNo( drug.getDrugNo() );
        costItem.setCostItemUnit( drug.getDrugUnit() );
        costItem.setCostItemDose( drug.getDoseUnit() );
        costItem.setCostItemName( drug.getDrugName() );
        costItem.setCostItemType( drug.getDrugType() );
        costItem.setCostItemPrice( drug.getDrugPrice() );

        return costItem;
    }

    @Override
    public List<CostItem> drugToCostItemList(List<Drug> drugs) {
        if ( drugs == null ) {
            return null;
        }

        List<CostItem> list = new ArrayList<CostItem>( drugs.size() );
        for ( Drug drug : drugs ) {
            list.add( drugToCostItem( drug ) );
        }

        return list;
    }
}
