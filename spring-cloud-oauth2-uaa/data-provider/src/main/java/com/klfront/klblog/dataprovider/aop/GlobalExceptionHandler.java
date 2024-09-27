package com.klfront.klblog.dataprovider.aop;

import com.klfront.klblog.common.entity.GlobalResponse;
import com.klfront.klblog.common.entity.MyException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 全局异常处理类
 *
 * @author:lujinlong
 * @created:2019-09-08 01:08
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //访问权限异常处理方法
    @ExceptionHandler(value = AccessDeniedException.class)
    public Object accessDeniedException(HttpServletRequest request, AccessDeniedException e, HandlerMethod handlerMethod) {
        return GlobalResponse.authFail();
    }

    //自定义异常处理方法
    @ExceptionHandler(value = MyException.class)
    public Object myException(HttpServletRequest request, MyException e, HandlerMethod handlerMethod) {
        return GlobalResponse.error(e.getMsg(), e.getCode());
    }

    // 服务器异常处理方法
    @ExceptionHandler(value = Exception.class)
    public Object exception(HttpServletRequest request, Exception e, HandlerMethod handlerMethod) {
        Method method = handlerMethod.getMethod();
        log.error(method.getName()+":服务器发生异常，异常信息为:", e);
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        return GlobalResponse.error(ExceptionUtils.getMessage(e) +
                " at " + stackTraceElements[0].toString());
    }

}

