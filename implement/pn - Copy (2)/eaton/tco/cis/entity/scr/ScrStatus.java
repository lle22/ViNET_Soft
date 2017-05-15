package com.eaton.tco.cis.entity.scr;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SCR_STATUS")
public class ScrStatus {
	@Id
	@Column(name = "SCR_STATUS") 
	private Integer scrStatus;
	
	@Column(name = "STATUS_DESC" , length=30, nullable = false) 
	private String statusDesc;
	
	@Column(name = "CREATED_BY") 
	 private String createbBy;
	
	@Column(name = "CREATE_STMP")	
	private Date CreateStmp;
	
	@Column(name = "UPDATED_BY") 
	 private String UpdateBy;

	@Column(name = "LAST_MAINT_DATE") 
	private Date lastMaintDate;

	@OneToMany(mappedBy="scrStatus", fetch=FetchType.LAZY)
	private List<Scr> scr;	
	public void setScr(List<Scr> scr) {
		this.scr = scr;
	}

	public List<Scr> getScr() {
		return scr;
	}
	
	public Integer getScrStatus() {
		return scrStatus;
	}

	public void setScrStatus(Integer scrStatus) {
		this.scrStatus = scrStatus;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getCreatebBy() {
		return createbBy;
	}

	public void setCreatebBy(String createbBy) {
		this.createbBy = createbBy;
	}

	public Date getCreateStmp() {
		return CreateStmp;
	}

	public void setCreateStmp(Date createStmp) {
		CreateStmp = createStmp;
	}

	public String getUpdateBy() {
		return UpdateBy;
	}

	public void setUpdateBy(String updateBy) {
		UpdateBy = updateBy;
	}

	public Date getLastMaintDate() {
		return lastMaintDate;
	}

	public void setLastMaintDate(Date lastMaintDate) {
		this.lastMaintDate = lastMaintDate;
	}

	
}
