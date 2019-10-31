package com.cf;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	
	
	@RequestMapping("/hello2")
	public String hello()
	{
		
		
		return "Hello World,dev tools";
	}

	
	@RequestMapping("/getUser")
	public User getUser()
	{
		User user = new User();
		user.setCreateDate(new Date());
		user.setUserId("001");
		user.setUserName("huabin");
		
		return user;
		
		
	}
}
