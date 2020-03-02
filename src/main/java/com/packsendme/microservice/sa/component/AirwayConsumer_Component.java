package com.packsendme.microservice.sa.component;

public class AirwayConsumer_Component {

	private String airwayMsg; 
	
	/*
	@KafkaListener(topics = "${kafka.topic.airwaybre}")
	public void receiveTopic(String msg) {
		this.airwayMsg = msg;
		System.out.println(" ---------------------------- ");
		System.out.println(" topic_airway_sa "+ msg);
		System.out.println(" ---------------------------- ");
	} */

	public String contextMsg() {
		return airwayMsg;
	}
}
