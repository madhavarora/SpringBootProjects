package com.madhav.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.madhav.dao.Quote;

@SpringBootApplication
public class SpringRestClientApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringRestClientApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRestClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		
		return builder.build();
		
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate){
		
		
		return args -> {
			Quote quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};
		
		
		
	}
	
	
}
