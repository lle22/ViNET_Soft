package com.pn.dao.bcTongHop;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pn.dao.base.impl.GenericDAOImpl;
import com.pn.model.BCTongHop;

@Repository("bCTongHopDao")
public class BCTongHopDaoImpl extends GenericDAOImpl<BCTongHop, Integer> implements BCTongHopDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Object> getAllCustomerInMonth(String tuNgay, String denNgay) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Session session =sessionFactory.openSession();
		List results = null;
		try {
			Query query = session.createQuery("SELECT bc.doiTuongCongNoID, bc.tenDoiTuongCongNo , SUM(bc.soLuong * bc.donGia) as tongTien " 
        		   			+ " FROM BCTongHop bc "   			
        		   			+ " WHERE bc.noCo=1 AND bc.tKCoID like '51%'" 
        		   			+ " AND bc.ngayNhap >= :tuNgay " 
        		   			+ " AND bc.ngayNhap <= :denNgay"
        		   			+ " GROUP BY bc.doiTuongCongNoID, bc.tenDoiTuongCongNo"
        		   			+ " ORDER BY bc.doiTuongCongNoID")
			.setDate("tuNgay", format.parse(tuNgay))
			.setDate("denNgay", format.parse(denNgay));
			results = query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		 
		return results;
	}
	@SuppressWarnings("unchecked")
	public List<BCTongHop> getBaoCaoTheoCongTy(String maCty, String tuNgay, String denNgay) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Session session =sessionFactory.openSession();
		List results = null;
		try {
			Query query = session.getNamedQuery("getCongNoTheoKhachHang")
			.setString("doiTuongCongNoID", maCty).setDate("tuNgay", format.parse(tuNgay))
			.setDate("denNgay", format.parse(denNgay));
			results = query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return results;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<BCTongHop> getBaoCaoTheoThang(String tuNgay, String denNgay) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Session session =sessionFactory.openSession();
		List results = null;
		try {
			Query query = session.getNamedQuery("getCongNoTheoThang")
			.setDate("tuNgay", format.parse(tuNgay))
			.setDate("denNgay", format.parse(denNgay));
			results = query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		 
		return results;
	}
	@Override
	public int tongHopData() {
		int result = -1;
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createSQLQuery("sp_TongHopToanBoWeb");
			result = query.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;

	}
}