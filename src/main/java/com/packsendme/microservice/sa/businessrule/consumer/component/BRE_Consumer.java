package com.packsendme.microservice.sa.businessrule.consumer.component;

public interface BRE_Consumer {
	
	//@KafkaListener
	public void receive(String data);
	
	
	public String consumerTopic();

}
