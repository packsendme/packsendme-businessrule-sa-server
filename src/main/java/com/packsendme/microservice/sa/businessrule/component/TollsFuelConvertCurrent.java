package com.packsendme.microservice.sa.businessrule.component;

import org.springframework.stereotype.Component;

import com.packsendme.lib.utility.FormatValueMoney;
import com.packsendme.tollsfuel.bre.model.TollsFuelBRE_Model;
import com.packsendme.tollsfuel.bre.rule.price.model.TollsFuelPriceCountryBRE_Model;

@Component
public class TollsFuelConvertCurrent {
	
	FormatValueMoney moneyFormat = new FormatValueMoney();
	
	// Execute to GET operation	
	public TollsFuelBRE_Model opGETConvertToCountryOrigin(TollsFuelBRE_Model tollsFuelBRE, String country) {
			
		TollsFuelPriceCountryBRE_Model tollsfuelPriceCountry = tollsFuelBRE.tollsfuelPriceCountry.get(country);
		
		tollsfuelPriceCountry.fuel_price = moneyFormat.doubleFormatRound(tollsfuelPriceCountry.fuel_price * tollsfuelPriceCountry.rate_exchange);
		tollsfuelPriceCountry.tolls_price = moneyFormat.doubleFormatRound(tollsfuelPriceCountry.tolls_price * tollsfuelPriceCountry.rate_exchange);
		// Add Map Way by Country
		tollsFuelBRE.tollsfuelPriceCountry.put(country, tollsfuelPriceCountry);
		return tollsFuelBRE;
	}

	// Execute to POST operation
	public TollsFuelBRE_Model opPOSTConvertToDollar(TollsFuelBRE_Model tollsFuelBRE, double vlr_rate, String country) {
		
		TollsFuelPriceCountryBRE_Model tollsfuelPriceCountry = tollsFuelBRE.tollsfuelPriceCountry.get(country);
		
		tollsfuelPriceCountry.fuel_price = moneyFormat.doubleFormatRound(tollsfuelPriceCountry.fuel_price / vlr_rate);
		tollsfuelPriceCountry.tolls_price = moneyFormat.doubleFormatRound(tollsfuelPriceCountry.tolls_price / vlr_rate);
		tollsfuelPriceCountry.rate_exchange = vlr_rate;
		// Add Map Way by Country
		tollsFuelBRE.tollsfuelPriceCountry.put(country, tollsfuelPriceCountry);
		return tollsFuelBRE;
	}

}
