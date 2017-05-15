package com.pn.view.chungtu.bean;

import java.util.Calendar;

public class ChungTuBean {
	Calendar cal = Calendar.getInstance();  
	private Integer chungTuId;
	private Integer thang = cal.get(cal.MONTH)+1;
	public Integer getChungTuId() {
		return chungTuId;
	}
	public void setChungTuId(Integer chungTuId) {
		this.chungTuId = chungTuId;
	}
	public Integer getThang() {
		return thang;
	}
	public void setThang(Integer thang) {
		this.thang = thang;
	}
}
