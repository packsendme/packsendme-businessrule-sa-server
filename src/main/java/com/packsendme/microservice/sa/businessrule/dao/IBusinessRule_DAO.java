package com.packsendme.microservice.sa.businessrule.dao;

import java.util.List;

public interface IBusinessRule_DAO <T> {
	
	public void add(T object);
	public void delete(String key);
	public T findOne(String id);
	public List<T> findAll(String id);
	
}
