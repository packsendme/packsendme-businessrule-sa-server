package com.packsendme.microservice.sa.businessrule.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.airway.bre.rule.model.AirwayBRE_Model;
import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;
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
			
	
	public ResponseEntity<?> executeOperation(ExecutionBRE_Model executionBRE, String operation) {
		Response<ExecutionBRE_Model> responseObj = null;
		ExecutionBRE_Model executionObj = new ExecutionBRE_Model();
		BusinessRuleImpl_DAO<ExecutionBRE_Model> businessRuleImpl_DAO = new BusinessRuleImpl_DAO<ExecutionBRE_Model>();
		
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 executionObj = businessRuleImpl_DAO.findOne(executionBRE.status);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 executionObj = businessRuleImpl_DAO.findOne(executionBRE.id_rule);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 businessRuleImpl_DAO.add(executionBRE);
			 }
			responseObj = new Response<ExecutionBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), executionObj);
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<ExecutionBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> roadwayOperation(RoadwayBRE_Model roadway, String operation) {
		System.out.println(" +++++++++++++++++++++++ roadwayOperation "+ roadway.id_rule);
		Response<RoadwayBRE_Model> responseObj = null;
		RoadwayBRE_Model roadwayObj = new RoadwayBRE_Model();
		BusinessRuleImpl_DAO<RoadwayBRE_Model> businessRuleImpl_DAO = new BusinessRuleImpl_DAO<RoadwayBRE_Model>();

		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 roadwayObj = businessRuleImpl_DAO.findOne(roadway.status);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 roadwayObj = businessRuleImpl_DAO.findOne(roadway.id_rule);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 System.out.println(" -------------------- roadwayOperation POST ");
				 businessRuleImpl_DAO.add(roadway);
			 }
			responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), roadwayObj);
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			e.printStackTrace();
			responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> airwayOperation(AirwayBRE_Model airway, String operation) {
		Response<AirwayBRE_Model> responseObj = null;
		AirwayBRE_Model airwayObj = new AirwayBRE_Model();
		BusinessRuleImpl_DAO<AirwayBRE_Model> businessRuleImpl_DAO = new BusinessRuleImpl_DAO<AirwayBRE_Model>();

		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 airwayObj = businessRuleImpl_DAO.findOne(airway.status);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 airwayObj = businessRuleImpl_DAO.findOne(airway.id_rule);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 businessRuleImpl_DAO.add(airway);
			 }
			responseObj = new Response<AirwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), airwayObj);
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<AirwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> maritimewayOperation(MaritimewayBRE_Model maritimeway, String operation) {
		Response<MaritimewayBRE_Model> responseObj = null;
		MaritimewayBRE_Model maritimewayObj = new MaritimewayBRE_Model();
		BusinessRuleImpl_DAO<MaritimewayBRE_Model> businessRuleImpl_DAO = new BusinessRuleImpl_DAO<MaritimewayBRE_Model>();

		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 maritimewayObj = businessRuleImpl_DAO.findOne(maritimeway.status);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 maritimewayObj = businessRuleImpl_DAO.findOne(maritimeway.id_rule);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 businessRuleImpl_DAO.add(maritimeway);
			 }
			responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), maritimewayObj);
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
