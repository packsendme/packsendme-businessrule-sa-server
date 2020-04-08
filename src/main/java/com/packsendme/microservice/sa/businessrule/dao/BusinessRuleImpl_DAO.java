package com.packsendme.microservice.sa.businessrule.dao;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BusinessRuleImpl_DAO<T> implements IBusinessRule_DAO<T>{

	@Autowired
	private RedisTemplate<String, T> redisTemplate;
	private HashOperations hashOps;
	
	@PostConstruct
	private void init() {
		hashOps = redisTemplate.opsForHash();
	}
	
	@Override
	public void add(String cache, int value, T object) {
		System.out.println(" +++++++++++++++++++++++ BusinessRuleImpl_DAO ");
		//redisTemplate.opsForValue().set("Roadway", object);
		redisTemplate.opsForHash().delete(cache,value);  
		redisTemplate.opsForHash().put(cache, value, object);
	}

	@Override
	public void delete(String cache, int value) {
		//redisTemplate.opsForValue().getOperations().delete(key);
		redisTemplate.opsForHash().delete(cache,value);  
	}

	@Override
	public T findOne(String cache,int value) {
		return (T) redisTemplate.opsForHash().get(cache, value);
	}

	/*@Override
	public List<T> findAll(String id) {
		List<T> roadwayL = new ArrayList<T>();
		Set<String> keys = redisTemplate.keys("*");
		Iterator<String> it = keys.iterator();
			
		while(it.hasNext()){
			roadwayL.add(findOne(it.next()));
		}
		return roadwayL;
	} */

	 
 
}
