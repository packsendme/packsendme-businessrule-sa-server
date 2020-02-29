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
import com.packsendme.lib.businessrule.model.BusinessRulesModel;
import com.packsendme.microservice.businessrule.sa.service.BusinessRuleConsumerSenderService;
import com.packsendme.microservice.businessrule.sa.service.ProduceSenderService;

@RestController
public class BusinessRuleController {

	
	@Autowired
	private ProduceSenderService produceRuleSA; 
	
	@Autowired
	private BusinessRuleConsumerSenderService consumerRuleSA; 
	
	@PostMapping("/businessrule/sa")
	public ResponseEntity<?> postBusinessRuleBRE_SA(
			@Validated @RequestBody BusinessRulesModel brObject) {		
		try {
			return produceRuleSA.sendBusinessRule(brObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(brObject, HttpStatus.INTERNAL_SERVER_ERROR);
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
	
	@PostMapping("/businessrule/sa/roadway")
	public ResponseEntity<?> postRoadwayBRE_SA(
			@Validated @RequestBody BusinessRulesModel brObject) {		
		try {
			return produceRuleSA.sendRoadway(brObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(brObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/businessrule/sa/airway")
	public ResponseEntity<?> postAirwayBRE_SA(
			@Validated @RequestBody BusinessRulesModel brObject) {		
		try {
			return produceRuleSA.sendRoadway(brObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(brObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/businessrule/sa/maritime")
	public ResponseEntity<?> postMaritimewayBRE_SA(
			@Validated @RequestBody BusinessRulesModel brObject) {		
		try {
			return produceRuleSA.sendRoadway(brObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(brObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
