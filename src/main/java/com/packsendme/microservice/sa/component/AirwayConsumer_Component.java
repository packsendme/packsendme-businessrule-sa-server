package com.packsendme.microservice.sa.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AirwayConsumer_Component  implements BREConsumer_Interface  {

	private String airwayMsg; 
	
	@Override
	@KafkaListener(topics = "${kafka.topic.airwaybre}")
	public void receiveTopic(String msg) {
		this.airwayMsg = msg;
		System.out.println(" ---------------------------- ");
		System.out.println(" topic_airway_sa "+ msg);
		System.out.println(" ---------------------------- ");
	}

	@Override
	public String contextMsg() {
		return airwayMsg;
	}
}
