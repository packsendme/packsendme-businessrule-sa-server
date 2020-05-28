package com.packsendme.microservice.sa.businessrule.component;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.packsendme.exchange.bre.model.ExchangeBRE_Model;
import com.packsendme.exchange.bre.model.ExchangeCountryBRE_Model;
import com.packsendme.lib.common.constants.generic.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;

@Component
public class ParserData_Component {

	Gson gson = new Gson();
	
	// Parse Response HTTP the service ExchangeRateBRE 
	public ExchangeBRE_Model getParseExchange(ResponseEntity<?> cacheResponse) {
		ExchangeBRE_Model exchangeBRE = null;
		try{
			if(cacheResponse.getStatusCode() == HttpStatus.ACCEPTED) {
				String jsonPayload = cacheResponse.getBody().toString();
				Response<Object> response = gson.fromJson(jsonPayload, Response.class);
				if(response.getResponseCode() == HttpExceptionPackSend.FOUND_EXCHANGE.value()) {
					System.out.println(" MY OBJECT  "+ response.getBody().toString());
					String jsonObject = response.getBody().toString();
					exchangeBRE = gson.fromJson(jsonObject, ExchangeBRE_Model.class);
					System.out.println(" ");
					System.out.println(" ");
					System.out.println("===============================================================================");
					System.out.println("RoadwayBRE - name "+ exchangeBRE.value);
					System.out.println("RoadwayBRE - roadwayBRE_Dto  "+ exchangeBRE.toCurrent);
					System.out.println("===============================================================================");
					System.out.println(" ");
				}
			}
			return exchangeBRE;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Parse Response HTTP the service ExchangeRateBRE 
	public ExchangeCountryBRE_Model getParseCountryExchange(ResponseEntity<?> cacheResponse) {
		ExchangeCountryBRE_Model exchangeCountryBRE = null;
		try{
			if(cacheResponse.getStatusCode() == HttpStatus.ACCEPTED) {
				String jsonPayload = cacheResponse.getBody().toString();
				Response<Object> response = gson.fromJson(jsonPayload, Response.class);
				if(response.getResponseCode() == HttpExceptionPackSend.FOUND_EXCHANGE.value()) {
					System.out.println(" MY OBJECT  "+ response.getBody().toString());
					String jsonObject = response.getBody().toString();
					exchangeCountryBRE = gson.fromJson(jsonObject, ExchangeCountryBRE_Model.class);
					System.out.println(" ");
					System.out.println(" ");
					System.out.println("===============================================================================");
					System.out.println("RoadwayBRE - name "+ exchangeCountryBRE.currencyName);
					System.out.println("RoadwayBRE - currencySymbol "+ exchangeCountryBRE.currencySymbol);
					System.out.println("===============================================================================");
					System.out.println(" ");
				}
			}
			return exchangeCountryBRE;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
