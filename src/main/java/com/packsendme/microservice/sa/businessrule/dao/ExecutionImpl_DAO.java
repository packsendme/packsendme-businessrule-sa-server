package com.packsendme.microservice.sa.businessrule.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.packsendme.execution.bre.rule.model.ExecutionBRE_Model;

@Repository
public class ExecutionImpl_DAO implements IBusinessRule_DAO<ExecutionBRE_Model>{

	private RedisTemplate<String, ExecutionBRE_Model> redisTemplate;

	@Override
	public void add(ExecutionBRE_Model object) {
		redisTemplate.opsForValue().set(object.id_rule, object);
	}

	@Override
	public void delete(ExecutionBRE_Model object) {
		String key = object.id_rule;
		redisTemplate.opsForValue().getOperations().delete(key);
	}
	
	@Override
	public ExecutionBRE_Model findOne(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public List<ExecutionBRE_Model> findAll(String id) {
		List<ExecutionBRE_Model> roadwayL = new ArrayList<ExecutionBRE_Model>();
		Set<String> keys = redisTemplate.keys("*");
		Iterator<String> it = keys.iterator();
			
		while(it.hasNext()){
			roadwayL.add(findOne(it.next()));
		}
		return roadwayL;
	}
 
}
