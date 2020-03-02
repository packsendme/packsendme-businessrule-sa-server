package com.packsendme.microservice.sa.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MultiMethodsConsumer_Component {

	public String topic_msg;
	
	@KafkaListener(topics = "#{'${spring.kafka.listener_topics}'.split(',')}")
	public void consumerTopicBusinessRule(String msg) {
		System.out.println(" ============================");
		System.out.println(" consumerTopicBusinessRule "+ msg);
		System.out.println(" ============================");
		this.topic_msg = msg;
	}


}
