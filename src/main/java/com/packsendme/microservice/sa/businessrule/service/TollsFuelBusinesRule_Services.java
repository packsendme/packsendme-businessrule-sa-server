package com.packsendme.microservice.sa.businessrule.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.exchange.bre.model.ExchangeBRE_Model;
import com.packsendme.exchange.bre.model.ExchangeCountryBRE_Model;
import com.packsendme.lib.common.constants.generic.HttpExceptionPackSend;
import com.packsendme.lib.common.constants.generic.MicroservicesConstants;
import com.packsendme.lib.common.response.Response;
import com.packsendme.microservice.sa.businessrule.component.ParserData_Component;
import com.packsendme.microservice.sa.businessrule.component.TollsFuelConvertCurrent;
import com.packsendme.microservice.sa.businessrule.config.Cache_Config;
import com.packsendme.microservice.sa.businessrule.controller.IExchange;
import com.packsendme.microservice.sa.businessrule.dao.BusinessRuleImpl_DAO;
import com.packsendme.tollsfuel.bre.model.TollsFuelBRE_Model;

@Service
@ComponentScan("{com.packsendme.microservice.sa.businessrule.dao,"
		+ "com.packsendme.microservice.sa.businessrule.component}")
//@EnableFeignClients(basePackages="com.packsendme.microservice.sa.businessrule.controller")
public class TollsFuelBusinesRule_Services {

	public enum Operation_Enum {
		GET, POST, DELETE;
	}
	
	@Autowired
	Cache_Config cacheConfig;
	
	@Autowired
	BusinessRuleImpl_DAO<TollsFuelBRE_Model> tollsFuelBREImpl_DAO;
	
	@Autowired
	IExchange exchangeRate_Client;
	
	@Autowired
	private ParserData_Component parserData;
	@Autowired
	private TollsFuelConvertCurrent convertCurrent;
	


	public ResponseEntity<?> tollsFuelOperation(String name_rule, TollsFuelBRE_Model tollsEntity, String operation, Map headInformation) {
		Response<TollsFuelBRE_Model> responseObj = null;
		TollsFuelBRE_Model tollsFuelObj = null;
		boolean result;
		
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 tollsFuelObj = tollsFuelBREImpl_DAO.findOne(cacheConfig.tollsfuelBRE_SA,name_rule);
				 
				 if(tollsFuelObj != null) {
					 if(headInformation.get("originApp").toString().equals(MicroservicesConstants.WEB_REQUEST_ORIGIN)) {
						 // Exchange API
						ResponseEntity<?> exchangeResponse = exchangeRate_Client.getExchange(headInformation.get("isoCurrencyCode").toString());
						ExchangeBRE_Model exchangeBRE = parserData.getParseExchange(exchangeResponse);
							
						// Country-Exchange API
						ResponseEntity<?> exchangeCountryResponse = exchangeRate_Client.getCountry(headInformation.get("isoCountryCode").toString());
						ExchangeCountryBRE_Model exchangeCountryBRE = parserData.getParseCountryExchange(exchangeCountryResponse);
							
						// Convert Value to Exchange Country-Origin
						tollsFuelObj = convertCurrent.opGETConvertToCountryOrigin(tollsFuelObj, exchangeCountryBRE.currencyName);
					}
					else{
						responseObj = new Response<TollsFuelBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), tollsFuelObj);
					}
				}
				else {
					 responseObj = new Response<TollsFuelBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				}
			 }
			 else if(operation.equals(Operation_Enum.DELETE.toString())) {
				 result = tollsFuelBREImpl_DAO.delete(cacheConfig.tollsfuelBRE_SA,name_rule);
				 
				 if(result == true) {
					 responseObj = new Response<TollsFuelBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<TollsFuelBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
				 if(headInformation.get("originApp").toString().equals(MicroservicesConstants.WEB_REQUEST_ORIGIN)) {
					 // Exchange API
					ResponseEntity<?> exchangeResponse = exchangeRate_Client.getExchange(headInformation.get("isoCurrencyCode").toString());
					ExchangeBRE_Model exchangeRateBRE = parserData.getParseExchange(exchangeResponse);
						
					// Country-Exchange API
					ResponseEntity<?> exchangeCountryResponse = exchangeRate_Client.getCountry(headInformation.get("isoCountryCode").toString());
					ExchangeCountryBRE_Model exchangeCountryBRE = parserData.getParseCountryExchange(exchangeCountryResponse);
							
					// Convert Value to Exchange Country-Origin
					tollsFuelObj = convertCurrent.opPOSTConvertToDollar(tollsEntity, exchangeRateBRE.value, exchangeCountryBRE.currencyName);
					result = tollsFuelBREImpl_DAO.add(cacheConfig.tollsfuelBRE_SA, tollsFuelObj.name_rule, tollsFuelObj);
				}
				else{
					result = tollsFuelBREImpl_DAO.add(cacheConfig.tollsfuelBRE_SA, tollsEntity.name_rule, tollsEntity);
				}
	
				 if(result == true) {
					 responseObj = new Response<TollsFuelBRE_Model>(HttpExceptionPackSend.BUSINESS_RULE.value(),HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
				 }
				 else {
					 responseObj = new Response<TollsFuelBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				 }
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			responseObj = new Response<TollsFuelBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

}
