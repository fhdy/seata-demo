package com.sly.seata.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * eureka server启动类
 * 
 * @author sly
 * @time 2019年6月12日
 */
@EnableEurekaServer
@SpringBootApplication
public class ApplicationEureka {

	public static void main(String[] args) throws Exception{
//		String path=Thread.currentThread().getContextClassLoader().getResource("").toString();
//		if(path.startsWith("jar")){
//			path = path.substring(4);
//		}
//		System.out.println(path);
//		path = path.substring(6);
//		System.out.println("jar包目录："+path);
//		path = path.substring(0,path.indexOf(".jar"));
//		File temp = new File(path);
//		path = temp.getParent();
//		System.out.println("处理后："+path);

		SpringApplication.run(ApplicationEureka.class, args);
	}

}
