package com.pn.dao.customer;

import java.util.List;

import com.pn.dao.base.GenericDAO;
import com.pn.model.Customer.DTCongNo;


public interface DTCongNoDao extends GenericDAO<DTCongNo, String>{
	public List<DTCongNo> getListDoiTuongCongNo();
}