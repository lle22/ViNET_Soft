package com.pn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="getCongNoTheoKhachHang",
			query="FROM BCTongHop bc "
        	+ " WHERE bc.noCo=1 AND bc.doiTuongCongNoID = :doiTuongCongNoID AND bc.ngayNhap >= :tuNgay " 
        	+ " AND bc.ngayNhap <= :denNgay AND bc.tKCoID like '51%'" 
        	+ " ORDER BY bc.ngayNhap, bc.soCT ASC"),
	@NamedQuery(name="getCongNoTheoKhachHangSoChungTu",
			query="FROM BCTongHop bc "
        	+ " WHERE bc.noCo=1 AND bc.soCT = :soChungTu AND bc.tKCoID like '51%'" 
        	+ " ORDER BY bc.ngayNhap, bc.soCT ASC"),
    @NamedQuery(name="getCongNoTheoThang",
    		query="FROM BCTongHop bc " 
    			+ " WHERE bc.noCo=1 AND bc.ngayNhap >= :tuNgay " 
    			+ " AND bc.ngayNhap <= :denNgay AND bc.tKCoID like '51%'" 
    			+ " ORDER BY bc.doiTuongCongNoID, bc.ngayNhap, bc.soCT ASC")
   })
@Entity
@Table(name = "BC_TongHopWeb")
public class BCTongHop {
	 
	@Id
	@Column(name = "ID") 
	private Integer  id;
	
