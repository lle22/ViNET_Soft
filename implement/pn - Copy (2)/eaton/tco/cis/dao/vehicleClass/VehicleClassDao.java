package com.eaton.tco.cis.dao.vehicleClass;

import java.util.List;

import com.eaton.tco.cis.dao.base.GenericDAO;
import com.eaton.tco.cis.entity.vehicleClass.VehicleClass;

public interface VehicleClassDao extends GenericDAO<VehicleClass, Integer> {
	public List<VehicleClass> loadAll();
}
