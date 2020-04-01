package com.packsendme.microservice.sa.businessrule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.packsendme.airway.bre.rule.model.AirwayCostsBRE_Model;
import com.packsendme.execution.bre.rule.instance.model.AirwayInstanceBRE_Model;
import com.packsendme.microservice.sa.businessrule.service.ConsumerBRE_Service;
import com.packsendme.microservice.sa.businessrule.service.ProduceBRE_Service;

//@RestController
//@RequestMapping("/bre/sa/airway")
public class AirwayBRE_Controller {

	
	@Autowired
	private ProduceBRE_Service produceRuleSA; 
	
	@Autowired
	private ConsumerBRE_Service consumerRuleSA; 
	

	//========================================================================================
	// METHOD POST|GET :: AIRWAY-BRE
	//========================================================================================//

	@PostMapping("/topic/instance")
	public ResponseEntity<?> postAirwayInstanceBRE_SA(
			@Validated @RequestBody AirwayInstanceBRE_Model breObject) {		
		try {
			return produceRuleSA.sendAirwayInstanceTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/topic/costs")
	public ResponseEntity<?> postAirwayCostsBRE_SA(
			@Validated @RequestBody AirwayCostsBRE_Model breObject) {		
		try {
			return produceRuleSA.sendAirwayCostsTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/topic/instance")
	public ResponseEntity<?> getAirwayInstanceBRE_SA() {		
		try {
			return consumerRuleSA.consumerAirwayTopic();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/topic/costs")
	public ResponseEntity<?> getAirwayCostsBRE_SA() {		
		try {
			return consumerRuleSA.consumerAirwayTopic();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
