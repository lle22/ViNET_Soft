package com.pn.view.commentCustomer.bean;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUploadForm {
	private Integer  id;
	private String  nguoiGiaoDich;
	private String  emailTo;
	private String  emailCc = "";
	private String  emailBcc = "";
	private String  emailFrom="phuongnam_vpp@yahoo.com";
	private String  emailSubject = "K/G BẢNG BÁO GIÁ VPP CTY PHƯƠNG NAM ";
	private CommonsMultipartFile attach;
	private String fileName;
	private String  emailContent = "Em bên công ty Phương Nam, em gửi bảng báo giá văn phòng phẩm cho dai_tu tham khảo. Dai_tu vui lòng mở file đính kèm để xem chi tiết, có gì thắc mắc thì dai_tu reply email hoặc điện thoại lại giùm em nhé! <br>"
			 + "Em rất mong nhận được sự quan tâm và hợp tác lâu dài với bên dai_tu.<br><br> <b>Thanks and best regards, <br>";
	private String footer = "Công ty TNHH TM DV văn phòng phẩm Phương Nam <br>Địa chỉ: B18/19K Nguyễn Văn Linh Q.7 TP.HCM <br>ĐT: (08)3758 4761 - 0908 446 482 <br>Web site: <a href=\"http://sites.google.com/site/vanphongphampn/ \">http://sites.google.com/site/vanphongphampn/</a></b>";
	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getEmailCc() {
		return emailCc;
	}
	public void setEmailCc(String emailCc) {
		this.emailCc = emailCc;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	
	public String getEmailContent() {
		return emailContent;
	}
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setAttach(CommonsMultipartFile attach) {
		this.attach = attach;
	}
	public CommonsMultipartFile getAttach() {
		return attach;
	}	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setNguoiGiaoDich(String nguoiGiaoDich) {
		this.nguoiGiaoDich = nguoiGiaoDich;
	}
	public String getNguoiGiaoDich() {
		return nguoiGiaoDich;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}
	public String getFooter() {
		return footer;
	}
	public void setEmailBcc(String emailBcc) {
		this.emailBcc = emailBcc;
	}
	public String getEmailBcc() {
		return emailBcc;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileName() {
		return fileName;
	}	
	
}
