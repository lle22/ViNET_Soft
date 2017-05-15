package com.eaton.tco.cis.entity.vehicleClass;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.eaton.tco.cis.entity.scr.Scr;

@Entity
@Table(name="VEHICLE_CLASS")
public class VehicleClass {	
	@Id
	@Column(name = "VEHICLE_CLASS") 
	private String vehicleClass;
	
	@Column(name = "VEHICLE_CLASS_DESC" , length=25, nullable = false) 
	private String vehicleClassDesc;
	
	@Column(name = "CREATED_BY") 
	 private String createbBy;
	
	@Column(name = "CREATE_STMP")	
	private Date CreateStmp;
	
	@Column(name = "UPDATED_BY") 
	 private String UpdateBy;

	@Column(name = "LAST_MAINT_DATE") 
	private Date lastMaintDate;

	@OneToMany(mappedBy="vehicleClass", fetch=FetchType.LAZY)
	private List<Scr> scr;	
	public void setScr(List<Scr> scr) {
		this.scr = scr;
	}
	public String getVehicleClass() {
		return vehicleClass;
	}
	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
	}
	public String getVehicleClassDesc() {
		return vehicleClassDesc;
	}
	public void setVehicleClassDesc(String vehicleClassDesc) {
		this.vehicleClassDesc = vehicleClassDesc;
	}
	public String getCreatebBy() {
		return createbBy;
	}
	public void setCreatebBy(String createbBy) {
		this.createbBy = createbBy;
	}	
	public String getUpdateBy() {
		return UpdateBy;
	}
	public void setUpdateBy(String updateBy) {
		UpdateBy = updateBy;
	}
	public Date getCreateStmp() {
		return CreateStmp;
	}
	public void setCreateStmp(Date createStmp) {
		CreateStmp = createStmp;
	}
	public Date getLastMaintDate() {
		return lastMaintDate;
	}
	public void setLastMaintDate(Date lastMaintDate) {
		this.lastMaintDate = lastMaintDate;
	}
	public List<Scr> getScr() {
		return scr;
	}
	
}
