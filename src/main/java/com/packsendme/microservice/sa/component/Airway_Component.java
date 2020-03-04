package com.packsendme.microservice.sa.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Airway_Component {

private String msg;
	
	@KafkaListener(topics = "${kafka.topic.airway}")
	public void receive(String data) {
		this.msg = data;
		System.out.println(" ------------------------------- ");
		System.out.println(" topic_airway_sa "+ data);
		System.out.println(" ------------------------------- ");
	}
	
	public String consumerTopic(){
		return msg;
	}

}
