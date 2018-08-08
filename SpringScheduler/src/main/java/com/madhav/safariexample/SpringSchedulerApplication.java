package com.madhav.safariexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.madhav.scheduler")
public class SpringSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedulerApplication.class, args);
	}
}
