package com.packsendme.microservice.sa.businessrule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packsendme.airway.bre.rule.model.AirwayBRE_Model;
import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;
import com.packsendme.financecostdelivery.bre.model.FinanceCostDeliveryBRE_Model;
import com.packsendme.maritimeway.bre.rule.model.MaritimewayBRE_Model;
import com.packsendme.microservice.sa.businessrule.service.BusinessRule_Services;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;
import com.packsendme.tollsfuel.bre.model.TollsFuelBRE_Model;

@RestController
@RequestMapping("/businessrule/sa")
public class BusinessRuleBRE_Controller {
	
	@Autowired
	private BusinessRule_Services businessRule_Services; 
	
	
	//========================================================================================
	// METHOD POST|GET :: EXECUTION-BRE
	//========================================================================================//

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/execution")
	public ResponseEntity<?> postExecutionBRE_SA(@Validated @RequestBody ExecutionBRE_Model object) {		
		try {
			return businessRule_Services.executeOperation(null,object,"POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/execution/{name_rule}")
	public ResponseEntity<?> getExecutionBRE_SA(@Validated  @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.executeOperation(name_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/execution/{name_rule}")
	public ResponseEntity<?> deleteExecutionBRE_SA(@Validated  @PathVariable ("name_rule") String name_rule) {		
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
	public ResponseEntity<?> postRoadwayBRE_SA(@Validated @RequestBody RoadwayBRE_Model object) {		
		try {
			return businessRule_Services.roadwayOperation(null,object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" +++++++++++++++++++++++ postRoadwayBRE_SA ");

			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/roadway/{name_rule}")
	public ResponseEntity<?> getRoadwayBRE_SA(@Validated  @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.roadwayOperation(name_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/roadway/{name_rule}")
	public ResponseEntity<?> deleteRoadwayBRE_SA(@Validated  @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.roadwayOperation(name_rule,null,"DELETE");
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
	public ResponseEntity<?> postAirwayBRE_SA(@Validated @RequestBody AirwayBRE_Model object) {		
		try {
			return businessRule_Services.airwayOperation(null,object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/airway/{name_rule}")
	public ResponseEntity<?> getAirwayBRE_SA(@Validated @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.airwayOperation(name_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/airway/{name_rule}")
	public ResponseEntity<?> deleteAirwayBRE_SA(@Validated @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.airwayOperation(name_rule,null,"DELETE");
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
	public ResponseEntity<?> postMaritimewayBRE_SA(@Validated @RequestBody MaritimewayBRE_Model object) {		
		try {
			return businessRule_Services.maritimewayOperation(null,object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/maritimeway/{name_rule}")
	public ResponseEntity<?> getMaritimewayBRE_SA(@Validated @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.maritimewayOperation(name_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/maritimeway/{name_rule}")
	public ResponseEntity<?> deleteMaritimewayBRE_SA(@Validated @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.maritimewayOperation(name_rule,null,"DELETE");
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
	public ResponseEntity<?> postTollsFuelBRE_SA(@Validated @RequestBody TollsFuelBRE_Model object) {		
		try {
			return businessRule_Services.tollsFuelOperation(null,object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/tollsfuel/{name_rule}")
	public ResponseEntity<?> getTollsFuelBRE_SA(@Validated @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.tollsFuelOperation(name_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/tollsfuel/{name_rule}")
	public ResponseEntity<?> deleteTollsFuelBRE_SA(@Validated @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.tollsFuelOperation(name_rule,null,"DELETE");
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
	public ResponseEntity<?> postFinanceCostDeliveryBRE_SA(@Validated @RequestBody FinanceCostDeliveryBRE_Model object) {		
		try {
			return businessRule_Services.financeCostDeliveryOperation(null,object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/financecostdelivery")
	public ResponseEntity<?> getFinanceCostDeliveryBRE_SA(@Validated @RequestParam ("rule_type") String rule_type) {		
		try {
			return businessRule_Services.financeCostDeliveryOperation(rule_type,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/financecostdelivery")
	public ResponseEntity<?> deleteFinanceCostDeliveryBRE_SA(@Validated @RequestParam ("rule_type") String rule_type) {		
		try {
			return businessRule_Services.financeCostDeliveryOperation(rule_type,null,"DELETE");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
