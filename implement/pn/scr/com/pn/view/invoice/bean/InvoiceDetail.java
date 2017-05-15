package com.pn.view.invoice.bean;

public class InvoiceDetail {
    public InvoiceDetail() {
    }
    public InvoiceDetail(String soTT) {
    	this.soTT = soTT;
    }
    private String  soTT;
    private String  tenHangHoa = "";
    private String  donViTinh = "";
    private Double  soLuong;
    private Double  donGia;
    private Double  thanhTien;
    public String getSoTT() {
        return soTT;
    }
    public void setSoTT(String soTT) {
        this.soTT = soTT;
    }
    public String getTenHangHoa() {
        return tenHangHoa;
    }
    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }
    public String getDonViTinh() {
        return donViTinh;
    }
    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
    public Double getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(Double soLuong) {
        this.soLuong = soLuong;
    }
    public Double getDonGia() {
        return donGia;
    }
    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
    public Double getThanhTien() {
        return thanhTien;
    }
    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

}
