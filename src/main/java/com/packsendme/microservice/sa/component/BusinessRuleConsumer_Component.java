package com.packsendme.microservice.sa.component;

public class BusinessRuleConsumer_Component {

	private String businessRuleMsg; 
	/*
	@KafkaListener(topics = "${kafka.topic.businessrule}")
	public void receiveTopic(String msg) {
		this.businessRuleMsg = msg;
		System.out.println(" ---------------------------- ");
		System.out.println(" topic_businessRule_sa "+ msg);
		System.out.println(" ---------------------------- ");
	}

	public String contextMsg() {
		return businessRuleMsg;
	}
	*/
}
