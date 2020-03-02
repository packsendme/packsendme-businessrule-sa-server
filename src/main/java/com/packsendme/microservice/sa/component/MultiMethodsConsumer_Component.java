package com.packsendme.microservice.sa.component;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@KafkaListener(topics = "#{'${kafka.listener_topics}'.split(',')}")
public class MultiMethodsConsumer_Component {

	public String topic_msg;
	
	@KafkaHandler
	public void consumerTopicBusinessRule(String msg) {
		System.out.println(" ============================");
		System.out.println(" consumerTopicBusinessRule "+ msg);
		System.out.println(" ============================");
		this.topic_msg = msg;
	}


}
