package com.packsendme.microservice.sa.component;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "#{'${kafka.listener_topics}'.split(',')}")
public class MultiMethodsConsumer_Component {

	public String topic_msg;
	
	@KafkaHandler
	public void consumerTopicBusinessRule(String msg) {
		this.topic_msg = msg;
		System.out.println("Received: " + msg);
	}


}