	@Column(name = "MaCty", length=10) 
	private String  maCty;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="maCty")	
	private ThongTinKhachHang thongTinKhachHang;
	
	@Column(name = "TenCty") 
	private String  tenCty;
	@Column(name = "VAT_Seri", length=50) 
	private String  vAT_Seri;
	@Column(name = "VAT_So") 
	private String  vAT_So;  
	@Column(name = "NgayNhap", nullable = false) 
	private Date ngayNhap;
	@Column(name = "NgayDuyet") 
	private Date  ngayDuyet; 
	@Column(name = "SoCT", length=20) 
	private String  soCT;  
	@Column(name = "NgayCT", nullable = false) 
	private Date  ngayCT;  
	@Column(name = "LoaiTien", length=20) 
	private String  loaiTien;  
	@Column(name = "TyGia") 
	private Double tyGia;
	@Column(name = "TyGiaNhoHon") 
	private Boolean  TyGiaNhoHon;
	@Column(name = "ThoiHanThanhToan") 
	private Integer  ThoiHanThanhToan;
	@Column(name = "NganHangID", length=20) 
	private String  nganHangID;  
	@Column(name = "TenNganHang", length=20) 
	private String  tenNganHang;  
	@Column(name = "DiaChiNganHang", length=20) 
	private String  diaChiNganHang; 
	@Column(name = "TaiKhoan", length=20) 
	private String  taiKhoan;  
	@Column(name = "NganHangNguoiNhanID", length=20) 
	private String  nganHangNguoiNhanID;  
	@Column(name = "TenNganHangNguoiNhan", length=20) 
	private String  tenNganHangNguoiNhan;  
	@Column(name = "DiaChiNganHangNguoiNhan", length=20) 
	private String  diaChiNganHangNguoiNhan; 
	@Column(name = "TaiKhoanNguoiNhan", length=20) 
	private String  taiKhoanNguoiNhan; 
	@Column(name = "DoiTuongCongNoID", length=20) 
	private String  doiTuongCongNoID;  
	@Column(name = "TenDoiTuongCongNo", length=20) 
	private String  tenDoiTuongCongNo;  
	@Column(name = "DiaChi", length=255) 
	private String  diaChi;  
	@Column(name = "MaSothue", length=50) 
	private String  maSothue;
	@Column(name = "NguoiGiaoDich", length=50) 
	private String  nguoiGiaoDich;
	@Column(name = "NoiDung", length=500) 
	private String  noiDung;  
	@Column(name = "UserID", length=20) 
	private String  UserID;  
	@Column(name = "ChungTuID", length=50) 
	private String  ChungTuID;
	@Column(name = "HinhThucThanhToan", length=50) 
	private String  HinhThucThanhToan;
	@Column(name = "CTGoc", length=300) 
	private String  cTGoc;  
	@Column(name = "ViTri") 
	private Double  viTri;
	@Column(name = "ViTri_SoCT") 
	private Double  viTri_SoCT;
	@Column(name = "Sapxep", length=20, nullable = false) 
	private Integer  sapxep;  
	@Column(name = "ThueSuat_ChungTu", length=20) 
	private Integer  thueSuat_ChungTu;  
	@Column(name = "BoPhanID", length=20) 
	private String  boPhanID;  
	@Column(name = "TinhTrang", length=20) 
	private Integer  tinhTrang;  
	@Column(name = "Thang", length=20, nullable = false) 
	private Integer  thang;  
	@Column(name = "SoPhieu", length=50, nullable = false) 
	private String  soPhieu; 
	@Column(name = "TKNoID", length=20) 
	private String  tKNoID;  
	@Column(name = "TKCoID", length=20) 
	private String  tKCoID;  
	@Column(name = "VatTuID", length=50) 
	private String  vatTuID;
	@Column(name = "DVT", length=50) 
	private String  dVT;
	@Column(name = "DonGia") 
	private Double  donGia;
	@Column(name = "SoLuong") 
	private Double  soLuong;
	@Column(name = "PhatSinh") 
	private Double phatSinh; 
	@Column(name = "DienGiai", length=500) 
	private String  dienGiai;  
	@Column(name = "DonGiaNT") 
	private Double  donGiaNT;
	@Column(name = "PhatSinhNT") 
	private Double  phatSinhNT;
	@Column(name = "KhoHangID", length=20) 
	private String khoHangID ;
	@Column(name = "ThueSuat") 
	private Double thueSuat; 
	@Column(name = "YeuToQuanLyID", length=50) 
	private String  yeuToQuanLyID;
	@Column(name = "ButToanThueGTGT", length=20) 
	private Boolean butToanThueGTGT ;  
	@Column(name = "ChietKhau") 
	private Double chietKhau; 
	@Column(name = "MaThongKeID", length=20) 
	private String  maThongKeID;  
	@Column(name = "KhoanMucChiPhi", length=20) 
	private String  khoanMucChiPhi;  
	@Column(name = "DonGiaChuaCK", length=20) 
	private Double donGiaChuaCK; 
	@Column(name = "DonGiaChuaCKNT") 
	private Double donGiaChuaCKNT; 
	@Column(name = "ThanhPhamID", length=50) 
	private String  thanhPhamID;
	@Column(name = "STT", length=20, nullable = false) 
	private Integer  sTT;  
	@Column(name = "ChuyenKhoNoiBo", length=20) 
	private Boolean  chuyenKhoNoiBo;  
	@Column(name = "KhoChuyenDen", length=20) 
	private String  khoChuyenDen;
	@Column(name = "DoiTuongCongNoID_ChiTiet", length=20) 
	private String  doiTuongCongNoID_ChiTiet;
	@Column(name = "LoaiTien_ChiTiet", length=20) 
	private String  loaiTien_ChiTiet;  
	@Column(name = "TyGia_ChiTiet") 
	private Double tyGia_ChiTiet; 
	@Column(name = "SoLuong2")
	private Double soLuong2; 
	@Column(name = "GiaVon") 
	private Double giaVon; 
	@Column(name = "ButToanChietKhau", length=20)
	private Boolean  butToanChietKhau;  
	@Column(name = "TKDoiUng", length=20)
	private String  tKDoiUng;  
	@Column(name = "TenVatTu_ChiTiet", length=200)
	private String  tenVatTu_ChiTiet;  
	@Column(name = "TenDoiTuongCongNo_ChiTiet", length=200) 
	private String  tenDoiTuongCongNo_ChiTiet;  
	@Column(name = "DiaChi_ChiTiet", length=200) 
	private String  diaChi_ChiTiet;  
	@Column(name = "MaSoThue_ChiTiet", length=50) 
	private String  maSoThue_ChiTiet;
	@Column(name = "TKKhoNhapID", length=20) 
	private String  tKKhoNhapID;  
	@Column(name = "NoiBo") 
	private Boolean  noiBo;  
	@Column(name = "TyGiaNhoHon_Chitiet") 
	private Boolean TyGiaNhoHon_Chitiet ;  
	@Column(name = "LoaiVatTuID_ChiTiet", length=20) 
	private String  loaiVatTuID_ChiTiet;  
	@Column(name = "QuyCach", length=50) 
	private String  quyCach;
	@Column(name = "TienChietKhauTruocThue") 
	private Double  tienChietKhauTruocThue; 
	@Column(name = "TienChietKhauTruocThueNT")
	private Double  tienChietKhauTruocThueNT; 
	@Column(name = "MucChietKhau") 
	private Double  mucChietKhau; 
	@Column(name = "MucChietKhauNT") 
	private Double  mucChietKhauNT; 
	@Column(name = "LoHangID", length=20) 
	private String  loHangID;  
	@Column(name = "STTLienKet", length=20) 
	private Integer sTTLienKet ;  
	@Column(name = "ChiPhiMuaHang") 
	private Double  chiPhiMuaHang;
	@Column(name = "ChiPhiMuaHangNT") 
	private Double  chiPhiMuaHangNT;
	@Column(name = "TKCongNo_CanTru", length=20) 
	private String  tKCongNo_CanTru;  
	@Column(name = "DoiTuongCongNoID_ChiTiet_CanTru", length=20) 
	private String  doiTuongCongNoID_ChiTiet_CanTru;  
	@Column(name = "CanTruCongNo", length=20) 
	private Boolean  canTruCongNo;  
	@Column(name = "DaLapBaoCao", length=20) 
	private Boolean  daLapBaoCao;  
	@Column(name = "TKGoc", length=20) 
	private String  tKGoc;  
	@Column(name = "TKCap2", length=20) 
	private String  tKCap2;  
	@Column(name = "TKCap3", length=20) 
	private String  tKCap3;  
	@Column(name = "TKID", length=20) 
	private String  tKID;  
	@Column(name = "TenTK", length=60) 
	private String  tenTK;  
	@Column(name = "TenTKEng", length=100) 
	private String  tenTKEng; 
	@Column(name = "Kieu", length=50)
	private String  kieu;
	@Column(name = "CapTK", length=20) 
	private Integer  capTK;  
	@Column(name = "LoaiTaiKhoan", length=50) 
	private String  loaiTaiKhoan;
	@Column(name = "TKDoiUngID", length=20) 
	private String  tKDoiUngID;  
	@Column(name = "TenTKDoiUng", length=60) 
	private String  tenTKDoiUng;  
	@Column(name = "TenTKDoiUngEng", length=100) 
	private String  tenTKDoiUngEng;  
	@Column(name = "TenYeuToQuanly", length=50) 
	private String  tenYeuToQuanly;
	@Column(name = "YeuToquanLy_GhiChu", length=50) 
	private String  yeuToquanLy_GhiChu;
	@Column(name = "YeuToQuanLy_NgayBatdau")
	private Date  yeuToQuanLy_NgayBatdau;  
	@Column(name = "YeuToQuanLy_NgayKetthuc")
	private Date  yeuToQuanLy_NgayKetthuc;  
	@Column(name = "YeuToQuanLy_DoiTuongCongNoID", length=50)
	private String  yeuToQuanLy_DoiTuongCongNoID;
	@Column(name = "YeuToQuanLy_TenDoiTuongCongNo", length=200) 
	private String  yeuToQuanLy_TenDoiTuongCongNo;  
	@Column(name = "NguoiDaiDien", length=50)
	private String  nguoiDaiDien;  
	@Column(name = "Chucvu", length=50) 
	private String  chucvu; 
	@Column(name = "Fax", length=20) 
	private String  fax;  
	@Column(name = "DienThoai", length=50)
	private String  dienThoai; 
	@Column(name = "SoNgay", length=20) 
	private Integer  soNgay;  
	@Column(name = "LoaiDoiTuongCongNoID", length=20)
	private String  loaiDoiTuongCongNoID;  
	@Column(name = "TenLoaiDoiTuongCongNo", length=50)
	private String  tenLoaiDoiTuongCongNo;  
	@Column(name = "KhuVucID", length=50) 
	private String  khuVucID; 
	@Column(name = "TenKhuvuc", length=50)
	private String  tenKhuvuc; 
	@Column(name = "NhanVienKDID", length=50)
	private String  nhanVienKDID; 
	@Column(name = "TenNhanVienKD", length=50)
	private String  tenNhanVienKD;  
	@Column(name = "VungID", length=20) 
	private String vungID ;  
	@Column(name = "TenVung", length=200)	
	private String  tenVung;  
	@Column(name = "TenVatTu", length=200)
	private String  tenVatTu;  
	@Column(name = "DVTChuan", length=20)
	private String  dVTChuan;  
	@Column(name = "TheoDoiChiphi", length=20) 
	private Boolean  theoDoiChiphi;  
	@Column(name = "LoaiVatTuID", length=20) 
	private String  loaiVatTuID;  
	@Column(name = "TenLoaiVatTu", length=50) 
	private String  tenLoaiVatTu;  
	@Column(name = "KieuVatTu", length=50) 
	private String  kieuVatTu;  
	@Column(name = "TenKhoHang", length=50) 
	private String  tenKhoHang;  
	@Column(name = "TenKhoChuyenDen", length=50) 
	private String  tenKhoChuyenDen;  
	@Column(name = "TenPhongBan", length=100) 
	private String  tenPhongBan;  
	@Column(name = "TenKhoanMucChiPhi", length=100) 
	private String  tenKhoanMucChiPhi;  
	@Column(name = "TenLohang", length=100) 
	private String  tenLohang;  
	@Column(name = "TenMaThongKe", length=100)
	private String  tenMaThongKe;  
	@Column(name = "TenCongDoan", length=100) 
	private String  tenCongDoan;  
	@Column(name = "TenBoPhan", length=100) 
	private String  tenBoPhan;  
	@Column(name = "TenCapMot", length=100) 
	private String  tenCapMot;  
	@Column(name = "TenCapHai", length=100) 
	private String  tenCapHai;  
	@Column(name = "TenCapBa", length=100) 
	private String  tenCapBa;  
	@Column(name = "TenCapBon", length=100) 
	private String  tenCapBon;  
	@Column(name = "TenCapNam", length=100) 
	private String  tenCapNam;  
	@Column(name = "TenCapSau", length=100) 
	private String  tenCapSau;  
	@Column(name = "TenCapBay", length=100) 
	private String  tenCapBay;  
	@Column(name = "TenCapTam", length=100) 
	private String  tenCapTam;  
	@Column(name = "TenCapChin", length=100) 
	private String  tenCapChin;  
	@Column(name = "TenCapMuoi", length=100) 
	private String  tenCapMuoi;  
	@Column(name = "NoCo", nullable = false) 
	private Integer  noCo;
	
	public String getMaCty() {
		return maCty;
	}
	public void setMaCty(String maCty) {
		this.maCty = maCty;
	}
	public String getTenCty() {
		return tenCty;
	}
	public void setTenCty(String tenCty) {
		this.tenCty = tenCty;
	}
	public String getvAT_Seri() {
		return vAT_Seri;
	}
	public void setvAT_Seri(String vATSeri) {
		vAT_Seri = vATSeri;
	}
	public String getvAT_So() {
		return vAT_So;
	}
	public void setvAT_So(String vATSo) {
		vAT_So = vATSo;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public Date getNgayDuyet() {
		return ngayDuyet;
	}
	public void setNgayDuyet(Date ngayDuyet) {
		this.ngayDuyet = ngayDuyet;
	}
	public String getSoCT() {
		return soCT;
	}
	public void setSoCT(String soCT) {
		this.soCT = soCT;
	}
	public Date getNgayCT() {
		return ngayCT;
	}
	public void setNgayCT(Date ngayCT) {
		this.ngayCT = ngayCT;
	}
	public String getLoaiTien() {
		return loaiTien;
	}
	public void setLoaiTien(String loaiTien) {
		this.loaiTien = loaiTien;
	}
	public Double getTyGia() {
		return tyGia;
	}
	public void setTyGia(Double tyGia) {
		this.tyGia = tyGia;
	}
	public Boolean getTyGiaNhoHon() {
		return TyGiaNhoHon;
	}
	public void setTyGiaNhoHon(Boolean tyGiaNhoHon) {
		TyGiaNhoHon = tyGiaNhoHon;
	}
	public Integer getThoiHanThanhToan() {
		return ThoiHanThanhToan;
	}
	public void setThoiHanThanhToan(Integer thoiHanThanhToan) {
		ThoiHanThanhToan = thoiHanThanhToan;
	}
	public String getNganHangID() {
		return nganHangID;
	}
	public void setNganHangID(String nganHangID) {
		this.nganHangID = nganHangID;
	}
	public String getTenNganHang() {
		return tenNganHang;
	}
	public void setTenNganHang(String tenNganHang) {
		this.tenNganHang = tenNganHang;
	}
	public String getDiaChiNganHang() {
		return diaChiNganHang;
	}
	public void setDiaChiNganHang(String diaChiNganHang) {
		this.diaChiNganHang = diaChiNganHang;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getNganHangNguoiNhanID() {
		return nganHangNguoiNhanID;
	}
	public void setNganHangNguoiNhanID(String nganHangNguoiNhanID) {
		this.nganHangNguoiNhanID = nganHangNguoiNhanID;
	}
	public String getTenNganHangNguoiNhan() {
		return tenNganHangNguoiNhan;
	}
	public void setTenNganHangNguoiNhan(String tenNganHangNguoiNhan) {
		this.tenNganHangNguoiNhan = tenNganHangNguoiNhan;
	}
	public String getDiaChiNganHangNguoiNhan() {
		return diaChiNganHangNguoiNhan;
	}
	public void setDiaChiNganHangNguoiNhan(String diaChiNganHangNguoiNhan) {
		this.diaChiNganHangNguoiNhan = diaChiNganHangNguoiNhan;
	}
	public String getTaiKhoanNguoiNhan() {
		return taiKhoanNguoiNhan;
	}
	public void setTaiKhoanNguoiNhan(String taiKhoanNguoiNhan) {
		this.taiKhoanNguoiNhan = taiKhoanNguoiNhan;
	}
	public String getDoiTuongCongNoID() {
		return doiTuongCongNoID;
	}
	public void setDoiTuongCongNoID(String doiTuongCongNoID) {
		this.doiTuongCongNoID = doiTuongCongNoID;
	}
	public String getTenDoiTuongCongNo() {
		return tenDoiTuongCongNo;
	}
	public void setTenDoiTuongCongNo(String tenDoiTuongCongNo) {
		this.tenDoiTuongCongNo = tenDoiTuongCongNo;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMaSothue() {
		return maSothue;
	}
	public void setMaSothue(String maSothue) {
		this.maSothue = maSothue;
	}
	public String getNguoiGiaoDich() {
		return nguoiGiaoDich;
	}
	public void setNguoiGiaoDich(String nguoiGiaoDich) {
		this.nguoiGiaoDich = nguoiGiaoDich;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
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
		return cTGoc;
	}
	public void setCTGoc(String cTGoc) {
		this.cTGoc = cTGoc;
	}
	public Double getViTri() {
		return viTri;
	}
	public void setViTri(Double viTri) {
		this.viTri = viTri;
	}
	public Double getViTri_SoCT() {
		return viTri_SoCT;
	}
	public void setViTri_SoCT(Double viTriSoCT) {
		this.viTri_SoCT = viTriSoCT;
	}
	public Integer getSapxep() {
		return sapxep;
	}
	public void setSapxep(Integer sapxep) {
		this.sapxep = sapxep;
	}
	public Integer getThueSuat_ChungTu() {
		return thueSuat_ChungTu;
	}
	public void setThueSuat_ChungTu(Integer thueSuatChungTu) {
		this.thueSuat_ChungTu = thueSuatChungTu;
	}
	public String getBoPhanID() {
		return boPhanID;
	}
	public void setBoPhanID(String boPhanID) {
		this.boPhanID = boPhanID;
	}
	public Integer getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(Integer tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public Integer getThang() {
		return thang;
	}
	public void setThang(Integer thang) {
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
	public String getdVT() {
		return dVT;
	}
	public void setdVT(String dVT) {
		this.dVT = dVT;
	}
	public Double getDonGia() {
		return donGia;
	}
	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}
	public Double getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(Double soLuong) {
		this.soLuong = soLuong;
	}
	public Double getPhatSinh() {
		return phatSinh;
	}
	public void setPhatSinh(Double phatSinh) {
		this.phatSinh = phatSinh;
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
	public Double getThueSuat() {
		return thueSuat;
	}
	public void setThueSuat(Double thueSuat) {
		this.thueSuat = thueSuat;
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
	public Double getChietKhau() {
		return chietKhau;
	}
	public void setChietKhau(Double chietKhau) {
		this.chietKhau = chietKhau;
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
	public Integer getsTT() {
		return sTT;
	}
	public void setsTT(Integer sTT) {
		this.sTT = sTT;
	}
	public Boolean getChuyenKhoNoiBo() {
		return chuyenKhoNoiBo;
	}
	public void setChuyenKhoNoiBo(Boolean chuyenKhoNoiBo) {
		this.chuyenKhoNoiBo = chuyenKhoNoiBo;
	}
	public String getKhoChuyenDen() {
		return khoChuyenDen;
	}
	public void setKhoChuyenDen(String khoChuyenDen) {
		this.khoChuyenDen = khoChuyenDen;
	}
	public String getDoiTuongCongNoID_ChiTiet() {
		return doiTuongCongNoID_ChiTiet;
	}
	public void setDoiTuongCongNoID_ChiTiet(String doiTuongCongNoIDChiTiet) {
		this.doiTuongCongNoID_ChiTiet = doiTuongCongNoIDChiTiet;
	}
	public String getLoaiTien_ChiTiet() {
		return loaiTien_ChiTiet;
	}
	public void setLoaiTien_ChiTiet(String loaiTienChiTiet) {
		this.loaiTien_ChiTiet = loaiTienChiTiet;
	}
	public Double getTyGia_ChiTiet() {
		return tyGia_ChiTiet;
	}
	public void setTyGia_ChiTiet(Double tyGiaChiTiet) {
		this.tyGia_ChiTiet = tyGiaChiTiet;
	}
	public Double getSoLuong2() {
		return soLuong2;
	}
	public void setSoLuong2(Double soLuong2) {
		this.soLuong2 = soLuong2;
	}
	public Double getGiaVon() {
		return giaVon;
	}
	public void setGiaVon(Double giaVon) {
		this.giaVon = giaVon;
	}
	public Boolean getButToanChietKhau() {
		return butToanChietKhau;
	}
	public void setButToanChietKhau(Boolean butToanChietKhau) {
		this.butToanChietKhau = butToanChietKhau;
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
		this.tenVatTu_ChiTiet = tenVatTuChiTiet;
	}
	public String getTenDoiTuongCongNo_ChiTiet() {
		return tenDoiTuongCongNo_ChiTiet;
	}
	public void setTenDoiTuongCongNo_ChiTiet(String tenDoiTuongCongNoChiTiet) {
		this.tenDoiTuongCongNo_ChiTiet = tenDoiTuongCongNoChiTiet;
	}
	public String getDiaChi_ChiTiet() {
		return diaChi_ChiTiet;
	}
	public void setDiaChi_ChiTiet(String diaChiChiTiet) {
		this.diaChi_ChiTiet = diaChiChiTiet;
	}
	public String getMaSoThue_ChiTiet() {
		return maSoThue_ChiTiet;
	}
	public void setMaSoThue_ChiTiet(String maSoThueChiTiet) {
		this.maSoThue_ChiTiet = maSoThueChiTiet;
	}
	public String gettKKhoNhapID() {
		return tKKhoNhapID;
	}
	public void settKKhoNhapID(String tKKhoNhapID) {
		this.tKKhoNhapID = tKKhoNhapID;
	}
	public Boolean getNoiBo() {
		return noiBo;
	}
	public void setNoiBo(Boolean noiBo) {
		this.noiBo = noiBo;
	}
	public Boolean getTyGiaNhoHon_Chitiet() {
		return TyGiaNhoHon_Chitiet;
	}
	public void setTyGiaNhoHon_Chitiet(Boolean tyGiaNhoHonChitiet) {
		TyGiaNhoHon_Chitiet = tyGiaNhoHonChitiet;
	}
	public String getLoaiVatTuID_ChiTiet() {
		return loaiVatTuID_ChiTiet;
	}
	public void setLoaiVatTuID_ChiTiet(String loaiVatTuIDChiTiet) {
		this.loaiVatTuID_ChiTiet = loaiVatTuIDChiTiet;
	}
	public String getQuyCach() {
		return quyCach;
	}
	public void setQuyCach(String quyCach) {
		this.quyCach = quyCach;
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
	public String getLoHangID() {
		return loHangID;
	}
	public void setLoHangID(String loHangID) {
		this.loHangID = loHangID;
	}
	public Integer getSTTLienKet() {
		return sTTLienKet;
	}
	public void setSTTLienKet(Integer sTTLienKet) {
		this.sTTLienKet = sTTLienKet;
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
	public String gettKCongNo_CanTru() {
		return tKCongNo_CanTru;
	}
	public void settKCongNo_CanTru(String tKCongNoCanTru) {
		this.tKCongNo_CanTru = tKCongNoCanTru;
	}
	public String getDoiTuongCongNoID_ChiTiet_CanTru() {
		return doiTuongCongNoID_ChiTiet_CanTru;
	}
	public void setDoiTuongCongNoID_ChiTiet_CanTru(
			String doiTuongCongNoIDChiTietCanTru) {
		this.doiTuongCongNoID_ChiTiet_CanTru = doiTuongCongNoIDChiTietCanTru;
	}
	public Boolean getCanTruCongNo() {
		return canTruCongNo;
	}
	public void setCanTruCongNo(Boolean canTruCongNo) {
		this.canTruCongNo = canTruCongNo;
	}
	public Boolean getDaLapBaoCao() {
		return daLapBaoCao;
	}
	public void setDaLapBaoCao(Boolean daLapBaoCao) {
		this.daLapBaoCao = daLapBaoCao;
	}
	public String gettKGoc() {
		return tKGoc;
	}
	public void settKGoc(String tKGoc) {
		this.tKGoc = tKGoc;
	}
	public String gettKCap2() {
		return tKCap2;
	}
	public void settKCap2(String tKCap2) {
		this.tKCap2 = tKCap2;
	}
	public String gettKCap3() {
		return tKCap3;
	}
	public void settKCap3(String tKCap3) {
		this.tKCap3 = tKCap3;
	}
	public String gettKID() {
		return tKID;
	}
	public void settKID(String tKID) {
		this.tKID = tKID;
	}
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public String getTenTKEng() {
		return tenTKEng;
	}
	public void setTenTKEng(String tenTKEng) {
		this.tenTKEng = tenTKEng;
	}
	public String getKieu() {
		return kieu;
	}
	public void setKieu(String kieu) {
		this.kieu = kieu;
	}
	public Integer getCapTK() {
		return capTK;
	}
	public void setCapTK(Integer capTK) {
		this.capTK = capTK;
	}
	public String getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}
	public void setLoaiTaiKhoan(String loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}
	public String gettKDoiUngID() {
		return tKDoiUngID;
	}
	public void settKDoiUngID(String tKDoiUngID) {
		this.tKDoiUngID = tKDoiUngID;
	}
	public String getTenTKDoiUng() {
		return tenTKDoiUng;
	}
	public void setTenTKDoiUng(String tenTKDoiUng) {
		this.tenTKDoiUng = tenTKDoiUng;
	}
	public String getTenTKDoiUngEng() {
		return tenTKDoiUngEng;
	}
	public void setTenTKDoiUngEng(String tenTKDoiUngEng) {
		this.tenTKDoiUngEng = tenTKDoiUngEng;
	}
	public String getTenYeuToQuanly() {
		return tenYeuToQuanly;
	}
	public void setTenYeuToQuanly(String tenYeuToQuanly) {
		this.tenYeuToQuanly = tenYeuToQuanly;
	}
	public String getYeuToquanLy_GhiChu() {
		return yeuToquanLy_GhiChu;
	}
	public void setYeuToquanLy_GhiChu(String yeuToquanLyGhiChu) {
		this.yeuToquanLy_GhiChu = yeuToquanLyGhiChu;
	}
	public Date getYeuToQuanLy_NgayBatdau() {
		return yeuToQuanLy_NgayBatdau;
	}
	public void setYeuToQuanLy_NgayBatdau(Date yeuToQuanLyNgayBatdau) {
		this.yeuToQuanLy_NgayBatdau = yeuToQuanLyNgayBatdau;
	}
	public Date getYeuToQuanLy_NgayKetthuc() {
		return yeuToQuanLy_NgayKetthuc;
	}
	public void setYeuToQuanLy_NgayKetthuc(Date yeuToQuanLyNgayKetthuc) {
		this.yeuToQuanLy_NgayKetthuc = yeuToQuanLyNgayKetthuc;
	}
	public String getYeuToQuanLy_DoiTuongCongNoID() {
		return yeuToQuanLy_DoiTuongCongNoID;
	}
	public void setYeuToQuanLy_DoiTuongCongNoID(String yeuToQuanLyDoiTuongCongNoID) {
		this.yeuToQuanLy_DoiTuongCongNoID = yeuToQuanLyDoiTuongCongNoID;
	}
	public String getYeuToQuanLy_TenDoiTuongCongNo() {
		return yeuToQuanLy_TenDoiTuongCongNo;
	}
	public void setYeuToQuanLy_TenDoiTuongCongNo(String yeuToQuanLyTenDoiTuongCongNo) {
		this.yeuToQuanLy_TenDoiTuongCongNo = yeuToQuanLyTenDoiTuongCongNo;
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
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public Integer getSoNgay() {
		return soNgay;
	}
	public void setSoNgay(Integer soNgay) {
		this.soNgay = soNgay;
	}
	public String getLoaiDoiTuongCongNoID() {
		return loaiDoiTuongCongNoID;
	}
	public void setLoaiDoiTuongCongNoID(String loaiDoiTuongCongNoID) {
		this.loaiDoiTuongCongNoID = loaiDoiTuongCongNoID;
	}
	public String getTenLoaiDoiTuongCongNo() {
		return tenLoaiDoiTuongCongNo;
	}
	public void setTenLoaiDoiTuongCongNo(String tenLoaiDoiTuongCongNo) {
		this.tenLoaiDoiTuongCongNo = tenLoaiDoiTuongCongNo;
	}
	public String getKhuVucID() {
		return khuVucID;
	}
	public void setKhuVucID(String khuVucID) {
		this.khuVucID = khuVucID;
	}
	public String getTenKhuvuc() {
		return tenKhuvuc;
	}
	public void setTenKhuvuc(String tenKhuvuc) {
		this.tenKhuvuc = tenKhuvuc;
	}
	public String getNhanVienKDID() {
		return nhanVienKDID;
	}
	public void setNhanVienKDID(String nhanVienKDID) {
		this.nhanVienKDID = nhanVienKDID;
	}
	public String getTenNhanVienKD() {
		return tenNhanVienKD;
	}
	public void setTenNhanVienKD(String tenNhanVienKD) {
		this.tenNhanVienKD = tenNhanVienKD;
	}
	public String getVungID() {
		return vungID;
	}
	public void setVungID(String vungID) {
		this.vungID = vungID;
	}
	public String getTenVung() {
		return tenVung;
	}
	public void setTenVung(String tenVung) {
		this.tenVung = tenVung;
	}
	public String getTenVatTu() {
		return tenVatTu;
	}
	public void setTenVatTu(String tenVatTu) {
		this.tenVatTu = tenVatTu;
	}
	public String getdVTChuan() {
		return dVTChuan;
	}
	public void setdVTChuan(String dVTChuan) {
		this.dVTChuan = dVTChuan;
	}
	public Boolean getTheoDoiChiphi() {
		return theoDoiChiphi;
	}
	public void setTheoDoiChiphi(Boolean theoDoiChiphi) {
		this.theoDoiChiphi = theoDoiChiphi;
	}
	public String getLoaiVatTuID() {
		return loaiVatTuID;
	}
	public void setLoaiVatTuID(String loaiVatTuID) {
		this.loaiVatTuID = loaiVatTuID;
	}
	public String getTenLoaiVatTu() {
		return tenLoaiVatTu;
	}
	public void setTenLoaiVatTu(String tenLoaiVatTu) {
		this.tenLoaiVatTu = tenLoaiVatTu;
	}
	public String getKieuVatTu() {
		return kieuVatTu;
	}
	public void setKieuVatTu(String kieuVatTu) {
		this.kieuVatTu = kieuVatTu;
	}
	public String getTenKhoHang() {
		return tenKhoHang;
	}
	public void setTenKhoHang(String tenKhoHang) {
		this.tenKhoHang = tenKhoHang;
	}
	public String getTenKhoChuyenDen() {
		return tenKhoChuyenDen;
	}
	public void setTenKhoChuyenDen(String tenKhoChuyenDen) {
		this.tenKhoChuyenDen = tenKhoChuyenDen;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	public String getTenKhoanMucChiPhi() {
		return tenKhoanMucChiPhi;
	}
	public void setTenKhoanMucChiPhi(String tenKhoanMucChiPhi) {
		this.tenKhoanMucChiPhi = tenKhoanMucChiPhi;
	}
	public String getTenLohang() {
		return tenLohang;
	}
	public void setTenLohang(String tenLohang) {
		this.tenLohang = tenLohang;
	}
	public String getTenMaThongKe() {
		return tenMaThongKe;
	}
	public void setTenMaThongKe(String tenMaThongKe) {
		this.tenMaThongKe = tenMaThongKe;
	}
	public String getTenCongDoan() {
		return tenCongDoan;
	}
	public void setTenCongDoan(String tenCongDoan) {
		this.tenCongDoan = tenCongDoan;
	}
	public String getTenBoPhan() {
		return tenBoPhan;
	}
	public void setTenBoPhan(String tenBoPhan) {
		this.tenBoPhan = tenBoPhan;
	}
	public String getTenCapMot() {
		return tenCapMot;
	}
	public void setTenCapMot(String tenCapMot) {
		this.tenCapMot = tenCapMot;
	}
	public String getTenCapHai() {
		return tenCapHai;
	}
	public void setTenCapHai(String tenCapHai) {
		this.tenCapHai = tenCapHai;
	}
	public String getTenCapBa() {
		return tenCapBa;
	}
	public void setTenCapBa(String tenCapBa) {
		this.tenCapBa = tenCapBa;
	}
	public String getTenCapBon() {
		return tenCapBon;
	}
	public void setTenCapBon(String tenCapBon) {
		this.tenCapBon = tenCapBon;
	}
	public String getTenCapNam() {
		return tenCapNam;
	}
	public void setTenCapNam(String tenCapNam) {
		this.tenCapNam = tenCapNam;
	}
	public String getTenCapSau() {
		return tenCapSau;
	}
	public void setTenCapSau(String tenCapSau) {
		this.tenCapSau = tenCapSau;
	}
	public String getTenCapBay() {
		return tenCapBay;
	}
	public void setTenCapBay(String tenCapBay) {
		this.tenCapBay = tenCapBay;
	}
	public String getTenCapTam() {
		return tenCapTam;
	}
	public void setTenCapTam(String tenCapTam) {
		this.tenCapTam = tenCapTam;
	}
	public String getTenCapChin() {
		return tenCapChin;
	}
	public void setTenCapChin(String tenCapChin) {
		this.tenCapChin = tenCapChin;
	}
	public String getTenCapMuoi() {
		return tenCapMuoi;
	}
	public void setTenCapMuoi(String tenCapMuoi) {
		this.tenCapMuoi = tenCapMuoi;
	}
	public Integer getNoCo() {
		return noCo;
	}
	public void setNoCo(Integer noCo) {
		this.noCo = noCo;
	}
	public void setThongTinKhachHang(ThongTinKhachHang thongTinKhachHang) {
		this.thongTinKhachHang = thongTinKhachHang;
	}
	public ThongTinKhachHang getThongTinKhachHang() {
		return thongTinKhachHang;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
