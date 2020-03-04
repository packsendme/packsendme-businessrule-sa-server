package com.packsendme.microservice.businessrule.sa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.lib.bre.businessrule.model.BusinessRules_Model;
import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.microservice.sa.component.Airway_Component;
import com.packsendme.microservice.sa.component.BusinessRule_Component;
import com.packsendme.microservice.sa.component.Maritimeway_Component;
import com.packsendme.microservice.sa.component.Roadway_Component;

@Service
public class ConsumerBRE_Service {
	

	@Autowired
	private Airway_Component airwayConsumer;
	
	@Autowired
	private Roadway_Component roadwayConsumer;
	
	@Autowired
	private BusinessRule_Component businessRuleConsumer;
	
	@Autowired
	private Maritimeway_Component maritimewayConsumer;
	
	
	public ResponseEntity<?> consumerBusinessRuleTopic() {
		Response<String> responseObj = null;
		try {
			String msgTopic = businessRuleConsumer.consumerTopic();
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), msgTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> consumerAirwayTopic() {
		Response<String> responseObj = null;
		try {
			String msgTopic = airwayConsumer.consumerTopic();
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), msgTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> consumerMaritimewayTopic() {
		Response<String> responseObj = null;
		try {
			String msgTopic = maritimewayConsumer.consumerTopic();
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), msgTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public ResponseEntity<?> consumerRoadwayTopic() {
		Response<String> responseObj = null;
		try {
			String msgTopic = roadwayConsumer.consumerTopic();
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), msgTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
