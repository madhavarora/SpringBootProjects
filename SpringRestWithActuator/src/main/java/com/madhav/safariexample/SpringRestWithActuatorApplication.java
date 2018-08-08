package com.madhav.safariexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.madhav")
public class SpringRestWithActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestWithActuatorApplication.class, args);
	}
}
