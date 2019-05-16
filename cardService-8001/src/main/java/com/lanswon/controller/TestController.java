package com.lanswon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/usr")
public class TestController {
	

	/**
	 * 	熔断配置，也可以在Feign中的api整合使用，使用springAOP思路
	 * 	@HystrixCommand(fallbackMethod="error")
	 */
	@GetMapping("/test")
	public String test() {
		System.out.println("8001服务");
		return "8001提供服务";
	}
	
	
	public String error() {
		return "8001服务挂了,无法提供服务";
	}

}
