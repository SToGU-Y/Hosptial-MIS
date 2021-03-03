package com.hh.his.graduationproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog {

    private Long logId;
    private String username;
    private String method;
    private String methodDescribe;
    private String createDate;
    private String uri;
    private String params;
    private String ip;

}
