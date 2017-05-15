package com.pn.model.chungtu;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "PS_ChiTiet")
public class ChiTietChungTu {

	@Id
	@Column(name = "STT")
	private Integer STT;
	
	@Column(name = "Thang")
	private int thang;

	@Column(name = "SoPhieu", length = 50)
	private String soPhieu;

	@Column(name = "TKNoID ", length = 20)
	private String tKNoID;
	@Column(name = "TKCoID", length = 20)
	private String tKCoID;
	@Column(name = "VatTuID", length = 50)
	private String vatTuID;
	@Column(name = "DVT", length = 50)
	private String DVT;
	@Column(name = "DonGia")
	private int donGia;
	@Column(name = "SoLuong")
	private int soLuong;
	@Column(name = "PhatSinh")
	private Double phatSinh;
	@Column(name = "GianTiep")
	private Boolean gianTiep;
	@Column(name = "DienGiai", length = 500)
	private String dienGiai;
	@Column(name = "DonGiaNT")
	private Double donGiaNT;
	@Column(name = "PhatSinhNT")
	private Double phatSinhNT;
	@Column(name = "KhoHangID", length = 50)
	private String khoHangID;
	@Column(name = "LCTT", length = 5)
	private String LCTT;
	@Column(name = "ThueSuat")
	private Double thueSuat;
	@Column(name = "KhongCoThue")
	private Boolean khongCoThue;
	@Column(name = "DoanhSo")
	private Double doanhSo;
	@Column(name = "YeuToQuanLyID", length = 50)
	private String yeuToQuanLyID;
	@Column(name = "ButToanThueGTGT")
	private Boolean butToanThueGTGT;
	@Column(name = "ButToanThueNK")
	private Boolean butToanThueNK;
	@Column(name = "ThueSuatNK")
	private Double thueSuatNK;
	@Column(name = "TienThueNK")
	private Double tienThueNK;
	@Column(name = "TkThueNK", length = 20)
	private String tkThueNK;
	@Column(name = "TienThueNKNT")
	private Double tienThueNKNT;
	@Column(name = "ChietKhau")
	private Double chietKhau;
	@Column(name = "HoaHong")
	private Double hoaHong;
	@Column(name = "PhongBanID", length = 20)
	private String phongBanID;
	@Column(name = "MaThongKeID", length = 20)
	private String maThongKeID;
	@Column(name = "KhoanMucChiPhi", length = 20)
	private String khoanMucChiPhi;
	@Column(name = "DonGiaChuaCK")
	private Double donGiaChuaCK;
	@Column(name = "DonGiaChuaCKNT")
	private Double donGiaChuaCKNT;
	@Column(name = "ThanhPhamID", length = 20)
	private String thanhPhamID;
	@Column(name = "KhoChuyenDen", length = 50)
	private String KhoChuyenDen;
	@Column(name = "ChuyenKhoNoiBo")
	private Boolean chuyenKhoNoiBo;
	@Column(name = "DoiTuongCongNoID_ChiTiet", length = 50)
	private String DoiTuongCongNoID_ChiTiet;
	@Column(name = "LoaiTien_ChiTiet", length = 20)
	private String LoaiTien_ChiTiet;
	@Column(name = "TyGia_ChiTiet")
	private Double tyGia_ChiTiet;
	@Column(name = "SoLuong2")
	private Double SoLuong2;
	@Column(name = "MoTaMathang", length = 100)
	private String moTaMathang;
	@Column(name = "TonKhoHientai")
	private Double tonKhoHientai;
	private Double GiaVon;
	@Column(name = "CongDoanID", length = 20)
	private String congDoanID;
	@Column(name = "ButToanChietKhau", length = 20)
	private Boolean ButToanChietKhau;
	@Column(name = "TKDoiUng", length = 20)
	private String tKDoiUng;
	
	@Column(name = "TenVatTu_ChiTiet", length = 200)
	private String tenVatTu_ChiTiet;
	
