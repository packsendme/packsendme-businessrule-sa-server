package com.packsendme.microservice.businessrule.sa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@org.springframework.context.annotation.Configuration
@ConfigurationProperties(prefix="packsendme-businessrulesa-server")
public class Configuration {
	
	@Setter
	@Getter
	public String topicBusinessRuleSouthAmericaDev;

}
