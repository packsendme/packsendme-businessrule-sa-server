package com.packsendme.microservice.businessrule.sa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@org.springframework.context.annotation.Configuration
@ConfigurationProperties(prefix="packsendme-businessrulesa-server")
public class TopicConf {
	
	@Setter
	@Getter
	public String topic_businessrule_sa;
	
	@Setter
	@Getter
	public String topic_roadway_sa;
	
	@Setter
	@Getter
	public String topic_airway_sa;

	@Setter
	@Getter
	public String topic_maritimeway_sa;

}
