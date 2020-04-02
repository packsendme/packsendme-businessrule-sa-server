package com.packsendme.microservice.sa.businessrule.consumer.component;

import org.springframework.stereotype.Component;

@Component
public class AirwayBREConsumer_Component implements BRE_Consumer{

	private String msg;
	
//	@KafkaListener(topics = "${kafka.topic.airwayBRE_SA_Instance}")
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
