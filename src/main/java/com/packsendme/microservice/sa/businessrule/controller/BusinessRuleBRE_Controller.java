package com.packsendme.microservice.sa.businessrule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packsendme.airway.bre.rule.model.AirwayBRE_Model;
import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;
import com.packsendme.maritimeway.bre.rule.model.MaritimewayBRE_Model;
import com.packsendme.microservice.sa.businessrule.service.BusinessRule_Services;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;

@RestController
@RequestMapping("/businessrule/sa")
public class BusinessRuleBRE_Controller {
	
	@Autowired
	private BusinessRule_Services businessRule_Services; 
	
	
	//========================================================================================
	// METHOD POST|GET :: EXECUTION-BRE
	//========================================================================================//

	@PostMapping("/execution")
	public ResponseEntity<?> postExecutionBRE_SA(@Validated @RequestBody ExecutionBRE_Model object) {		
		try {
			return businessRule_Services.executeOperation(object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/execution")
	public ResponseEntity<?> getExecutionBRE_SA(@Validated @RequestBody ExecutionBRE_Model object) {		
		try {
			return businessRule_Services.executeOperation(object, "GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/execution")
	public ResponseEntity<?> deleteExecutionBRE_SA(@Validated @RequestBody ExecutionBRE_Model object) {		
		try {
			return businessRule_Services.executeOperation(object, "DELETE");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	//========================================================================================
	// METHOD POST|GET :: ROADWAY-BRE
	//========================================================================================//

	@PostMapping("/roadway")
	public ResponseEntity<?> postRoadwayBRE_SA(@Validated @RequestBody RoadwayBRE_Model object) {		
		try {
			return businessRule_Services.roadwayOperation(object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" +++++++++++++++++++++++ postRoadwayBRE_SA ");

			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/roadway")
	public ResponseEntity<?> getRoadwayBRE_SA(@Validated @RequestBody RoadwayBRE_Model object) {		
		try {
			return businessRule_Services.roadwayOperation(object, "GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/roadway")
	public ResponseEntity<?> deleteRoadwayBRE_SA(@Validated @RequestBody RoadwayBRE_Model object) {		
		try {
			return businessRule_Services.roadwayOperation(object, "DELETE");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//========================================================================================
	// METHOD POST|GET :: AIRWAY-BRE
	//========================================================================================//

	@PostMapping("/airway")
	public ResponseEntity<?> postAirwayBRE_SA(@Validated @RequestBody AirwayBRE_Model object) {		
		try {
			return businessRule_Services.airwayOperation(object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/airway")
	public ResponseEntity<?> getAirwayBRE_SA(@Validated @RequestBody AirwayBRE_Model object) {		
		try {
			return businessRule_Services.airwayOperation(object, "GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/airway")
	public ResponseEntity<?> deleteAirwayBRE_SA(@Validated @RequestBody AirwayBRE_Model object) {		
		try {
			return businessRule_Services.airwayOperation(object, "DELETE");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//========================================================================================
	// METHOD POST|GET :: MARITIMEWAY-BRE
	//========================================================================================//

	@PostMapping("/maritimeway")
	public ResponseEntity<?> postMaritimewayBRE_SA(@Validated @RequestBody MaritimewayBRE_Model object) {		
		try {
			return businessRule_Services.maritimewayOperation(object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/maritimeway")
	public ResponseEntity<?> getMaritimewayBRE_SA(@Validated @RequestBody MaritimewayBRE_Model object) {		
		try {
			return businessRule_Services.maritimewayOperation(object, "GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/maritimeway")
	public ResponseEntity<?> deleteMaritimewayBRE_SA(@Validated @RequestBody MaritimewayBRE_Model object) {		
		try {
			return businessRule_Services.maritimewayOperation(object, "DELETE");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
