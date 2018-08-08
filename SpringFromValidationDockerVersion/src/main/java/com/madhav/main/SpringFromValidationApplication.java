package com.madhav.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.madhav"})
public class SpringFromValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFromValidationApplication.class, args);
	}
}
