package com.packsendme.microservice.sa.businessrule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
		exclude = { RedisRepositoriesAutoConfiguration.class }
)
@EnableEurekaClient
public class MicroserviceBusinessRuleServer_SA_Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBusinessRuleServer_SA_Application.class, args);
	}
}

