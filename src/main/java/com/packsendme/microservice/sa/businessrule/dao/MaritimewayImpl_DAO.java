package com.packsendme.microservice.sa.businessrule.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;

import com.packsendme.maritimeway.bre.rule.model.MaritimewayBRE_Model;

public class MaritimewayImpl_DAO implements IBusinessRule_DAO<MaritimewayBRE_Model> {

	private RedisTemplate<String, MaritimewayBRE_Model> redisTemplate;

	@Override
	public void add(MaritimewayBRE_Model object) {
		redisTemplate.opsForValue().set(object.id_rule, object);
	}

	@Override
	public void delete(MaritimewayBRE_Model object) {
		String key = object.id_rule;
		redisTemplate.opsForValue().getOperations().delete(key);
	}
	
	@Override
	public MaritimewayBRE_Model findOne(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public List<MaritimewayBRE_Model> findAll(String id) {
		List<MaritimewayBRE_Model> roadwayL = new ArrayList<MaritimewayBRE_Model>();
		Set<String> keys = redisTemplate.keys("*");
		Iterator<String> it = keys.iterator();
			
		while(it.hasNext()){
			roadwayL.add(findOne(it.next()));
		}
		return roadwayL;
	}
 
}
