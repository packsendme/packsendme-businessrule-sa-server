package com.packsendme.microservice.sa.businessrule.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="packsendme-exchange-api")
public interface IExchange {

	@GetMapping("/api/exchange/rate/{current}")
	public ResponseEntity<?> getExchange(@Validated  @PathVariable ("current") String current);
	@GetMapping("/api/exchange/country/{countryCode}")
	public ResponseEntity<?> getCountry(@Validated  @PathVariable ("countryCode") String countryCode);		

}
