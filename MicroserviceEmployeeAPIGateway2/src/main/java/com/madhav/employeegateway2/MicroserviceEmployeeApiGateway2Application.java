package com.madhav.employeegateway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class MicroserviceEmployeeApiGateway2Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEmployeeApiGateway2Application.class, args);
	}
}
