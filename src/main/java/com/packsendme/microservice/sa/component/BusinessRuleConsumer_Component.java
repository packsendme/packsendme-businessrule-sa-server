package com.packsendme.microservice.sa.component;

import org.springframework.kafka.annotation.KafkaListener;


public class BusinessRuleConsumer_Component implements BREConsumer_Interface  {

	private String businessRuleMsg; 
	
	@KafkaListener(topics = "${kafka.topic.businessrule}")
	public void receiveTopic(String msg) {
		this.businessRuleMsg = msg;
		System.out.println(" ---------------------------- ");
		System.out.println(" topic_businessRule_sa "+ msg);
		System.out.println(" ---------------------------- ");
	}

	@Override
	public String contextMsg() {
		return businessRuleMsg;
	}
}
