package com.association.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID=1L;

    private Integer code;
    private String msg;
    private T data;

    public static <T> ResultBean<T> build(){
        return new ResultBean<T>();
    }
    public static <T> ResultBean<T> success(){
        return new ResultBean<T>(200,null,null);
    }
    public static <T> ResultBean<T> success(String msg){
        return new ResultBean<T>(200,msg,null);
    }
    public static <T> ResultBean<T> success(String msg, T data){
        return new ResultBean<T>(200,msg,data);
    }
    public static <T> ResultBean<T> fail(){
        return new ResultBean<T>(400,null,null);
    }
    public static <T> ResultBean<T> fail(String msg){
        return new ResultBean<T>(400,msg,null);
    }
    public static <T> ResultBean<T> fail(String msg,T data){
        return new ResultBean<T>(400,msg,data);
    }

    public static <T> ResultBean<T> warn(String msg,T data) {
        return new ResultBean<T>(400, msg, data);
    }
    public static <T> ResultBean<T> error(String msg){
        return new ResultBean<T>(500,msg,null);
    }
    public static <T> ResultBean<T> error(String msg, T data){
        return new ResultBean<T>(500,msg,data);
    }
}
