//package com.sly.seata.account.service.test;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//
//@Aspect
//
//public class ParamLogUtil {
//
//
//
//    private static final Logger logger  = LoggerFactory.getLogger(ParamLogUtil.class);
//
//
//
//    public ParamLogUtil() {
//
//        logger.info("加载aop模块");
//
//    }
//
//
//
//
//
//@Pointcut("@within(com.sly.seata.account.service.test.ParamLog)")
//
//    public void methodCachePointcut() {
//
//    }
//
//
//
//    @Around("methodCachePointcut()")
//
//    public Object around(ProceedingJoinPoint point) throws Throwable {
//
//
//
//         Object[] args = point.getArgs();
//
//         for (Object object : args) {
//
//            logInfo(object,0);
//
//         }
//
//
//
//
//
//        Object object;
//
//        try {
//
//           object = point.proceed();
//
//        } catch (Exception e) {
//
//           throw e;
//
//        }
//
//
//
//
//
//        logInfo(object,1);
//
//
//
//        return object;
//
//    }
//
//
//
//    public void logInfo(Object object, Integer i) {
//
//        String logType = "";
//
//        if(i == 0) {
//
//           logType = "输入参数：";
//
//        }else {
//
//           logType = "输出参数：";
//
//        }
//
//        if(object == null) {
//
//            logger.info(logType+"为null");
//
//         }else {
//
//            logger.info(logType+object.toString());
//
//         }
//
//    }
//
//    @AfterReturning(value = "@within(com.sly.seata.account.service.test.ParamLog)",returning="retValue")
//    public void after(JoinPoint joinPoint,Object retValue) throws Throwable {
//        System.out.println(retValue);
//        throw new Exception("22");
////        joinPoint.
////        System.out.println(11111);
////        LogFactory.getLog(this.getClass()).info("monitor.after, class: " + joinPoint.getSignature().getDeclaringType().getSimpleName() + ", method: " + joinPoint.getSignature().getName());
//    }
//}