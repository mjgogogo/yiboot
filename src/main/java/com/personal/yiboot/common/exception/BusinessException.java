package com.personal.yiboot.common.exception;

/**
 * @author chenmj
 * 业务异常
 * @date 2021/7/16 13:59
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 3408541688505074566L;

    private String message;

    private int code;

    public BusinessException() {
    }

    public BusinessException(int code,String message){
        super(message);
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
