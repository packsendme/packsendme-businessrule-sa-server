package com.packsendme.microservice.businessrule.sa.service;

import org.springframework.kafka.annotation.KafkaListener;

public class ConsumerMsg {
	
	@KafkaListener(topics = "${packsendme-businessrule-sa-server.roadwaybre}")
	public void receive(String data) {
		System.out.println(" ------------------------------- ");
		System.out.println(" topic_businessRule_sa "+ data);
		System.out.println(" ------------------------------- ");
	}

}