package com.packsendme.microservice.sa.businessrule.component;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.packsendme.lib.common.constants.way.Roadway_Constants;
import com.packsendme.lib.utility.DistanceConvert;
import com.packsendme.lib.utility.FormatValueMoney;
import com.packsendme.lib.utility.WeightConvert_Utility;
import com.packsendme.roadway.bre.rule.costs.model.RuleCosts_Model;
import com.packsendme.roadway.bre.rule.instance.model.RuleInstance_Model;
import com.packsendme.roadway.bre.rule.model.RoadwayBRE_Model;

@Component
public class RoadwayConvert {
	
	FormatValueMoney moneyFormat = new FormatValueMoney();
	DistanceConvert distanceFormat = new DistanceConvert();
	WeightConvert_Utility weightConvert = new WeightConvert_Utility();

	// Execute to GET operation	
	public RoadwayBRE_Model opGETConvertToCountryOrigin(RoadwayBRE_Model roadwayBRE, String country) {
			
		Map<String,RuleCosts_Model> ruleCostsMap = roadwayBRE.getRuleCosts().get(country);
		RuleCosts_Model ruleCosts_BICYCLE = ruleCostsMap.get(Roadway_Constants.ROADWAY_BICYCLE); 
		RuleCosts_Model ruleCosts_CAR = ruleCostsMap.get(Roadway_Constants.ROADWAY_CAR); 
		RuleCosts_Model ruleCosts_MOTORCYCLE = ruleCostsMap.get(Roadway_Constants.ROADWAY_MOTORCYCLE); 
		RuleCosts_Model ruleCosts_TRUCK = ruleCostsMap.get(Roadway_Constants.ROADWAY_TRUCK); 
		RuleCosts_Model ruleCosts_WALKING = ruleCostsMap.get(Roadway_Constants.ROADWAY_WALKING); 
		
		// Convert KM TO Meters
		RuleInstance_Model ruleInstanceBicycle = roadwayBRE.getRuleInstance().get(Roadway_Constants.ROADWAY_BICYCLE);
		ruleInstanceBicycle.distance_max = distanceFormat.distanceMeters_to_KM(ruleInstanceBicycle.distance_max);
		// Convert KG TO Gr
		ruleInstanceBicycle.weight_max = weightConvert.GramaToKilograma(ruleInstanceBicycle.weight_max);
		roadwayBRE.ruleInstance.put(Roadway_Constants.ROADWAY_BICYCLE, ruleInstanceBicycle);


		RuleInstance_Model ruleInstanceCar = roadwayBRE.getRuleInstance().get(Roadway_Constants.ROADWAY_CAR);
		ruleInstanceCar.distance_max = distanceFormat.distanceMeters_to_KM(ruleInstanceCar.distance_max);
		// Convert KG TO Gr
		ruleInstanceCar.weight_max = weightConvert.GramaToKilograma(ruleInstanceCar.weight_max);
		roadwayBRE.ruleInstance.put(Roadway_Constants.ROADWAY_CAR, ruleInstanceCar);

		RuleInstance_Model ruleInstanceMotorcycle = roadwayBRE.getRuleInstance().get(Roadway_Constants.ROADWAY_MOTORCYCLE);
		ruleInstanceMotorcycle.distance_max = distanceFormat.distanceMeters_to_KM(ruleInstanceMotorcycle.distance_max);
		// Convert KG TO Gr
		ruleInstanceMotorcycle.weight_max = weightConvert.GramaToKilograma(ruleInstanceMotorcycle.weight_max);
		roadwayBRE.ruleInstance.put(Roadway_Constants.ROADWAY_MOTORCYCLE, ruleInstanceMotorcycle);

		RuleInstance_Model ruleInstanceTruck = roadwayBRE.getRuleInstance().get(Roadway_Constants.ROADWAY_TRUCK);
		ruleInstanceTruck.distance_max = distanceFormat.distanceMeters_to_KM(ruleInstanceTruck.distance_max);
		// Convert T TO Gr
		ruleInstanceTruck.weight_max = weightConvert.GramaToToneleda(ruleInstanceTruck.weight_max);
		roadwayBRE.ruleInstance.put(Roadway_Constants.ROADWAY_TRUCK, ruleInstanceTruck);
		
		
		RuleInstance_Model ruleInstanceWalk = roadwayBRE.getRuleInstance().get(Roadway_Constants.ROADWAY_WALKING);
		ruleInstanceWalk.distance_max = distanceFormat.distanceMeters_to_KM(ruleInstanceWalk.distance_max);
		// Convert T TO Gr
		ruleInstanceWalk.weight_max = weightConvert.GramaToKilograma(ruleInstanceWalk.weight_max);
		roadwayBRE.ruleInstance.put(Roadway_Constants.ROADWAY_WALKING, ruleInstanceWalk);

		
		// CONVERT Current to Exchange/Rate
		// BICYCLE
		ruleCosts_BICYCLE.distance_cost = moneyFormat.formatDouble(ruleCosts_BICYCLE.distance_cost * ruleCosts_BICYCLE.rate_exchange);
		ruleCosts_BICYCLE.weight_cost = moneyFormat.formatDouble(ruleCosts_BICYCLE.weight_cost * ruleCosts_BICYCLE.rate_exchange);
		ruleCosts_BICYCLE.worktime_cost = moneyFormat.formatDouble(ruleCosts_BICYCLE.worktime_cost * ruleCosts_BICYCLE.rate_exchange);
		ruleCostsMap.put(Roadway_Constants.ROADWAY_BICYCLE, ruleCosts_BICYCLE);
		
		// CAR
		ruleCosts_CAR.distance_cost = moneyFormat.formatDouble(ruleCosts_CAR.distance_cost * ruleCosts_CAR.rate_exchange);
		ruleCosts_CAR.weight_cost = moneyFormat.formatDouble(ruleCosts_CAR.weight_cost * ruleCosts_CAR.rate_exchange);
		ruleCosts_CAR.worktime_cost = moneyFormat.formatDouble(ruleCosts_CAR.worktime_cost * ruleCosts_CAR.rate_exchange);
		ruleCostsMap.put(Roadway_Constants.ROADWAY_CAR, ruleCosts_CAR);

		// MOTOCYCLE
		ruleCosts_MOTORCYCLE.distance_cost = moneyFormat.formatDouble(ruleCosts_MOTORCYCLE.distance_cost * ruleCosts_MOTORCYCLE.rate_exchange);
		ruleCosts_MOTORCYCLE.weight_cost = moneyFormat.formatDouble(ruleCosts_MOTORCYCLE.weight_cost * ruleCosts_MOTORCYCLE.rate_exchange);
		ruleCosts_MOTORCYCLE.worktime_cost = moneyFormat.formatDouble(ruleCosts_MOTORCYCLE.worktime_cost * ruleCosts_MOTORCYCLE.rate_exchange);
		ruleCostsMap.put(Roadway_Constants.ROADWAY_MOTORCYCLE, ruleCosts_MOTORCYCLE);

		// MOTOCYCLE
		ruleCosts_TRUCK.distance_cost = moneyFormat.formatDouble(ruleCosts_TRUCK.distance_cost * ruleCosts_TRUCK.rate_exchange);
		ruleCosts_TRUCK.weight_cost = moneyFormat.formatDouble(ruleCosts_TRUCK.weight_cost * ruleCosts_TRUCK.rate_exchange);
		ruleCosts_TRUCK.worktime_cost = moneyFormat.formatDouble(ruleCosts_TRUCK.worktime_cost * ruleCosts_TRUCK.rate_exchange);
		ruleCostsMap.put(Roadway_Constants.ROADWAY_TRUCK, ruleCosts_TRUCK);
		
		// MOTOCYCLE
		ruleCosts_WALKING.distance_cost = moneyFormat.formatDouble(ruleCosts_WALKING.distance_cost * ruleCosts_WALKING.rate_exchange);
		ruleCosts_WALKING.weight_cost = moneyFormat.formatDouble(ruleCosts_WALKING.weight_cost * ruleCosts_WALKING.rate_exchange);
		ruleCosts_WALKING.worktime_cost = moneyFormat.formatDouble(ruleCosts_WALKING.worktime_cost * ruleCosts_WALKING.rate_exchange);
		ruleCostsMap.put(Roadway_Constants.ROADWAY_WALKING, ruleCosts_WALKING);

		// Add Map Way by Country
		roadwayBRE.getRuleCosts().put(country, ruleCostsMap);
		return roadwayBRE;
	}

