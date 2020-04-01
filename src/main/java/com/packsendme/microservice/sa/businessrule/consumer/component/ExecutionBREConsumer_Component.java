package com.packsendme.microservice.sa.businessrule.consumer.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ExecutionBREConsumer_Component implements BRE_Consumer {

	private String msg;
	
	@KafkaListener(topics = "${kafka.topic.executionBRE}")
	public void receive(String data) {
		this.msg = data;
		System.out.println(" ------------------------------- ");
		System.out.println(" topic_executionBRE_sa "+ data);
		System.out.println(" ------------------------------- ");
	}
	
	public String consumerTopic(){
		return msg;
	}

}
