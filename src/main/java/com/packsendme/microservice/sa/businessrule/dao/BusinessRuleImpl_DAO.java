package com.packsendme.microservice.sa.businessrule.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BusinessRuleImpl_DAO<T> implements IBusinessRule_DAO<T>{

	@Autowired
	private RedisTemplate<String, T> redisTemplate;
	
	@Override
	public void add(String cache, String value, T object) {
		redisTemplate.opsForHash().delete(cache,value);  
		redisTemplate.opsForHash().put(cache, cache, object);
	}

	@Override
	public void delete(String cache, String value) {
		//redisTemplate.opsForValue().getOperations().delete(key);
		redisTemplate.opsForHash().delete(cache,value);  
	}

	@Override
	public T findOne(String cache,String value) {
		return (T) redisTemplate.opsForHash().get(cache, value);
	}

 
}
