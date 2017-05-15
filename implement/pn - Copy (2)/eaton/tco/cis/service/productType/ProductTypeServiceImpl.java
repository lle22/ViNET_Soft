package com.eaton.tco.cis.service.productType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eaton.tco.cis.dao.productType.ProductTypeDao;
import com.eaton.tco.cis.entity.productType.ProductType;

@Service("ProductTypeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductTypeServiceImpl implements ProductTypeService{

	public ProductTypeServiceImpl() {
	}
	@Autowired
	private ProductTypeDao productTypeDao;
	
	@Override
	public List<ProductType> getAllProductType(){
		return productTypeDao.loadAll();
	}
}
