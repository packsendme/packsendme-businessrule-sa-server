package com.packsendme.microservice.sa.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BusinessRule_Component {

private String msg;
	
	@KafkaListener(topics = "${kafka.topic.businessrule}")
	public void receive(String data) {
		this.msg = data;
		System.out.println(" ------------------------------- ");
		System.out.println(" topic_businessrule_sa "+ data);
		System.out.println(" ------------------------------- ");
	}
	
	public String consumerTopic(){
		return msg;
	}

}
