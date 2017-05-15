package com.eaton.tco.cis.service.vehicleClassService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eaton.tco.cis.dao.vehicleClass.VehicleClassDao;
import com.eaton.tco.cis.entity.vehicleClass.VehicleClass;

@Service("VehicleClassService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VehicleClassServiceImpl implements VehicleClassService{

	public VehicleClassServiceImpl() {
	}
	@Autowired
	private VehicleClassDao vehicleClassDao;
	
	@Override
	public List<VehicleClass> getAllVehicleClass(){
		return vehicleClassDao.loadAll();
	}
}
