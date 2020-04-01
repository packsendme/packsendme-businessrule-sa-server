package com.packsendme.microservice.sa.businessrule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.packsendme.microservice.sa.businessrule.controller")
public class MicroserviceBusinessRuleServer_SA_Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBusinessRuleServer_SA_Application.class, args);
	}
}

