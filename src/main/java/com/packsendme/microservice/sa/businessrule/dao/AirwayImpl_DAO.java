package com.packsendme.microservice.sa.businessrule.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.packsendme.airway.bre.rule.model.AirwayBRE_Model;

@Repository
public class AirwayImpl_DAO implements IBusinessRule_DAO<AirwayBRE_Model> {

	private RedisTemplate<String, AirwayBRE_Model> redisTemplate;

	@Override
	public void add(AirwayBRE_Model object) {
		redisTemplate.opsForValue().set(object.id_rule, object);
	}

	@Override
	public void delete(AirwayBRE_Model object) {
		String key = object.id_rule;
		redisTemplate.opsForValue().getOperations().delete(key);
	}
	
	@Override
	public AirwayBRE_Model findOne(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public List<AirwayBRE_Model> findAll(String id) {
		List<AirwayBRE_Model> roadwayL = new ArrayList<AirwayBRE_Model>();
		Set<String> keys = redisTemplate.keys("*");
		Iterator<String> it = keys.iterator();
			
		while(it.hasNext()){
			roadwayL.add(findOne(it.next()));
		}
		return roadwayL;
	}
 
}
