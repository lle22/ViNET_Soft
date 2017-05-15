package com.eaton.tco.cis.dao.productType;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eaton.tco.cis.dao.base.impl.GenericDAOImpl;
import com.eaton.tco.cis.entity.productType.ProductType;
import com.googlecode.ehcache.annotations.Cacheable;
@Repository("ProductTypeDao")
public class ProductTypeDaoImpl extends GenericDAOImpl<ProductType, Integer> 
	implements ProductTypeDao{
	
	@Cacheable(cacheName="productTypeCache")
	public List<ProductType> loadAll() {
    	return super.loadAll();
    }
}
