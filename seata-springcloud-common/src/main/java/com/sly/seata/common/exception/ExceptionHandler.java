package com.sly.seata.common.exception;

import com.sly.seata.common.constant.ExceptionConstant;
import com.sly.seata.common.context.ExceptionMsgContext;

import java.util.Map;

public class ExceptionHandler {

    public static void dealExceptions(Map result) throws Exception{
        String code = (String)result.get(ExceptionConstant.throwExceptionCodeKey);
        if(code==null || !ExceptionConstant.throwExceptionCodeValue.equals(code)){//异常码为空或者异常码不相等正常返回值
            return;
        }
        String throwExceptionStackMsg = (String) result.get(ExceptionConstant.throwExceptionStackMsgKey);
        String throwExceptionMsg = (String) result.get(ExceptionConstant.throwExceptionMsgCode);

        if(ExceptionConstant.throwBusinessExceptionCode.equals(code)){
            throw new RuntimeException(throwExceptionMsg);
        }else{
            throw new RuntimeException(throwExceptionStackMsg);
        }

    }
}
