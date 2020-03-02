package com.packsendme.microservice.sa.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BusinessRuleConsumer_Component implements BREConsumer_Interface  {

	private String businessRuleMsg; 
	
	@Override
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
