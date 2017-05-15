package com.eaton.tco.cis.dao.vehicleClass;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.eaton.tco.cis.dao.base.impl.GenericDAOImpl;
import com.eaton.tco.cis.entity.vehicleClass.VehicleClass;
import com.googlecode.ehcache.annotations.Cacheable;
@Repository("VehicleClassDao")
public class VehicleClassDaoImpl extends GenericDAOImpl<VehicleClass, Integer> 
	implements VehicleClassDao{
	
	@Cacheable(cacheName="vehicleClassesCache")
	public List<VehicleClass> loadAll() {
    	return super.loadAll();
    }
}
