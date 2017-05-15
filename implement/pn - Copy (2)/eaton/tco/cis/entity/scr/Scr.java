package com.eaton.tco.cis.entity.scr;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eaton.tco.cis.entity.vehicleClass.VehicleClass;

@Entity
@Table(name = "SCR")
public class Scr {
	 	
	  @Id
	  @Column(name = "SCR_NUMBER") 
	  private Integer scrNumber;
	  
	  @Column(name = "VERSION_NO") 
	  private Integer versionNo;
	  
	  @Column(name = "ACCT_NUMBER", nullable = false) 
	  private Integer accNumber;
	  
	  @Column(name = "OEM_CODE", nullable = false)
	  private Integer oemCode;
	  
	  @ManyToOne(fetch =FetchType.EAGER)
	  @JoinColumn(name="VEHICLE_CLASS", insertable=false, updatable=false, nullable=false)
	  private VehicleClass vehicleClass;
	  
	  @Column(name = "SCR_NAME", length=30, nullable = false)
	  private String scrName;
	  
	  @Column(name = "QUANTITY", nullable = false) 
	  private Integer quantiy;
	  
	  @Column(name = "SCR_YEAR", nullable = false) 
	  private Integer scrYear;
	  
	  @Column(name = "CURRENCY_CODE", length=3)
	  private String  currencyCode;
	  
	  @Column(name = "CUSTOMER_ACCEPTED") 
	  private Date customerAccepted;

	  @Column(name = "CUSTOMER_REJECTED") 
	  private Date customerRejected;

	  @Column(name = "EXPIRATION_DATE") 
	  private Date  expirationDate;
	  
	  @ManyToOne(fetch =FetchType.EAGER)
	  @JoinColumn(name="scr_Status", insertable=false, updatable=false, nullable=false)
	  private ScrStatus scrStatus;
	  
	  
	  @Column(name = "CREATED_BY", length=8, nullable = false)
	  private String createdBy;
	  
	  @Column(name = "CREATE_STMP", nullable = false)
	  private Date createSTMP;
	         
	  @Column(name = "UPDATED_BY", nullable = false) 
	  private String updatedBy;

	  @Column(name = "LAST_MAINT_DATE", nullable = false)
	   private Date lastMaintDate;
	     
	  @Column(name = "AVAIL_QTY") 
	  private Integer availQty;
	  
	  @Column(name = "TARGET_YN", length=1)
	  private String  targetYN;
	           
	  @Column(name = "VEHICLE_VOCATION") 
	  private Integer vehicleVocation;
	  
	  @Column(name = "CCR_ID") 
	  private Integer ccrID;
	  
	  @Column(name = "SHOW_TARGETS", length=1)
	  private String showTagerts;
	  
	  @Column(name = "NATIONAL_LTA", length=1) 
	  private String nationalLta;

	public Integer getScrNumber() {
		return scrNumber;
	}

	public void setScrNumber(Integer scrNumber) {
		this.scrNumber = scrNumber;
	}

	public Integer getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	public Integer getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(Integer accNumber) {
		this.accNumber = accNumber;
	}

	public Integer getOemCode() {
		return oemCode;
	}

	public void setOemCode(Integer oemCode) {
		this.oemCode = oemCode;
	}
	
	public String getScrName() {
		return scrName;
	}

	public void setScrName(String scrName) {
		this.scrName = scrName;
	}

	public Integer getQuantiy() {
		return quantiy;
	}

	public void setQuantiy(Integer quantiy) {
		this.quantiy = quantiy;
	}

	public Integer getScrYear() {
		return scrYear;
	}

	public void setScrYear(Integer scrYear) {
		this.scrYear = scrYear;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Date getCustomerAccepted() {
		return customerAccepted;
	}

	public void setCustomerAccepted(Date customerAccepted) {
		this.customerAccepted = customerAccepted;
	}

	public Date getCustomerRejected() {
		return customerRejected;
	}

	public void setCustomerRejected(Date customerRejected) {
		this.customerRejected = customerRejected;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateSTMP() {
		return createSTMP;
	}

	public void setCreateSTMP(Date createSTMP) {
		this.createSTMP = createSTMP;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getLastMaintDate() {
		return lastMaintDate;
	}

	public void setLastMaintDate(Date lastMaintDate) {
		this.lastMaintDate = lastMaintDate;
	}

	public Integer getAvailQty() {
		return availQty;
	}

	public void setAvailQty(Integer availQty) {
		this.availQty = availQty;
	}

	public String getTargetYN() {
		return targetYN;
	}

	public void setTargetYN(String targetYN) {
		this.targetYN = targetYN;
	}

	public Integer getVehicleVocation() {
		return vehicleVocation;
	}

	public void setVehicleVocation(Integer vehicleVocation) {
		this.vehicleVocation = vehicleVocation;
	}

	public Integer getCcrID() {
		return ccrID;
	}

	public void setCcrID(Integer ccrID) {
		this.ccrID = ccrID;
	}

	public String getShowTagerts() {
		return showTagerts;
	}

	public void setShowTagerts(String showTagerts) {
		this.showTagerts = showTagerts;
	}

	public String getNationalLta() {
		return nationalLta;
	}

	public void setNationalLta(String nationalLta) {
		this.nationalLta = nationalLta;
	}

	public void setScrStatus(ScrStatus scrStatus) {
		this.scrStatus = scrStatus;
	}

	public ScrStatus getScrStatus() {
		return scrStatus;
	}

	public void setVehicleClass(VehicleClass vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	public VehicleClass getVehicleClass() {
		return vehicleClass;
	}
	
}
