package com.packsendme.microservice.sa.businessrule.dao;

public interface IBusinessRule_DAO <T> {
	
	public void add(String cache, int value, T object);
	public void delete(String cache, int value);
	public T findOne(String cache,int value);
	//public List<T> findAll(String id);
	
}
