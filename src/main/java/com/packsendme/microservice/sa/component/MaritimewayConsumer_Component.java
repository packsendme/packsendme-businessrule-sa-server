package com.packsendme.microservice.sa.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MaritimewayConsumer_Component implements BREConsumer_Interface  {

	private String maritimewayMsg;
	
	@Override
	@KafkaListener(topics = "${kafka.topic.maritimewaybre}")
	public void receiveTopic(String msg) {
		this.maritimewayMsg = msg;
		System.out.println(" ---------------------------- ");
		System.out.println(" topic_maritimeway_sa "+ msg);
		System.out.println(" ---------------------------- ");
	}

	@Override
	public String contextMsg() {
		return maritimewayMsg;
	}

}