	// Execute to POST operation
	public RoadwayBRE_Model opPOSTConvertToDollar(RoadwayBRE_Model roadwayBRE, double vlr_tax, String country, String currencySymbol) {
		
		Map<String,RuleCosts_Model> ruleCostsMap = roadwayBRE.getRuleCosts().get(country);
		
		RuleCosts_Model ruleCosts_BICYCLE = ruleCostsMap.get(Roadway_Constants.ROADWAY_BICYCLE); 
		RuleCosts_Model ruleCosts_CAR = ruleCostsMap.get(Roadway_Constants.ROADWAY_CAR); 
		RuleCosts_Model ruleCosts_MOTORCYCLE = ruleCostsMap.get(Roadway_Constants.ROADWAY_MOTORCYCLE); 
		RuleCosts_Model ruleCosts_TRUCK = ruleCostsMap.get(Roadway_Constants.ROADWAY_TRUCK); 
		RuleCosts_Model ruleCosts_WALKING = ruleCostsMap.get(Roadway_Constants.ROADWAY_WALKING); 
		
		// CONVERT KM TO Meters
		RuleInstance_Model ruleInstanceBicycle = roadwayBRE.getRuleInstance().get(Roadway_Constants.ROADWAY_BICYCLE);
		ruleInstanceBicycle.distance_max = distanceFormat.distanceKM_to_Meters(ruleInstanceBicycle.distance_max);
		// Convert KG To GR
		ruleInstanceBicycle.weight_max = weightConvert.kilogramoToGrama(ruleInstanceBicycle.weight_max);
		roadwayBRE.ruleInstance.put(Roadway_Constants.ROADWAY_BICYCLE, ruleInstanceBicycle);

		RuleInstance_Model ruleInstanceCar = roadwayBRE.getRuleInstance().get(Roadway_Constants.ROADWAY_CAR);
		ruleInstanceCar.distance_max = distanceFormat.distanceKM_to_Meters(ruleInstanceCar.distance_max);
		// Convert KG To GR
		ruleInstanceCar.weight_max = weightConvert.kilogramoToGrama(ruleInstanceCar.weight_max);
		roadwayBRE.ruleInstance.put(Roadway_Constants.ROADWAY_CAR, ruleInstanceCar);

		RuleInstance_Model ruleInstanceMotorcycle = roadwayBRE.getRuleInstance().get(Roadway_Constants.ROADWAY_MOTORCYCLE);
		ruleInstanceMotorcycle.distance_max = distanceFormat.distanceKM_to_Meters(ruleInstanceMotorcycle.distance_max);
		// Convert KG To GR
		ruleInstanceMotorcycle.weight_max = weightConvert.kilogramoToGrama(ruleInstanceMotorcycle.weight_max);
		roadwayBRE.ruleInstance.put(Roadway_Constants.ROADWAY_MOTORCYCLE, ruleInstanceMotorcycle);

		RuleInstance_Model ruleInstanceTruck = roadwayBRE.getRuleInstance().get(Roadway_Constants.ROADWAY_TRUCK);
		ruleInstanceTruck.distance_max = distanceFormat.distanceKM_to_Meters(ruleInstanceTruck.distance_max);
		// Convert T To GR
		ruleInstanceTruck.weight_max = weightConvert.ToneladaToGrama(ruleInstanceTruck.weight_max);
		roadwayBRE.ruleInstance.put(Roadway_Constants.ROADWAY_TRUCK, ruleInstanceTruck);
		
		RuleInstance_Model ruleInstanceWalk = roadwayBRE.getRuleInstance().get(Roadway_Constants.ROADWAY_WALKING);
		ruleInstanceWalk.distance_max = distanceFormat.distanceKM_to_Meters(ruleInstanceWalk.distance_max);
		// Convert KG To GR
		ruleInstanceWalk.weight_max = weightConvert.kilogramoToGrama(ruleInstanceWalk.weight_max);
		roadwayBRE.ruleInstance.put(Roadway_Constants.ROADWAY_WALKING, ruleInstanceWalk);

		// CONVERT Current to Exchange/Rate
		// BICYCLE
		ruleCosts_BICYCLE.distance_cost = moneyFormat.formatDouble(ruleCosts_BICYCLE.distance_cost / vlr_tax);
		ruleCosts_BICYCLE.weight_cost = moneyFormat.formatDouble(ruleCosts_BICYCLE.weight_cost / vlr_tax);
		ruleCosts_BICYCLE.worktime_cost = moneyFormat.formatDouble(ruleCosts_BICYCLE.worktime_cost / vlr_tax);
		ruleCosts_BICYCLE.rate_exchange = moneyFormat.formatDouble(vlr_tax);
		ruleCosts_BICYCLE.current_exchange = currencySymbol;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_BICYCLE, ruleCosts_BICYCLE);
		
