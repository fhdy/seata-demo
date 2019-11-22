package com.sly.seata.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * order 启动类
 * 
 * @author sly
 * @time 2019年6月12日
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.sly.seata.order.mapper")
@ComponentScan(basePackages = {"com.sly","cn.com.mcsca.exception"})
@EnableFeignClients(basePackages = {"com.sly","cn.com.mcsca.exception"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
