package com.packsendme.microservice.sa.component;

import org.springframework.stereotype.Component;

 
public class MaritimewayConsumer_Component {

	private String maritimewayMsg;
	/*
	@KafkaListener(topics = "${kafka.topic.maritimewaybre}")
	public void receiveTopic(String msg) {
		this.maritimewayMsg = msg;
		System.out.println(" ---------------------------- ");
		System.out.println(" topic_maritimeway_sa "+ msg);
		System.out.println(" ---------------------------- ");
	} */

 
	public String contextMsg() {
		return maritimewayMsg;
	}

}
