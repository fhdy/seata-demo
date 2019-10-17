package cn.com.mcsca.exception.service.hystrix;

import cn.com.mcsca.exception.entity.ExceptionEntity;
import cn.com.mcsca.exception.service.ExceptionService;
import org.springframework.stereotype.Component;


@Component
public class ExceptionServiceHystrixImpl implements ExceptionService {

    @Override
    public void saveException(ExceptionEntity exceptionEntity) throws Exception {
        System.out.println("调用异常服务失败");
    }

    @Override
    public ExceptionEntity getExceptionById(String id) throws Exception {
        return null;
    }
}