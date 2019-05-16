package com.lanswon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usr")
public class TestController {
	
	@GetMapping("/test")
	public String test() {
		long time=5;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("8002服务");
		return "8002提供服务";
	}

}
