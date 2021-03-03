package com.hh.his.graduationproject.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {

    private Integer id;
    private String url;
    private String path;
    private String name;
    private int requireAuth;
    private Integer parentId;
    private String component;
    private Integer type;
    private String iconCls;


    private Integer roleId;
}
