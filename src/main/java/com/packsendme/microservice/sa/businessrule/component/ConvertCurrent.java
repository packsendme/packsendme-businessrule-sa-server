package com.packsendme.microservice.sa.businessrule.component;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.packsendme.lib.common.constants.way.Roadway_Constants;
import com.packsendme.roadway.bre.rule.costs.model.RuleCosts_Model;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;

@Component
public class ConvertCurrent {
	
	// Execute to GET operation	
	public RoadwayBRE_Model opGETConvertToCountryOrigin(RoadwayBRE_Model roadwayBRE, double vlr_tax, String country) {
			
		Map<String,RuleCosts_Model> ruleCostsMap = roadwayBRE.getRuleCosts().get(country);
		
		RuleCosts_Model ruleCosts_BICYCLE = ruleCostsMap.get(Roadway_Constants.ROADWAY_BICYCLE); 
		RuleCosts_Model ruleCosts_CAR = ruleCostsMap.get(Roadway_Constants.ROADWAY_CAR); 
		RuleCosts_Model ruleCosts_MOTORCYCLE = ruleCostsMap.get(Roadway_Constants.ROADWAY_MOTORCYCLE); 
		RuleCosts_Model ruleCosts_TRUCK = ruleCostsMap.get(Roadway_Constants.ROADWAY_TRUCK); 
		RuleCosts_Model ruleCosts_WALKING = ruleCostsMap.get(Roadway_Constants.ROADWAY_WALKING); 
		
		// BICYCLE
		ruleCosts_BICYCLE.distance_cost = ruleCosts_BICYCLE.distance_cost * ruleCosts_BICYCLE.rate_exchange;
		ruleCosts_BICYCLE.fuel_average_cost = ruleCosts_BICYCLE.fuel_average_cost * ruleCosts_BICYCLE.rate_exchange;
		ruleCosts_BICYCLE.tolls_average_cost = ruleCosts_BICYCLE.tolls_average_cost  * ruleCosts_BICYCLE.rate_exchange;
		ruleCosts_BICYCLE.weight_cost = ruleCosts_BICYCLE.weight_cost * ruleCosts_BICYCLE.rate_exchange;
		ruleCosts_BICYCLE.worktime_cost = ruleCosts_BICYCLE.worktime_cost * ruleCosts_BICYCLE.rate_exchange;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_BICYCLE, ruleCosts_BICYCLE);
		
