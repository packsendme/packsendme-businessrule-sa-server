package com.packsendme.microservice.sa.businessrule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.packsendme.execution.bre.rule.instance.model.MaritimewayInstanceBRE_Model;
import com.packsendme.maritimeway.bre.rule.model.MaritimewayCostsBRE_Model;
import com.packsendme.microservice.sa.businessrule.service.ConsumerBRE_Service;
import com.packsendme.microservice.sa.businessrule.service.ProduceBRE_Service;

public class Maritimeway_Controller {

	
	@Autowired
	private ProduceBRE_Service produceRuleSA; 
	
	@Autowired
	private ConsumerBRE_Service consumerRuleSA; 
	

	//========================================================================================
	// METHOD POST|GET :: MARITIME-BRE
	//========================================================================================//

	@PostMapping("/topic/instance")
	public ResponseEntity<?> postMaritimewayInstanceBRE_SA(
			@Validated @RequestBody MaritimewayInstanceBRE_Model breObject) {		
		try {
			return produceRuleSA.sendMaritimewayInstanceTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/topic/costs")
	public ResponseEntity<?> postMaritimewayCostsBRE_SA(
			@Validated @RequestBody MaritimewayCostsBRE_Model breObject) {		
		try {
			return produceRuleSA.sendMaritimewayCostsTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/topic/instance")
	public ResponseEntity<?> getMaritimewayInstanceBRE_SA() {		
		try {
			return consumerRuleSA.consumerMaritimewayTopic();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/topic/costs")
	public ResponseEntity<?> getMaritimewayCostsBRE_SA() {		
		try {
			return consumerRuleSA.consumerMaritimewayTopic();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
