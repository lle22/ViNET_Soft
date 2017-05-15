package com.pn.view.invoice.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pn.model.BCTongHop;
import com.pn.util.Ultil;


public class InvoiceBean {    
    Date now = new Date();
    Calendar cal = Calendar.getInstance();
    private Boolean isKemBangKe = true;
    private String tuNgay;
    private String denNgay = Ultil.dateToString(new Date());
    private String maCty;
    private String dTCongNo;
    private Integer  id;
	private String  ngay;
	private String  thang;
	private String  nam;
	private String  tenNguoiMuaHang;
	private String  tenDonVi;
	private String  maSoThue;
	private String  diaChi;
	private String  hinhThucThanhToan = "TM/CK";
	private String  soTaiKhoan;
	public List<InvoiceDetail> invoiceDetails = new ArrayList<InvoiceDetail>();
	private int  thueSuatGTGT = 10;
	private int  congTienHang;
	private int  tienThueGTGT;
	private String  soTienBangChu;
	private String  nguoiBanHang;
	private String  bangKeText = "Văn phòng phẩm các loại (kèm bảng kê chi tiết số:     ngày " 
		+ (cal.get(Calendar.DAY_OF_MONTH)<10?"0":"") + cal.get(Calendar.DAY_OF_MONTH) + " tháng  " 
		+ (cal.get(Calendar.MONTH)<10?"0":"") + (cal.get(Calendar.MONTH) + 1)  + " năm " +cal.get(Calendar.YEAR) +")";
	
	public InvoiceBean() {
	    cal.setTime(now);
	    this.ngay = cal.get(Calendar.DAY_OF_MONTH)<10?"0":"" + cal.get(Calendar.DAY_OF_MONTH);
	    this.thang = cal.get(Calendar.MONTH)<10?"0":"" + (cal.get(Calendar.MONTH) + 1);
	    this.nam = "" + cal.get(Calendar.YEAR);
	    for (int i = 0; i < 10; i++) {
	    	invoiceDetails.add(new InvoiceDetail());
		} 
	}
	public void formatInvoice(InvoiceBean invoiceBean) {
	    invoiceBean.setTenNguoiMuaHang(invoiceBean.getTenNguoiMuaHang()!=null?invoiceBean.getTenNguoiMuaHang().trim():"");
        invoiceBean.setTenDonVi(invoiceBean.getTenDonVi()!=null?invoiceBean.getTenDonVi().trim():"");
        invoiceBean.setMaSoThue(invoiceBean.getMaSoThue()!=null?invoiceBean.getMaSoThue().trim():"");
        invoiceBean.setDiaChi(invoiceBean.getDiaChi()!=null?invoiceBean.getDiaChi().trim():"");
        invoiceBean.setHinhThucThanhToan(invoiceBean.getHinhThucThanhToan()!=null?invoiceBean.getHinhThucThanhToan().trim():"");
        invoiceBean.setSoTaiKhoan(invoiceBean.getSoTaiKhoan()!=null?invoiceBean.getSoTaiKhoan().trim():"");
//        for (int i = 0; i < invoiceBean.getInvoiceDetails().size(); i++) {
//            InvoiceDetail invoiceDetail = invoiceBean.getInvoiceDetail(i);
//            invoiceDetail.setTenHangHoa(invoiceDetail.getTenHangHoa()!=null?invoiceDetail.getTenHangHoa().trim():"");
//            invoiceDetail.setDonViTinh(invoiceDetail.getDonViTinh()!=null?invoiceDetail.getDonViTinh().trim():"");            
//        }
    }
	public InvoiceBean(InvoiceBean invoiceBean) {
	    formatInvoice(invoiceBean);
	    
	}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNgay() {
        return ngay;
    }
    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
    public String getThang() {
        return thang;
    }
    public void setThang(String thang) {
        this.thang = thang;
    }
    public String getNam() {
        return nam;
    }
    public void setNam(String nam) {
        this.nam = nam;
    }
    public String getTenNguoiMuaHang() {
        return tenNguoiMuaHang;
    }
    public void setTenNguoiMuaHang(String tenNguoiMuaHang) {
        this.tenNguoiMuaHang = tenNguoiMuaHang;
    }
    public String getTenDonVi() {
        return tenDonVi;
    }
    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }
    public String getMaSoThue() {
        return maSoThue;
    }
    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }
    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }
    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }
    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }
    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }
    public String getSoTienBangChu() {
        return soTienBangChu;
    }
    public void setSoTienBangChu(String soTienBangChu) {
        this.soTienBangChu = soTienBangChu;
    }
    public String getNguoiBanHang() {
        return nguoiBanHang;
    }
    public void setNguoiBanHang(String nguoiBanHang) {
        this.nguoiBanHang = nguoiBanHang;
    }
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
    public String getdTCongNo() {
        return dTCongNo;
    }
    public void setdTCongNo(String dTCongNo) {
        this.dTCongNo = dTCongNo;
    }
    public Boolean getIsKemBangKe() {
        return isKemBangKe;
    }
    public void setIsKemBangKe(Boolean isKemBangKe) {
        this.isKemBangKe = isKemBangKe;
    }
    public int getCongTienHang() {
        return congTienHang;
    }
    public void setCongTienHang(int congTienHang) {
        this.congTienHang = congTienHang;
    }
    public int getTienThueGTGT() {
        return tienThueGTGT;
    }
    public void setTienThueGTGT(int tienThueGTGT) {
        this.tienThueGTGT = tienThueGTGT;
    }
    public int getThueSuatGTGT() {
        return thueSuatGTGT;
    }
    public void setThueSuatGTGT(int thueSuatGTGT) {
        this.thueSuatGTGT = thueSuatGTGT;
    }

	public void setBangKeText(String bangKeText) {
		this.bangKeText = bangKeText;
	}

	public String getBangKeText() {
		return bangKeText;
	}
    public void setInvoiceDetailsFromBcCongNo(List<BCTongHop> bcCongNo) {
        for(int i = 0 ; i < bcCongNo.size(); i++){
            BCTongHop bc = bcCongNo.get(i);
            if(bc.getSoLuong()!= null && bc.getSoLuong() > 0 && bc.getDonGia()!= null && bc.getDonGia()>0){
               InvoiceDetail invoiceDetail = new InvoiceDetail();
               invoiceDetail.setDonGia(bc.getDonGia());
               invoiceDetail.setDonViTinh(bc.getdVT());
               invoiceDetail.setSoLuong(bc.getSoLuong());
               invoiceDetail.setSoTT((i +1) + "");
               invoiceDetail.setTenHangHoa(bc.getTenVatTu());
               invoiceDetail.setThanhTien(bc.getSoLuong()*bc.getDonGia());
               this.invoiceDetails.add(invoiceDetail);
            }
        }       
    }
}
