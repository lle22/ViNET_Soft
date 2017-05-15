package com.pn.service.thongTinKhachHang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pn.dao.thongTinCongTy.ThongTinCongTyDao;
import com.pn.model.ThongTinKhachHang;
@Service("ThongTinCongTyService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ThongTinCongTyServiceImpl implements ThongTinCongTyService{
	
	@Autowired
	private ThongTinCongTyDao thongTinCongTyDao;

	public ThongTinCongTyServiceImpl() {
	}
	public List<ThongTinKhachHang> getThongTinCongTy() {
		return thongTinCongTyDao.getThongTinCongTy();
	}
}
