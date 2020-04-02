package com.packsendme.microservice.sa.businessrule.consumer.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

import com.packsendme.microservice.sa.businessrule.config.Consumer_Config;

@Component
public class MaritimewayBREConsumer_Component implements BRE_ConsumerT {

	Consumer_Config consumer_Config = new Consumer_Config();

	public void receive() {
        System.out.println("==================================================================="); 
        System.out.println(" RECEIVE"); 
        System.out.println("==================================================================="); 

		KafkaConsumer<String, String> consumer = consumer_Config.consumerFactory();
		consumer.subscribe(Arrays.asList("topicRoadwayBRE_SA_Instance"));
	    List<ConsumerRecord<String, String>> buffer = new ArrayList<ConsumerRecord<String, String>>();
	    while (true) {
	        ConsumerRecords<String, String> records = consumer.poll(100);

	        for (ConsumerRecord<String, String> record : records) {
	            buffer.add(record);
		        System.out.println("==================================================================="); 
	            System.err.println(buffer.size() + "----->" + record.value());
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
