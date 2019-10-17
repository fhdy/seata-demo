package cn.com.mcsca.exception111.base.mcscaexceptionbase.config;

import feign.Feign;
import okhttp3.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignConfig {

//    @Bean
//    public Contract feignContract() {
//        return new feign.Contract.Default();
//    }

//    @Bean
//    @ConditionalOnMissingBean({Client.class})
//    public Client feignClient(okhttp3.OkHttpClient client) {
//        return new feign.okhttp.OkHttpClient(client);
//    }

    @Bean
    public okhttp3.OkHttpClient okHttpClient(@Autowired OkHttpLoggingInterceptor okHttpLoggingInterceptor){
        okhttp3.OkHttpClient.Builder ClientBuilder = new okhttp3.OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS) //读取超时
                .connectTimeout(10, TimeUnit.SECONDS) //连接超时
                .writeTimeout(60, TimeUnit.SECONDS) //写入超时
                .connectionPool(new ConnectionPool(10 /*maxIdleConnections*/, 3, TimeUnit.MINUTES))
                .addInterceptor(okHttpLoggingInterceptor);
        return ClientBuilder.build();

//        Boolean followRedirects = httpClientProperties.isFollowRedirects();
//        Integer connectTimeout = httpClientProperties.getConnectionTimeout();
//        Boolean disableSslValidation = httpClientProperties.isDisableSslValidation();
//        return httpClientFactory.createBuilder(disableSslValidation)
//                .connectTimeout((long)connectTimeout, TimeUnit.MILLISECONDS)
//                .followRedirects(followRedirects)
//                .connectionPool(new ConnectionPool(10 /*maxIdleConnections*/, 3, TimeUnit.MINUTES))
//                .addInterceptor(new OkHttpLoggingInterceptor()) // 自定义请求日志拦截器
//                .build();
    }
}
