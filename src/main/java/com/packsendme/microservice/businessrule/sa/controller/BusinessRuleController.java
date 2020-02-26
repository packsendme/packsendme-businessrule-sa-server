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
import com.packsendme.microservice.businessrule.sa.service.ConsumerSenderBRService;
import com.packsendme.microservice.businessrule.sa.service.ProduceSenderBRService;

@RestController
public class BusinessRuleController {

	
	@Autowired
	private ProduceSenderBRService produceRuleSA; 
	
	@Autowired
	private ConsumerSenderBRService consumerRuleSA; 
	
	@PostMapping("/businessrule/sa")
	public ResponseEntity<?> postBusinessRuleSouthAmerica(
			@Validated @RequestBody BusinessRulesModel brObject) {		
		try {
			return produceRuleSA.sendMessage(brObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(brObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/businessrule/sa")
	public ResponseEntity<?> getBusinessRuleSouthAmerica() {		
		try {
			System.out.println(" getBusinessRuleSouthAmerica ");
			return consumerRuleSA.consumerMessage();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
