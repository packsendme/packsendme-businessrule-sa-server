package com.packsendme.microservice.sa.businessrule.consumer.component;

import java.time.Duration;
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
	        String grp_id="group-id";  
	        String topic="topicRoadwayBRE_SA_Instance";  
	        //Creating consumer properties  
	        Properties properties=new Properties();  
	        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);  
	        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,   StringDeserializer.class.getName());  
	        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());  
	        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,grp_id);  
	        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");  

		
		
		
		
        System.out.println("==================================================================="); 
        System.out.println(" RECEIVE"); 
        System.out.println("==================================================================="); 
        
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(properties);
		consumer.subscribe(Arrays.asList(topic));
	    while (true) {
	        ConsumerRecords<String, String> records = consumer.poll(1000);
	        System.out.println(records.count());

	        for (ConsumerRecord<String, String> record : records) {
		        System.out.println("==================================================================="); 
	            System.err.println(" VALUE ----->" + record.value());
		        System.out.println("==================================================================="); 

	        }
	    }
		/*final int giveUp = 100;   int noRecordsCount = 0;
	        while (true) {
	            final ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
	            if (consumerRecords.count()==0) {
	                noRecordsCount++;
	                if (noRecordsCount > giveUp) break;
	                else continue;
	            }
	            consumerRecords.forEach(record -> {
	                System.out.printf("Consumer Record:(%d, %s, %d, %d)\n",
	                        record.key(), record.value(),
	                        record.partition(), record.offset());
	                
	            });
	            
	            consumer.commitAsync();
	        }
	        consumer.close();
	        System.out.println("DONE"); */
	}
	
	
	  
	
	
	public String consumerTopic(){
		return "DONE";
	}

}
