package com.packsendme.microservice.sa.businessrule.consumer.component;

import org.springframework.stereotype.Component;

@Component
public class RoadwayBREConsumer_Component extends ConsumerBRE_Abstract{

	
//	@KafkaListener(topics = "${kafka.topic.roadwayBRE_SA_Instance}")
	public void receiveTopic_instance(String msg) {
		this.setMsg_Topic_instance(msg);
	}

//	@KafkaListener(topics = "${kafka.topic.roadwayBRE_SA_Costs}")
	public void receiveTopic_cots(String msg) {
		this.setMsg_Topic_costs(msg);
	}
	
	
 

}
