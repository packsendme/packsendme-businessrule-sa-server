package com.packsendme.microservice.businessrule.sa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.packsendme.microservice.businessrule.sa.config.Configuration;
 
@Service
public class ProduceSenderBusinessRuleService {
	
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private Configuration configuration;
	
	
	
	/*
	public ResponseEntity<?> sendRuleSA(BusinessRulesModel businessrule) {		
		ObjectMapper mapper = new ObjectMapper();
		Response<String> responseObj = null;

		try {
			
			 ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("topicBusinessRuleSouthAmericaDev", "ALICIA");
		        result.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
		            @Override
		            public void onSuccess(SendResult<String, String> result) {
		            	System.out.println("@ SUCCESSS @");
		            }

		            @Override
		            public void onFailure(Throwable ex) {
		            	System.out.println("@ ERRO @ "+ ex.getMessage());
		            }
		        });
			
			/*
			String ruleJson = mapper.writeValueAsString(businessrule);
			
			System.out.println(" ");
			System.out.println("+++++++++++++++++++  TOPIC +++++++++++++++++++++ :: "+ configuration.topicBusinessRuleSouthAmericaDev);
			System.out.println(" ");
			System.out.println("+++++++++++++++++++  JSON +++++++++++++++++++++ :: "+ ruleJson);
			System.out.println(" ");
			
			
			String msg = "Ricardo CHegou"; 
			
			
		       Message<String> message = MessageBuilder
		                .withPayload(msg)
		                .setHeader(KafkaHeaders.TOPIC, "topicBusinessRuleSouthAmericaDev")
		                .setHeader(KafkaHeaders.MESSAGE_KEY, "999")
		                .setHeader(KafkaHeaders.PARTITION_ID, 1)
		                .build();
			this.kafkaTemplate.send(message); */
	    /*    
			responseObj = new Response<String>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), "ruleJson");
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			e.printStackTrace();
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);

		} 
	
	} */
	
	public void sendMessage(String message) {
		ListenableFuture<SendResult<String, String>> future = 
		kafkaTemplate.send("topicBusinessRuleSouthAmericaDev", "ALICIA");
		
		/*
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
            	System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");            }

            @Override
            public void onFailure(Throwable ex) {
            	System.out.println("Unable to send message=["+ message + "] due to : " + ex.getMessage());
            }
        }); */
	}

}
