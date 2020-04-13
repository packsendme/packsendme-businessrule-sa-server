package com.packsendme.microservice.sa.businessrule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.airway.bre.rule.model.AirwayBRE_Model;
import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;
import com.packsendme.fuel.bre.rule.model.FuelBRE_Model;
import com.packsendme.lib.common.constants.CacheBRE_Constants;
import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.maritimeway.bre.rule.model.MaritimewayBRE_Model;
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
		ExecutionBRE_Model executionObj = new ExecutionBRE_Model();
		
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 executionObj = executeBREImpl_DAO.findOne(CacheBRE_Constants.EXECUTE_BRE_SA_CACHE,name_rule);
				 responseObj = new Response<ExecutionBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), executionObj);

			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 executeBREImpl_DAO.delete(CacheBRE_Constants.EXECUTE_BRE_SA_CACHE,name_rule);
				 responseObj = new Response<ExecutionBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 executeBREImpl_DAO.add(CacheBRE_Constants.EXECUTE_BRE_SA_CACHE,executionBRE.name_rule,executionBRE);
				 responseObj = new Response<ExecutionBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<ExecutionBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> roadwayOperation(String name_rule, RoadwayBRE_Model roadway, String operation) {
		Response<RoadwayBRE_Model> responseObj = null;
		RoadwayBRE_Model roadwayObj = new RoadwayBRE_Model();

		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 roadwayObj = roadwayBREImpl_DAO.findOne(CacheBRE_Constants.ROADWAY_BRE_SA_CACHE,name_rule);
				 responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), roadwayObj);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 roadwayBREImpl_DAO.delete(CacheBRE_Constants.ROADWAY_BRE_SA_CACHE,name_rule);
				 responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 roadwayBREImpl_DAO.add(CacheBRE_Constants.ROADWAY_BRE_SA_CACHE,roadway.name_rule,roadway);
				 responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			e.printStackTrace();
			responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> airwayOperation(String name_rule, AirwayBRE_Model airway, String operation) {
		Response<AirwayBRE_Model> responseObj = null;
		AirwayBRE_Model airwayObj = new AirwayBRE_Model();
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 airwayObj = airwayBREImpl_DAO.findOne(CacheBRE_Constants.AIRWAY_BRE_SA_CACHE,name_rule);
				 responseObj = new Response<AirwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), airwayObj);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 airwayBREImpl_DAO.delete(CacheBRE_Constants.AIRWAY_BRE_SA_CACHE,name_rule);
				 responseObj = new Response<AirwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 airwayBREImpl_DAO.add(CacheBRE_Constants.AIRWAY_BRE_SA_CACHE,airway.name_rule,airway);
				 responseObj = new Response<AirwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<AirwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> maritimewayOperation(String name_rule, MaritimewayBRE_Model maritimeway, String operation) {
		Response<MaritimewayBRE_Model> responseObj = null;
		MaritimewayBRE_Model maritimewayObj = new MaritimewayBRE_Model();

		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 maritimewayObj = maritimewayBREImpl_DAO.findOne(CacheBRE_Constants.MARITIMEWAY_BRE_SA_CACHE,name_rule);
				 responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), maritimewayObj);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 maritimewayBREImpl_DAO.delete(CacheBRE_Constants.MARITIMEWAY_BRE_SA_CACHE,name_rule);
				 responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 maritimewayBREImpl_DAO.add(CacheBRE_Constants.MARITIMEWAY_BRE_SA_CACHE,maritimeway.name_rule,maritimeway);
				 responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> fuelOperation(String name_rule, FuelBRE_Model fuelEntity, String operation) {
		Response<FuelBRE_Model> responseObj = null;
		FuelBRE_Model fuelObj = new FuelBRE_Model();

		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 fuelObj = fuelBREImpl_DAO.findOne(CacheBRE_Constants.FUEL_BRE_SA_CACHE,name_rule);
				 responseObj = new Response<FuelBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), fuelObj);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 maritimewayBREImpl_DAO.delete(CacheBRE_Constants.FUEL_BRE_SA_CACHE,name_rule);
				 responseObj = new Response<FuelBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 fuelBREImpl_DAO.add(CacheBRE_Constants.FUEL_BRE_SA_CACHE,fuelEntity.name_rule,fuelEntity);
				 responseObj = new Response<FuelBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<FuelBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> tollsFuelOperation(String name_rule, TollsFuelBRE_Model tollsEntity, String operation) {
		Response<TollsFuelBRE_Model> responseObj = null;
		TollsFuelBRE_Model tollsFuelObj = new TollsFuelBRE_Model();

		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 tollsFuelObj = tollsFuelBREImpl_DAO.findOne(CacheBRE_Constants.TOLLSFUEL_BRE_SA_CACHE,name_rule);
				 responseObj = new Response<TollsFuelBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), tollsFuelObj);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 tollsFuelBREImpl_DAO.delete(CacheBRE_Constants.TOLLSFUEL_BRE_SA_CACHE,name_rule);
				 responseObj = new Response<TollsFuelBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 tollsFuelBREImpl_DAO.add(CacheBRE_Constants.TOLLSFUEL_BRE_SA_CACHE, tollsEntity.name_rule, tollsEntity);
				 //.add(BRE_SA_Constants.TOLLS_BRE_SA_CACHE,tollsEntity.name_rule,tollsEntity);
				 responseObj = new Response<TollsFuelBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<TollsFuelBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