	@Column(name = "KheuocID", length = 20)
	private String KheuocID;
	@Column(name = "TienThue_VAT")
	private Integer tienThue_VAT;
	@Column(name = "TkNoID_VAT", length = 10)
	private String tkNoID_VAT;
	@Column(name = "TKCoID_VAT", length = 10)
	private String tKCoID_VAT;
	@Column(name = "ButToanThueGTGT_TuChiTiet")
	private Boolean ButToanThueGTGT_TuChiTiet;
	@Column(name = "KhongBangKe")
	private Boolean KhongBangKe;
	@Column(name = "LoHangID", length = 20)
	private String LoHangID;
	@Column(name = "STTLienKet")
	private Integer STTLienKet;
	@Column(name = "KhongLenBangKeThue")
	private Boolean KhongLenBangKeThue;
	@Column(name = "ChiThueNhapKhau")
	private Boolean chiThueNhapKhau;
	@Column(name = "TaiSanID", length = 20)
	private String taiSanID;
	@Column(name = "ChiPhiTraTruocID", length = 20)
	private String chiPhiTraTruocID;
	@Column(name = "VAT_Seri_ChiTiet", length = 20)
	private String vAT_Seri_ChiTiet;
	@Column(name = "VAT_So_ChiTiet", length = 20)
	private String vAT_So_ChiTiet;
	@Column(name = "VAT_Ngay_ChiTiet")
	private Date vAT_Ngay_ChiTiet;
	@Column(name = "TenDoiTuongCongNo_ChiTiet", length = 200)
	private String tenDoiTuongCongNo_ChiTiet;
	@Column(name = "DiaChi_ChiTiet", length = 200)
	private String diaChi_ChiTiet;
	@Column(name = "MaSoThue_ChiTiet", length = 50)
	private String maSoThue_ChiTiet;
	@Column(name = "DaTinhNguocDonGia")
	private Boolean daTinhNguocDonGia;
	@Column(name = "DaTinhNguocNgoaiTe")
	private Boolean daTinhNguocNgoaiTe;
	@Column(name = "ChiPhiKhongHopLe")
	private Boolean chiPhiKhongHopLe;
	@Column(name = "ChiPhiMuaHang")
	private Double chiPhiMuaHang;
	@Column(name = "ChiPhiMuaHangNT")
	private Double chiPhiMuaHangNT;
	@Column(name = "TKKhoNhapID", length = 20)
	private String tKKhoNhapID;
	@Column(name = "TienChietKhauTruocThue")
	private Double tienChietKhauTruocThue;
	@Column(name = "TienChietKhauTruocThueNT")
	private Double tienChietKhauTruocThueNT;
	@Column(name = "MucChietKhau")
	private Double mucChietKhau;
	@Column(name = "MucChietKhauNT")
	private Double mucChietKhauNT;
	@Column(name = "HanSuDung")
	private Date HanSuDung;
	@Column(name = "BarCode", length = 20)
	private String BarCode;
	@Column(name = "NoiBo")
	private Boolean NoiBo;
	@Column(name = "VatTuID_HD", length = 20)
	private String vatTuID_HD;
	@Column(name = "TenVatTu_HD", length = 255)
	private String tenVatTu_HD;
	@Column(name = "DVT_HD", length = 50)
	private String DVT_HD;
	@Column(name = "DonGia_HD")
	private Double donGia_HD;
	@Column(name = "SoLuong_HD")
	private Double SoLuong_HD;
	@Column(name = "PhatSinh_HD")
	private Double PhatSinh_HD;
	@Column(name = "BoID", length = 20)
	private String BoID;
	@Column(name = "TenBo_ChiTiet", length = 200)
	private String tenBo_ChiTiet;
	@Column(name = "SoLuongBo")
	private Integer SoLuongBo;
	@Column(name = "DienGiai_Eng", length = 250)
	private String DienGiai_Eng;
	@Column(name = "TyGiaNhoHon_Chitiet")
	private Boolean tyGiaNhoHon_Chitiet;
	@Column(name = "LoaiVatTuID_ChiTiet", length = 20)
	private String LoaiVatTuID_ChiTiet;
	@Column(name = "TienThue_VATNT")
	private Double tienThue_VATNT;
	@Column(name = "KhongTuDongTinhPhatSinhTuSoLuongDonGia")
	private Boolean KhongTuDongTinhPhatSinhTuSoLuongDonGia;
	@Column(name = "TenVatTu_ChiTiet_HoaDon", length = 200)
	private String tenVatTu_ChiTiet_HoaDon;
	@Column(name = "ChoPhepXuatQuaLuongTon")
	private Boolean choPhepXuatQuaLuongTon;
	@Column(name = "TKCongno_CanTru", length = 20)
	private String tKCongno_CanTru;
	@Column(name = "DoiTuongCongNoID_ChiTiet_CanTru", length = 20)
	private String DoiTuongCongNoID_ChiTiet_CanTru;
	@Column(name = "CanTruCongNo")
	private Boolean canTruCongNo;
	@Column(name = "QuyCach", length = 50)
	private String quyCach;
	@Column(name = "NhanHieu", length = 50)
	private String nhanHieu;
	@Column(name = "TonKhoToiThieu_ChiTiet")
	private Double tonKhoToiThieu_ChiTiet;
	@Column(name = "TonKhoToiDa_ChiTiet")
	private Double tonKhoToiDa_ChiTiet;
	@Column(name = "DoanhSoTheoCapID", length = 20)
	private String doanhSoTheoCapID;
	@Column(name = "SuaTienThue_ChiTiet")
	private Boolean SuaTienThue_ChiTiet;
	@Column(name = "ChinhSuaMaVatTuHangLoatBangCauLenh")
	private Boolean chinhSuaMaVatTuHangLoatBangCauLenh;
	@Column(name = "VatTuID_ChinhSua", length = 20)
	private String vatTuID_ChinhSua;
	@Column(name = "SuaTienThueNhapKhauBangTay")
	private Boolean suaTienThueNhapKhauBangTay;
	@Column(name = "NgayXuatKho")
	private Date ngayXuatKho;
	@Column(name = "SuaGiaVonBangTay")
	private Boolean suaGiaVonBangTay;
	@Column(name = "DalapBaocao")
	private Boolean dalapBaocao;
	@Column(name = "GiaVonChuan")
	private Double giaVonChuan;
	public Integer getSTT() {
		return STT;
	}
	public void setSTT(Integer sTT) {
		STT = sTT;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public String getSoPhieu() {
		return soPhieu;
	}
	public void setSoPhieu(String soPhieu) {
		this.soPhieu = soPhieu;
	}
	public String gettKNoID() {
		return tKNoID;
	}
	public void settKNoID(String tKNoID) {
		this.tKNoID = tKNoID;
	}
	public String gettKCoID() {
		return tKCoID;
	}
	public void settKCoID(String tKCoID) {
		this.tKCoID = tKCoID;
	}
	public String getVatTuID() {
		return vatTuID;
	}
	public void setVatTuID(String vatTuID) {
		this.vatTuID = vatTuID;
	}
	public String getDVT() {
		return DVT;
	}
	public void setDVT(String dVT) {
		DVT = dVT;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Double getPhatSinh() {
		return phatSinh;
	}
	public void setPhatSinh(Double phatSinh) {
		this.phatSinh = phatSinh;
	}
	public Boolean getGianTiep() {
		return gianTiep;
	}
	public void setGianTiep(Boolean gianTiep) {
		this.gianTiep = gianTiep;
	}
	public String getDienGiai() {
		return dienGiai;
	}
	public void setDienGiai(String dienGiai) {
		this.dienGiai = dienGiai;
	}
	public Double getDonGiaNT() {
		return donGiaNT;
	}
	public void setDonGiaNT(Double donGiaNT) {
		this.donGiaNT = donGiaNT;
	}
	public Double getPhatSinhNT() {
		return phatSinhNT;
	}
	public void setPhatSinhNT(Double phatSinhNT) {
		this.phatSinhNT = phatSinhNT;
	}
	public String getKhoHangID() {
		return khoHangID;
	}
	public void setKhoHangID(String khoHangID) {
		this.khoHangID = khoHangID;
	}
	public String getLCTT() {
		return LCTT;
	}
	public void setLCTT(String lCTT) {
		LCTT = lCTT;
	}
	public Double getThueSuat() {
		return thueSuat;
	}
	public void setThueSuat(Double thueSuat) {
		this.thueSuat = thueSuat;
	}
	public Boolean getKhongCoThue() {
		return khongCoThue;
	}
	public void setKhongCoThue(Boolean khongCoThue) {
		this.khongCoThue = khongCoThue;
	}
	public Double getDoanhSo() {
		return doanhSo;
	}
	public void setDoanhSo(Double doanhSo) {
		this.doanhSo = doanhSo;
	}
	public String getYeuToQuanLyID() {
		return yeuToQuanLyID;
	}
	public void setYeuToQuanLyID(String yeuToQuanLyID) {
		this.yeuToQuanLyID = yeuToQuanLyID;
	}
	public Boolean getButToanThueGTGT() {
		return butToanThueGTGT;
	}
	public void setButToanThueGTGT(Boolean butToanThueGTGT) {
		this.butToanThueGTGT = butToanThueGTGT;
	}
	public Boolean getButToanThueNK() {
		return butToanThueNK;
	}
	public void setButToanThueNK(Boolean butToanThueNK) {
		this.butToanThueNK = butToanThueNK;
	}
	public Double getThueSuatNK() {
		return thueSuatNK;
	}
	public void setThueSuatNK(Double thueSuatNK) {
		this.thueSuatNK = thueSuatNK;
	}
	public Double getTienThueNK() {
		return tienThueNK;
	}
	public void setTienThueNK(Double tienThueNK) {
		this.tienThueNK = tienThueNK;
	}
	public String getTkThueNK() {
		return tkThueNK;
	}
	public void setTkThueNK(String tkThueNK) {
		this.tkThueNK = tkThueNK;
	}
	public Double getTienThueNKNT() {
		return tienThueNKNT;
	}
	public void setTienThueNKNT(Double tienThueNKNT) {
		this.tienThueNKNT = tienThueNKNT;
	}
	public Double getChietKhau() {
		return chietKhau;
	}
	public void setChietKhau(Double chietKhau) {
		this.chietKhau = chietKhau;
	}
	public Double getHoaHong() {
		return hoaHong;
	}
	public void setHoaHong(Double hoaHong) {
		this.hoaHong = hoaHong;
	}
	public String getPhongBanID() {
		return phongBanID;
	}
	public void setPhongBanID(String phongBanID) {
		this.phongBanID = phongBanID;
	}
	public String getMaThongKeID() {
		return maThongKeID;
	}
	public void setMaThongKeID(String maThongKeID) {
		this.maThongKeID = maThongKeID;
	}
	public String getKhoanMucChiPhi() {
		return khoanMucChiPhi;
	}
	public void setKhoanMucChiPhi(String khoanMucChiPhi) {
		this.khoanMucChiPhi = khoanMucChiPhi;
	}
	public Double getDonGiaChuaCK() {
		return donGiaChuaCK;
	}
	public void setDonGiaChuaCK(Double donGiaChuaCK) {
		this.donGiaChuaCK = donGiaChuaCK;
	}
	public Double getDonGiaChuaCKNT() {
		return donGiaChuaCKNT;
	}
	public void setDonGiaChuaCKNT(Double donGiaChuaCKNT) {
		this.donGiaChuaCKNT = donGiaChuaCKNT;
	}
	public String getThanhPhamID() {
		return thanhPhamID;
	}
	public void setThanhPhamID(String thanhPhamID) {
		this.thanhPhamID = thanhPhamID;
	}
	public String getKhoChuyenDen() {
		return KhoChuyenDen;
	}
	public void setKhoChuyenDen(String khoChuyenDen) {
		KhoChuyenDen = khoChuyenDen;
	}
	public Boolean getChuyenKhoNoiBo() {
		return chuyenKhoNoiBo;
	}
	public void setChuyenKhoNoiBo(Boolean chuyenKhoNoiBo) {
		this.chuyenKhoNoiBo = chuyenKhoNoiBo;
	}
	public String getDoiTuongCongNoID_ChiTiet() {
		return DoiTuongCongNoID_ChiTiet;
	}
	public void setDoiTuongCongNoID_ChiTiet(String doiTuongCongNoIDChiTiet) {
		DoiTuongCongNoID_ChiTiet = doiTuongCongNoIDChiTiet;
	}
	public String getLoaiTien_ChiTiet() {
		return LoaiTien_ChiTiet;
	}
	public void setLoaiTien_ChiTiet(String loaiTienChiTiet) {
		LoaiTien_ChiTiet = loaiTienChiTiet;
	}
	public Double getTyGia_ChiTiet() {
		return tyGia_ChiTiet;
	}
	public void setTyGia_ChiTiet(Double tyGiaChiTiet) {
		tyGia_ChiTiet = tyGiaChiTiet;
	}
	public Double getSoLuong2() {
		return SoLuong2;
	}
	public void setSoLuong2(Double soLuong2) {
		SoLuong2 = soLuong2;
	}
	public String getMoTaMathang() {
		return moTaMathang;
	}
	public void setMoTaMathang(String moTaMathang) {
		this.moTaMathang = moTaMathang;
	}
	public Double getTonKhoHientai() {
		return tonKhoHientai;
	}
	public void setTonKhoHientai(Double tonKhoHientai) {
		this.tonKhoHientai = tonKhoHientai;
	}
	public Double getGiaVon() {
		return GiaVon;
	}
	public void setGiaVon(Double giaVon) {
		GiaVon = giaVon;
	}
	public String getCongDoanID() {
		return congDoanID;
	}
	public void setCongDoanID(String congDoanID) {
		this.congDoanID = congDoanID;
	}
	public Boolean getButToanChietKhau() {
		return ButToanChietKhau;
	}
	public void setButToanChietKhau(Boolean butToanChietKhau) {
		ButToanChietKhau = butToanChietKhau;
	}
	public String gettKDoiUng() {
		return tKDoiUng;
	}
	public void settKDoiUng(String tKDoiUng) {
		this.tKDoiUng = tKDoiUng;
	}
	public String getTenVatTu_ChiTiet() {
		return tenVatTu_ChiTiet;
	}
	public void setTenVatTu_ChiTiet(String tenVatTuChiTiet) {
		tenVatTu_ChiTiet = tenVatTuChiTiet;
	}
	public String getKheuocID() {
		return KheuocID;
	}
	public void setKheuocID(String kheuocID) {
		KheuocID = kheuocID;
	}
	public Integer getTienThue_VAT() {
		return tienThue_VAT;
	}
	public void setTienThue_VAT(Integer tienThueVAT) {
		tienThue_VAT = tienThueVAT;
	}
	public String getTkNoID_VAT() {
		return tkNoID_VAT;
	}
	public void setTkNoID_VAT(String tkNoIDVAT) {
		tkNoID_VAT = tkNoIDVAT;
	}
	public String gettKCoID_VAT() {
		return tKCoID_VAT;
	}
	public void settKCoID_VAT(String tKCoIDVAT) {
		tKCoID_VAT = tKCoIDVAT;
	}
	public Boolean getButToanThueGTGT_TuChiTiet() {
		return ButToanThueGTGT_TuChiTiet;
	}
	public void setButToanThueGTGT_TuChiTiet(Boolean butToanThueGTGTTuChiTiet) {
		ButToanThueGTGT_TuChiTiet = butToanThueGTGTTuChiTiet;
	}
	public Boolean getKhongBangKe() {
		return KhongBangKe;
	}
	public void setKhongBangKe(Boolean khongBangKe) {
		KhongBangKe = khongBangKe;
	}
	public String getLoHangID() {
		return LoHangID;
	}
	public void setLoHangID(String loHangID) {
		LoHangID = loHangID;
	}
	public Integer getSTTLienKet() {
		return STTLienKet;
	}
	public void setSTTLienKet(Integer sTTLienKet) {
		STTLienKet = sTTLienKet;
	}
	public Boolean getKhongLenBangKeThue() {
		return KhongLenBangKeThue;
	}
	public void setKhongLenBangKeThue(Boolean khongLenBangKeThue) {
		KhongLenBangKeThue = khongLenBangKeThue;
	}
	public Boolean getChiThueNhapKhau() {
		return chiThueNhapKhau;
	}
	public void setChiThueNhapKhau(Boolean chiThueNhapKhau) {
		this.chiThueNhapKhau = chiThueNhapKhau;
	}
	public String getTaiSanID() {
		return taiSanID;
	}
	public void setTaiSanID(String taiSanID) {
		this.taiSanID = taiSanID;
	}
	public String getChiPhiTraTruocID() {
		return chiPhiTraTruocID;
	}
	public void setChiPhiTraTruocID(String chiPhiTraTruocID) {
		this.chiPhiTraTruocID = chiPhiTraTruocID;
	}
	public String getvAT_Seri_ChiTiet() {
		return vAT_Seri_ChiTiet;
	}
	public void setvAT_Seri_ChiTiet(String vATSeriChiTiet) {
		vAT_Seri_ChiTiet = vATSeriChiTiet;
	}
	public String getvAT_So_ChiTiet() {
		return vAT_So_ChiTiet;
	}
	public void setvAT_So_ChiTiet(String vATSoChiTiet) {
		vAT_So_ChiTiet = vATSoChiTiet;
	}
	public Date getvAT_Ngay_ChiTiet() {
		return vAT_Ngay_ChiTiet;
	}
	public void setvAT_Ngay_ChiTiet(Date vATNgayChiTiet) {
		vAT_Ngay_ChiTiet = vATNgayChiTiet;
	}
	public String getTenDoiTuongCongNo_ChiTiet() {
		return tenDoiTuongCongNo_ChiTiet;
	}
	public void setTenDoiTuongCongNo_ChiTiet(String tenDoiTuongCongNoChiTiet) {
		tenDoiTuongCongNo_ChiTiet = tenDoiTuongCongNoChiTiet;
	}
	public String getDiaChi_ChiTiet() {
		return diaChi_ChiTiet;
	}
	public void setDiaChi_ChiTiet(String diaChiChiTiet) {
		diaChi_ChiTiet = diaChiChiTiet;
	}
	public String getMaSoThue_ChiTiet() {
		return maSoThue_ChiTiet;
	}
	public void setMaSoThue_ChiTiet(String maSoThueChiTiet) {
		maSoThue_ChiTiet = maSoThueChiTiet;
	}
	public Boolean getDaTinhNguocDonGia() {
		return daTinhNguocDonGia;
	}
	public void setDaTinhNguocDonGia(Boolean daTinhNguocDonGia) {
		this.daTinhNguocDonGia = daTinhNguocDonGia;
	}
	public Boolean getDaTinhNguocNgoaiTe() {
		return daTinhNguocNgoaiTe;
	}
	public void setDaTinhNguocNgoaiTe(Boolean daTinhNguocNgoaiTe) {
		this.daTinhNguocNgoaiTe = daTinhNguocNgoaiTe;
	}
	public Boolean getChiPhiKhongHopLe() {
		return chiPhiKhongHopLe;
	}
	public void setChiPhiKhongHopLe(Boolean chiPhiKhongHopLe) {
		this.chiPhiKhongHopLe = chiPhiKhongHopLe;
	}
	public Double getChiPhiMuaHang() {
		return chiPhiMuaHang;
	}
	public void setChiPhiMuaHang(Double chiPhiMuaHang) {
		this.chiPhiMuaHang = chiPhiMuaHang;
	}
	public Double getChiPhiMuaHangNT() {
		return chiPhiMuaHangNT;
	}
	public void setChiPhiMuaHangNT(Double chiPhiMuaHangNT) {
		this.chiPhiMuaHangNT = chiPhiMuaHangNT;
	}
	public String gettKKhoNhapID() {
		return tKKhoNhapID;
	}
	public void settKKhoNhapID(String tKKhoNhapID) {
		this.tKKhoNhapID = tKKhoNhapID;
	}
	public Double getTienChietKhauTruocThue() {
		return tienChietKhauTruocThue;
	}
	public void setTienChietKhauTruocThue(Double tienChietKhauTruocThue) {
		this.tienChietKhauTruocThue = tienChietKhauTruocThue;
	}
	public Double getTienChietKhauTruocThueNT() {
		return tienChietKhauTruocThueNT;
	}
	public void setTienChietKhauTruocThueNT(Double tienChietKhauTruocThueNT) {
		this.tienChietKhauTruocThueNT = tienChietKhauTruocThueNT;
	}
	public Double getMucChietKhau() {
		return mucChietKhau;
	}
	public void setMucChietKhau(Double mucChietKhau) {
		this.mucChietKhau = mucChietKhau;
	}
	public Double getMucChietKhauNT() {
		return mucChietKhauNT;
	}
	public void setMucChietKhauNT(Double mucChietKhauNT) {
		this.mucChietKhauNT = mucChietKhauNT;
	}
	public Date getHanSuDung() {
		return HanSuDung;
	}
	public void setHanSuDung(Date hanSuDung) {
		HanSuDung = hanSuDung;
	}
	public String getBarCode() {
		return BarCode;
	}
	public void setBarCode(String barCode) {
		BarCode = barCode;
	}
	public Boolean getNoiBo() {
		return NoiBo;
	}
	public void setNoiBo(Boolean noiBo) {
		NoiBo = noiBo;
	}
	public String getVatTuID_HD() {
		return vatTuID_HD;
	}
	public void setVatTuID_HD(String vatTuIDHD) {
		vatTuID_HD = vatTuIDHD;
	}
	public String getTenVatTu_HD() {
		return tenVatTu_HD;
	}
	public void setTenVatTu_HD(String tenVatTuHD) {
		tenVatTu_HD = tenVatTuHD;
	}
	public String getDVT_HD() {
		return DVT_HD;
	}
	public void setDVT_HD(String dVTHD) {
		DVT_HD = dVTHD;
	}
	public Double getDonGia_HD() {
		return donGia_HD;
	}
	public void setDonGia_HD(Double donGiaHD) {
		donGia_HD = donGiaHD;
	}
	public Double getSoLuong_HD() {
		return SoLuong_HD;
	}
	public void setSoLuong_HD(Double soLuongHD) {
		SoLuong_HD = soLuongHD;
	}
	public Double getPhatSinh_HD() {
		return PhatSinh_HD;
	}
	public void setPhatSinh_HD(Double phatSinhHD) {
		PhatSinh_HD = phatSinhHD;
	}
	public String getBoID() {
		return BoID;
	}
	public void setBoID(String boID) {
		BoID = boID;
	}
	public String getTenBo_ChiTiet() {
		return tenBo_ChiTiet;
	}
	public void setTenBo_ChiTiet(String tenBoChiTiet) {
		tenBo_ChiTiet = tenBoChiTiet;
	}
	public Integer getSoLuongBo() {
		return SoLuongBo;
	}
	public void setSoLuongBo(Integer soLuongBo) {
		SoLuongBo = soLuongBo;
	}
	public String getDienGiai_Eng() {
		return DienGiai_Eng;
	}
	public void setDienGiai_Eng(String dienGiaiEng) {
		DienGiai_Eng = dienGiaiEng;
	}
	public Boolean getTyGiaNhoHon_Chitiet() {
		return tyGiaNhoHon_Chitiet;
	}
	public void setTyGiaNhoHon_Chitiet(Boolean tyGiaNhoHonChitiet) {
		tyGiaNhoHon_Chitiet = tyGiaNhoHonChitiet;
	}
	public String getLoaiVatTuID_ChiTiet() {
		return LoaiVatTuID_ChiTiet;
	}
	public void setLoaiVatTuID_ChiTiet(String loaiVatTuIDChiTiet) {
		LoaiVatTuID_ChiTiet = loaiVatTuIDChiTiet;
	}
	public Double getTienThue_VATNT() {
		return tienThue_VATNT;
	}
	public void setTienThue_VATNT(Double tienThueVATNT) {
		tienThue_VATNT = tienThueVATNT;
	}
	public Boolean getKhongTuDongTinhPhatSinhTuSoLuongDonGia() {
		return KhongTuDongTinhPhatSinhTuSoLuongDonGia;
	}
	public void setKhongTuDongTinhPhatSinhTuSoLuongDonGia(
			Boolean khongTuDongTinhPhatSinhTuSoLuongDonGia) {
		KhongTuDongTinhPhatSinhTuSoLuongDonGia = khongTuDongTinhPhatSinhTuSoLuongDonGia;
	}
	public String getTenVatTu_ChiTiet_HoaDon() {
		return tenVatTu_ChiTiet_HoaDon;
	}
	public void setTenVatTu_ChiTiet_HoaDon(String tenVatTuChiTietHoaDon) {
		tenVatTu_ChiTiet_HoaDon = tenVatTuChiTietHoaDon;
	}
	public Boolean getChoPhepXuatQuaLuongTon() {
		return choPhepXuatQuaLuongTon;
	}
	public void setChoPhepXuatQuaLuongTon(Boolean choPhepXuatQuaLuongTon) {
		this.choPhepXuatQuaLuongTon = choPhepXuatQuaLuongTon;
	}
	public String gettKCongno_CanTru() {
		return tKCongno_CanTru;
	}
	public void settKCongno_CanTru(String tKCongnoCanTru) {
		tKCongno_CanTru = tKCongnoCanTru;
	}
	public String getDoiTuongCongNoID_ChiTiet_CanTru() {
		return DoiTuongCongNoID_ChiTiet_CanTru;
	}
	public void setDoiTuongCongNoID_ChiTiet_CanTru(
			String doiTuongCongNoIDChiTietCanTru) {
		DoiTuongCongNoID_ChiTiet_CanTru = doiTuongCongNoIDChiTietCanTru;
	}
	public Boolean getCanTruCongNo() {
		return canTruCongNo;
	}
	public void setCanTruCongNo(Boolean canTruCongNo) {
		this.canTruCongNo = canTruCongNo;
	}
	public String getQuyCach() {
		return quyCach;
	}
	public void setQuyCach(String quyCach) {
		this.quyCach = quyCach;
	}
	public String getNhanHieu() {
		return nhanHieu;
	}
	public void setNhanHieu(String nhanHieu) {
		this.nhanHieu = nhanHieu;
	}
	public Double getTonKhoToiThieu_ChiTiet() {
		return tonKhoToiThieu_ChiTiet;
	}
	public void setTonKhoToiThieu_ChiTiet(Double tonKhoToiThieuChiTiet) {
		tonKhoToiThieu_ChiTiet = tonKhoToiThieuChiTiet;
	}
	public Double getTonKhoToiDa_ChiTiet() {
		return tonKhoToiDa_ChiTiet;
	}
	public void setTonKhoToiDa_ChiTiet(Double tonKhoToiDaChiTiet) {
		tonKhoToiDa_ChiTiet = tonKhoToiDaChiTiet;
	}
	public String getDoanhSoTheoCapID() {
		return doanhSoTheoCapID;
	}
	public void setDoanhSoTheoCapID(String doanhSoTheoCapID) {
		this.doanhSoTheoCapID = doanhSoTheoCapID;
	}
	public Boolean getSuaTienThue_ChiTiet() {
		return SuaTienThue_ChiTiet;
	}
	public void setSuaTienThue_ChiTiet(Boolean suaTienThueChiTiet) {
		SuaTienThue_ChiTiet = suaTienThueChiTiet;
	}
	public Boolean getChinhSuaMaVatTuHangLoatBangCauLenh() {
		return chinhSuaMaVatTuHangLoatBangCauLenh;
	}
	public void setChinhSuaMaVatTuHangLoatBangCauLenh(
			Boolean chinhSuaMaVatTuHangLoatBangCauLenh) {
		this.chinhSuaMaVatTuHangLoatBangCauLenh = chinhSuaMaVatTuHangLoatBangCauLenh;
	}
	public String getVatTuID_ChinhSua() {
		return vatTuID_ChinhSua;
	}
	public void setVatTuID_ChinhSua(String vatTuIDChinhSua) {
		vatTuID_ChinhSua = vatTuIDChinhSua;
	}
	public Boolean getSuaTienThueNhapKhauBangTay() {
		return suaTienThueNhapKhauBangTay;
	}
	public void setSuaTienThueNhapKhauBangTay(Boolean suaTienThueNhapKhauBangTay) {
		this.suaTienThueNhapKhauBangTay = suaTienThueNhapKhauBangTay;
	}
	public Date getNgayXuatKho() {
		return ngayXuatKho;
	}
	public void setNgayXuatKho(Date ngayXuatKho) {
		this.ngayXuatKho = ngayXuatKho;
	}
	public Boolean getSuaGiaVonBangTay() {
		return suaGiaVonBangTay;
	}
	public void setSuaGiaVonBangTay(Boolean suaGiaVonBangTay) {
		this.suaGiaVonBangTay = suaGiaVonBangTay;
	}
	public Boolean getDalapBaocao() {
		return dalapBaocao;
	}
	public void setDalapBaocao(Boolean dalapBaocao) {
		this.dalapBaocao = dalapBaocao;
	}
	public Double getGiaVonChuan() {
		return giaVonChuan;
	}
	public void setGiaVonChuan(Double giaVonChuan) {
		this.giaVonChuan = giaVonChuan;
	}
	
}
