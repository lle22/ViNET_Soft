package com.pn.dao.chungtu;

import java.util.List;

import com.pn.dao.base.GenericDAO;
import com.pn.model.chungtu.ChiTietChungTu;


public interface ChungTuDao extends GenericDAO<ChiTietChungTu, Integer>{
	public List<ChiTietChungTu> getAllChungTuBaseSoPhieu(String sophieu, Integer thang);

}