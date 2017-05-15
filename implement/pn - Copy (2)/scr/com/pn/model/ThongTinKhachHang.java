package com.pn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Sys_ThongTinKhachhang")
public class ThongTinKhachHang {
	
	@Column(name = "TenCty", length = 200, nullable = false)
	private String tenCty;
	@Column(name = "DiaChi", length = 200)
	private String diaChi;
	@Column(name = "MasoThue", length = 50)
	private String masoThue;
	@Column(name = "DienThoai", length = 50)
	private String dienThoai;
	@Column(name = "Fax", length = 20)
	private String fax;
	@Column(name = "KiemTraTonKho")
	private Boolean kiemTraTonKho;
	@Column(name = "KiemTraCongNo")
	private Boolean kiemTraCongNo;
	@Column(name = "NamlamViec")
	private Integer NamlamViec;
	@Column(name = "TenCtyEng", length = 200)
	private String tenCtyEng;
	@Column(name = "Bo", length = 200)
	private String bo;
	@Column(name = "TongCty", length = 200)
	private String tongCty;
	@Column(name = "Nganhang", length = 200)
	private String nganhang;
	@Column(name = "TaiKhoan", length = 50)
	private String taiKhoan;
	@Column(name = "NguyenTe", length = 50)
	private String nguyenTe;
	@Column(name = "TinhGiaVon")
	private Integer tinhGiaVon;
	@Column(name = "PhanBoChiPhi")
	private Integer phanBoChiPhi;
	@Column(name = "KhuTrung", length = 50)
	private String KhuTrung;
	@Column(name = "NguoiDaiDien", length = 50)
	private String nguoiDaiDien;
	@Column(name = "ChucVu", length = 50)
	private String ChucVu;
	@Column(name = "NgoaiTe", length = 50)
	private String ngoaiTe;
	@Column(name = "VAT")
	private Double vAT;
	@Column(name = "DinhDangNguyenTe", length = 50)
	private String dinhDangNguyenTe;
	@Column(name = "DinhDangNgoaiTe", length = 50)
	private String dinhDangNgoaiTe;
	@Column(name = "DinhDangSoLuong", length = 50)
	private String dinhDangSoLuong;
	@Column(name = "TenMaySuDung", length = 254)
	private String tenMaySuDung;
	@Column(name = "UnLockKey", length = 50)
	private String unLockKey;
	@Column(name = "NguoiXacNhan", length = 50)
	private String nguoiXacNhan;
	@Column(name = "DuocThayDoiMaTaiKhoan", nullable = false)
	private Boolean duocThayDoiMaTaiKhoan;
	@Column(name = "DuocThayDoiMaVatTu", nullable = false)
	private Boolean duocThayDoiMaVatTu;
	@Column(name = "DuocThayDoiMaDoiTuongCongNo", nullable = false)
	private Boolean duocThayDoiMaDoiTuongCongNo;
	@Column(name = "DuocThayDoiMaKhohang", nullable = false)
	private Boolean duocThayDoiMaKhohang;
	@Column(name = "DauCachHangNghin", length = 1, nullable = false)
	private String dauCachHangNghin;
	@Column(name = "DauCachThapPhan", length = 1, nullable = false)
	private String dauCachThapPhan;
	@Column(name = "NguoiKy", length = 50, nullable = false)
	private String nguoiKy;
	@Column(name = "QuyetDinh", length = 4, nullable = false)
	private String quyetDinh;
	@Column(name = "DinhDangDonGia", length = 20, nullable = false)
	private String dinhDangDonGia;
	@Id
	@Column(name = "MaCty", length = 10)
	private String maCty;
	
