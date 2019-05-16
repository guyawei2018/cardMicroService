package com.lanswon.springcloud.confg;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


//@Configuration //使用feign 可以不用注入restTemplate fegin 会动态代理restTemplate
public class ContentConfig {
	
//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	
}
