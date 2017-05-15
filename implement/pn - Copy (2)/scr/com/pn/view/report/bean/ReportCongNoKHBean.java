package com.pn.view.report.bean;

import java.util.Date;

import com.pn.util.Ultil;

public class ReportCongNoKHBean {
	private String tuNgay;
	private String denNgay = Ultil.dateToString(new Date());
	private String maCty;
	private String dTCongNo;
	private Boolean isBangKe = true;
	private Boolean isCongNo = true;
	private Boolean isTongHopMatHang;
	private Boolean isTongSoKHtrongThang;
	private String chietKhau;	
	private Boolean isShowMaHang;
	
	public String getTuNgay() {
		return tuNgay;
	}
	public void setTuNgay(String tuNgay) {
		this.tuNgay = tuNgay;
	}
	public String getDenNgay() {
		return denNgay;
	}
	public void setDenNgay(String denNgay) {
		this.denNgay = denNgay;
	}
	public String getMaCty() {
		return maCty;
	}
	public void setMaCty(String maCty) {
		this.maCty = maCty;
	}
	public String getDTCongNo() {
		return dTCongNo;
	}
	public void setDTCongNo(String congNo) {
		dTCongNo = congNo;
	}	
	public Boolean getIsBangKe() {
		return isBangKe;
	}
	public void setIsBangKe(Boolean isBangKe) {
		this.isBangKe = isBangKe;
	}
	public Boolean getIsCongNo() {
		return isCongNo;
	}
	public void setIsCongNo(Boolean isCongNo) {
		this.isCongNo = isCongNo;
	}
	public void setIsTongHopMatHang(Boolean isTongHopMatHang) {
		this.isTongHopMatHang = isTongHopMatHang;
	}
	public Boolean getIsTongHopMatHang() {
		return isTongHopMatHang;
	}
	public void setChietKhau(String chietKhau) {
		this.chietKhau = chietKhau;
	}
	public String getChietKhau() {
		return chietKhau;
	}
	public void setIsTongSoKHtrongThang(Boolean isTongSoKHtrongThang) {
		this.isTongSoKHtrongThang = isTongSoKHtrongThang;
	}
	public Boolean getIsTongSoKHtrongThang() {
		return isTongSoKHtrongThang;
	}
	public void setIsShowMaHang(Boolean isShowMaHang) {
		this.isShowMaHang = isShowMaHang;
	}
	public Boolean getIsShowMaHang() {
		return isShowMaHang;
	}	
	
	
}
