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
import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;
import com.packsendme.microservice.sa.businessrule.service.ConsumerBRE_Service;
import com.packsendme.microservice.sa.businessrule.service.ProduceBRE_Service;

@RestController
@RequestMapping("/businessrule/sa/execute")
public class Execute_Controller {

	
	@Autowired
	private ProduceBRE_Service produceRuleSA; 
	
	@Autowired
	private ConsumerBRE_Service consumerRuleSA; 
	

	//========================================================================================
	// METHOD POST|GET :: EXECUTION-BRE
	//========================================================================================//

	@PostMapping("/topic/execution")
	public ResponseEntity<?> postExecuteBRE_SA(
			@Validated @RequestBody ExecutionBRE_Model breObject) {		
		try {
			return produceRuleSA.sendExecutionTopic(breObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(breObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/topic/execution")
	public ResponseEntity<?> getBusinessRuleBRE_SA() {		
		try {
			System.out.println(" getBusinessRuleSouthAmerica ");
			return consumerRuleSA.consumerExecutionTopic();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
