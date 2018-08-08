package com.madhav.employeemangodocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.madhav.repository.EmployeeRepository;


@SpringBootApplication
@ComponentScan(basePackages = "com.madhav")
@EnableMongoRepositories(basePackageClasses=EmployeeRepository.class)
public class EmployeeMangoDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMangoDockerApplication.class, args);
	}
}
