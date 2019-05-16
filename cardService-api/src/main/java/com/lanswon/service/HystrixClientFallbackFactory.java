package com.lanswon.service;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

//必须要此注解，否则无法使用熔断功能
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<Service_api>{

	
	@Override
	public Service_api create(Throwable cause) {
		
		return new Service_api() {
			
			@Override
			public String test() {
				return "服务中断";
			}
		};
	}

}
