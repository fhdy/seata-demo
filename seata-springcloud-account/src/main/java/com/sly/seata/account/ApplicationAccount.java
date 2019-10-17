package com.sly.seata.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * account 启动类
 * 
 * @author sly
 * @time 2019年6月12日
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.sly.seata.account.mapper")
@ComponentScan(basePackages={"com.sly","cn.com.mcsca.exception"})
@EnableFeignClients(basePackages={"cn.com.mcsca.exception"})
public class ApplicationAccount {

	public static void main(String[] args) {


		SpringApplication.run(ApplicationAccount.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	public Map index(){
		Map map = new HashMap();
		map.put("index","myIndex");
		return map;
	}
}
