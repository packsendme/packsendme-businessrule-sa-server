package com.packsendme.microservice.businessrule.sa.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.microservice.sa.component.AirwayConsumer_Component;
import com.packsendme.microservice.sa.component.BusinessRuleConsumer_Component;
import com.packsendme.microservice.sa.component.MaritimewayConsumer_Component;
import com.packsendme.microservice.sa.component.RoadwayConsumer_Component;

@Service
public class BREConsumer_Service {

	private RoadwayConsumer_Component roadwayConsumer = new RoadwayConsumer_Component(); 
	private AirwayConsumer_Component airwayConsumer = new AirwayConsumer_Component(); 
	private MaritimewayConsumer_Component maritimewayConsumer = new MaritimewayConsumer_Component(); 
	private BusinessRuleConsumer_Component businessruleConsumer = new BusinessRuleConsumer_Component(); 

	
	public ResponseEntity<?> consumerBusinessRuleBRE() {
		Response<String> responseObj = null;
		try {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), businessruleConsumer.contextMsg());
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> consumerMaritimewayBRE() {
		Response<String> responseObj = null;
		try {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), maritimewayConsumer.contextMsg());
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> consumerRoadwayBRE() {
		Response<String> responseObj = null;
		try {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), roadwayConsumer.contextMsg());
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> consumerAirwayBRE() {
		Response<String> responseObj = null;
		try {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), airwayConsumer.contextMsg());
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
