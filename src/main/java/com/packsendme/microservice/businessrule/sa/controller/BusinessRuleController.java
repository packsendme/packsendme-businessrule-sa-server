package com.packsendme.microservice.businessrule.sa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.packsendme.lib.businessrule.model.BusinessRulesModel;
import com.packsendme.microservice.businessrule.sa.service.ProduceSenderBRService;


@RestController
public class BusinessRuleController {

	
	@Autowired
	private ProduceSenderBRService businessRuleSA; 

	
	@PostMapping("/businessrule/sa")
	public ResponseEntity<?> postBusinessRuleSouthAmerica(
			@Validated @RequestBody BusinessRulesModel businessruleSA) {		
		 businessRuleSA.sendMessage("Ricardo");
		return new ResponseEntity<>("SUCCESS", HttpStatus.FOUND);
	}
}
