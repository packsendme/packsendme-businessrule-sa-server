package com.packsendme.microservice.sa.businessrule.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BusinessRuleImpl_DAO<T> implements IBusinessRule_DAO<T>{
	
	private final boolean RESULT_SUCCESS = true;
	private final boolean RESULT_ERROR = false;

	@Autowired
	private RedisTemplate<String, T> redisTemplate;
	
	@Override
	public boolean add(String cache, String value, T object) {
		try {
			redisTemplate.opsForHash().delete(cache,value);  
			redisTemplate.opsForHash().put(cache, value, object);
			return RESULT_SUCCESS;
		}
		catch (Exception e) {
			e.printStackTrace();
			return RESULT_ERROR;
		}
	}

	@Override
	public boolean delete(String cache, String value) {
		long result = 0;
		try {
			result = redisTemplate.opsForHash().delete(cache,value);
			System.out.println(" ===========================================================  ");
			System.out.println(" RESULT DELETE  "+ result);
			System.out.println(" ===========================================================  ");
			if(result > 0) {
				return RESULT_SUCCESS;
			}
			else {
				return RESULT_ERROR;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return RESULT_ERROR;
		}
	}

	@Override
	public T findOne(String cache,String value) {
		try {
			return (T) redisTemplate.opsForHash().get(cache, value);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

 
}
