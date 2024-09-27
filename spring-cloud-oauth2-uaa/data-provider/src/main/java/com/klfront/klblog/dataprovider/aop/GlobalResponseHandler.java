package com.klfront.klblog.dataprovider.aop;

import com.klfront.klblog.common.entity.GlobalResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 全局返回结果处理类
 *
 * @author:lujinlong
 * @created:2019-09-08 00:39
 **/
@RestControllerAdvice(annotations = {RestController.class})
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        final String returnTypeName = methodParameter.getParameterType().getName();
        return !"com.klfront.klblog.common.entity.GlobalResponse".equals(returnTypeName)
                && !"org.springframework.http.ResponseEntity".equals(returnTypeName);
    }

    /**
     * 定义统一处理handler
     * @param body
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @SuppressWarnings("rawTypes")
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        final String returnTypeName = methodParameter.getParameterType().getName();
        if ("void".equals(returnTypeName)) {
            return GlobalResponse.success(null);
        }

        if (!mediaType.includes(MediaType.APPLICATION_JSON)) {
            return body;
        }

        if("com.klfront.klblog.common.entity.GlobalResponse".equals(returnTypeName)){
            return body;
        }
        return GlobalResponse.success(body);
    }
}
