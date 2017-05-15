package com.pn.service.bcTongHop;

import java.util.List;

import com.pn.model.BCTongHop;
import com.pn.model.Customer.DTCongNo;

public interface BCTongHopService {
	public List<BCTongHop> getBaoCaoTheoCongTy(String maCty, String tuNgay, String denNgay);
	public List<BCTongHop> getBaoCaoTheoSoChungTu(String soChungTu);
	public List<BCTongHop> getBaoCaoTheoThang(String tuNgay, String denNgay);
	public List<Object> getAllCustomerInMonth(String tuNgay, String denNgay);
	public List<DTCongNo> getListDoiTuongCongNo();
	public int tongHopData();
}
