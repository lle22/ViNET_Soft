package com.pn.view.commentCustomer.bean;

import com.pn.model.Customer.CustomerPotential;
import com.pn.util.Ultil;


public class CommentCustomerBean {
	
	private Integer  id;
	private String  name;
	private String  diaChi;
	private String  dienThoai;
	private String  fax;
	private String  email;
	private String  ghiChu;
	private String  ghiChuCu;
	private String  nguoiGiaoDich;
	private String  employeeId;
	private String  employeeName;
	private String  remindDate;
	private String  createDate;
	private String  updateDate;
	private String  toCreateDate;
	private Integer ratePotentialId;
	private String  ratePotentialDesc;
	private String  sortColumn;
	private String  orderBy;
	private String  updatedBy;
	private boolean  inactive;
	public CommentCustomerBean() {}
	public CommentCustomerBean(CustomerPotential cp) {
		this.setCreateDate(Ultil.dateToString(cp.getCreateDate()));
		this.setDiaChi(cp.getDiaChi());
		this.setDienThoai(cp.getDienThoai());
		this.setEmail(cp.getEmail());
		this.setFax(cp.getFax());
		this.setGhiChuCu(cp.getGhiChu());
		this.setId(cp.getId());
		this.setName(cp.getName());
		this.setNguoiGiaoDich(cp.getNguoiGiaoDich());
		this.setRemindDate(Ultil.dateToString(cp.getRemindDate()));
		this.setUpdateDate(Ultil.dateToString(cp.getUpdateDate()));
		this.setEmployeeId(cp.getEmployee().getId());
		this.setEmployeeName(cp.getEmployee().getTenNhanVienKD());
		this.setRatePotentialId(cp.getRatePotentialId());
		this.setRatePotentialDesc(cp.getRatePotential().getDescription());
		this.setInactive(cp.getInactive());
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getNguoiGiaoDich() {
		return nguoiGiaoDich;
	}
	public void setNguoiGiaoDich(String nguoiGiaoDich) {
		this.nguoiGiaoDich = nguoiGiaoDich;
	}
	public void setRemindDate(String remindDate) {
		this.remindDate = remindDate;
	}
	public String getRemindDate() {
		return remindDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateDate() {
		return createDate;
	}
	
	public void setToCreateDate(String toCreateDate) {
		this.toCreateDate = toCreateDate;
	}
	public String getToCreateDate() {
		return toCreateDate;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setRatePotentialId(Integer ratePotential) {
		this.ratePotentialId = ratePotential;
	}
	public Integer getRatePotentialId() {
		return ratePotentialId;
	}
	public void setRatePotentialDesc(String ratePotentialDesc) {
		this.ratePotentialDesc = ratePotentialDesc;
	}
	public String getRatePotentialDesc() {
		return ratePotentialDesc;
	}
	public void setGhiChuCu(String ghiChuCu) {
		this.ghiChuCu = ghiChuCu;
	}
	public String getGhiChuCu() {
		return ghiChuCu;
	}
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
	public String getSortColumn() {
		return sortColumn;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}
	public boolean getInactive() {
		return inactive;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}	
}
