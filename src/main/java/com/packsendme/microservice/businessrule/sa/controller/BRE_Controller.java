package com.packsendme.microservice.businessrule.sa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.packsendme.lib.bre.airway.model.AirwayBRE_Model;
import com.packsendme.lib.bre.execution.model.Execution_Model;
import com.packsendme.lib.bre.maritimeway.model.MaritimewayBRE_Model;
import com.packsendme.lib.bre.roadway.model.RoadwayBRE_Model;
import com.packsendme.microservice.businessrule.sa.service.ConsumerBRE_Service;
import com.packsendme.microservice.businessrule.sa.service.ProduceBRE_Service;

@RestController("/businessrule/sa")
public class BRE_Controller {

	
	@Autowired
	private ProduceBRE_Service produceRuleSA; 
	
	@Autowired
	private ConsumerBRE_Service consumerRuleSA; 
	

	// Method POST/GET :: BusinessRule BRE
	
	@PostMapping("/executionbre")
	public ResponseEntity<?> postExecuteBRE_SA(
			@Validated @RequestBody Execution_Model breObject) {		
		try {
			return produceRuleSA.sendExecutionTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping("/executionbre")
	public ResponseEntity<?> getBusinessRuleBRE_SA() {		
		try {
			System.out.println(" getBusinessRuleSouthAmerica ");
			return consumerRuleSA.consumerExecutionTopic();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	// METHOD POST/GET :: ROADWAY BRE

	@PostMapping("/roadwaybre")
	public ResponseEntity<?> postRoadwayBRE_SA(
			@Validated @RequestBody RoadwayBRE_Model breObject) {		
		try {
			return produceRuleSA.sendRoadwayTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/roadwaybre")
	public ResponseEntity<?> getRoadwayBRE_SA() {		
		try {
			System.out.println(" getRoadwayBRE_SA ");
			return consumerRuleSA.consumerRoadwayTopic();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// METHOD POST/GET :: AIRWAY BRE
	@PostMapping("/airwaybre")
	public ResponseEntity<?> postAirwayBRE_SA(
			@Validated @RequestBody AirwayBRE_Model breObject) {		
		try {
			return produceRuleSA.sendAirwayTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/airwaybre")
	public ResponseEntity<?> getAirwayBRE_SA() {		
		try {
			return consumerRuleSA.consumerAirwayTopic();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// METHOD POST/GET :: MARITIME BRE
	@PostMapping("/maritimebre")
	public ResponseEntity<?> postMaritimewayBRE_SA(
			@Validated @RequestBody MaritimewayBRE_Model breObject) {		
		try {
			return produceRuleSA.sendMaritimewayTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/maritimebre")
	public ResponseEntity<?> getMaritimewayBRE_SA() {		
		try {
			return consumerRuleSA.consumerMaritimewayTopic();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
