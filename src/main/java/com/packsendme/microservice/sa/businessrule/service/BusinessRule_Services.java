package com.packsendme.microservice.sa.businessrule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.airway.bre.rule.model.AirwayBRE_Model;
import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;
import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.maritimeway.bre.rule.model.MaritimewayBRE_Model;
import com.packsendme.microservice.sa.businessrule.dao.AirwayImpl_DAO;
import com.packsendme.microservice.sa.businessrule.dao.ExecutionImpl_DAO;
import com.packsendme.microservice.sa.businessrule.dao.MaritimewayImpl_DAO;
import com.packsendme.microservice.sa.businessrule.dao.RoadwayImpl_DAO;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;

@Service
public class BusinessRule_Services {
	
	@Autowired
	private RoadwayImpl_DAO roadwayDAO;
	
	@Autowired
	private AirwayImpl_DAO airwayDAO;
	
	@Autowired
	private MaritimewayImpl_DAO maritimewayDAO;
	
	@Autowired
	private ExecutionImpl_DAO<ExecutionBRE_Model> executionDAO;
	
	
	public enum Operation_Enum {
		GET, POST, DELETE;
	}
			
	
	public ResponseEntity<?> executeOperation(ExecutionBRE_Model executionBRE, String operation) {
		Response<ExecutionBRE_Model> responseObj = null;
		ExecutionBRE_Model executionObj = new ExecutionBRE_Model();
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 executionObj = executionDAO.findOne(executionBRE.status);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 executionObj = executionDAO.findOne(executionBRE.id_rule);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 executionDAO.add(executionBRE);
			 }
			responseObj = new Response<ExecutionBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), executionObj);
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<ExecutionBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> roadwayOperation(RoadwayBRE_Model roadway, String operation) {
		Response<RoadwayBRE_Model> responseObj = null;
		RoadwayBRE_Model roadwayObj = new RoadwayBRE_Model();
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 roadwayObj = roadwayDAO.findOne(roadway.status);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 roadwayObj = roadwayDAO.findOne(roadway.id_rule);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 roadwayDAO.add(roadway);
			 }
			responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), roadwayObj);
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> airwayOperation(AirwayBRE_Model airway, String operation) {
		Response<AirwayBRE_Model> responseObj = null;
		AirwayBRE_Model airwayObj = new AirwayBRE_Model();
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 airwayObj = airwayDAO.findOne(airway.status);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 airwayObj = airwayDAO.findOne(airway.id_rule);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 airwayDAO.add(airway);
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
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 maritimewayObj = maritimewayDAO.findOne(maritimeway.status);
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 maritimewayObj = maritimewayDAO.findOne(maritimeway.id_rule);
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 maritimewayDAO.add(maritimeway);
			 }
			responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), maritimewayObj);
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<MaritimewayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
