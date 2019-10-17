package cn.com.mcsca.exception.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class ExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionApplication.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    public Map index(){
        Map map = new HashMap();
        map.put("index","myIndex");
        return map;
    }

}
