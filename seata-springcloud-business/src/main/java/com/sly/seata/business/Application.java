package com.sly.seata.business;

import io.seata.core.constants.ConfigurationKeys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * business 启动类
 * @author sly
 * @time 2019年6月12日
 */
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.sly.seata","cn.com.mcsca.exception"})
@EnableCircuitBreaker
@SpringBootApplication
@ComponentScan(basePackages={"com.sly.seata","cn.com.mcsca.exception"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
