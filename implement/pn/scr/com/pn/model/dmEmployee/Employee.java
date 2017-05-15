package com.pn.model.dmEmployee;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pn.model.Customer.CustomerPotential;

@Entity
@Table(name = "DM_nhanvienKD")
public class Employee {
	
	@Id
	@Column(name = "ID", nullable = false, length=20) 
	private String  id;
	@Column(name = "TenNhanVienKD", length=50) 
	private String  tenNhanVienKD;
	@Column(name = "GhiChu", length=50) 
	private String  ghiChu;
	@Column(name = "PassWord", length=20, nullable = false) 
	private String  passWord;
	@Column(name = "role", length=10, nullable = false) 
	private String  role;
	
	@OneToMany(mappedBy="employee", fetch=FetchType.EAGER)
	private List<CustomerPotential> cp;
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenNhanVienKD() {
		return tenNhanVienKD;
	}
	public void setTenNhanVienKD(String tenNhanVienKD) {
		this.tenNhanVienKD = tenNhanVienKD;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public void setCp(List<CustomerPotential> cp) {
		this.cp = cp;
	}
	public List<CustomerPotential> getCp() {
		return cp;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	
}
