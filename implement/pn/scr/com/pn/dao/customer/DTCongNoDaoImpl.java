package com.pn.dao.customer;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pn.dao.base.impl.GenericDAOImpl;
import com.pn.model.Customer.DTCongNo;

@Repository("dTCongNoDao")
public class DTCongNoDaoImpl extends GenericDAOImpl<DTCongNo, String> implements DTCongNoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<DTCongNo> getListDoiTuongCongNo() {
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("getDoiTuongCongNo");		
		List<DTCongNo> list = query.list();
		session.close();
		return list;
	}

	
}