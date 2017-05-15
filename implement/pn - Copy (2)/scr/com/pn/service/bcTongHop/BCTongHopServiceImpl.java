package com.pn.service.bcTongHop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.pn.dao.bcTongHop.BCTongHopDao;
import com.pn.dao.customer.DTCongNoDao;
import com.pn.model.BCTongHop;
import com.pn.model.Customer.DTCongNo;
@Service("bCTongHopService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BCTongHopServiceImpl implements BCTongHopService{

	@Autowired
	private BCTongHopDao bCTongHopDao;

	@Autowired
	private DTCongNoDao dTCongNoDao;
	
	public BCTongHopServiceImpl() {
	}
	@Override
	public List<BCTongHop> getBaoCaoTheoCongTy(String maCty, String tuNgay, String denNgay) {
		return bCTongHopDao.getBaoCaoTheoCongTy(maCty, tuNgay, denNgay);
	}
	@Override
	public List<BCTongHop> getBaoCaoTheoThang(String tuNgay, String denNgay) {
		return bCTongHopDao.getBaoCaoTheoThang(tuNgay, denNgay);
	}
	public List<Object> getAllCustomerInMonth(String tuNgay, String denNgay){
		return bCTongHopDao.getAllCustomerInMonth(tuNgay, denNgay);
	}
	@Cacheable(cacheName="dtCongNoCache")
	public List<DTCongNo> getListDoiTuongCongNo() {
		return dTCongNoDao.getListDoiTuongCongNo();
	}
	public int tongHopData(){
		return bCTongHopDao.tongHopData();
	}
}
