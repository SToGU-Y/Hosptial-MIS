package com.hh.his.graduationproject.utils.result;

public enum ResponseCode {
    ERROR(500,"ERROR"),
    SUCCESS(200,"SUCCESS"),
    WARN(300,"WARN");

    public final int code;
    public final String msg;

    ResponseCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
