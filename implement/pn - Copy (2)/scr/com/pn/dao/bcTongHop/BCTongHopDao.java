package com.pn.dao.bcTongHop;

import java.util.List;

import com.pn.dao.base.GenericDAO;
import com.pn.model.BCTongHop;


public interface BCTongHopDao extends GenericDAO<BCTongHop, Integer>{
	public List<BCTongHop> getBaoCaoTheoCongTy(String maCty, String tuNgay, String denNgay);
	public List<BCTongHop> getBaoCaoTheoThang(String tuNgay, String denNgay);
	public int tongHopData();
	public List<Object> getAllCustomerInMonth(String tuNgay, String denNgay);

}