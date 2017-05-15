package com.pn.service.chungtu;

import java.util.List;

import com.pn.model.chungtu.ChiTietChungTu;

public interface ChungtuService {
	public List<ChiTietChungTu> getAllChungTuBaseSoPhieu(String sophieu, Integer thang);
}
