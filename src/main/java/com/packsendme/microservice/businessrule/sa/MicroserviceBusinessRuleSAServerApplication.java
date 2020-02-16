package com.packsendme.microservice.businessrule.sa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceBusinessRuleSAServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBusinessRuleSAServerApplication.class, args);
	}
}

