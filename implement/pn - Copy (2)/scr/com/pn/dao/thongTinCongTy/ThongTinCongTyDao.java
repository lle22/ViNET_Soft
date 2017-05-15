package com.pn.dao.thongTinCongTy;

import java.util.List;

import com.pn.dao.base.GenericDAO;
import com.pn.model.ThongTinKhachHang;

public interface ThongTinCongTyDao  extends GenericDAO<ThongTinKhachHang, Integer>{
	public List<ThongTinKhachHang> getThongTinCongTy();

}
