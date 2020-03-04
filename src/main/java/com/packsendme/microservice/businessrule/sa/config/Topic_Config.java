package com.packsendme.microservice.businessrule.sa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Topic_Config {
	
	@Value(value = "${kafka.topic.businessrule}")
	public String topic_businessrule_sa;
	
	@Value(value = "${kafka.topic.roadway}")
	public String topic_roadway_sa;
	
	@Value(value = "${kafka.topic.airway}")
	public String topic_airway_sa;
	
	@Value(value = "${kafka.topic.maritimeway}")
	public String topic_maritimeway_sa;
}
