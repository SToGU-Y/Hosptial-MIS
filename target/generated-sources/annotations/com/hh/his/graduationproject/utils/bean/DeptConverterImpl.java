package com.hh.his.graduationproject.utils.bean;

import com.hh.his.graduationproject.model.entity.Dept;
import com.hh.his.graduationproject.model.vo.DeptSelectVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-01T22:37:35+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class DeptConverterImpl implements DeptConverter {

    @Override
    public DeptSelectVO toSelectVO(Dept dept) {
        if ( dept == null ) {
            return null;
        }

        DeptSelectVO deptSelectVO = new DeptSelectVO();

        deptSelectVO.setDeptId( dept.getDeptId() );
        deptSelectVO.setDeptName( dept.getDeptName() );

        return deptSelectVO;
    }

    @Override
    public List<DeptSelectVO> toSelectVOList(List<Dept> depts) {
        if ( depts == null ) {
            return null;
        }

        List<DeptSelectVO> list = new ArrayList<DeptSelectVO>( depts.size() );
        for ( Dept dept : depts ) {
            list.add( toSelectVO( dept ) );
        }

        return list;
    }
}
