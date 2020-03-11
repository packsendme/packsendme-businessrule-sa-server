package com.packsendme.microservice.sa.businessrule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.packsendme.airway.bre.rule.model.AirwayBRE_Model;
import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;
import com.packsendme.maritimeway.bre.rule.model.MaritimewayBRE_Model;
import com.packsendme.microservice.sa.businessrule.service.ConsumerBRE_Service;
import com.packsendme.microservice.sa.businessrule.service.ProduceBRE_Service;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;

@RestController
@RequestMapping("/businessrule/sa/bre")
public class BusinessRule_Controller {

	
	@Autowired
	private ProduceBRE_Service produceRuleSA; 
	
	@Autowired
	private ConsumerBRE_Service consumerRuleSA; 
	

	// Method POST/GET :: BusinessRule BRE
	
	@PostMapping("/execution")
	public ResponseEntity<?> postExecuteBRE_SA(
			@Validated @RequestBody ExecutionBRE_Model breObject) {		
		try {
			return produceRuleSA.sendExecutionTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/execution")
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

	@PostMapping("/roadway")
	public ResponseEntity<?> postRoadwayBRE_SA(
			@Validated @RequestBody RoadwayBRE_Model breObject) {		
		try {
			return produceRuleSA.sendRoadwayTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/roadway")
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
	@PostMapping("/airway")
	public ResponseEntity<?> postAirwayBRE_SA(
			@Validated @RequestBody AirwayBRE_Model breObject) {		
		try {
			return produceRuleSA.sendAirwayTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/airway")
	public ResponseEntity<?> getAirwayBRE_SA() {		
		try {
			return consumerRuleSA.consumerAirwayTopic();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// METHOD POST/GET :: MARITIME BRE
	@PostMapping("/maritime")
	public ResponseEntity<?> postMaritimewayBRE_SA(
			@Validated @RequestBody MaritimewayBRE_Model breObject) {		
		try {
			return produceRuleSA.sendMaritimewayTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/maritime")
	public ResponseEntity<?> getMaritimewayBRE_SA() {		
		try {
			return consumerRuleSA.consumerMaritimewayTopic();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
