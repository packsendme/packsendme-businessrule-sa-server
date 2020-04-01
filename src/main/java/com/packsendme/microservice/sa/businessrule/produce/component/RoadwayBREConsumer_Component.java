package com.packsendme.microservice.sa.businessrule.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RoadwayBREConsumer_Component implements BRE_Consumer {

	private String msg;
	
	@KafkaListener(topics = "${kafka.topic.roadwayBRE_SA_Instance}")
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
