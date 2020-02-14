package com.packsendme.microservice.businessrule.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix="packsendme-businessrule-server")
public class Configuration {

	@Setter
	@Getter
	public String topic_simulation_southamerica;
	
	@Setter
	@Getter
	public String topic_simulation_europe;

	@Setter
	@Getter
	public String topic_simulation_eua;
	
}
