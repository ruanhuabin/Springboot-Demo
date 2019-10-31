package com.cf;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String hello()
	{
		
		return "Hello World";
	}

	
	@RequestMapping("indexJsp")
	public String index(Map<String, Object> map)
	{
		
		map.put("hello", "ruanhuabin");
		return "index";
	}
}
