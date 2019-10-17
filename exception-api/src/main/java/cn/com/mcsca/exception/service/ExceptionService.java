package cn.com.mcsca.exception.service;

import cn.com.mcsca.exception.entity.ExceptionEntity;
import cn.com.mcsca.exception.service.hystrix.ExceptionServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "seata-springcloud-exception", fallback = ExceptionServiceHystrixImpl.class)
public interface ExceptionService {

    @RequestMapping(value = "/exception/saveException", method = RequestMethod.POST)
    public void saveException(@RequestBody ExceptionEntity exceptionEntity) throws Exception;

    @RequestMapping(value = "/exception/getExceptionById", method = RequestMethod.POST)
    public ExceptionEntity getExceptionById(@RequestBody String id) throws Exception;
}
