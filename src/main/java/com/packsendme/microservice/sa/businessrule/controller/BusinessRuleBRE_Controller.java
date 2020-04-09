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
import com.packsendme.fuel.bre.rule.model.FuelBRE_Model;
import com.packsendme.maritimeway.bre.rule.model.MaritimewayBRE_Model;
import com.packsendme.microservice.sa.businessrule.service.BusinessRule_Services;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;
import com.packsendme.tolls.bre.model.TollsBRE_Model;

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
			return businessRule_Services.executeOperation(null,object,"POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/execution/{id_rule}")
	public ResponseEntity<?> getExecutionBRE_SA(@Validated  @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.executeOperation(name_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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
	
	@GetMapping("/roadway/{name_rule}")
	public ResponseEntity<?> getRoadwayBRE_SA(@Validated  @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.roadwayOperation(name_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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

	@PostMapping("/airway")
	public ResponseEntity<?> postAirwayBRE_SA(@Validated @RequestBody AirwayBRE_Model object) {		
		try {
			return businessRule_Services.airwayOperation(null,object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/airway/{name_rule}")
	public ResponseEntity<?> getAirwayBRE_SA(@Validated @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.airwayOperation(name_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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

	@PostMapping("/maritimeway")
	public ResponseEntity<?> postMaritimewayBRE_SA(@Validated @RequestBody MaritimewayBRE_Model object) {		
		try {
			return businessRule_Services.maritimewayOperation(null,object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/maritimeway/{name_rule}")
	public ResponseEntity<?> getMaritimewayBRE_SA(@Validated @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.maritimewayOperation(name_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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
	// METHOD POST|GET :: TOLLS-BRE
	//========================================================================================//

	@PostMapping("/tolls")
	public ResponseEntity<?> postTollsBRE_SA(@Validated @RequestBody TollsBRE_Model object) {		
		try {
			return businessRule_Services.tollsOperation(null,object, "POST");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/tolls/{name_rule}")
	public ResponseEntity<?> getTollsBRE_SA(@Validated @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.tollsOperation(name_rule,null,"GET");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/tolls/{name_rule}")
	public ResponseEntity<?> deleteTollsBRE_SA(@Validated @PathVariable ("name_rule") String name_rule) {		
		try {
			return businessRule_Services.tollsOperation(name_rule,null,"DELETE");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//========================================================================================
	// METHOD POST|GET :: FUEL-BRE
	//========================================================================================//

		@PostMapping("/fuel")
		public ResponseEntity<?> postFuelBRE_SA(@Validated @RequestBody FuelBRE_Model object) {		
			try {
				return businessRule_Services.fuelOperation(null,object,"POST");
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/fuel/{name_rule}")
		public ResponseEntity<?> getFuelBRE_SA(@Validated @PathVariable ("name_rule") String name_rule) {		
			try {
				return businessRule_Services.fuelOperation(name_rule,null,"GET");
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/fuel/{name_rule}")
		public ResponseEntity<?> deleteFuelBRE_SA(@Validated @PathVariable ("name_rule") String name_rule) {		
			try {
				return businessRule_Services.fuelOperation(name_rule,null,"DELETE");
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	
}
