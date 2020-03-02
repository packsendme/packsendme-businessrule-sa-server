package com.packsendme.microservice.sa.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RoadwayConsumer_Component implements BREConsumer_Interface {
	
	private String roadwayMsg;

	@KafkaListener(topics = "${kafka.topic.roadwaybre}")
	public void receiveTopic(String msg) {
		this.roadwayMsg = msg;
		System.out.println(" ---------------------------- ");
		System.out.println(" topic_roadway_sa "+ msg);
		System.out.println(" ---------------------------- ");
	}

	@Override
	public String contextMsg() {
		return roadwayMsg;
	}

}
