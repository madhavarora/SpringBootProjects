package com.madhav.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.madhav.pojo.Email;

/**
 * this is more like a message driven POJO
 * @author madhavarora
 *
 */
@Component
public class Receiver {

	/*
	 * this 
	 */
	@JmsListener(destination="mailbox", containerFactory="myFactory")
	public void receiveMessage(Email email){
		
		System.out.println("Received< "+email+">");
	}
	
}
