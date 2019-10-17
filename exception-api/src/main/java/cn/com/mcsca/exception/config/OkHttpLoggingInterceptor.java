//package cn.com.mcsca.exception.config;
//
//import cn.com.mcsca.exception.entity.ExceptionEntity;
//import cn.com.mcsca.exception.service.ExceptionService;
//import io.seata.core.context.RootContext;
//import okhttp3.Interceptor;
//import okhttp3.Request;
//import okhttp3.Response;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//public class OkHttpLoggingInterceptor implements Interceptor {
//    private static final Logger logger = LoggerFactory.getLogger(OkHttpLoggingInterceptor.class);
//
//    public OkHttpLoggingInterceptor(){
//
//    }
//
//    public OkHttpLoggingInterceptor(ExceptionService exceptionService){
//        this.exceptionService = exceptionService;
//    }
//
//    private ExceptionService exceptionService;
//
//    @Override
//    public okhttp3.Response intercept(Chain chain) throws IOException {
//        Request request = chain.request();
//
//        String xid = RootContext.getXID();
//        if(StringUtils.isNotBlank(xid)){
//            xid = xid.replaceAll("\\pP","");
//        }
//        ExceptionEntity exceptionEntity = null;
//        try {
//            exceptionEntity = exceptionService.getExceptionById(xid);
//        }catch (Exception e){
//            //不作任何操作
//            logger.info("获取异常信息异常");
//        }
//        if(exceptionEntity!=null){
//            throw new IOException("熔断");
//        }
//
//        Response response = chain.proceed(request);
//        return response;
//    }
//}