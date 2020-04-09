package com.packsendme.microservice.sa.businessrule.dao;

public interface IBusinessRule_DAO <T> {
	
	public void add(String cache, String value, T object);
	public void delete(String cache, String value);
	public T findOne(String cache,String value);
	//public List<T> findAll(String id);
	
}
