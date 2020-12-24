package com.hh.his.graduationproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 登录DTO
 * 映射前端传来的JSON
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    /**
     * 登录账号（员工工号）
     */
    private String sid;

    /**
     * 登录密码（员工密码）
     */
    private String spw;
}
