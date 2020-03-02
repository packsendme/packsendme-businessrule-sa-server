package com.packsendme.microservice.sa.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

 
public class BusinessRuleConsumer_Component {

	private String businessRuleMsg; 
	/*
	@KafkaListener(topics = "${kafka.topic.businessrule}")
	public void receiveTopic(String msg) {
		this.businessRuleMsg = msg;
		System.out.println(" ---------------------------- ");
		System.out.println(" topic_businessRule_sa "+ msg);
		System.out.println(" ---------------------------- ");
	}

	public String contextMsg() {
		return businessRuleMsg;
	}
	*/
}
