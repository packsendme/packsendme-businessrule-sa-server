package com.packsendme.microservice.sa.businessrule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.airway.bre.rule.model.AirwayBRE_Model;
import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;
import com.packsendme.lib.common.constants.BRE_SA_Constants;
import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.maritimeway.bre.rule.model.MaritimewayBRE_Model;
import com.packsendme.microservice.sa.businessrule.dao.BusinessRuleImpl_DAO;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;

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
	
	public ResponseEntity<?> executeOperation(int id_rule, ExecutionBRE_Model executionBRE, String operation) {
		Response<ExecutionBRE_Model> responseObj = null;
		ExecutionBRE_Model executionObj = new ExecutionBRE_Model();
		
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 executionObj = executeBREImpl_DAO.findOne(BRE_SA_Constants.EXECUTE_BRE_SA_CACHE,id_rule);
				 responseObj = new Response<ExecutionBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), executionObj);

			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 executeBREImpl_DAO.delete(BRE_SA_Constants.EXECUTE_BRE_SA_CACHE,id_rule);
				 responseObj = new Response<ExecutionBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 executeBREImpl_DAO.add(BRE_SA_Constants.EXECUTE_BRE_SA_CACHE,executionBRE.id_rule,executionBRE);
				 responseObj = new Response<ExecutionBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<ExecutionBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> roadwayOperation(int id_rule, RoadwayBRE_Model roadway, String operation) {
		System.out.println(" +++++++++++++++++++++++ roadwayOperation ");
		Response<RoadwayBRE_Model> responseObj = null;
		RoadwayBRE_Model roadwayObj = new RoadwayBRE_Model();

		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 roadwayObj = roadwayBREImpl_DAO.findOne(BRE_SA_Constants.ROADWAY_BRE_SA_CACHE,id_rule);
				 responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), roadwayObj);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 roadwayBREImpl_DAO.delete(BRE_SA_Constants.ROADWAY_BRE_SA_CACHE,id_rule);
				 responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 roadwayBREImpl_DAO.add(BRE_SA_Constants.ROADWAY_BRE_SA_CACHE,roadway.id_rule,roadway);
				 responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			e.printStackTrace();
			responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> airwayOperation(int id_rule, AirwayBRE_Model airway, String operation) {
		Response<AirwayBRE_Model> responseObj = null;
		AirwayBRE_Model airwayObj = new AirwayBRE_Model();
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 airwayObj = airwayBREImpl_DAO.findOne(BRE_SA_Constants.AIRWAY_BRE_SA_CACHE,id_rule);
				 responseObj = new Response<AirwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), airwayObj);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 airwayBREImpl_DAO.delete(BRE_SA_Constants.AIRWAY_BRE_SA_CACHE,id_rule);
				 responseObj = new Response<AirwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 airwayBREImpl_DAO.add(BRE_SA_Constants.AIRWAY_BRE_SA_CACHE,airway.id_rule,airway);
				 responseObj = new Response<AirwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<AirwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> maritimewayOperation(int id_rule, MaritimewayBRE_Model maritimeway, String operation) {
		Response<MaritimewayBRE_Model> responseObj = null;
		MaritimewayBRE_Model maritimewayObj = new MaritimewayBRE_Model();

		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 maritimewayObj = maritimewayBREImpl_DAO.findOne(BRE_SA_Constants.MARITIMEWAY_BRE_SA_CACHE,id_rule);
				 responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), maritimewayObj);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 maritimewayBREImpl_DAO.delete(BRE_SA_Constants.MARITIMEWAY_BRE_SA_CACHE,id_rule);
				 responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 maritimewayBREImpl_DAO.add(BRE_SA_Constants.MARITIMEWAY_BRE_SA_CACHE,maritimeway.id_rule,maritimeway);
				 responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
