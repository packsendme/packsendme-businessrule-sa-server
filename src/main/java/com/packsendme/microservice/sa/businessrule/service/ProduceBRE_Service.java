package com.packsendme.microservice.sa.businessrule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.airway.bre.rule.model.AirwayCostsBRE_Model;
import com.packsendme.execution.bre.rule.instance.model.AirwayInstanceBRE_Model;
import com.packsendme.execution.bre.rule.instance.model.MaritimewayInstanceBRE_Model;
import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;
import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.constants.Topic_SA_Constants;
import com.packsendme.lib.common.response.Response;
import com.packsendme.maritimeway.bre.rule.model.MaritimewayCostsBRE_Model;
import com.packsendme.microservice.sa.businessrule.component.ProduceBRE_Component;
import com.packsendme.roadway.bre.rule.model.RoadwayCostsBRE_Model;
import com.packsendme.roadway.bre.rule.model.RoadwayInstanceBRE_Model;
 
@Service
@ComponentScan({"com.packsendme.microservice.sa.businessrule.service"})
public class ProduceBRE_Service {
	
	@Autowired
	private ProduceBRE_Component produceBREComponent;
	
	private ObjectMapper mapper = new ObjectMapper();

	
	public ResponseEntity<?> sendExecutionTopic(ExecutionBRE_Model brObject) throws JsonProcessingException {
		Response<String> responseObj = null;
		String msgJson = mapper.writeValueAsString(brObject);
		String responseTopic = null; 
		try {
			responseTopic = produceBREComponent.sendTopic(msgJson, Topic_SA_Constants.TOPIC_EXECUTION_SA);
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), responseTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//========================================================================================
	// METHOD-SERVICE :: ROADWAY-BRE
	//========================================================================================//

	public ResponseEntity<?> sendRoadwayInstanceTopic(RoadwayInstanceBRE_Model breObj) throws JsonProcessingException {
		Response<String> responseObj = null;
		String msgJson = mapper.writeValueAsString(breObj);
		String responseTopic = null; 
		try {
			responseTopic = produceBREComponent.sendTopic(msgJson, Topic_SA_Constants.TOPIC_ROADWAY_SA_Instance);
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), responseTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> sendRoadwayCostsTopic(RoadwayCostsBRE_Model breObj) throws JsonProcessingException {
		Response<String> responseObj = null;
		String msgJson = mapper.writeValueAsString(breObj);
		String responseTopic = null; 
		try {
			responseTopic = produceBREComponent.sendTopic(msgJson, Topic_SA_Constants.TOPIC_ROADWAY_SA_Costs);
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), responseTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	//========================================================================================
	// METHOD-SERVICE :: AIRWAY-BRE
	//========================================================================================//

	public ResponseEntity<?> sendAirwayInstanceTopic(AirwayInstanceBRE_Model breObj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Response<String> responseObj = null;
		String msgJson = mapper.writeValueAsString(breObj);
		String responseTopic = null; 
		try {
			responseTopic = produceBREComponent.sendTopic(msgJson, Topic_SA_Constants.TOPIC_AIRWAY_SA_Instance);
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), responseTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> sendAirwayCostsTopic(AirwayCostsBRE_Model breObj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Response<String> responseObj = null;
		String msgJson = mapper.writeValueAsString(breObj);
		String responseTopic = null; 
		try {
			responseTopic = produceBREComponent.sendTopic(msgJson, Topic_SA_Constants.TOPIC_AIRWAY_SA_Costs);
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), responseTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//========================================================================================
	// METHOD-SERVICE :: MARITIMEWAY-BRE
	//========================================================================================//

	public ResponseEntity<?> sendMaritimewayInstanceTopic(MaritimewayInstanceBRE_Model maritimewayObj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Response<String> responseObj = null;
		String msgJson = mapper.writeValueAsString(maritimewayObj);
		String responseTopic = null; 
		try {
			responseTopic = produceBREComponent.sendTopic(msgJson, Topic_SA_Constants.TOPIC_MARITIMEWAY_SA_Instance);
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), responseTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> sendMaritimewayCostsTopic(MaritimewayCostsBRE_Model maritimewayObj) throws JsonProcessingException {
		Response<String> responseObj = null;
		String msgJson = mapper.writeValueAsString(maritimewayObj);
		String responseTopic = null; 
		try {
			responseTopic = produceBREComponent.sendTopic(msgJson, Topic_SA_Constants.TOPIC_MARITIMEWAY_SA_Costs);
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), responseTopic);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
