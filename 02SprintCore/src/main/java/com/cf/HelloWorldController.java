package com.cf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Value("${test.user}")
	private String name;
	
	@Value("${test.age}")
	private int age;
	
	@RequestMapping("/hello")
	public String hello()
	{
		System.out.println("!!!!!huabin's name = " + name + ", age = " + age);
		
		return "!!!!!!!!!!!!!!Hello World, ruanhuabin!!!!!!";
	}

}
