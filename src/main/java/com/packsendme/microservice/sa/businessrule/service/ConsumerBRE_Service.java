package com.packsendme.microservice.sa.businessrule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.microservice.sa.businessrule.component.AirwayBREConsumer_Component;
import com.packsendme.microservice.sa.businessrule.component.ExecutionBREConsumer_Component;
import com.packsendme.microservice.sa.businessrule.component.MaritimewayBREConsumer_Component;
import com.packsendme.microservice.sa.businessrule.component.RoadwayBREConsumer_Component;

@Service
@ComponentScan({"com.packsendme.microservice.sa.component"})
public class ConsumerBRE_Service {
	
	@Autowired
	private AirwayBREConsumer_Component airwayConsumer;
	
	@Autowired
	private RoadwayBREConsumer_Component roadwayConsumer;
	
	@Autowired
	private ExecutionBREConsumer_Component executionConsumer;
	
	@Autowired
	private MaritimewayBREConsumer_Component maritimewayConsumer;
	
	
	public ResponseEntity<?> consumerExecutionTopic() {
		Response<String> responseObj = null;
		try {
				String msgTopic = executionConsumer.consumerTopic();
				responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), msgTopic);
				return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> consumerAirwayTopic() {
		Response<String> responseObj = null;
		try {
			String msgTopic = airwayConsumer.consumerTopic();
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), msgTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> consumerMaritimewayTopic() {
		Response<String> responseObj = null;
		try {
			String msgTopic = maritimewayConsumer.consumerTopic();
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), msgTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public ResponseEntity<?> consumerRoadwayTopic() {
		Response<String> responseObj = null;
		try {
			String msgTopic = roadwayConsumer.consumerTopic();
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), msgTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
