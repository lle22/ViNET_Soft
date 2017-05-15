package com.eaton.tco.cis.service.scr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eaton.tco.cis.dao.scr.ScrDao;
import com.eaton.tco.cis.entity.scr.Scr;

@Service("ScrService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ScrServiceImpl implements ScrService{

	public ScrServiceImpl() {
	}
	@Autowired
	private ScrDao scrDao;
	
	@Override
	public Scr getScr(Integer scrNumber) {
		return scrDao.loadById(scrNumber);
	}
}
