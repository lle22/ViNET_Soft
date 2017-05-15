package com.pn.model.Customer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.pn.model.dmEmployee.Employee;
import com.pn.util.Ultil;
import com.pn.view.commentCustomer.bean.CommentCustomerBean;

@NamedQuery(name="getCommentCustomerByName",  
query="FROM CustomerPotential cp " +
"WHERE cp.name = :name"
)
@Entity
@Table(name = "CustomerPotential")
public class CustomerPotential {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false) 
	private Integer  id;
	@Column(name = "Name", length=255) 
	private String  name;
	@Column(name = "DiaChi", length=255) 
	private String  diaChi;
	@Column(name = "DienThoai", length=20) 
	private String  dienThoai;
	@Column(name = "Fax", length=20) 
	private String  fax;
	@Column(name = "Email", length=50) 
	private String  email;
	@Column(name = "GhiChu", length=5000) 
	private String  ghiChu;
	@Column(name = "NguoiGiaoDich", length=50) 
	private String  nguoiGiaoDich;

	@Column(name = "updated_by", length=50) 
	private String  updatedBy;
	
	@Column(name = "RatePotentialId", nullable=false) 
	private Integer  ratePotentialId;
	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="RatePotentialId", insertable=false, updatable=false, nullable=false)
	private RatePotential ratePotential;	 
	
	@Column(name = "employeeId", length=20, nullable=false) 
	private String  employeeId;
	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="employeeId", insertable=false, updatable=false, nullable=false)
	private Employee employee;	
	
	
	@Column(name = "RemindDate", length=20) 
	private Date  remindDate;
	
	@Column(name = "CreateDate", length=20) 
	private Date  createDate;
	
	@Column(name = "updateDate", length=20) 
	private Date  updateDate;
	
	@Column(name = "inactive", length=1) 
	private boolean  inactive;
	
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
	public void setRemindDate(Date remindDate) {
		this.remindDate = remindDate;
	}
	public Date getRemindDate() {
		return remindDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	
	public CustomerPotential(CommentCustomerBean bean, Employee userLogin){
		this.setCreateDate(Ultil.stringToDate(bean.getCreateDate()));
		this.setDiaChi(bean.getDiaChi().trim());
		this.setDienThoai(bean.getDienThoai().trim());
		if (bean.getEmail() != null) {
			this.setEmail(bean.getEmail().trim());
		}
		if (bean.getFax() != null) {
			this.setFax(bean.getFax());
		}
		String ghiChu = Ultil.dateTimeToString(new Date());
		if (bean.getGhiChu() != null) {
			ghiChu = "[" + ghiChu + "-" + userLogin.getId() + "] " + bean.getGhiChu().trim();
		}
		if (bean.getGhiChuCu() != null) {
			ghiChu = ghiChu + "\n" + bean.getGhiChuCu().trim();
		}
		this.setGhiChu(ghiChu);
		this.setId(bean.getId());
		this.setName(bean.getName());
		if (bean.getNguoiGiaoDich() != null) {
			this.setNguoiGiaoDich(bean.getNguoiGiaoDich().trim());
		}
		this.setRemindDate(Ultil.stringToDate(bean.getRemindDate()));
		this.setUpdateDate(new Date());
		this.setEmployeeId(bean.getEmployeeId());
		this.setRatePotentialId(bean.getRatePotentialId());
		this.setInactive(bean.getInactive());
		this.setUpdatedBy(userLogin.getId());
	}
	public CustomerPotential(){}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setRatePotentialId(Integer ratePotentialId) {
		this.ratePotentialId = ratePotentialId;
	}
	public Integer getRatePotentialId() {
		return ratePotentialId;
	}
	public void setRatePotential(RatePotential ratePotential) {
		this.ratePotential = ratePotential;
	}
	public RatePotential getRatePotential() {
		return ratePotential;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getUpdateDate() {
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
