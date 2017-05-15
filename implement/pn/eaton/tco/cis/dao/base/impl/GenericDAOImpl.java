package com.eaton.tco.cis.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.eaton.tco.cis.dao.base.GenericDAO;
import com.eaton.tco.cis.dao.base.HibernateFactory;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements
        GenericDAO<T, ID> {

    private Class<T> persistentClass;
    private Transaction tx;
    @Autowired
	protected SessionFactory sessionFactory;
    
    protected Session session;
    
    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

      public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @SuppressWarnings("unchecked")
	public T loadById(ID id) {
    	startOperation();
        T t = (T) session.get(persistentClass, id);
        tx.commit();
        return t;
    }

    public void persist(T entity) {
    	startOperation();
    	session.persist(entity); 
    	tx.commit();
    }
    public void save(T entity) {
    	startOperation();
    	session.save(entity); 
    	tx.commit();
    }
    public void saveOrUpdate(T entity) {
    	startOperation();
    	session.saveOrUpdate(entity); 
    	tx.commit();
    }
    public void update(T entity) {
        startOperation();
    	session.update(entity); 
    	tx.commit();
    }

    public void delete(T entity) {
        startOperation();
    	session.delete(entity); 
    	tx.commit();
    }

    public void refesh(T entity) {
    	startOperation();
    	session.refresh(entity); 
    	tx.commit();
    }
    @SuppressWarnings("unchecked")
    public List<T> loadAll() {
    	startOperation();
    	List<T> t = session.createQuery(
                "select t from " + persistentClass.getSimpleName() + " t").list();
    	 tx.commit();
    	return t;
    }

    public void deleteById(ID id) {
        T entity = loadById(id);
        delete(entity);
    }
    
    protected void startOperation() throws HibernateException {
        session = HibernateFactory.openSession(sessionFactory);
        tx = session.beginTransaction();
    }

}