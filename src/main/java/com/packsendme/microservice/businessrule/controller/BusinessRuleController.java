package com.packsendme.microservice.businessrule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.packsendme.lib.businessrule.model.BusinessRulesModel;
import com.packsendme.microservice.businessrule.service.BusinessRuleEuaService;
import com.packsendme.microservice.businessrule.service.BusinessRuleEuroService;
import com.packsendme.microservice.businessrule.service.BusinessRuleSAService;


@RestController
public class BusinessRuleController {

	
	@Autowired
	private BusinessRuleSAService businessRuleSA; 

	@Autowired
	private BusinessRuleEuroService businessRuleEuro;
	
	@Autowired
	private BusinessRuleEuaService businessRuleEua;
	
	
	@PostMapping("/businessrule/sa")
	public ResponseEntity<?> postBusinessRuleSouthAmerica(
			@Validated @RequestBody BusinessRulesModel businessruleSA) {		
		return businessRuleSA.saveBusinessRuleSA(businessruleSA);
	}
	
	@PostMapping("/businessrule/euro")
	public ResponseEntity<?> postBusinessRuleEurope(
			@Validated @RequestBody BusinessRulesModel businessruleEuro) {		
		return businessRuleEuro.saveBusinessRuleEuro(businessruleEuro);
	}
	
	@PostMapping("/businessrule/eua")
	public ResponseEntity<?> postBusinessRuleAmerica(
			@Validated @RequestBody BusinessRulesModel businessruleEua) {		
		return businessRuleEua.saveBusinessRuleEua(businessruleEua);
	}


}
