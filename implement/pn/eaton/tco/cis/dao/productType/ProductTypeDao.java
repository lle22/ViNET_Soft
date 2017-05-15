package com.eaton.tco.cis.dao.productType;

import java.util.List;

import com.eaton.tco.cis.dao.base.GenericDAO;
import com.eaton.tco.cis.entity.productType.ProductType;

public interface ProductTypeDao  extends GenericDAO<ProductType, Integer> {
	public List<ProductType> loadAll();
}
