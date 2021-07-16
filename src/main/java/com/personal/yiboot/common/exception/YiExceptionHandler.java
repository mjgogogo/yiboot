package com.personal.yiboot.common.exception;

/**
 * @author chenmj
 * @date 2021/7/16 15:42
 * 统一异常处理
 */

import com.personal.yiboot.api.RespGenerator;
import com.personal.yiboot.api.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class YiExceptionHandler {
    private final static Logger logger = Logger.getLogger(YiExceptionHandler.class);
    /**
     * 参数解析失败异常处理
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseResult handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        logger.error(request.getRequestURI() + ":参数解析失败",e);
        return RespGenerator.fail(HttpStatus.BAD_REQUEST.value(),"参数解析失败");
    }

    /**
     * 不支持当前请求方法异常处理
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResponseResult handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        logger.error(request.getRequestURI() + ":不支持当前请求方法",e);
        return RespGenerator.fail(HttpStatus.METHOD_NOT_ALLOWED.value(),"不支持当前请求方法");
    }


    /**
     * 项目运行异常处理
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult handleException(Exception e, HttpServletRequest request) {
        logger.error(request.getRequestURI() + ":服务运行异常",e);
        return RespGenerator.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(),"服务运行异常");

    }


    /**
     * 自定义异常处理
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseResult handleException(BusinessException e, HttpServletRequest request) {
        logger.error(request.getRequestURI() + ":自定义内部异常",e);
        return RespGenerator.fail(500,e.getMessage());
    }


}
