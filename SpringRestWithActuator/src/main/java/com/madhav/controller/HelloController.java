package com.madhav.controller;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.madhav.pojo.Greeting;

@Controller
public class HelloController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/helloWorld")
	@ResponseBody
	public Greeting sayHello(String name){

		return new Greeting(counter.incrementAndGet(), String.format(template, name));
}
	
}

