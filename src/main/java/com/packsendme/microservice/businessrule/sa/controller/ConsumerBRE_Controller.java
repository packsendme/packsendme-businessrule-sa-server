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
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.packsendme.microservice.businessrule.sa.config.Consumer_Config;

@RestController
public class ConsumerBRE_Controller {
	
	@Autowired
	public Consumer_Config consumerConfig;
	
	@Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

	@RequestMapping(value = "/producer/consume-message/{topic}", method = { RequestMethod.GET })
	@ResponseBody
	public String consumeMessage(@PathVariable String topic) {
		
		ConsumerFactory<String, Object> consumerFactory = consumerFactory();
		Consumer<String, Object> consumer = consumerFactory.createConsumer();
		
		consumer.subscribe(Collections.singletonList(topic));
		
		ConsumerRecords<String, Object> consumerRecords = consumer.poll(Duration.ofDays(1)); 
		consumerRecords.forEach(action ->{
			System.out.println(" :: KAFKA RESPONSE :: "+ action.value());
		});
		return "Success";
	}
	
	public ConsumerFactory<String, Object> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "groupId");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    return new DefaultKafkaConsumerFactory<>(props);
	}
}
