package com.packsendme.microservice.businessrule.sa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.microservice.sa.component.MultiMethodsConsumer_Component;

@Service
public class BusinessRuleConsumer_Service {

	private String businessruleJson;
	
	@Autowired
	private MultiMethodsConsumer_Component multiConsumer; 
	
	/*
	//@KafkaListener(topics = "${topicConfig:topic_businessrule_sa}")
	@KafkaListener(topics = "${packsendme-businessrule-sa-server.topic_businessrule_sa}")
    public void receive(String data) {
		this.businessruleJson = data;
		System.out.println(" ---------------------------- ");
		System.out.println(" BusinessRuleListenerService "+ data);
		System.out.println(" ---------------------------- ");
	}*/
	
	public ResponseEntity<?> consumerMessage() {
		Response<String> responseObj = null;
		try {
			System.out.println(" receiveRoadyay "+ multiConsumer.topic_msg);
			
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), businessruleJson);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}