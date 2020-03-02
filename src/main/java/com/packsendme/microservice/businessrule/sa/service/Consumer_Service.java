package com.packsendme.microservice.businessrule.sa.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;

@Service
public class Consumer_Service {

	//private RoadwayConsumer_Component roadwayConsumer = new RoadwayConsumer_Component(); 
	//private AirwayConsumer_Component airwayConsumer = new AirwayConsumer_Component(); 
	//private MaritimewayConsumer_Component maritimewayConsumer = new MaritimewayConsumer_Component(); 
	//private BusinessRuleConsumer_Component businessruleConsumer = new BusinessRuleConsumer_Component(); 
	//private BusinessRuleConsumer_Component businessruleConsumer = new BusinessRuleConsumer_Component();

	public String airwayMsg;
	
	@KafkaListener(topics = "${kafka.topic.businessrule}")
	public void listen(String message) {
		airwayMsg = message;
		System.out.println(" ------------------------------- ");
		System.out.println(" topic_businessRule_sa "+ message);
		System.out.println(" ------------------------------- ");
	}
	
	public  ResponseEntity<?>  contextMsg() {
		Response<String> responseObj = null;
		try {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), airwayMsg);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}
