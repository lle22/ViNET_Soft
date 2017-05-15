package com.pn.service.chungtu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pn.dao.chungtu.ChungTuDao;
import com.pn.model.chungtu.ChiTietChungTu;
@Service("chungtuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ChungtuServiceImpl implements ChungtuService{

	@Autowired
	private ChungTuDao chungTuDao;

	public ChungtuServiceImpl() {
	}
	@Override
	public List<ChiTietChungTu> getAllChungTuBaseSoPhieu(String sophieu, Integer thang) {
		return chungTuDao.getAllChungTuBaseSoPhieu(sophieu, thang);
	}	
}
