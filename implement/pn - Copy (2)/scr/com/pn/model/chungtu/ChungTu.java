package com.pn.model.chungtu;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PS_ChungTu")
public class ChungTu {

	@Column(name = "Thang") 
	private Integer Thang;
	@Column(name = "SoPhieu", length = 50) 
	private String SoPhieu; 
	@Column(name = "NgayNhap") 
	private Date NgayNhap;
	
	@Column(name = "SoCT", length = 50) 
	private String SoCT;
	
	@Column(name = "NgayCT") private Date NgayCT;
	@Column(name = "DoiTuongCongNoID", length = 50) 
	private String DoiTuongCongNoID; 
	@Column(name = "TenDoiTuongCongNo", length = 255) 
	private String TenDoiTuongCongNo; 
	@Column(name = "DiaChi", length = 255)
	private String DiaChi; 
	@Column(name = "MasoThue", length = 50) 
	private String MasoThue; 
	@Column(name = "NoiDung", length = 500) 
	private String NoiDung; 
	@Column(name = "UserID", length = 20) 
	private String UserID; 
	@Column(name = "ChungTuID", length = 50) 
	private String ChungTuID; 
	@Column(name = "HinhThucThanhToan", length = 50) 
	private String HinhThucThanhToan; 
	@Column(name = "CTGoc", length = 300) 
	private String CTGoc; 
	@Column(name = "ViTri") 
	private Integer ViTri;
	@Column(name = "NganHangID", length = 50) 
	private String NganHangID; 
	@Column(name = "TenNganHang", length = 200) 
	private String TenNganHang; 
	@Column(name = "TaiKhoan", length = 50)
	private String TaiKhoan; 
	@Column(name = "DiaChiNganHang", length = 200)
	private String DiaChiNganHang; 
	@Column(name = "NganHangNguoiNhanID", length = 50)
	private String NganHangNguoiNhanID; 
	@Column(name = "TenNganHangNguoiNhan", length = 200)
	private String TenNganHangNguoiNhan; 
	@Column(name = "DiaChiNganHangNguoiNhan", length = 200)
	private String DiaChiNganHangNguoiNhan; 
	@Column(name = "TaiKhoanNguoiNhan", length = 50)
	private String TaiKhoanNguoiNhan; 
	@Column(name = "VAT_Seri", length = 200) 
	private String VAT_Seri; 
	@Column(name = "VAT_So", length = 50) 
	private String VAT_So; 
	@Column(name = "VAT_Ngay") 
	private Date VAT_Ngay;
	@Column(name = "LoaiTien", length = 20) 
	private String LoaiTien; 
	@Column(name = "TyGia") 
	private Double TyGia;
	@Column(name = "KhoaSo") 
	private Boolean KhoaSo;
	@Column(name = "ThoiHanThanhToan") 
	private Integer ThoiHanThanhToan;
	@Column(name = "ThangLienKet") 
	private Integer ThangLienKet;
	@Column(name = "SoPhieuLienKet", length = 20)
	private String SoPhieuLienKet; 
	@Column(name = "DonHangID", length = 20)
	private String DonHangID; 
	@Column(name = "NghiepVu", length = 10) 
	private String NghiepVu; 
	@Column(name = "NguoiGiaoDich", length = 50) 
	private String NguoiGiaoDich; 
	@Column(name = "ThanhToanNgay")
	private Boolean ThanhToanNgay;
	@Column(name = "SapXep") 
	private Integer SapXep;
	@Column(name = "ChungTuPhatSinhID", length = 20) 
	private String ChungTuPhatSinhID; 
	@Column(name = "MaCty", length = 10) 
	private String MaCty; 
	@Column(name = "TenCty", length = 200) 
	private String TenCty; 
	@Column(name = "TiepThi", length = 50) 
	private String TiepThi; 
	@Column(name = "ViTri_SoCT") 
	private Integer ViTri_SoCT;
	@Column(name = "TkChietKhauNo", length = 20) 
	private String TkChietKhauNo; 
	@Column(name = "TKChietKhauCo", length = 20) 
	private String TKChietKhauCo; 
	@Column(name = "TienChietKhau") 
	private Double TienChietKhau;
	@Column(name = "TienChietKhauNT") 
	private Double TienChietKhauNT;
	@Column(name = "ChietKhauTruocThue") 
	private Boolean ChietKhauTruocThue;
	@Column(name = "Congno") 
	private Double Congno;
	@Column(name = "TkThueNo", length = 20)
	private String QuyCach; 
	@Column(name = "TKThueCo", length = 20) 
	private String TKThueCo; 
	@Column(name = "TienThue_ChungTu") 
	private Double TienThue_ChungTu;
	@Column(name = "TienThueNT_ChungTu")
	private Double TienThueNT_ChungTu;
	@Column(name = "ThueSuat_ChungTu")
	private Integer ThueSuat_ChungTu;
	@Column(name = "TonKhoToiThieu_ChiTiet") 
	private Date TonKhoToiThieu_ChiTiet;
	@Column(name = "UserChinhSuaID", length = 20) 
	private String UserChinhSuaID; 
	@Column(name = "ThoiGianChinhSua") 
	private Date ThoiGianChinhSua;
	@Column(name = "TinhTrang") 
	private Integer TinhTrang;
	@Column(name = "PhiNgoai") 
	private Boolean PhiNgoai;
	@Column(name = "TamUng") 
	private Double TamUng;
	@Column(name = "TamUngNT") 
	private Double TamUngNT;
	@Column(name = "TyGiaNhoHon") 
	private Boolean TyGiaNhoHon;
	@Column(name = "DiaChiGiaohang", length = 200) 
	private String DiaChiGiaohang; 
	@Column(name = "TyLeChietKhau") 
	private Double TyLeChietKhau;
	@Column(name = "BoPhanID", length = 20) 
	private String BoPhanID; 
	@Column(name = "FromPOS") 
	private Boolean FromPOS;
	@Column(name = "TienThue_Noibo") 
	private Boolean TienThue_Noibo;
	@Column(name = "SuaTienThue") 
	private Boolean SuaTienThue;
	@Column(name = "NgayDuyet") 
	private Date NgayDuyet;
	@Column(name = "DuLieuDuocNapTuDatabaseKhac") 
	private Boolean DuLieuDuocNapTuDatabaseKhac;
	@Column(name = "SoTienBangChu", length = 350) 
	private String SoTienBangChu; 
	@Column(name = "MaChungTuTuychonID", length = 20) 
	private String MaChungTuTuychonID;
	public Integer getThang() {
		return Thang;
	}
	public void setThang(Integer thang) {
		Thang = thang;
	}
	public String getSoPhieu() {
		return SoPhieu;
	}
	public void setSoPhieu(String soPhieu) {
		SoPhieu = soPhieu;
	}
	public Date getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}
	public String getSoCT() {
		return SoCT;
	}
	public void setSoCT(String soCT) {
		SoCT = soCT;
	}
	public Date getNgayCT() {
		return NgayCT;
	}
	public void setNgayCT(Date ngayCT) {
		NgayCT = ngayCT;
	}
	public String getDoiTuongCongNoID() {
		return DoiTuongCongNoID;
	}
	public void setDoiTuongCongNoID(String doiTuongCongNoID) {
		DoiTuongCongNoID = doiTuongCongNoID;
	}
	public String getTenDoiTuongCongNo() {
		return TenDoiTuongCongNo;
	}
	public void setTenDoiTuongCongNo(String tenDoiTuongCongNo) {
		TenDoiTuongCongNo = tenDoiTuongCongNo;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getMasoThue() {
		return MasoThue;
	}
	public void setMasoThue(String masoThue) {
		MasoThue = masoThue;
	}
	public String getNoiDung() {
		return NoiDung;
	}
	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getChungTuID() {
		return ChungTuID;
	}
	public void setChungTuID(String chungTuID) {
		ChungTuID = chungTuID;
	}
	public String getHinhThucThanhToan() {
		return HinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		HinhThucThanhToan = hinhThucThanhToan;
	}
	public String getCTGoc() {
		return CTGoc;
	}
	public void setCTGoc(String cTGoc) {
		CTGoc = cTGoc;
	}
	public Integer getViTri() {
		return ViTri;
	}
	public void setViTri(Integer viTri) {
		ViTri = viTri;
	}
	public String getNganHangID() {
		return NganHangID;
	}
	public void setNganHangID(String nganHangID) {
		NganHangID = nganHangID;
	}
	public String getTenNganHang() {
		return TenNganHang;
	}
	public void setTenNganHang(String tenNganHang) {
		TenNganHang = tenNganHang;
	}
	public String getTaiKhoan() {
		return TaiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}
	public String getDiaChiNganHang() {
		return DiaChiNganHang;
	}
	public void setDiaChiNganHang(String diaChiNganHang) {
		DiaChiNganHang = diaChiNganHang;
	}
	public String getNganHangNguoiNhanID() {
		return NganHangNguoiNhanID;
	}
	public void setNganHangNguoiNhanID(String nganHangNguoiNhanID) {
		NganHangNguoiNhanID = nganHangNguoiNhanID;
	}
	public String getTenNganHangNguoiNhan() {
		return TenNganHangNguoiNhan;
	}
	public void setTenNganHangNguoiNhan(String tenNganHangNguoiNhan) {
		TenNganHangNguoiNhan = tenNganHangNguoiNhan;
	}
	public String getDiaChiNganHangNguoiNhan() {
		return DiaChiNganHangNguoiNhan;
	}
	public void setDiaChiNganHangNguoiNhan(String diaChiNganHangNguoiNhan) {
		DiaChiNganHangNguoiNhan = diaChiNganHangNguoiNhan;
	}
	public String getTaiKhoanNguoiNhan() {
		return TaiKhoanNguoiNhan;
	}
	public void setTaiKhoanNguoiNhan(String taiKhoanNguoiNhan) {
		TaiKhoanNguoiNhan = taiKhoanNguoiNhan;
	}
	public String getVAT_Seri() {
		return VAT_Seri;
	}
	public void setVAT_Seri(String vATSeri) {
		VAT_Seri = vATSeri;
	}
	public String getVAT_So() {
		return VAT_So;
	}
	public void setVAT_So(String vATSo) {
		VAT_So = vATSo;
	}
	public Date getVAT_Ngay() {
		return VAT_Ngay;
	}
	public void setVAT_Ngay(Date vATNgay) {
		VAT_Ngay = vATNgay;
	}
	public String getLoaiTien() {
		return LoaiTien;
	}
	public void setLoaiTien(String loaiTien) {
		LoaiTien = loaiTien;
	}
	public Double getTyGia() {
		return TyGia;
	}
	public void setTyGia(Double tyGia) {
		TyGia = tyGia;
	}
	public Boolean getKhoaSo() {
		return KhoaSo;
	}
	public void setKhoaSo(Boolean khoaSo) {
		KhoaSo = khoaSo;
	}
	public Integer getThoiHanThanhToan() {
		return ThoiHanThanhToan;
	}
	public void setThoiHanThanhToan(Integer thoiHanThanhToan) {
		ThoiHanThanhToan = thoiHanThanhToan;
	}
	public Integer getThangLienKet() {
		return ThangLienKet;
	}
	public void setThangLienKet(Integer thangLienKet) {
		ThangLienKet = thangLienKet;
	}
	public String getSoPhieuLienKet() {
		return SoPhieuLienKet;
	}
	public void setSoPhieuLienKet(String soPhieuLienKet) {
		SoPhieuLienKet = soPhieuLienKet;
	}
	public String getDonHangID() {
		return DonHangID;
	}
	public void setDonHangID(String donHangID) {
		DonHangID = donHangID;
	}
	public String getNghiepVu() {
		return NghiepVu;
	}
	public void setNghiepVu(String nghiepVu) {
		NghiepVu = nghiepVu;
	}
	public String getNguoiGiaoDich() {
		return NguoiGiaoDich;
	}
	public void setNguoiGiaoDich(String nguoiGiaoDich) {
		NguoiGiaoDich = nguoiGiaoDich;
	}
	public Boolean getThanhToanNgay() {
		return ThanhToanNgay;
	}
	public void setThanhToanNgay(Boolean thanhToanNgay) {
		ThanhToanNgay = thanhToanNgay;
	}
	public Integer getSapXep() {
		return SapXep;
	}
	public void setSapXep(Integer sapXep) {
		SapXep = sapXep;
	}
	public String getChungTuPhatSinhID() {
		return ChungTuPhatSinhID;
	}
	public void setChungTuPhatSinhID(String chungTuPhatSinhID) {
		ChungTuPhatSinhID = chungTuPhatSinhID;
	}
	public String getMaCty() {
		return MaCty;
	}
	public void setMaCty(String maCty) {
		MaCty = maCty;
	}
	public String getTenCty() {
		return TenCty;
	}
	public void setTenCty(String tenCty) {
		TenCty = tenCty;
	}
	public String getTiepThi() {
		return TiepThi;
	}
	public void setTiepThi(String tiepThi) {
		TiepThi = tiepThi;
	}
	public Integer getViTri_SoCT() {
		return ViTri_SoCT;
	}
	public void setViTri_SoCT(Integer viTriSoCT) {
		ViTri_SoCT = viTriSoCT;
	}
	public String getTkChietKhauNo() {
		return TkChietKhauNo;
	}
	public void setTkChietKhauNo(String tkChietKhauNo) {
		TkChietKhauNo = tkChietKhauNo;
	}
	public String getTKChietKhauCo() {
		return TKChietKhauCo;
	}
	public void setTKChietKhauCo(String tKChietKhauCo) {
		TKChietKhauCo = tKChietKhauCo;
	}
	public Double getTienChietKhau() {
		return TienChietKhau;
	}
	public void setTienChietKhau(Double tienChietKhau) {
		TienChietKhau = tienChietKhau;
	}
	public Double getTienChietKhauNT() {
		return TienChietKhauNT;
	}
	public void setTienChietKhauNT(Double tienChietKhauNT) {
		TienChietKhauNT = tienChietKhauNT;
	}
	public Boolean getChietKhauTruocThue() {
		return ChietKhauTruocThue;
	}
	public void setChietKhauTruocThue(Boolean chietKhauTruocThue) {
		ChietKhauTruocThue = chietKhauTruocThue;
	}
	public Double getCongno() {
		return Congno;
	}
	public void setCongno(Double congno) {
		Congno = congno;
	}
	public String getQuyCach() {
		return QuyCach;
	}
	public void setQuyCach(String quyCach) {
		QuyCach = quyCach;
	}
	public String getTKThueCo() {
		return TKThueCo;
	}
	public void setTKThueCo(String tKThueCo) {
		TKThueCo = tKThueCo;
	}
	public Double getTienThue_ChungTu() {
		return TienThue_ChungTu;
	}
	public void setTienThue_ChungTu(Double tienThueChungTu) {
		TienThue_ChungTu = tienThueChungTu;
	}
	public Double getTienThueNT_ChungTu() {
		return TienThueNT_ChungTu;
	}
	public void setTienThueNT_ChungTu(Double tienThueNTChungTu) {
		TienThueNT_ChungTu = tienThueNTChungTu;
	}
	public Integer getThueSuat_ChungTu() {
		return ThueSuat_ChungTu;
	}
	public void setThueSuat_ChungTu(Integer thueSuatChungTu) {
		ThueSuat_ChungTu = thueSuatChungTu;
	}
	public Date getTonKhoToiThieu_ChiTiet() {
		return TonKhoToiThieu_ChiTiet;
	}
	public void setTonKhoToiThieu_ChiTiet(Date tonKhoToiThieuChiTiet) {
		TonKhoToiThieu_ChiTiet = tonKhoToiThieuChiTiet;
	}
	public String getUserChinhSuaID() {
		return UserChinhSuaID;
	}
	public void setUserChinhSuaID(String userChinhSuaID) {
		UserChinhSuaID = userChinhSuaID;
	}
	public Date getThoiGianChinhSua() {
		return ThoiGianChinhSua;
	}
	public void setThoiGianChinhSua(Date thoiGianChinhSua) {
		ThoiGianChinhSua = thoiGianChinhSua;
	}
	public Integer getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(Integer tinhTrang) {
		TinhTrang = tinhTrang;
	}
	public Boolean getPhiNgoai() {
		return PhiNgoai;
	}
	public void setPhiNgoai(Boolean phiNgoai) {
		PhiNgoai = phiNgoai;
	}
	public Double getTamUng() {
		return TamUng;
	}
	public void setTamUng(Double tamUng) {
		TamUng = tamUng;
	}
	public Double getTamUngNT() {
		return TamUngNT;
	}
	public void setTamUngNT(Double tamUngNT) {
		TamUngNT = tamUngNT;
	}
	public Boolean getTyGiaNhoHon() {
		return TyGiaNhoHon;
	}
	public void setTyGiaNhoHon(Boolean tyGiaNhoHon) {
		TyGiaNhoHon = tyGiaNhoHon;
	}
	public String getDiaChiGiaohang() {
		return DiaChiGiaohang;
	}
	public void setDiaChiGiaohang(String diaChiGiaohang) {
		DiaChiGiaohang = diaChiGiaohang;
	}
	public Double getTyLeChietKhau() {
		return TyLeChietKhau;
	}
	public void setTyLeChietKhau(Double tyLeChietKhau) {
		TyLeChietKhau = tyLeChietKhau;
	}
	public String getBoPhanID() {
		return BoPhanID;
	}
	public void setBoPhanID(String boPhanID) {
		BoPhanID = boPhanID;
	}
	public Boolean getFromPOS() {
		return FromPOS;
	}
	public void setFromPOS(Boolean fromPOS) {
		FromPOS = fromPOS;
	}
	public Boolean getTienThue_Noibo() {
		return TienThue_Noibo;
	}
	public void setTienThue_Noibo(Boolean tienThueNoibo) {
		TienThue_Noibo = tienThueNoibo;
	}
	public Boolean getSuaTienThue() {
		return SuaTienThue;
	}
	public void setSuaTienThue(Boolean suaTienThue) {
		SuaTienThue = suaTienThue;
	}
	public Date getNgayDuyet() {
		return NgayDuyet;
	}
	public void setNgayDuyet(Date ngayDuyet) {
		NgayDuyet = ngayDuyet;
	}
	public Boolean getDuLieuDuocNapTuDatabaseKhac() {
		return DuLieuDuocNapTuDatabaseKhac;
	}
	public void setDuLieuDuocNapTuDatabaseKhac(Boolean duLieuDuocNapTuDatabaseKhac) {
		DuLieuDuocNapTuDatabaseKhac = duLieuDuocNapTuDatabaseKhac;
	}
	public String getSoTienBangChu() {
		return SoTienBangChu;
	}
	public void setSoTienBangChu(String soTienBangChu) {
		SoTienBangChu = soTienBangChu;
	}
	public String getMaChungTuTuychonID() {
		return MaChungTuTuychonID;
	}
	public void setMaChungTuTuychonID(String maChungTuTuychonID) {
		MaChungTuTuychonID = maChungTuTuychonID;
	} 

}
