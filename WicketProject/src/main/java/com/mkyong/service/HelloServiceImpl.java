package com.mkyong.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl {
	
	public String getHelloWorldMsg() {
		return "Integration with Spring : hello world";
	}

}
