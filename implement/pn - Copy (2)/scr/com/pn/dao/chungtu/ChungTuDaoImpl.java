package com.pn.dao.chungtu;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pn.dao.base.impl.GenericDAOImpl;
import com.pn.model.chungtu.ChiTietChungTu;

@Repository("chungTuDao")
public class ChungTuDaoImpl extends GenericDAOImpl<ChiTietChungTu, Integer> implements ChungTuDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ChiTietChungTu> getAllChungTuBaseSoPhieu(String sophieu, Integer thang) {
		Session session =sessionFactory.openSession();
		List results = null;
		try {
			Query query = session.createQuery("FROM ChiTietChungTu a WHERE a.soPhieu = :sophieu and a.thang = :thang AND a.tKCoID=5111")
			.setString("sophieu", sophieu)
			.setInteger("thang", thang);
			results = query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		 
		return results;
	}	
}