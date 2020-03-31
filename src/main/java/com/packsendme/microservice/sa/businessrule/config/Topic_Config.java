package com.packsendme.microservice.sa.businessrule.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Topic_Config {
	
	@Value(value = "${kafka.topic.executionBRE}")
	public String topic_executionrule_sa;
	
	// ROADWAY
	@Value(value = "${kafka.topic.roadwayBRE_SA_Instance}")
	public String topicRoadwayInstance;
	@Value(value = "${kafka.topic.roadwayBRE_SA_Costs}")
	public String topicRoadwayCosts;
	
	// AIRWAY
	@Value(value = "${kafka.topic.airwayBRE_SA_Instance}")
	public String topicAirwayInstance;
	@Value(value = "${kafka.topic.airwayBRE_SA_Costs}")
	public String topicAirwayCosts;

	// MARITIMEWAY
	@Value(value = "${kafka.topic.maritimewayBRE_SA_Instance}")
	public String topicMaritimewayInstance;
	@Value(value = "${kafka.topic.maritimewayBRE_SA_Costs}")
	public String topicMaritimewayCosts;
}
