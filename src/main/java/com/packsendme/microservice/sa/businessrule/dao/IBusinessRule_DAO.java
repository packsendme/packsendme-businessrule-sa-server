package com.packsendme.microservice.sa.businessrule.dao;

public interface IBusinessRule_DAO <T> {
	
	public boolean add(String cache, String value, T object);
	public boolean delete(String cache, String value);
	public T findOne(String cache,String value);

	
}
