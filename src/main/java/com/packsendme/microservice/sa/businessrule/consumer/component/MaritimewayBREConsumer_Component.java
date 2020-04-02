package com.packsendme.microservice.sa.businessrule.consumer.component;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Component;

import com.packsendme.microservice.sa.businessrule.config.Consumer_Config;

@Component
public class MaritimewayBREConsumer_Component implements BRE_ConsumerT {

	Consumer_Config consumer_Config = new Consumer_Config();

	public void receive() {
		
	     String bootstrapServers="167.172.152.184:9092";  
	        String grp_id="Java";  
	        String topic="topicRoadwayBRE_SA_Instance";  
	        //Creating consumer properties  
	        Properties properties=new Properties();  
	        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);  
	        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,   StringDeserializer.class.getName());  
	        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());  
	        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,grp_id);  
	       // properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");  

		
		
		
		
        System.out.println("==================================================================="); 
        System.out.println(" RECEIVE"); 
        System.out.println("==================================================================="); 
        
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(properties);
		consumer.subscribe(Arrays.asList(topic));
		boolean result = true;
	    while (result) {
	        ConsumerRecords<String, String> records = consumer.poll(1000);
	        
	        System.out.println("==================================================================="); 
	        System.out.println(" TOTAL REGISTER :: "+ records.count());
	        System.out.println("==================================================================="); 



	        for (ConsumerRecord<String, String> record : records) {
		        System.out.println("==================================================================="); 
	            System.err.println(" VALUE ----->" + record.value());
		        System.out.println("==================================================================="); 

	        }
	        result = false;
	    }
	}
	
	
	  
	
	
	public String consumerTopic(){
		return "DONE";
	}

}
