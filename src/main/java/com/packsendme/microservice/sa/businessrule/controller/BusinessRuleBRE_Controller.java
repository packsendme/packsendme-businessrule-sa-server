package com.packsendme.microservice.sa.businessrule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
			return businessRule_Services.executeOperation(0,object,"POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/execution/{id_rule}")
	public ResponseEntity<?> getExecutionBRE_SA(@Validated  @PathVariable ("id_rule") int id_rule) {		
		try {
			return businessRule_Services.executeOperation(id_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/execution/{id_rule}")
	public ResponseEntity<?> deleteExecutionBRE_SA(@Validated  @PathVariable ("id_rule") int id_rule) {		
		try {
			return businessRule_Services.executeOperation(id_rule,null,"DELETE");
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
			return businessRule_Services.roadwayOperation(0,object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" +++++++++++++++++++++++ postRoadwayBRE_SA ");

			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/roadway/{id_rule}")
	public ResponseEntity<?> getRoadwayBRE_SA(@Validated  @PathVariable ("id_rule") int id_rule) {		
		try {
			return businessRule_Services.roadwayOperation(id_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/roadway/{id_rule}")
	public ResponseEntity<?> deleteRoadwayBRE_SA(@Validated  @PathVariable ("id_rule") int id_rule) {		
		try {
			return businessRule_Services.roadwayOperation(id_rule,null,"DELETE");
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
			return businessRule_Services.airwayOperation(0,object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/airway/{id_rule}")
	public ResponseEntity<?> getAirwayBRE_SA(@Validated  @PathVariable ("id_rule") int id_rule) {		
		try {
			return businessRule_Services.airwayOperation(id_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/airway/{id_rule}")
	public ResponseEntity<?> deleteAirwayBRE_SA(@Validated @PathVariable ("id_rule") int id_rule) {		
		try {
			return businessRule_Services.airwayOperation(id_rule,null,"DELETE");
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
			return businessRule_Services.maritimewayOperation(0,object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/maritimeway")
	public ResponseEntity<?> getMaritimewayBRE_SA(@Validated @PathVariable ("id_rule") int id_rule) {		
		try {
			return businessRule_Services.maritimewayOperation(id_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/maritimeway")
	public ResponseEntity<?> deleteMaritimewayBRE_SA(@Validated @PathVariable ("id_rule") int id_rule) {		
		try {
			return businessRule_Services.maritimewayOperation(id_rule,null,"DELETE");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
