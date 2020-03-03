package com.packsendme.microservice.businessrule.sa.controller;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.packsendme.microservice.businessrule.sa.config.Consumer_Config;

@RestController
@EnableKafka
public class ConsumerBRE_Controller {
	
	@Autowired
	public Consumer_Config consumerConfig;
	
	@Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

	@RequestMapping(value = "/producer/consume-message/{topic}", method = { RequestMethod.GET })
	@ResponseBody
	public String consumeMessage(@PathVariable String topic) throws InterruptedException {

		ConsumerFactory<String, Object> consumerFactory = consumerFactory();
		Consumer<String, Object> consumer = consumerFactory.createConsumer();
		
		consumer.subscribe(Collections.singletonList(topic));
		
		ConsumerRecords<String, Object> consumerRecords = consumer.poll(Duration.ofDays(1)); 
		
		 if (consumerRecords.count()==0) {
				System.out.println(" :: KAFKA RESPONSE :: 0 ");

		 }else {
			 
			consumerRecords.forEach(action ->{
				System.out.println(" :: KAFKA RESPONSE :: "+ action.value());
			});
		 }
		return "Success";
	}
	
	public ConsumerFactory<String, Object> consumerFactory() {
		Map<String, Object> configs = new java.util.HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id");
		configs.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 15000);
		configs.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 1000);
		ConsumerFactory<String, Object> consumerFactory = new DefaultKafkaConsumerFactory<>(configs);
		return consumerFactory;
	}
}
