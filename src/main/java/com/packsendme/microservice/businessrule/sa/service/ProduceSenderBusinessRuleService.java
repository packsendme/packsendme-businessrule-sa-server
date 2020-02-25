package com.packsendme.microservice.businessrule.sa.service;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packsendme.microservice.businessrule.sa.config.Configuration;
 
@Service
public class ProduceSenderBusinessRuleService {
	
	
	@Autowired
    private KafkaProducer<String,String> producer;
	
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
		 Properties properties= new Properties();
		 
		 properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"167.172.152.184:29092");
		 properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	     properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	     producer = new KafkaProducer<String, String>(properties);
	        
		ProducerRecord<String,String> record = new ProducerRecord<String, String>("topicBusinessRuleSouthAmericaDev","Alicia");
		producer.send(record);
	    producer.flush();
        producer.close();
	}

}
