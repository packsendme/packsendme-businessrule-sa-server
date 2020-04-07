package com.packsendme.microservice.sa.businessrule.dao;

import java.util.List;

import com.packsendme.airway.bre.rule.model.AirwayBRE_Model;

public class AirwayImpl_DAO implements IBusinessRule_DAO<AirwayBRE_Model> {

	@Override
	public void add(AirwayBRE_Model object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AirwayBRE_Model findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AirwayBRE_Model> findAll(String id) {
		// TODO Auto-generated method stub
		return null;
	}
/*
	private RedisTemplate<String, AirwayBRE_Model> redisTemplate;

	@Override
	public void add(AirwayBRE_Model object) {
		redisTemplate.opsForValue().set(object.id_rule, object);
	}

	@Override
	public void delete(String key) {
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
	}*/
 
}
