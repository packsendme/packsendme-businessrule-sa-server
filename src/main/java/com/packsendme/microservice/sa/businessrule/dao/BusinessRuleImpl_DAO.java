package com.packsendme.microservice.sa.businessrule.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BusinessRuleImpl_DAO<T> implements IBusinessRule_DAO<T>{

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public void add(T object) {
		System.out.println(" +++++++++++++++++++++++ BusinessRuleImpl_DAO ");

		redisTemplate.opsForValue().set("Execution", object);
	}

	@Override
	public void delete(String key) {
		redisTemplate.opsForValue().getOperations().delete(key);		
	}

	@Override
	public T findOne(String id) {
		return (T) redisTemplate.opsForValue().get(id);
	}

	@Override
	public List<T> findAll(String id) {
		List<T> roadwayL = new ArrayList<T>();
		Set<String> keys = redisTemplate.keys("*");
		Iterator<String> it = keys.iterator();
			
		while(it.hasNext()){
			roadwayL.add(findOne(it.next()));
		}
		return roadwayL;
	}

	 
 
}
