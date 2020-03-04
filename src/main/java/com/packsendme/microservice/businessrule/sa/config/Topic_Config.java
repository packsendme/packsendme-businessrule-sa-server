package com.packsendme.microservice.businessrule.sa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Topic_Config {
	
	@Value(value = "${kafka.topic.executionBRE}")
	public String topic_executionrule_sa;
	
	@Value(value = "${kafka.topic.roadwayBRE}")
	public String topic_roadway_sa;
	
	@Value(value = "${kafka.topic.airwayBRE}")
	public String topic_airway_sa;
	
	@Value(value = "${kafka.topic.maritimewayBRE}")
	public String topic_maritimeway_sa;
}
