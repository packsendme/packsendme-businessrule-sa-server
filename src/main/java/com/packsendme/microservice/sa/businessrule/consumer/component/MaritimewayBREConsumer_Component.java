package com.packsendme.microservice.sa.businessrule.consumer.component;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.stereotype.Component;

import com.packsendme.microservice.sa.businessrule.config.Consumer_Config;

@Component
public class MaritimewayBREConsumer_Component implements BRE_ConsumerT {

	Consumer_Config consumer_Config = new Consumer_Config();

	public void receive() {
		 final Consumer<Long, String> consumer = consumer_Config.consumerFactory();
		 String msg = "";
	        final int giveUp = 100;   int noRecordsCount = 0;
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
	        System.out.println("DONE");
	}
	
	public String consumerTopic(){
		return "DONE";
	}

}
