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
import com.packsendme.lib.businessrule.model.BusinessRulesModel;
import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.microservice.businessrule.sa.config.TopicConf;
 
@Service
public class ProduceSenderBRService {
	
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private TopicConf topic;
	
	
	
	public ResponseEntity<?> sendMessage(BusinessRulesModel brObject) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Response<String> responseObj = null;
		String msgJson = mapper.writeValueAsString(brObject);
		
		System.out.println(" TOPIC INSTANCE "+ topic.topicBusinessRuleSouthAmericaDev);
		try {
			ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic.topicBusinessRuleSouthAmericaDev, msgJson);
			future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
					@Override
		            public void onSuccess(SendResult<String, String> result) {
		            	System.out.println("Sent message=[" + msgJson + "] with offset=[" + result.getRecordMetadata().offset() + "]");  
		            }
		            
		            @Override
		            public void onFailure(Throwable ex) {
		            	System.out.println("Unable to send message=["+ msgJson + "] due to : " + ex.getMessage());
		            }
	       	});
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), msgJson);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
