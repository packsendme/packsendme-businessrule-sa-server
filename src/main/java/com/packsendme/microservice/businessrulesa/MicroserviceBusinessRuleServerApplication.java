package com.packsendme.microservice.businessrulesa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceBusinessRuleServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBusinessRuleServerApplication.class, args);
	}
}

