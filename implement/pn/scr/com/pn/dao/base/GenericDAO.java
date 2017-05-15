package com.pn.dao.base;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	T loadById(ID id);

	void persist(T entity);
	
	public ID save(T entity);
	
	public void saveOrUpdate(T entity);
	
	void update(T entity);
	
	void delete(T entity);
	
	public void refesh(T entity);
	
	List<T> loadAll();
	
	public void deleteById(ID id);

//    List<T> findByProperty(String propertyName, Object value);
}