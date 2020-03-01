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
import com.packsendme.lib.bre.businessrule.model.BusinessRules_Model;
import com.packsendme.lib.bre.maritimeway.model.MaritimewayBRE_Model;
import com.packsendme.lib.bre.roadway.model.RoadwayBRE_Model;
import com.packsendme.microservice.businessrule.sa.service.AirwayBREConsumer_Service;
import com.packsendme.microservice.businessrule.sa.service.BusinessRuleConsumer_Service;
import com.packsendme.microservice.businessrule.sa.service.GenericBREProduce_Service;
import com.packsendme.microservice.businessrule.sa.service.MaritimewayBREConsumer_Service;
import com.packsendme.microservice.businessrule.sa.service.RoadwayBREConsumer_Service;

@RestController
public class BusinessRuleSA_Controller {

	
	@Autowired
	private GenericBREProduce_Service produceRuleSA; 
	
	@Autowired
	private BusinessRuleConsumer_Service consumerRuleSA; 
	
	@Autowired
	private RoadwayBREConsumer_Service roadwayConsumer;
	
	@Autowired
	private AirwayBREConsumer_Service airwayConsumer;
	
	@Autowired
	private MaritimewayBREConsumer_Service maritimewayConsumer;

	
	// Method POST/GET :: BusinessRule BRE
	
	@PostMapping("/businessrule/sa")
	public ResponseEntity<?> postBusinessRuleBRE_SA(
			@Validated @RequestBody BusinessRules_Model breObject) {		
		try {
			return produceRuleSA.sendBusinessRule(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/businessrule/sa")
	public ResponseEntity<?> getBusinessRuleBRE_SA() {		
		try {
			System.out.println(" getBusinessRuleSouthAmerica ");
			return consumerRuleSA.consumerMessage();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// METHOD POST/GET :: ROADWAY BRE

	@PostMapping("/businessrule/sa/roadway")
	public ResponseEntity<?> postRoadwayBRE_SA(
			@Validated @RequestBody RoadwayBRE_Model breObject) {		
		try {
			return produceRuleSA.sendRoadway(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/businessrule/sa/roadway")
	public ResponseEntity<?> getRoadwayBRE_SA() {		
		try {
			System.out.println(" getRoadwayBRE_SA ");
			return roadwayConsumer.consumerMessage();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// METHOD POST/GET :: AIRWAY BRE

	@PostMapping("/businessrule/sa/airway")
	public ResponseEntity<?> postAirwayBRE_SA(
			@Validated @RequestBody AirwayBRE_Model breObject) {		
		try {
			return produceRuleSA.sendAirway(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
/*
	@GetMapping("/businessrule/sa/airway")
	public ResponseEntity<?> getAirwayBRE_SA() {		
		try {
			return airwayConsumer.consumerMessage();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
	// METHOD POST/GET :: MARITIME BRE

	@PostMapping("/businessrule/sa/maritime")
	public ResponseEntity<?> postMaritimewayBRE_SA(
			@Validated @RequestBody MaritimewayBRE_Model breObject) {		
		try {
			return produceRuleSA.sendMaritimeway(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/*
	@GetMapping("/businessrule/sa/maritime")
	public ResponseEntity<?> getMaritimewayBRE_SA() {		
		try {
			return maritimewayConsumer.consumerMessage();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
*/
}
