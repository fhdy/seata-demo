package com.sly.seata.account.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
 
/**
 * 拦截Controller方法默认返回参数，统一处理返回值/响应体
 *
 * @author yclimb
 * @date 2018/6/29
 */
@ControllerAdvice
public class TestResponseBodyAdvice implements ResponseBodyAdvice {
 
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse ) {
 
        System.out.println("TestResponseBodyAdvice==>beforeBodyWrite:" + o.toString() + ","
                + methodParameter);
        return o;
    }
 
 
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }
}