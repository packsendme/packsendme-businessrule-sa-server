package com.packsendme.microservice.businessrule.sa.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;

@Service
public class RoadwayBREConsumer_Service {

	private String roadwayJson;
	
	@KafkaListener(topics = "${topicConf:topic_roadway_bre_sa}")
    public void receive(String data) {
		this.roadwayJson = data;
		System.out.println(" ---------------------------- ");
		System.out.println(" topic_roadway_sa "+ data);
		System.out.println(" ---------------------------- ");
	}
	
	public ResponseEntity<?> consumerMessage() {
		Response<String> responseObj = null;
		try {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), roadwayJson);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
