package com.pn.dao.thongTinCongTy;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pn.dao.base.impl.GenericDAOImpl;
import com.pn.model.ThongTinKhachHang;
@Repository("thongTinCongTyDao")
public class ThongTinCongTyDaoImpl  extends GenericDAOImpl<ThongTinKhachHang, Integer> implements ThongTinCongTyDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinKhachHang> getThongTinCongTy() {
		return (List<ThongTinKhachHang>) sessionFactory.getCurrentSession().createCriteria(ThongTinKhachHang.class).list();
	}

}
