package com.madhav.employeedashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class MicroserviceEmployeeDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEmployeeDashboardApplication.class, args);
	}
	
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		
		return builder.build();
	}
}
