package com.packsendme.microservice.sa.businessrule.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.airway.bre.rule.model.AirwayBRE_Model;
import com.packsendme.exchange.bre.model.ExchangeBRE_Model;
import com.packsendme.exchange.bre.model.ExchangeCountryBRE_Model;
import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;
import com.packsendme.financecostdelivery.bre.model.FinanceCostDeliveryBRE_Model;
import com.packsendme.fuel.bre.rule.model.FuelBRE_Model;
import com.packsendme.lib.common.constants.generic.HttpExceptionPackSend;
import com.packsendme.lib.common.constants.generic.MicroservicesConstants;
import com.packsendme.lib.common.response.Response;
import com.packsendme.maritimeway.bre.rule.model.MaritimewayBRE_Model;
import com.packsendme.microservice.sa.businessrule.component.RoadwayConvert;
import com.packsendme.microservice.sa.businessrule.component.ParserData_Component;
import com.packsendme.microservice.sa.businessrule.config.Cache_Config;
import com.packsendme.microservice.sa.businessrule.controller.IExchange;
import com.packsendme.microservice.sa.businessrule.dao.BusinessRuleImpl_DAO;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;
import com.packsendme.tollsfuel.bre.model.TollsFuelBRE_Model;

@Service
@ComponentScan("{com.packsendme.microservice.sa.businessrule.dao,"
		+ "com.packsendme.microservice.sa.businessrule.component}")
@EnableFeignClients(basePackages="com.packsendme.microservice.sa.businessrule.controller")
public class BusinessRule_Services {
	
	public enum Operation_Enum {
		GET, POST, DELETE;
	}
	
	@Autowired
	Cache_Config cacheConfig;
	
	@Autowired
	BusinessRuleImpl_DAO<AirwayBRE_Model> airwayBREImpl_DAO;
	@Autowired
	BusinessRuleImpl_DAO<MaritimewayBRE_Model> maritimewayBREImpl_DAO;
	@Autowired
	BusinessRuleImpl_DAO<ExecutionBRE_Model> executeBREImpl_DAO;
	@Autowired
	BusinessRuleImpl_DAO<FuelBRE_Model> fuelBREImpl_DAO;
	@Autowired
	BusinessRuleImpl_DAO<FinanceCostDeliveryBRE_Model> financeCostDeliveryImpl_DAO;
	
	@Autowired
	IExchange exchangeRate_Client;
	
	@Autowired
	private ParserData_Component parserData;
	@Autowired
	private RoadwayConvert convertCurrent;
	
	
	
	public ResponseEntity<?> executeOperation(String name_rule, ExecutionBRE_Model executionBRE, String operation) {
		Response<ExecutionBRE_Model> responseObj = null;
		ExecutionBRE_Model executionObj = null;
		boolean result;
		
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 executionObj = executeBREImpl_DAO.findOne(cacheConfig.executeBRE_SA,name_rule);
				 if(executionObj != null) {
					 responseObj = new Response<ExecutionBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), executionObj);
				 }
				 else {
					 responseObj = new Response<ExecutionBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 result = executeBREImpl_DAO.delete(cacheConfig.executeBRE_SA,name_rule);
				 if(result == true) {
					 responseObj = new Response<ExecutionBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<ExecutionBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 result = executeBREImpl_DAO.add(cacheConfig.executeBRE_SA,executionBRE.name_rule,executionBRE);

				 if(result == true) {
					 responseObj = new Response<ExecutionBRE_Model>(HttpExceptionPackSend.BUSINESS_RULE.value(),HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<ExecutionBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			responseObj = new Response<ExecutionBRE_Model>(HttpExceptionPackSend.FAIL_EXECUTION.value(),HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	public ResponseEntity<?> airwayOperation(String name_rule, AirwayBRE_Model airway, String operation, Map headInformation) {
		Response<AirwayBRE_Model> responseObj = null;
		AirwayBRE_Model airwayObj = null;
		boolean result;
		
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 airwayObj = airwayBREImpl_DAO.findOne(cacheConfig.airwayBRE_SA,name_rule);
				 
				 if(airwayObj != null) {
					 responseObj = new Response<AirwayBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), airwayObj);
				 }
				 else {
					 responseObj = new Response<AirwayBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 result = airwayBREImpl_DAO.delete(cacheConfig.airwayBRE_SA,name_rule);

				 if(result == true) {
					 responseObj = new Response<AirwayBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<AirwayBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 result = airwayBREImpl_DAO.add(cacheConfig.airwayBRE_SA,airway.name_rule,airway);
				 
				 if(result == true) {
					 responseObj = new Response<AirwayBRE_Model>(HttpExceptionPackSend.BUSINESS_RULE.value(),HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<AirwayBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<AirwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> maritimewayOperation(String name_rule, MaritimewayBRE_Model maritimeway, String operation, Map headInformation) {
		Response<MaritimewayBRE_Model> responseObj = null;
		MaritimewayBRE_Model maritimewayObj = null;
		boolean result;
		
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 maritimewayObj = maritimewayBREImpl_DAO.findOne(cacheConfig.maritimewayBRE_SA,name_rule);
				 
				 if(maritimewayObj != null) {
					 responseObj = new Response<MaritimewayBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), maritimewayObj);
				 }
				 else {
					 responseObj = new Response<MaritimewayBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 result = maritimewayBREImpl_DAO.delete(cacheConfig.maritimewayBRE_SA,name_rule);

				 if(result == true) {
					 responseObj = new Response<MaritimewayBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<MaritimewayBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 result = maritimewayBREImpl_DAO.add(cacheConfig.maritimewayBRE_SA,maritimeway.name_rule,maritimeway);
				 if(result == true) {
					 responseObj = new Response<MaritimewayBRE_Model>(HttpExceptionPackSend.BUSINESS_RULE.value(),HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<MaritimewayBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	public ResponseEntity<?> financeCostDeliveryOperation(String rule_type, FinanceCostDeliveryBRE_Model financeEntity, String operation, Map headInformation) {
		Response<FinanceCostDeliveryBRE_Model> responseObj = null;
		FinanceCostDeliveryBRE_Model financeCostDeliveryObj = null;
		boolean result;
		
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 financeCostDeliveryObj = financeCostDeliveryImpl_DAO.findOne(cacheConfig.financeCostDeliveryBRE_SA,rule_type);
				 
				 if(financeCostDeliveryObj != null) {
					 responseObj = new Response<FinanceCostDeliveryBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), financeCostDeliveryObj);
				 }
				 else {
					 responseObj = new Response<FinanceCostDeliveryBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 result = financeCostDeliveryImpl_DAO.delete(cacheConfig.financeCostDeliveryBRE_SA,rule_type);
				 
				 if(result == true) {
					 responseObj = new Response<FinanceCostDeliveryBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<FinanceCostDeliveryBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 result = financeCostDeliveryImpl_DAO.add(cacheConfig.financeCostDeliveryBRE_SA, financeEntity.type, financeEntity);
	
				 if(result == true) {
					 responseObj = new Response<FinanceCostDeliveryBRE_Model>(HttpExceptionPackSend.BUSINESS_RULE.value(),HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<FinanceCostDeliveryBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<FinanceCostDeliveryBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
