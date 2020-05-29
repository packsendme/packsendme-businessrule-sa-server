package com.packsendme.microservice.sa.businessrule.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packsendme.airway.bre.rule.model.AirwayBRE_Model;
import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;
import com.packsendme.financecostdelivery.bre.model.FinanceCostDeliveryBRE_Model;
import com.packsendme.maritimeway.bre.rule.model.MaritimewayBRE_Model;
import com.packsendme.microservice.sa.businessrule.service.BusinessRule_Services;
import com.packsendme.microservice.sa.businessrule.service.RoadwayBusinesRule_Services;
import com.packsendme.microservice.sa.businessrule.service.TollsFuelBusinesRule_Services;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;
import com.packsendme.tollsfuel.bre.model.TollsFuelBRE_Model;

@RestController
@RequestMapping("/businessrule/sa")
public class BusinessRuleBRE_Controller {
	
	@Autowired
	private BusinessRule_Services businessRule_Services;
	
	@Autowired
	private RoadwayBusinesRule_Services roadway_Services;
	
	@Autowired
	private TollsFuelBusinesRule_Services tollsfuel_Services;
	
	private Map<String,Object> headInformation = new HashMap<String,Object>();
	
	//========================================================================================
	// METHOD POST|GET :: EXECUTION-BRE
	//========================================================================================//

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/execution")
	public ResponseEntity<?> postExecutionBRE_SA(
			@Validated @RequestBody ExecutionBRE_Model object) {		
		try {
			return businessRule_Services.executeOperation(null,object,"POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/execution")
	public ResponseEntity<?> getExecutionBRE_SA(@Validated  @RequestHeader ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.executeOperation(name_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/execution")
	public ResponseEntity<?> deleteExecutionBRE_SA(@Validated  @RequestHeader ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.executeOperation(name_rule,null,"DELETE");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	//========================================================================================
	// METHOD POST|GET :: ROADWAY-BRE
	//========================================================================================//

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/roadway")
	public ResponseEntity<?> postRoadwayBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestBody RoadwayBRE_Model object) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);
			
			return roadway_Services.roadwayOperation(null,object, "POST", headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" +++++++++++++++++++++++ postRoadwayBRE_SA ");

			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/roadway")
	public ResponseEntity<?> getRoadwayBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated  @RequestParam ("name_rule") String name_rule) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);
			return roadway_Services.roadwayOperation(name_rule,null,"GET",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/roadway")
	public ResponseEntity<?> deleteRoadwayBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated  @RequestParam ("name_rule") String name_rule) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);
			return roadway_Services.roadwayOperation(name_rule,null,"DELETE",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//========================================================================================
	// METHOD POST|GET :: AIRWAY-BRE
	//========================================================================================//

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/airway")
	public ResponseEntity<?> postAirwayBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestBody AirwayBRE_Model object) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);

			return businessRule_Services.airwayOperation(null,object, "POST",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/airway")
	public ResponseEntity<?> getAirwayBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestParam ("name_rule") String name_rule) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);

			return businessRule_Services.airwayOperation(name_rule,null,"GET",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/airway")
	public ResponseEntity<?> deleteAirwayBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestParam ("name_rule") String name_rule) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);
			return businessRule_Services.airwayOperation(name_rule,null,"DELETE",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//========================================================================================
	// METHOD POST|GET :: MARITIMEWAY-BRE
	//========================================================================================//

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/maritimeway")
	public ResponseEntity<?> postMaritimewayBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestBody MaritimewayBRE_Model object) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);

			return businessRule_Services.maritimewayOperation(null,object, "POST",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/maritimeway")
	public ResponseEntity<?> getMaritimewayBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestParam ("name_rule") String name_rule) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);

			return businessRule_Services.maritimewayOperation(name_rule,null,"GET",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/maritimeway")
	public ResponseEntity<?> deleteMaritimewayBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestParam ("name_rule") String name_rule) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);
			return businessRule_Services.maritimewayOperation(name_rule,null,"DELETE",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//========================================================================================
	// METHOD POST|GET :: TOLLSFUEL-BRE
	//========================================================================================//

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/tollsfuel")
	public ResponseEntity<?> postTollsFuelBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestBody TollsFuelBRE_Model object) {		

		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);

			return tollsfuel_Services.tollsFuelOperation(null,object, "POST",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/tollsfuel")
	public ResponseEntity<?> getTollsFuelBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestParam ("name_rule") String name_rule) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);

			return tollsfuel_Services.tollsFuelOperation(name_rule,null,"GET",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/tollsfuel")
	public ResponseEntity<?> deleteTollsFuelBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestParam ("name_rule") String name_rule) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);
			return tollsfuel_Services.tollsFuelOperation(name_rule,null,"DELETE",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//========================================================================================
		// METHOD POST|GET :: FinanceCostDelivery-BRE
		//========================================================================================//

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/financecostdelivery")
	public ResponseEntity<?> postFinanceCostDeliveryBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestBody FinanceCostDeliveryBRE_Model object) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);

			return businessRule_Services.financeCostDeliveryOperation(null,object, "POST",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/financecostdelivery")
	public ResponseEntity<?> getFinanceCostDeliveryBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestParam ("name_rule") String name_rule) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);

			return businessRule_Services.financeCostDeliveryOperation(name_rule,null,"GET",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/financecostdelivery")
	public ResponseEntity<?> deleteFinanceCostDeliveryBRE_SA(
			@RequestHeader("isoLanguageCode") String isoLanguageCode, 
			@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,
			@RequestHeader("originApp") String originApp,
			@Validated @RequestParam ("name_rule") String rule_type) {		
		try {
			headInformation.put("isoLanguageCode", isoLanguageCode);
			headInformation.put("isoCountryCode", isoCountryCode);
			headInformation.put("isoCurrencyCode", isoCurrencyCode);
			headInformation.put("originApp", originApp);
			return businessRule_Services.financeCostDeliveryOperation(rule_type,null,"DELETE",headInformation);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
