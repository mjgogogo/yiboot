package com.personal.yiboot.api;

/**
 * @author chenmj
 * @date 2021/7/16 16:25
 */
public class RespGenerator {
    private RespGenerator() {
    }

    public static <T>  ResponseResult successful(T data){
        return new ResponseResult(200,data,true);
    }

    public static <T>  ResponseResult fail(int code,String message){
        return new ResponseResult(code,message,false);
    }

}
