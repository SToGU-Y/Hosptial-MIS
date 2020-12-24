package com.hh.his.graduationproject.utils.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private Integer status;
    private T data;
    private String msg;

    public static <T> Result<T> OK(){
        return new Result<T>(ResponseCode.SUCCESS.code,null,ResponseCode.SUCCESS.msg);
    }

    public static <T> Result<T> OK(T data){
        return new Result<T>(ResponseCode.SUCCESS.code,data,ResponseCode.SUCCESS.msg);
    }

    public static <T> Result<T> ERROR(){
        return new Result<T>(ResponseCode.ERROR.code,null,ResponseCode.ERROR.msg);
    }

    public static <T> Result<T> ERROR(String msg){
        return new Result<T>(ResponseCode.ERROR.code,null,msg);
    }

    public static <T> Result<T> WARN(String msg){
        return new Result<T>(ResponseCode.WARN.code,null,msg);
    }
}
