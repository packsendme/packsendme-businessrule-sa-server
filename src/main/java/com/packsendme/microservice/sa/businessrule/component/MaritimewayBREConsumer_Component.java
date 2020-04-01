	package com.packsendme.microservice.sa.businessrule.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MaritimewayBREConsumer_Component implements BRE_Consumer {

	private String msg;
	
	@KafkaListener(topics = "${kafka.topic.maritimewayBRE}")
	public void receive(String data) {
		this.msg = data;
		System.out.println(" ------------------------------- ");
		System.out.println(" topic_maritimeway_sa "+ data);
		System.out.println(" ------------------------------- ");
	}
	
	public String consumerTopic(){
		return msg;
	}

}
