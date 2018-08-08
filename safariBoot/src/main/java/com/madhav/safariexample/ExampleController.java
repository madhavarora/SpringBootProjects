package com.madhav.safariexample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

	
	@RequestMapping("/hello")
	public String hello(){
		return "Hello There";
	}
}
