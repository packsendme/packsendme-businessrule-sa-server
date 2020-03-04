package com.packsendme.microservice.businessrule.sa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.lib.bre.airway.model.AirwayBRE_Model;
import com.packsendme.lib.bre.execution.model.Execution_Model;
import com.packsendme.lib.bre.maritimeway.model.MaritimewayBRE_Model;
import com.packsendme.lib.bre.roadway.model.RoadwayBRE_Model;
import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.microservice.businessrule.sa.config.Topic_Config;
 
@Service
public class ProduceBRE_Service {
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private Topic_Config topic;
	
	public ResponseEntity<?> sendExecutionTopic(Execution_Model brObject) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Response<String> responseObj = null;
		String msgJson = mapper.writeValueAsString(brObject);
		
		System.out.println(" TOPIC INSTANCE "+ topic.topic_executionrule_sa);
		try {
			ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic.topic_executionrule_sa, msgJson);
			future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
					@Override
		            public void onSuccess(SendResult<String, String> result) {
		            	System.out.println("<> Sent message=[" + msgJson + "] with offset=[" + result.getRecordMetadata().offset() + "]");  
		            }
		            
		            @Override
		            public void onFailure(Throwable ex) {
		            	System.out.println("Unable to send message=["+ msgJson + "] due to : " + ex.getMessage());
		            }
	       	});
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), msgJson);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public ResponseEntity<?> sendRoadwayTopic(RoadwayBRE_Model roadwayObj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Response<String> responseObj = null;
		String msgJson = mapper.writeValueAsString(roadwayObj);
		
		System.out.println(" TOPIC INSTANCE "+ topic.topic_roadway_sa);
		try {
			ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic.topic_roadway_sa, msgJson);
			future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
					@Override
		            public void onSuccess(SendResult<String, String> result) {
		            	System.out.println("< ROADWAY > Success: sent message=[" + msgJson + "] with offset=[" + result.getRecordMetadata().offset() + "]");  
		            }
		            
		            @Override
		            public void onFailure(Throwable ex) {
		            	System.out.println("< ROADWAY > ERROR: send message=["+ msgJson + "] due to : " + ex.getMessage());
		            }
	       	});
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), msgJson);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> sendAirwayTopic(AirwayBRE_Model airwayObj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Response<String> responseObj = null;
		String msgJson = mapper.writeValueAsString(airwayObj);
		
		System.out.println(" TOPIC INSTANCE "+ topic.topic_airway_sa);
		try {
			ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic.topic_airway_sa, msgJson);
			future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
					@Override
		            public void onSuccess(SendResult<String, String> result) {
		            	System.out.println("< AIRWAY > SUCCESS: sent message=[" + msgJson + "] with offset=[" + result.getRecordMetadata().offset() + "]");  
		            }
		            
		            @Override
		            public void onFailure(Throwable ex) {
		            	System.out.println("< AIRWAY > ERROR: send message=["+ msgJson + "] due to : " + ex.getMessage());
		            }
	       	});
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), msgJson);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> sendMaritimewayTopic(MaritimewayBRE_Model maritimewayObj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Response<String> responseObj = null;
		String msgJson = mapper.writeValueAsString(maritimewayObj);
		
		System.out.println(" TOPIC INSTANCE "+ topic.topic_maritimeway_sa);
		try {
			ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic.topic_maritimeway_sa, msgJson);
			future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
					@Override
		            public void onSuccess(SendResult<String, String> result) {
		            	System.out.println("< MARITIME > SUCCESS: sent message=[" + msgJson + "] with offset=[" + result.getRecordMetadata().offset() + "]");  
		            }
		            
		            @Override
		            public void onFailure(Throwable ex) {
		            	System.out.println("< MARITIME > ERROR: send message=["+ msgJson + "] due to : " + ex.getMessage());
		            }
	       	});
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), msgJson);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
