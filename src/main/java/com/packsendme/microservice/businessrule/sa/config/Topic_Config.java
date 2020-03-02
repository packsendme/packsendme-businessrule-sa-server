package com.packsendme.microservice.businessrule.sa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Topic_Config {
	
	@Value(value = "${kafka.topic.businessrule}")
	public String topic_businessrule_sa;
	
	@Value(value = "${kafka.topic.roadwaybre}")
	public String topic_roadway_bre_sa;
	
	@Value(value = "${kafka.topic.airwaybre}")
	public String topic_airway_bre_sa;

	@Value(value = "${kafka.topic.maritimewaybre}")
	public String topic_maritimeway_bre_sa;

}
