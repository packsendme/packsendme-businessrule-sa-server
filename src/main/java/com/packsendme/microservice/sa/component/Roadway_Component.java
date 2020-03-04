package com.packsendme.microservice.sa.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Roadway_Component {

private String msg;
	
	@KafkaListener(topics = "${kafka.topic.roadway}")
	public void receive(String data) {
		this.msg = data;
		System.out.println(" ------------------------------- ");
		System.out.println(" topic_roadway_sa "+ data);
		System.out.println(" ------------------------------- ");
	}
	
	public String consumerTopic(){
		return msg;
	}

}
