package com.packsendme.microservice.sa.businessrule.consumer.component;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
	    Properties properties = new Properties();  
	    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);  
	    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,   StringDeserializer.class.getName());  
	    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());  
	    properties.put(ConsumerConfig.GROUP_ID_CONFIG,grp_id);  
	    properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
	    properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,10);
	    properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
	    

	    // latest earliest
        System.out.println("==================================================================="); 
        System.out.println(" RECEIVE"); 
        System.out.println("==================================================================="); 
        
		KafkaConsumer<Long, String> consumer = new KafkaConsumer<>(properties);
		consumer.subscribe(Collections.singletonList(topic));
		
		try {
		    while (true) {	
		        ConsumerRecords<Long, String> records = consumer.poll(Duration.ofMillis(3000));
		        
		        System.out.println("==================================================================="); 
		        System.out.println(" TOTAL REGISTER :: "+ records.count());
		        System.out.println("==================================================================="); 
	
		        for (ConsumerRecord<Long, String> record : records) {
			        System.out.println("==================================================================="); 
		            System.err.println(" VALUE ----->" + record.value());
			        System.out.println("==================================================================="); 
			        
			        record.headers().forEach(header -> {
	                    System.out.println("Header key: " + header.key() + ", value:" + header.value());
	                });
		        }
		        consumer.commitSync();
	            TimeUnit.SECONDS.sleep(5);
		   }
		}
		catch (Exception e) {
			e.printStackTrace();
	    } finally {
	    	consumer.close();
	    }
		    
	}
	
	
	  
	
	
	public String consumerTopic(){
		return "DONE";
	}

}
