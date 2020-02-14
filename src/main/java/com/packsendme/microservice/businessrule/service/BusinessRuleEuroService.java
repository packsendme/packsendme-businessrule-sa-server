package com.packsendme.microservice.businessrule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.lib.businessrule.model.BusinessRulesModel;
import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.microservice.businessrule.config.Configuration;

@Service
public class BusinessRuleEuroService {
	
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private Configuration configuration;

	
	public ResponseEntity<?> saveBusinessRuleEuro(BusinessRulesModel businessrule) {		
		ObjectMapper mapper = new ObjectMapper();
		Response<String> responseObj = null;

		try {
			String ruleJson = mapper.writeValueAsString(businessrule);
	        this.kafkaTemplate.send(configuration.topic_simulation_europe, ruleJson);
	        responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), ruleJson);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	
}
