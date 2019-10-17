package cn.com.mcsca.exception.filter;

import cn.com.mcsca.exception.entity.BusinessException;
import cn.com.mcsca.exception.entity.ExceptionEntity;
import cn.com.mcsca.exception.service.ExceptionService;
import io.seata.core.context.RootContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GlobalTransactionalFilter {

    @Autowired
    private ExceptionService exceptionService;

    private static final Logger logger  = LoggerFactory.getLogger(GlobalTransactionalFilter.class);

    public GlobalTransactionalFilter() {
        logger.info("加载aop模块");

    }

    @Pointcut("@annotation(io.seata.spring.annotation.GlobalTransactional)")
    public void globalTransactionalPointcut() {

    }

    @Around("globalTransactionalPointcut()")

    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object object;
        object = point.proceed();

        String xid = RootContext.getXID();
        xid = xid.replaceAll("\\pP","");
        ExceptionEntity exceptionEntity = exceptionService.getExceptionById(xid);
        if(exceptionEntity!=null){
            throw  new BusinessException(exceptionEntity.getExceptionCode(),exceptionEntity.getExceptionMsg());
        }
        return object;

    }

//    @After(value = "@within(io.seata.spring.annotation.GlobalTransactional)")
//    public void after(JoinPoint joinPoint) throws Throwable {
//        String xid = RootContext.getXID();
//        ExceptionEntity exceptionEntity = exceptionService.getExceptionById(xid);
//        if(exceptionEntity!=null){
//            LogFactory.getLog(this.getClass()).info("monitor.after, class: " + joinPoint.getSignature().getDeclaringType().getSimpleName() + ", method: " + joinPoint.getSignature().getName());
//            throw new RuntimeException(exceptionEntity.getStackMsg());
//        }
//        System.out.println(retValue);
//        throw new Exception("22");
//        joinPoint.
//        System.out.println(11111);
//        LogFactory.getLog(this.getClass()).info("monitor.after, class: " + joinPoint.getSignature().getDeclaringType().getSimpleName() + ", method: " + joinPoint.getSignature().getName());
//    }

}