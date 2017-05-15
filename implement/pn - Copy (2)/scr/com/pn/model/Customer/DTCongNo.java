package com.pn.model.Customer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name="getDoiTuongCongNo",  
        query="FROM DTCongNo cn WHERE cn.kieuCongNo='Khách hàng' ORDER BY cn.tenDoiTuongCongNo ASC") 
@Entity
@Table(name = "DM_DoiTuongCongNo")
public class DTCongNo {
	
	@Id
	@Column(name = "ID", length=20, nullable = false) 
	private String  id;
	@Column(name = "TenDoiTuongCongNo", length=255) 
	private String  tenDoiTuongCongNo;
	@Column(name = "NgayLamviec") 
	private Date  ngayLamviec;
	@Column(name = "MaSoThue", length=50) 
	private String  maSoThue;
	@Column(name = "NguoiDaiDien", length=50) 
	private String  nguoiDaiDien;	
	@Column(name = "Chucvu", length=50) 
	private String  chucvu;
	@Column(name = "KhuVucID", length=50) 
	private String  khuVucID;
	@Column(name = "GioiHanCN") 
	private Double gioiHanCN;
	@Column(name = "SoNgay") 
	private Integer  soNgay;
	@Column(name = "DiaChi", length=255) 
	private String  diaChi;
	@Column(name = "DienThoai", length=20) 
	private String  dienThoai;
	@Column(name = "Fax", length=20) 
	private String  fax;
	@Column(name = "Email", length=50) 
	private String  email;
	@Column(name = "Website", length=50) 
	private String  Website;
	@Column(name = "GhiChu", length=200) 
	private String  ghiChu;
	@Column(name = "LoaiDoiTuongCongNoID", length=20) 
	private String  loaiDoiTuongCongNoID;
	@Column(name = "PriceTypeID", length=20) 
	private String  priceTypeID;
	@Column(name = "KieuCongNo", length=50) 
	private String  kieuCongNo;
	@Column(name = "CongNoHienTai") 
	private Double congNoHienTai;
	@Column(name = "CongNoHoaDon") 
	private Boolean  CongNoHoaDon;
	@Column(name = "NguoiGiaoDich", length=50) 
	private String  nguoiGiaoDich;
	@Column(name = "KhongHienThi") 
	private Boolean  khongHienThi;
	@Column(name = "DiaChiGiaohang", length=200) 
	private String  diaChiGiaohang;
	@Column(name = "TenNganhang", length=200) 
	private String  tenNganhang;
	@Column(name = "DiaChiNganHang", length=150) 
	private String  diaChiNganHang;
	@Column(name = "TaiKhoanNganHang", length=50) 
	private String  taiKhoanNganHang;
	@Column(name = "NhanVienKDID", length=50) 
	private String  nhanVienKDID;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenDoiTuongCongNo() {
		return tenDoiTuongCongNo;
	}
	public void setTenDoiTuongCongNo(String tenDoiTuongCongNo) {
		this.tenDoiTuongCongNo = tenDoiTuongCongNo;
	}
	public Date getNgayLamviec() {
		return ngayLamviec;
	}
	public void setNgayLamviec(Date ngayLamviec) {
		this.ngayLamviec = ngayLamviec;
	}
	public String getMaSoThue() {
		return maSoThue;
	}
	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	public String getNguoiDaiDien() {
		return nguoiDaiDien;
	}
	public void setNguoiDaiDien(String nguoiDaiDien) {
		this.nguoiDaiDien = nguoiDaiDien;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public String getKhuVucID() {
		return khuVucID;
	}
	public void setKhuVucID(String khuVucID) {
		this.khuVucID = khuVucID;
	}
	public Double getGioiHanCN() {
		return gioiHanCN;
	}
	public void setGioiHanCN(Double gioiHanCN) {
		this.gioiHanCN = gioiHanCN;
	}
	public Integer getSoNgay() {
		return soNgay;
	}
	public void setSoNgay(Integer soNgay) {
		this.soNgay = soNgay;
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
	public String getWebsite() {
		return Website;
	}
	public void setWebsite(String website) {
		Website = website;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getLoaiDoiTuongCongNoID() {
		return loaiDoiTuongCongNoID;
	}
	public void setLoaiDoiTuongCongNoID(String loaiDoiTuongCongNoID) {
		this.loaiDoiTuongCongNoID = loaiDoiTuongCongNoID;
	}
	public String getPriceTypeID() {
		return priceTypeID;
	}
	public void setPriceTypeID(String priceTypeID) {
		this.priceTypeID = priceTypeID;
	}
	public String getKieuCongNo() {
		return kieuCongNo;
	}
	public void setKieuCongNo(String kieuCongNo) {
		this.kieuCongNo = kieuCongNo;
	}
	public Double getCongNoHienTai() {
		return congNoHienTai;
	}
	public void setCongNoHienTai(Double congNoHienTai) {
		this.congNoHienTai = congNoHienTai;
	}
	public Boolean getCongNoHoaDon() {
		return CongNoHoaDon;
	}
	public void setCongNoHoaDon(Boolean congNoHoaDon) {
		CongNoHoaDon = congNoHoaDon;
	}
	public String getNguoiGiaoDich() {
		return nguoiGiaoDich;
	}
	public void setNguoiGiaoDich(String nguoiGiaoDich) {
		this.nguoiGiaoDich = nguoiGiaoDich;
	}
	public Boolean getKhongHienThi() {
		return khongHienThi;
	}
	public void setKhongHienThi(Boolean khongHienThi) {
		this.khongHienThi = khongHienThi;
	}
	public String getDiaChiGiaohang() {
		return diaChiGiaohang;
	}
	public void setDiaChiGiaohang(String diaChiGiaohang) {
		this.diaChiGiaohang = diaChiGiaohang;
	}
	public String getTenNganhang() {
		return tenNganhang;
	}
	public void setTenNganhang(String tenNganhang) {
		this.tenNganhang = tenNganhang;
	}
	public String getDiaChiNganHang() {
		return diaChiNganHang;
	}
	public void setDiaChiNganHang(String diaChiNganHang) {
		this.diaChiNganHang = diaChiNganHang;
	}
	public String getTaiKhoanNganHang() {
		return taiKhoanNganHang;
	}
	public void setTaiKhoanNganHang(String taiKhoanNganHang) {
		this.taiKhoanNganHang = taiKhoanNganHang;
	}
	public String getNhanVienKDID() {
		return nhanVienKDID;
	}
	public void setNhanVienKDID(String nhanVienKDID) {
		this.nhanVienKDID = nhanVienKDID;
	}
}
