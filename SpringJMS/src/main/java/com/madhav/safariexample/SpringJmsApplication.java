package com.madhav.safariexample;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.madhav.pojo.Email;

@SpringBootApplication
@EnableJms
@ComponentScan({"com.madhav"})
public class SpringJmsApplication {

	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer){
		
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		//at this poing we can set some values to the default factory
		//factory.set
		configurer.configure(factory, connectionFactory);
		return factory;
	}
	
	
	@Bean
	public MessageConverter jacksonJmsMessageConverter(){
		
		MappingJackson2MessageConverter converter  = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context  =  SpringApplication.run(SpringJmsApplication.class, args);
		JmsTemplate template = context.getBean(JmsTemplate.class);
		
		System.out.println("sending a message ");
		template.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
		
	}
}