		// CAR
		ruleCosts_CAR.distance_cost = ruleCosts_CAR.distance_cost * ruleCosts_CAR.rate_exchange;
		ruleCosts_CAR.fuel_average_cost = ruleCosts_CAR.fuel_average_cost * ruleCosts_CAR.rate_exchange;
		ruleCosts_CAR.tolls_average_cost = ruleCosts_CAR.tolls_average_cost  * ruleCosts_CAR.rate_exchange;
		ruleCosts_CAR.weight_cost = ruleCosts_CAR.weight_cost * ruleCosts_CAR.rate_exchange;
		ruleCosts_CAR.worktime_cost = ruleCosts_CAR.worktime_cost * ruleCosts_CAR.rate_exchange;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_CAR, ruleCosts_CAR);

		// MOTOCYCLE
		ruleCosts_MOTORCYCLE.distance_cost = ruleCosts_MOTORCYCLE.distance_cost * ruleCosts_MOTORCYCLE.rate_exchange;
		ruleCosts_MOTORCYCLE.fuel_average_cost = ruleCosts_MOTORCYCLE.fuel_average_cost * ruleCosts_MOTORCYCLE.rate_exchange;
		ruleCosts_MOTORCYCLE.tolls_average_cost = ruleCosts_MOTORCYCLE.tolls_average_cost  * ruleCosts_MOTORCYCLE.rate_exchange;
		ruleCosts_MOTORCYCLE.weight_cost = ruleCosts_MOTORCYCLE.weight_cost * ruleCosts_MOTORCYCLE.rate_exchange;
		ruleCosts_MOTORCYCLE.worktime_cost = ruleCosts_MOTORCYCLE.worktime_cost * ruleCosts_MOTORCYCLE.rate_exchange;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_MOTORCYCLE, ruleCosts_MOTORCYCLE);

		// MOTOCYCLE
		ruleCosts_TRUCK.distance_cost = ruleCosts_TRUCK.distance_cost * ruleCosts_TRUCK.rate_exchange;
		ruleCosts_TRUCK.fuel_average_cost = ruleCosts_TRUCK.fuel_average_cost * ruleCosts_TRUCK.rate_exchange;
		ruleCosts_TRUCK.tolls_average_cost = ruleCosts_TRUCK.tolls_average_cost  * ruleCosts_TRUCK.rate_exchange;
		ruleCosts_TRUCK.weight_cost = ruleCosts_TRUCK.weight_cost * ruleCosts_TRUCK.rate_exchange;
		ruleCosts_TRUCK.worktime_cost = ruleCosts_TRUCK.worktime_cost * ruleCosts_TRUCK.rate_exchange;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_TRUCK, ruleCosts_TRUCK);
		
		// MOTOCYCLE
		ruleCosts_WALKING.distance_cost = ruleCosts_WALKING.distance_cost * ruleCosts_WALKING.rate_exchange;
		ruleCosts_WALKING.fuel_average_cost = ruleCosts_WALKING.fuel_average_cost * ruleCosts_WALKING.rate_exchange;
		ruleCosts_WALKING.tolls_average_cost = ruleCosts_WALKING.tolls_average_cost  * ruleCosts_WALKING.rate_exchange;
		ruleCosts_WALKING.weight_cost = ruleCosts_WALKING.weight_cost * ruleCosts_WALKING.rate_exchange;
		ruleCosts_WALKING.worktime_cost = ruleCosts_WALKING.worktime_cost * ruleCosts_WALKING.rate_exchange;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_WALKING, ruleCosts_WALKING);

		// Add Map Way by Country
		roadwayBRE.getRuleCosts().put(country, ruleCostsMap);
		return roadwayBRE;
	}

	// Execute to POST operation
	public RoadwayBRE_Model opPOSTConvertToDollar(RoadwayBRE_Model roadwayBRE, double vlr_tax, String country) {
		
		Map<String,RuleCosts_Model> ruleCostsMap = roadwayBRE.getRuleCosts().get(country);
		
		RuleCosts_Model ruleCosts_BICYCLE = ruleCostsMap.get(Roadway_Constants.ROADWAY_BICYCLE); 
		RuleCosts_Model ruleCosts_CAR = ruleCostsMap.get(Roadway_Constants.ROADWAY_CAR); 
		RuleCosts_Model ruleCosts_MOTORCYCLE = ruleCostsMap.get(Roadway_Constants.ROADWAY_MOTORCYCLE); 
		RuleCosts_Model ruleCosts_TRUCK = ruleCostsMap.get(Roadway_Constants.ROADWAY_TRUCK); 
		RuleCosts_Model ruleCosts_WALKING = ruleCostsMap.get(Roadway_Constants.ROADWAY_WALKING); 
		
		// BICYCLE
		ruleCosts_BICYCLE.distance_cost = ruleCosts_BICYCLE.distance_cost / vlr_tax;
		ruleCosts_BICYCLE.fuel_average_cost = ruleCosts_BICYCLE.fuel_average_cost / vlr_tax;
		ruleCosts_BICYCLE.tolls_average_cost = ruleCosts_BICYCLE.tolls_average_cost  / vlr_tax;
		ruleCosts_BICYCLE.weight_cost = ruleCosts_BICYCLE.weight_cost / vlr_tax;
		ruleCosts_BICYCLE.worktime_cost = ruleCosts_BICYCLE.worktime_cost / vlr_tax;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_BICYCLE, ruleCosts_BICYCLE);
		
		// CAR
		ruleCosts_CAR.distance_cost = ruleCosts_CAR.distance_cost / vlr_tax;
		ruleCosts_CAR.fuel_average_cost = ruleCosts_CAR.fuel_average_cost / vlr_tax;
		ruleCosts_CAR.tolls_average_cost = ruleCosts_CAR.tolls_average_cost  / vlr_tax;
		ruleCosts_CAR.weight_cost = ruleCosts_CAR.weight_cost / vlr_tax;
		ruleCosts_CAR.worktime_cost = ruleCosts_CAR.worktime_cost / vlr_tax;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_CAR, ruleCosts_CAR);

		// MOTOCYCLE
		ruleCosts_MOTORCYCLE.distance_cost = ruleCosts_MOTORCYCLE.distance_cost / vlr_tax;
		ruleCosts_MOTORCYCLE.fuel_average_cost = ruleCosts_MOTORCYCLE.fuel_average_cost / vlr_tax;
		ruleCosts_MOTORCYCLE.tolls_average_cost = ruleCosts_MOTORCYCLE.tolls_average_cost  / vlr_tax;
		ruleCosts_MOTORCYCLE.weight_cost = ruleCosts_MOTORCYCLE.weight_cost / vlr_tax;
		ruleCosts_MOTORCYCLE.worktime_cost = ruleCosts_MOTORCYCLE.worktime_cost / vlr_tax;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_MOTORCYCLE, ruleCosts_MOTORCYCLE);

		// MOTOCYCLE
		ruleCosts_TRUCK.distance_cost = ruleCosts_TRUCK.distance_cost / vlr_tax;
		ruleCosts_TRUCK.fuel_average_cost = ruleCosts_TRUCK.fuel_average_cost / vlr_tax;
		ruleCosts_TRUCK.tolls_average_cost = ruleCosts_TRUCK.tolls_average_cost  / vlr_tax;
		ruleCosts_TRUCK.weight_cost = ruleCosts_TRUCK.weight_cost / vlr_tax;
		ruleCosts_TRUCK.worktime_cost = ruleCosts_TRUCK.worktime_cost / vlr_tax;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_TRUCK, ruleCosts_TRUCK);
		
		// MOTOCYCLE
		ruleCosts_WALKING.distance_cost = ruleCosts_WALKING.distance_cost / vlr_tax;
		ruleCosts_WALKING.fuel_average_cost = ruleCosts_WALKING.fuel_average_cost / vlr_tax;
		ruleCosts_WALKING.tolls_average_cost = ruleCosts_WALKING.tolls_average_cost  / vlr_tax;
		ruleCosts_WALKING.weight_cost = ruleCosts_WALKING.weight_cost / vlr_tax;
		ruleCosts_WALKING.worktime_cost = ruleCosts_WALKING.worktime_cost / vlr_tax;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_WALKING, ruleCosts_WALKING);

		// Add Map Way by Country
		roadwayBRE.getRuleCosts().put(country, ruleCostsMap);
		return roadwayBRE;
	}

}
