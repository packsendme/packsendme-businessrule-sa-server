package com.packsendme.microservice.sa.businessrule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflix.discovery.converters.Auto;
import com.packsendme.airway.bre.rule.model.AirwayBRE_Model;
import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;
import com.packsendme.fuel.bre.rule.model.FuelBRE_Model;
import com.packsendme.lib.common.constants.CacheBRE_Constants;
import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.maritimeway.bre.rule.model.MaritimewayBRE_Model;
import com.packsendme.microservice.sa.businessrule.config.Cache_Config;
import com.packsendme.microservice.sa.businessrule.dao.BusinessRuleImpl_DAO;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;
import com.packsendme.tollsfuel.bre.model.TollsFuelBRE_Model;

@Service
@ComponentScan("com.packsendme.microservice.sa.businessrule.dao")
public class BusinessRule_Services {
	
	public enum Operation_Enum {
		GET, POST, DELETE;
	}
	
	@Autowired
	Cache_Config cacheConfig;
	
	@Autowired
	BusinessRuleImpl_DAO<RoadwayBRE_Model> roadwayBREImpl_DAO;
	@Autowired
	BusinessRuleImpl_DAO<AirwayBRE_Model> airwayBREImpl_DAO;
	@Autowired
	BusinessRuleImpl_DAO<MaritimewayBRE_Model> maritimewayBREImpl_DAO;
	@Autowired
	BusinessRuleImpl_DAO<ExecutionBRE_Model> executeBREImpl_DAO;
	@Autowired
	BusinessRuleImpl_DAO<FuelBRE_Model> fuelBREImpl_DAO;
	@Autowired
	BusinessRuleImpl_DAO<TollsFuelBRE_Model> tollsFuelBREImpl_DAO;
	
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
	
	public ResponseEntity<?> roadwayOperation(String name_rule, RoadwayBRE_Model roadway, String operation) {
		Response<RoadwayBRE_Model> responseObj = null;
		RoadwayBRE_Model roadwayObj = null;
		boolean result;
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 roadwayObj = roadwayBREImpl_DAO.findOne(cacheConfig.roadwayBRE_SA,name_rule);
				 if(roadwayObj != null) {
					 responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), roadwayObj);
				 }
				 else {
					 responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 result = roadwayBREImpl_DAO.delete(cacheConfig.roadwayBRE_SA,name_rule);
				 if(result == true) {
					 responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 result = roadwayBREImpl_DAO.add(cacheConfig.roadwayBRE_SA,roadway.name_rule,roadway);
				 responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
				 
				 if(result == true) {
					 responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.BUSINESS_RULE.value(),HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			e.printStackTrace();
			responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.FAIL_EXECUTION.value(),HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> airwayOperation(String name_rule, AirwayBRE_Model airway, String operation) {
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
	
	public ResponseEntity<?> maritimewayOperation(String name_rule, MaritimewayBRE_Model maritimeway, String operation) {
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
	
	public ResponseEntity<?> tollsFuelOperation(String name_rule, TollsFuelBRE_Model tollsEntity, String operation) {
		Response<TollsFuelBRE_Model> responseObj = null;
		TollsFuelBRE_Model tollsFuelObj = null;
		boolean result;
		
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 tollsFuelObj = tollsFuelBREImpl_DAO.findOne(cacheConfig.tollsfuelBRE_SA,name_rule);
				 
				 if(tollsFuelObj != null) {
					 responseObj = new Response<TollsFuelBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), tollsFuelObj);
				 }
				 else {
					 responseObj = new Response<TollsFuelBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 result = tollsFuelBREImpl_DAO.delete(cacheConfig.tollsfuelBRE_SA,name_rule);
				 
				 if(result == true) {
					 responseObj = new Response<TollsFuelBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<TollsFuelBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 result = tollsFuelBREImpl_DAO.add(cacheConfig.tollsfuelBRE_SA, tollsEntity.name_rule, tollsEntity);
	
				 if(result == true) {
					 responseObj = new Response<TollsFuelBRE_Model>(HttpExceptionPackSend.BUSINESS_RULE.value(),HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<TollsFuelBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<TollsFuelBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

}
