package com.packsendme.microservice.sa.businessrule.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import com.packsendme.microservice.sa.businessrule.controller.RoadwayBRE_Controller;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackageClasses = RoadwayBRE_Controller.class)
public class MicroserviceBusinessRuleServer_SA_Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBusinessRuleServer_SA_Application.class, args);
	}
}

