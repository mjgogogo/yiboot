package com.personal.yiboot.api;

import java.io.Serializable;

/**
 * @author chenmj
 * @date 2021/7/16 16:02
 */
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = -1964247276879239770L;

    private boolean success;
    private T data;
    private Object[] params;
    private String time;
    private int code;
    private String message;

    public ResponseResult(boolean success, T data, Object[] params, String time, int code, String message) {
        this.success = success;
        this.data = data;
        this.params = params;
        this.time = time;
        this.code = code;
        this.message = message;
    }

    public ResponseResult() {
    }

    public ResponseResult(int code,T data,boolean success) {
        this.success = success;
        this.data = data;
        this.code = code;
    }

    public ResponseResult(int code,String message,boolean success) {
        this.success = success;
        this.code = code;
        this.message = message;

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