		// CAR
		ruleCosts_CAR.distance_cost = moneyFormat.formatDouble(ruleCosts_CAR.distance_cost / vlr_tax);
		ruleCosts_CAR.weight_cost = moneyFormat.formatDouble(ruleCosts_CAR.weight_cost / vlr_tax);
		ruleCosts_CAR.worktime_cost = moneyFormat.formatDouble(ruleCosts_CAR.worktime_cost / vlr_tax);
		ruleCosts_CAR.rate_exchange = moneyFormat.formatDouble(vlr_tax);
		ruleCosts_CAR.current_exchange = currencySymbol;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_CAR, ruleCosts_CAR);

		// MOTOCYCLE
		ruleCosts_MOTORCYCLE.distance_cost = moneyFormat.formatDouble(ruleCosts_MOTORCYCLE.distance_cost / vlr_tax);
		ruleCosts_MOTORCYCLE.weight_cost = moneyFormat.formatDouble(ruleCosts_MOTORCYCLE.weight_cost / vlr_tax);
		ruleCosts_MOTORCYCLE.worktime_cost = moneyFormat.formatDouble(ruleCosts_MOTORCYCLE.worktime_cost / vlr_tax);
		ruleCosts_MOTORCYCLE.rate_exchange = moneyFormat.formatDouble(vlr_tax);
		ruleCosts_MOTORCYCLE.current_exchange = currencySymbol;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_MOTORCYCLE, ruleCosts_MOTORCYCLE);

		// MOTOCYCLE
		ruleCosts_TRUCK.distance_cost = moneyFormat.formatDouble(ruleCosts_TRUCK.distance_cost / vlr_tax);
		ruleCosts_TRUCK.weight_cost = moneyFormat.formatDouble(ruleCosts_TRUCK.weight_cost / vlr_tax);
		ruleCosts_TRUCK.worktime_cost = moneyFormat.formatDouble(ruleCosts_TRUCK.worktime_cost / vlr_tax);
		ruleCosts_TRUCK.rate_exchange = moneyFormat.formatDouble(vlr_tax);
		ruleCosts_TRUCK.current_exchange = currencySymbol;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_TRUCK, ruleCosts_TRUCK);
		
		// MOTOCYCLE
		ruleCosts_WALKING.distance_cost = moneyFormat.formatDouble(ruleCosts_WALKING.distance_cost / vlr_tax);
		ruleCosts_WALKING.weight_cost = moneyFormat.formatDouble(ruleCosts_WALKING.weight_cost / vlr_tax);
		ruleCosts_WALKING.worktime_cost = moneyFormat.formatDouble(ruleCosts_WALKING.worktime_cost / vlr_tax);
		ruleCosts_WALKING.rate_exchange = moneyFormat.formatDouble(vlr_tax);
		ruleCosts_WALKING.current_exchange = currencySymbol;
		ruleCostsMap.put(Roadway_Constants.ROADWAY_WALKING, ruleCosts_WALKING);

		// Add Map Way by Country
		roadwayBRE.getRuleCosts().put(country, ruleCostsMap);
		return roadwayBRE;
	}

}
