package com.packsendme.microservice.businessrule.sa.config;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@org.springframework.context.annotation.Configuration
public class TopicConfig {
	
	@Value("${name}")
	public String topic_businessrule_sa;
	
	@Setter
	@Getter
	public String topic_roadway_bre_sa;
	
	@Setter
	@Getter
	public String topic_airway_bre_sa;

	@Setter
	@Getter
	public String topic_maritimeway_bre_sa;

}
