package com.packsendme.microservice.sa.component;

import org.springframework.stereotype.Component;

 
public class RoadwayConsumer_Component {
	
	private String roadwayMsg;

	/*
	@KafkaListener(topics = "${kafka.topic.roadwaybre}")
	public void receiveTopic(String msg) {
		this.roadwayMsg = msg;
		System.out.println(" ---------------------------- ");
		System.out.println(" topic_roadway_sa "+ msg);
		System.out.println(" ---------------------------- ");
	} */

	public String contextMsg() {
		return roadwayMsg;
	}

}
