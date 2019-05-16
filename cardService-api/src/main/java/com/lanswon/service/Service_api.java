package com.lanswon.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
//需要在消费端开启 feign: hystrix: enabled: true
@FeignClient(name="CARDSERVICE",fallbackFactory=HystrixClientFallbackFactory .class)
public interface Service_api {

	@GetMapping("/usr/test")
	public String test();

}