	@Column(name = "NhacNho")
	private Boolean nhacNho;
	@Column(name = "QuyDinhLapPhieu", nullable = false)
	private Integer quyDinhLapPhieu;
	@Column(name = "TuDongThemMoi")
	private Boolean tuDongThemMoi;
	@Column(name = "MuaHang", nullable = false)
	private Boolean muaHang;
	@Column(name = "BanHang", nullable = false)
	private Boolean banHang;
	@Column(name = "TonKho", nullable = false)
	private Boolean tonKho;
	@Column(name = "ThuChi", nullable = false)
	private Boolean thuChi;
	@Column(name = "TaiSan", nullable = false)
	private Boolean taiSan;
	@Column(name = "NhanSu", nullable = false)
	private Boolean nhanSu;
	@Column(name = "TongHop", nullable = false)
	private Boolean tongHop;
	@Column(name = "GiaThanhSanXuat", nullable = false)
	private Boolean giaThanhSanXuat;
	@Column(name = "GiaThanhCongTrinh", nullable = false)
	private Boolean giaThanhCongTrinh;
	@Column(name = "DauCachHangNghin_BaoCao", length = 1, nullable = false)
	private String dauCachHangNghin_BaoCao;
	@Column(name = "DauCachThapPhan_BaoCao", length = 1, nullable = false)
	private String dauCachThapPhan_BaoCao;
	@Column(name = "PPTTGia")
	private Integer pPTTGia;
	@Column(name = "ChiXuatHangTonKho")
	private Boolean chiXuatHangTonKho;
	@Column(name = "LapDuLieuBaoCaoNgayKhiLuu")
	private Boolean lapDuLieuBaoCaoNgayKhiLuu;
	@Column(name = "ChiInDuLieuThue")
	private Boolean chiInDuLieuThue;
	@Column(name = "KhongTuDongLapPhieuXuatkhoKhiBanHang")
	private Boolean khongTuDongLapPhieuXuatkhoKhiBanHang;
	@Column(name = "KhongTuDongLapPhieuNhapKhoKhiNhanHangTraVe")
	private Boolean khongTuDongLapPhieuNhapKhoKhiNhanHangTraVe;
	@Column(name = "PhuongPhapLapMaChungTu", nullable = false)
	private Integer phuongPhapLapMaChungTu;
	@Column(name = "KiemTraSoDuTaiKhoan")
	private Boolean kiemTraSoDuTaiKhoan;
	@Column(name = "GD_XemHinhCay")
	private Boolean gD_XemHinhCay;
	@Column(name = "ThongBaoTonKhoTaiThoiDiemPhatSinh")
	private Boolean thongBaoTonKhoTaiThoiDiemPhatSinh;
	@Column(name = "ThongBaoCongNoTaiThoiDiemPhatSinh")
	private Boolean thongBaoCongNoTaiThoiDiemPhatSinh;
	@Column(name = "KiemTraChungTuTrung")
	private Boolean kiemTraChungTuTrung;
	public String getTenCty() {
		return tenCty;
	}
	public void setTenCty(String tenCty) {
		this.tenCty = tenCty;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMasoThue() {
		return masoThue;
	}
	public void setMasoThue(String masoThue) {
		this.masoThue = masoThue;
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
	public Boolean getKiemTraTonKho() {
		return kiemTraTonKho;
	}
	public void setKiemTraTonKho(Boolean kiemTraTonKho) {
		this.kiemTraTonKho = kiemTraTonKho;
	}
	public Boolean getKiemTraCongNo() {
		return kiemTraCongNo;
	}
	public void setKiemTraCongNo(Boolean kiemTraCongNo) {
		this.kiemTraCongNo = kiemTraCongNo;
	}
	public Integer getNamlamViec() {
		return NamlamViec;
	}
	public void setNamlamViec(Integer namlamViec) {
		NamlamViec = namlamViec;
	}
	public String getTenCtyEng() {
		return tenCtyEng;
	}
	public void setTenCtyEng(String tenCtyEng) {
		this.tenCtyEng = tenCtyEng;
	}
	public String getBo() {
		return bo;
	}
	public void setBo(String bo) {
		this.bo = bo;
	}
	public String getTongCty() {
		return tongCty;
	}
	public void setTongCty(String tongCty) {
		this.tongCty = tongCty;
	}
	public String getNganhang() {
		return nganhang;
	}
	public void setNganhang(String nganhang) {
		this.nganhang = nganhang;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getNguyenTe() {
		return nguyenTe;
	}
	public void setNguyenTe(String nguyenTe) {
		this.nguyenTe = nguyenTe;
	}
	public Integer getTinhGiaVon() {
		return tinhGiaVon;
	}
	public void setTinhGiaVon(Integer tinhGiaVon) {
		this.tinhGiaVon = tinhGiaVon;
	}
	public Integer getPhanBoChiPhi() {
		return phanBoChiPhi;
	}
	public void setPhanBoChiPhi(Integer phanBoChiPhi) {
		this.phanBoChiPhi = phanBoChiPhi;
	}
	public String getKhuTrung() {
		return KhuTrung;
	}
	public void setKhuTrung(String khuTrung) {
		KhuTrung = khuTrung;
	}
	public String getNguoiDaiDien() {
		return nguoiDaiDien;
	}
	public void setNguoiDaiDien(String nguoiDaiDien) {
		this.nguoiDaiDien = nguoiDaiDien;
	}
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}
	public String getNgoaiTe() {
		return ngoaiTe;
	}
	public void setNgoaiTe(String ngoaiTe) {
		this.ngoaiTe = ngoaiTe;
	}
	public Double getvAT() {
		return vAT;
	}
	public void setvAT(Double vAT) {
		this.vAT = vAT;
	}
	public String getDinhDangNguyenTe() {
		return dinhDangNguyenTe;
	}
	public void setDinhDangNguyenTe(String dinhDangNguyenTe) {
		this.dinhDangNguyenTe = dinhDangNguyenTe;
	}
	public String getDinhDangNgoaiTe() {
		return dinhDangNgoaiTe;
	}
	public void setDinhDangNgoaiTe(String dinhDangNgoaiTe) {
		this.dinhDangNgoaiTe = dinhDangNgoaiTe;
	}
	public String getDinhDangSoLuong() {
		return dinhDangSoLuong;
	}
	public void setDinhDangSoLuong(String dinhDangSoLuong) {
		this.dinhDangSoLuong = dinhDangSoLuong;
	}
	public String getTenMaySuDung() {
		return tenMaySuDung;
	}
	public void setTenMaySuDung(String tenMaySuDung) {
		this.tenMaySuDung = tenMaySuDung;
	}
	public String getUnLockKey() {
		return unLockKey;
	}
	public void setUnLockKey(String unLockKey) {
		this.unLockKey = unLockKey;
	}
	public String getNguoiXacNhan() {
		return nguoiXacNhan;
	}
	public void setNguoiXacNhan(String nguoiXacNhan) {
		this.nguoiXacNhan = nguoiXacNhan;
	}
	public Boolean getDuocThayDoiMaTaiKhoan() {
		return duocThayDoiMaTaiKhoan;
	}
	public void setDuocThayDoiMaTaiKhoan(Boolean duocThayDoiMaTaiKhoan) {
		this.duocThayDoiMaTaiKhoan = duocThayDoiMaTaiKhoan;
	}
	public Boolean getDuocThayDoiMaVatTu() {
		return duocThayDoiMaVatTu;
	}
	public void setDuocThayDoiMaVatTu(Boolean duocThayDoiMaVatTu) {
		this.duocThayDoiMaVatTu = duocThayDoiMaVatTu;
	}
	public Boolean getDuocThayDoiMaDoiTuongCongNo() {
		return duocThayDoiMaDoiTuongCongNo;
	}
	public void setDuocThayDoiMaDoiTuongCongNo(Boolean duocThayDoiMaDoiTuongCongNo) {
		this.duocThayDoiMaDoiTuongCongNo = duocThayDoiMaDoiTuongCongNo;
	}
	public Boolean getDuocThayDoiMaKhohang() {
		return duocThayDoiMaKhohang;
	}
	public void setDuocThayDoiMaKhohang(Boolean duocThayDoiMaKhohang) {
		this.duocThayDoiMaKhohang = duocThayDoiMaKhohang;
	}
	public String getDauCachHangNghin() {
		return dauCachHangNghin;
	}
	public void setDauCachHangNghin(String dauCachHangNghin) {
		this.dauCachHangNghin = dauCachHangNghin;
	}
	public String getDauCachThapPhan() {
		return dauCachThapPhan;
	}
	public void setDauCachThapPhan(String dauCachThapPhan) {
		this.dauCachThapPhan = dauCachThapPhan;
	}
	public String getNguoiKy() {
		return nguoiKy;
	}
	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}
	public String getQuyetDinh() {
		return quyetDinh;
	}
	public void setQuyetDinh(String quyetDinh) {
		this.quyetDinh = quyetDinh;
	}
	public String getDinhDangDonGia() {
		return dinhDangDonGia;
	}
	public void setDinhDangDonGia(String dinhDangDonGia) {
		this.dinhDangDonGia = dinhDangDonGia;
	}
	public String getMaCty() {
		return maCty;
	}
	public void setMaCty(String maCty) {
		this.maCty = maCty;
	}
	public Boolean getNhacNho() {
		return nhacNho;
	}
	public void setNhacNho(Boolean nhacNho) {
		this.nhacNho = nhacNho;
	}
	public Integer getQuyDinhLapPhieu() {
		return quyDinhLapPhieu;
	}
	public void setQuyDinhLapPhieu(Integer quyDinhLapPhieu) {
		this.quyDinhLapPhieu = quyDinhLapPhieu;
	}
	public Boolean getTuDongThemMoi() {
		return tuDongThemMoi;
	}
	public void setTuDongThemMoi(Boolean tuDongThemMoi) {
		this.tuDongThemMoi = tuDongThemMoi;
	}
	public Boolean getMuaHang() {
		return this.muaHang;
	}
	public void setMuaHang(Boolean muaHang) {
		this.muaHang = muaHang;
	}
	public Boolean getBanHang() {
		return banHang;
	}
	public void setBanHang(Boolean banHang) {
		this.banHang = banHang;
	}
	public Boolean getTonKho() {
		return tonKho;
	}
	public void setTonKho(Boolean tonKho) {
		this.tonKho = tonKho;
	}
	public Boolean getThuChi() {
		return thuChi;
	}
	public void setThuChi(Boolean thuChi) {
		this.thuChi = thuChi;
	}
	public Boolean getTaiSan() {
		return taiSan;
	}
	public void setTaiSan(Boolean taiSan) {
		this.taiSan = taiSan;
	}
	public Boolean getNhanSu() {
		return nhanSu;
	}
	public void setNhanSu(Boolean nhanSu) {
		this.nhanSu = nhanSu;
	}
	public Boolean getTongHop() {
		return tongHop;
	}
	public void setTongHop(Boolean tongHop) {
		this.tongHop = tongHop;
	}
	public Boolean getGiaThanhSanXuat() {
		return giaThanhSanXuat;
	}
	public void setGiaThanhSanXuat(Boolean giaThanhSanXuat) {
		this.giaThanhSanXuat = giaThanhSanXuat;
	}
	public Boolean getGiaThanhCongTrinh() {
		return giaThanhCongTrinh;
	}
	public void setGiaThanhCongTrinh(Boolean giaThanhCongTrinh) {
		this.giaThanhCongTrinh = giaThanhCongTrinh;
	}
	public String getDauCachHangNghin_BaoCao() {
		return dauCachHangNghin_BaoCao;
	}
	public void setDauCachHangNghin_BaoCao(String dauCachHangNghinBaoCao) {
		this.dauCachHangNghin_BaoCao = dauCachHangNghinBaoCao;
	}
	public String getDauCachThapPhan_BaoCao() {
		return dauCachThapPhan_BaoCao;
	}
	public void setDauCachThapPhan_BaoCao(String dauCachThapPhanBaoCao) {
		this.dauCachThapPhan_BaoCao = dauCachThapPhanBaoCao;
	}
	public Integer getpPTTGia() {
		return pPTTGia;
	}
	public void setpPTTGia(Integer pPTTGia) {
		this.pPTTGia = pPTTGia;
	}
	public Boolean getChiXuatHangTonKho() {
		return chiXuatHangTonKho;
	}
	public void setChiXuatHangTonKho(Boolean chiXuatHangTonKho) {
		this.chiXuatHangTonKho = chiXuatHangTonKho;
	}
	public Boolean getLapDuLieuBaoCaoNgayKhiLuu() {
		return lapDuLieuBaoCaoNgayKhiLuu;
	}
	public void setLapDuLieuBaoCaoNgayKhiLuu(Boolean lapDuLieuBaoCaoNgayKhiLuu) {
		this.lapDuLieuBaoCaoNgayKhiLuu = lapDuLieuBaoCaoNgayKhiLuu;
	}
	public Boolean getChiInDuLieuThue() {
		return chiInDuLieuThue;
	}
	public void setChiInDuLieuThue(Boolean chiInDuLieuThue) {
		this.chiInDuLieuThue = chiInDuLieuThue;
	}
	public Boolean getKhongTuDongLapPhieuXuatkhoKhiBanHang() {
		return khongTuDongLapPhieuXuatkhoKhiBanHang;
	}
	public void setKhongTuDongLapPhieuXuatkhoKhiBanHang(
			Boolean khongTuDongLapPhieuXuatkhoKhiBanHang) {
		this.khongTuDongLapPhieuXuatkhoKhiBanHang = khongTuDongLapPhieuXuatkhoKhiBanHang;
	}
	public Boolean getKhongTuDongLapPhieuNhapKhoKhiNhanHangTraVe() {
		return khongTuDongLapPhieuNhapKhoKhiNhanHangTraVe;
	}
	public void setKhongTuDongLapPhieuNhapKhoKhiNhanHangTraVe(
			Boolean khongTuDongLapPhieuNhapKhoKhiNhanHangTraVe) {
		this.khongTuDongLapPhieuNhapKhoKhiNhanHangTraVe = khongTuDongLapPhieuNhapKhoKhiNhanHangTraVe;
	}
	public Integer getPhuongPhapLapMaChungTu() {
		return phuongPhapLapMaChungTu;
	}
	public void setPhuongPhapLapMaChungTu(Integer phuongPhapLapMaChungTu) {
		this.phuongPhapLapMaChungTu = phuongPhapLapMaChungTu;
	}
	public Boolean getKiemTraSoDuTaiKhoan() {
		return kiemTraSoDuTaiKhoan;
	}
	public void setKiemTraSoDuTaiKhoan(Boolean kiemTraSoDuTaiKhoan) {
		this.kiemTraSoDuTaiKhoan = kiemTraSoDuTaiKhoan;
	}
	public Boolean getgD_XemHinhCay() {
		return gD_XemHinhCay;
	}
	public void setgD_XemHinhCay(Boolean gDXemHinhCay) {
		this.gD_XemHinhCay = gDXemHinhCay;
	}
	public Boolean getThongBaoTonKhoTaiThoiDiemPhatSinh() {
		return thongBaoTonKhoTaiThoiDiemPhatSinh;
	}
	public void setThongBaoTonKhoTaiThoiDiemPhatSinh(
			Boolean thongBaoTonKhoTaiThoiDiemPhatSinh) {
		this.thongBaoTonKhoTaiThoiDiemPhatSinh = thongBaoTonKhoTaiThoiDiemPhatSinh;
	}
	public Boolean getThongBaoCongNoTaiThoiDiemPhatSinh() {
		return thongBaoCongNoTaiThoiDiemPhatSinh;
	}
	public void setThongBaoCongNoTaiThoiDiemPhatSinh(
			Boolean thongBaoCongNoTaiThoiDiemPhatSinh) {
		this.thongBaoCongNoTaiThoiDiemPhatSinh = thongBaoCongNoTaiThoiDiemPhatSinh;
	}
	public Boolean getKiemTraChungTuTrung() {
		return kiemTraChungTuTrung;
	}
	public void setKiemTraChungTuTrung(Boolean kiemTraChungTuTrung) {
		this.kiemTraChungTuTrung = kiemTraChungTuTrung;
	}
//	@OneToMany(mappedBy="thongTinKhachHang", fetch=FetchType.LAZY)
//	private List<BCTongHop> bCTongHop;	
//	public void setbCTongHop(List<BCTongHop> bCTongHop) {
//		this.bCTongHop = bCTongHop;
//	}
//	public List<BCTongHop> getbCTongHop() {
//		return bCTongHop;
//	}
}
