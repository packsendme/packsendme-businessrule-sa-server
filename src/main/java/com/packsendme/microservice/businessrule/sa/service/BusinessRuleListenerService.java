package com.packsendme.microservice.businessrule.sa.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BusinessRuleListenerService {

	@KafkaListener(topics = "${configuration:topic_simulation_southamerica}")
    public void receive(String data) {
		System.out.println(" ---------------------------- ");
		System.out.println(" BusinessRuleListenerService "+ data);
		System.out.println(" ---------------------------- ");
	}
}
