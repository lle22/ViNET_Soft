package com.eaton.tco.cis.entity.productType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType {
	@Id
	@Column(name = "PRODUCT_TYPE")
	private Integer productType;

	@Column(name = "PRODUCT_TYPE_DESC", length = 20, nullable = false)
	private String productTypeDesc;

	@Column(name = "PRODUCT_TYPE_SEQ", nullable = false)
	private Integer productTypeSeq;

	@Column(name = "DIVISION_NO", length = 1)
	private String divisionNo;

	@Column(name = "PRODUCT_TYPE_SEQ2")
	private Integer productTypeSeq2;

	@Column(name = "CLOSED_ORDER_COA", length = 37)
	private String closedOrderCOA;

	@Column(name = "INCENTIVE_IND", length = 1, nullable = false)
	private String incentiveIND;

	@Column(name = "INCENT_APPRV_AUTH", length = 8)
	private String incentApprvAuth;

	@Column(name = "INCENTIVE_CAP", length = 1, nullable = false)
	private String incentiveCAP;

	@Column(name = "SCR_RANGE_IND", length = 1, nullable = false)
	private String scrRangeIND;

	@Column(name = "VDN_RANGE_IND", length = 1, nullable = false)
	private String vdnRangeIND;

	@Column(name = "CREATED_BY", length = 8)
	private String createBy;

	@Column(name = "CREATE_STMP")
	private Date createSTMP;

	@Column(name = "UPDATED_BY", length = 8)
	private String updateBy;

	@Column(name = "LAST_MAINT_DATE")
	private Date lastMaintDate;

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public String getProductTypeDesc() {
		return productTypeDesc;
	}

	public void setProductTypeDesc(String productTypeDesc) {
		this.productTypeDesc = productTypeDesc;
	}

	public Integer getProductTypeSeq() {
		return productTypeSeq;
	}

	public void setProductTypeSeq(Integer productTypeSeq) {
		this.productTypeSeq = productTypeSeq;
	}

	public String getDivisionNo() {
		return divisionNo;
	}

	public void setDivisionNo(String divisionNo) {
		this.divisionNo = divisionNo;
	}

	public Integer getProductTypeSeq2() {
		return productTypeSeq2;
	}

	public void setProductTypeSeq2(Integer productTypeSeq2) {
		this.productTypeSeq2 = productTypeSeq2;
	}

	public String getClosedOrderCOA() {
		return closedOrderCOA;
	}

	public void setClosedOrderCOA(String closedOrderCOA) {
		this.closedOrderCOA = closedOrderCOA;
	}

	public String getIncentiveIND() {
		return incentiveIND;
	}

	public void setIncentiveIND(String incentiveIND) {
		this.incentiveIND = incentiveIND;
	}

	public String getIncentApprvAuth() {
		return incentApprvAuth;
	}

	public void setIncentApprvAuth(String incentApprvAuth) {
		this.incentApprvAuth = incentApprvAuth;
	}

	public String getIncentiveCAP() {
		return incentiveCAP;
	}

	public void setIncentiveCAP(String incentiveCAP) {
		this.incentiveCAP = incentiveCAP;
	}

	public String getScrRangeIND() {
		return scrRangeIND;
	}

	public void setScrRangeIND(String scrRangeIND) {
		this.scrRangeIND = scrRangeIND;
	}

	public String getVdnRangeIND() {
		return vdnRangeIND;
	}

	public void setVdnRangeIND(String vdnRangeIND) {
		this.vdnRangeIND = vdnRangeIND;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateSTMP() {
		return createSTMP;
	}

	public void setCreateSTMP(Date createSTMP) {
		this.createSTMP = createSTMP;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getLastMaintDate() {
		return lastMaintDate;
	}

	public void setLastMaintDate(Date lastMaintDate) {
		this.lastMaintDate = lastMaintDate;
	}
}
