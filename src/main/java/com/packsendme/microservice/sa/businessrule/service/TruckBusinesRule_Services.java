package com.packsendme.microservice.sa.businessrule.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.lib.common.constants.generic.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.microservice.sa.businessrule.config.Cache_Config;
import com.packsendme.microservice.sa.businessrule.dao.BusinessRuleImpl_DAO;
import com.packsendme.truck.bre.model.TruckBRE_Model;

@Service
@ComponentScan("{com.packsendme.microservice.sa.businessrule.dao,"
		+ "com.packsendme.microservice.sa.businessrule.component}")
public class TruckBusinesRule_Services {

	public enum Operation_Enum {
		GET, POST;
	}
	
	@Autowired
	Cache_Config cacheConfig;
	
	@Autowired
	BusinessRuleImpl_DAO<TruckBRE_Model> truckBREImpl_DAO;

	
	public ResponseEntity<?> truckOperation(String name_rule, TruckBRE_Model truckEntity, String operation, Map headInformation) {
		Response<TruckBRE_Model> responseObj = null;
		TruckBRE_Model truckObj = null;
		boolean result;
		
		try {
			 if(operation.equals(Operation_Enum.GET.toString())) {
				 truckObj = truckBREImpl_DAO.findOne(cacheConfig.truckBRE_SA,name_rule);
				 
				 if(truckObj != null) {
					responseObj = new Response<TruckBRE_Model>(HttpExceptionPackSend.FOUND_BUSINESS_RULE.value(),HttpExceptionPackSend.FOUND_BUSINESS_RULE.getAction(), truckObj);
				}
				else {
					 responseObj = new Response<TruckBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
				}
			 }
			 else if(operation.equals(Operation_Enum.POST.toString())) {
					result = truckBREImpl_DAO.add(cacheConfig.tollsfuelBRE_SA, truckEntity.name_rule, truckEntity);
	
					if(result == true) {
						responseObj = new Response<TruckBRE_Model>(HttpExceptionPackSend.BUSINESS_RULE.value(),HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
					}
					else {
					 responseObj = new Response<TruckBRE_Model>(HttpExceptionPackSend.NOT_BUSINESS_RULE.value(),HttpExceptionPackSend.NOT_BUSINESS_RULE.getAction(), null);
					}
			 }
			 return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			responseObj = new Response<TruckBRE_Model>(0,HttpExceptionPackSend.BUSINESS_RULE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
