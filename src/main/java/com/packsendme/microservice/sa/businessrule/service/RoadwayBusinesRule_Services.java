package com.packsendme.microservice.sa.businessrule.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.exchange.bre.model.ExchangeBRE_Model;
import com.packsendme.exchange.bre.model.ExchangeCountryBRE_Model;
import com.packsendme.lib.common.constants.generic.HttpExceptionPackSend;
import com.packsendme.lib.common.constants.generic.MicroservicesConstants;
import com.packsendme.lib.common.response.Response;
import com.packsendme.microservice.sa.businessrule.component.RoadwayConvertCurrent;
import com.packsendme.microservice.sa.businessrule.component.ParserData_Component;
import com.packsendme.microservice.sa.businessrule.config.Cache_Config;
import com.packsendme.microservice.sa.businessrule.controller.IExchange;
import com.packsendme.microservice.sa.businessrule.dao.BusinessRuleImpl_DAO;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;

@Service
@ComponentScan("{com.packsendme.microservice.sa.businessrule.dao,"
		+ "com.packsendme.microservice.sa.businessrule.component}")
@EnableFeignClients(basePackages="com.packsendme.microservice.sa.businessrule.controller")
public class RoadwayBusinesRule_Services {

	public enum Operation_Enum {
		GET, POST, DELETE;
	}
	
	@Autowired
	Cache_Config cacheConfig;
	
	@Autowired
	BusinessRuleImpl_DAO<RoadwayBRE_Model> roadwayBREImpl_DAO;
	
	@Autowired
	IExchange exchangeRate_Client;
	
	@Autowired
	private ParserData_Component parserData;
	@Autowired
	private RoadwayConvertCurrent convertCurrent;
	


	public ResponseEntity<?> roadwayOperation(String name_rule, RoadwayBRE_Model roadwayEntity, String operation, Map headInformation) {
		Response<RoadwayBRE_Model> responseObj = null;
		RoadwayBRE_Model roadwayObj = null;
		boolean result;
		try {
			if(operation.equals(Operation_Enum.GET.toString())) {
				roadwayObj = roadwayBREImpl_DAO.findOne(cacheConfig.roadwayBRE_SA,name_rule);
				if(roadwayObj != null) {
					if(headInformation.get("originApp").toString().equals(MicroservicesConstants.WEB_REQUEST_ORIGIN)) {
						// Exchange API
						ResponseEntity<?> exchangeResponse = exchangeRate_Client.getExchange(headInformation.get("isoCurrencyCode").toString());
						ExchangeBRE_Model exchangeBRE = parserData.getParseExchange(exchangeResponse);
						
						// Country-Exchange API
						ResponseEntity<?> exchangeCountryResponse = exchangeRate_Client.getCountry(headInformation.get("isoCountryCode").toString());
						ExchangeCountryBRE_Model exchangeCountryBRE = parserData.getParseCountryExchange(exchangeCountryResponse);
						
						// Convert Value to Exchange Country-Origin
						roadwayObj = convertCurrent.opGETConvertToCountryOrigin(roadwayObj, exchangeCountryBRE.currencyName);
						responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), roadwayObj);

					}
					else{
						responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), roadwayObj);
					}
				}
				else {
					responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				}
			}
			else if(operation.equals(Operation_Enum.DELETE.toString())) {
				result = roadwayBREImpl_DAO.delete(cacheConfig.roadwayBRE_SA,name_rule);
				if(result == true) {
					responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), null);
				}
				else {
					responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				}
			}
			else if(operation.equals(Operation_Enum.POST.toString())) {
				if(headInformation.get("originApp").toString().equals(MicroservicesConstants.WEB_REQUEST_ORIGIN)) {
					// Exchange API
					ResponseEntity<?> exchangeResponse = exchangeRate_Client.getExchange(headInformation.get("isoCurrencyCode").toString());
					ExchangeBRE_Model exchangeBRE = parserData.getParseExchange(exchangeResponse);
					
					// Country-Exchange API
					ResponseEntity<?> exchangeCountryResponse = exchangeRate_Client.getCountry(headInformation.get("isoCountryCode").toString());
					ExchangeCountryBRE_Model exchangeCountryBRE = parserData.getParseCountryExchange(exchangeCountryResponse);
					
					// Convert Value to Exchange Country-Origin
					roadwayObj = convertCurrent.opPOSTConvertToDollar(roadwayEntity, exchangeBRE.value, exchangeCountryBRE.currencyName);
					result = roadwayBREImpl_DAO.add(cacheConfig.roadwayBRE_SA,roadwayObj.name_rule,roadwayObj);
				}
				else{
					result = roadwayBREImpl_DAO.add(cacheConfig.roadwayBRE_SA,roadwayEntity.name_rule,roadwayEntity);
					responseObj = new Response<RoadwayBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
				}
				// ResultOperation - POST
				if(result == true) {
					responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.BUSINESS_RULE.value(),HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
				}
				else {
				 responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				}
			}
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			e.printStackTrace();
			responseObj = new Response<RoadwayBRE_Model>(HttpExceptionPackSend.FAIL_EXECUTION.value(),HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
