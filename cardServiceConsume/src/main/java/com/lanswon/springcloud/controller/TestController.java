package com.lanswon.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lanswon.service.Service_api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/consume")
@Api(tags= {"测试服务"})
public class TestController {
	
//	private static final String url="http://CARDSERVICE";
//	@Autowired
//	RestTemplate restTemplate;
	
	@Autowired
	Service_api api;
	
	@GetMapping("/test")
	@ApiOperation(value="测试方法")
	public String test() {
		return api.test();
		//return restTemplate.getForObject(url+"/usr/test", String.class);
	}
	

}
