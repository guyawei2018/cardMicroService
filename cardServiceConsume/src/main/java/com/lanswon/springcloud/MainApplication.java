package com.lanswon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.lanswon.MyRuleConfg;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
//表示那个微服务使用负载均衡
@RibbonClient(name="CARDSERVICE",configuration=MyRuleConfg.class)
//启用feign功能，并service注入到容器里
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.lanswon.service")
@EnableCircuitBreaker
@ComponentScan(value= {"com.lanswon.service","com.lanswon.springcloud"})
@EnableSwagger2
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
