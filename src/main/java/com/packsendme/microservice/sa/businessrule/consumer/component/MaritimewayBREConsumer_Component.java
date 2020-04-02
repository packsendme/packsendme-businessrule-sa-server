package com.packsendme.microservice.sa.businessrule.consumer.component;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

import com.packsendme.microservice.sa.businessrule.config.Consumer_Config;

@Component
public class MaritimewayBREConsumer_Component implements BRE_ConsumerT {

	Consumer_Config consumer_Config = new Consumer_Config();

	public void receive() {
		
	    String bootstrapServers="167.172.152.184:9092";  
	    String grp_id="Java";  
	    String topic="topicRoadwayBRE_SA_Instance";  
	    
	    Properties props = new Properties();
	     props.put("bootstrap.servers", bootstrapServers);
	     props.put("group.id", grp_id);
	     props.put("enable.auto.commit", "true");
	     props.put("auto.commit.interval.ms", "1000");
	     props.put("session.timeout.ms", "30000");
	     props.put("key.deserializer",
	        "org.apache.kafka.common.serializa-tion.StringDeserializer");
	     props.put("value.deserializer",
	        "org.apache.kafka.common.serializa-tion.StringDeserializer");
	     
	     
	     System.out.println("==================================================================="); 
	     System.out.println(" RECEIVE"); 
	     System.out.println("==================================================================="); 

	     KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(props);
			consumer.subscribe(Arrays.asList(topic));

			System.out.println("==================================================================="); 
			System.out.println("Subscribed to topic " + topic);
	        System.out.println("==================================================================="); 

			boolean result = true;
		    while (true) {
		        ConsumerRecords<String, String> records = consumer.poll(100);
		        
		        System.out.println("==================================================================="); 
		        System.out.println(" TOTAL REGISTER :: "+ records.count());
		        System.out.println("==================================================================="); 

		        for (ConsumerRecord<String, String> record : records) {
			        System.out.println("==================================================================="); 
		            System.out.printf("offset = %d, key = %s, value = %s\n", 
		                    record.offset(), record.key(), record.value());
			        System.out.println("==================================================================="); 
		        }
		    }
	  }
	
	    
	    /*
	    //Creating consumer properties  
	    Properties properties=new Properties();  
	    properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);  
	    properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,   StringDeserializer.class.getName());  
	    properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());  
	    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,grp_id);  
	    properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest");  

	    // latest earliest
        System.out.println("==================================================================="); 
        System.out.println(" RECEIVE"); 
        System.out.println("==================================================================="); 
        
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(properties);
		consumer.subscribe(Arrays.asList(topic));
		boolean result = true;
	    while (result) {
	        ConsumerRecords<String, String> records = consumer.poll(100);
	        
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
	}*/
	
	
	  
	
	
	public String consumerTopic(){
		return "DONE";
	}

}
