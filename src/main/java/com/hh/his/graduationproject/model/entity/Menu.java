package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private Integer id;
    private String url;
    private String path;
    private String name;
    private int requireAuth;
    private Integer parentId;
    private String component;
    private Integer type;
    private String iconCls;

    private List<Menu> children;
    private List<Role> roles;

}
