package com.pn.util;

import java.text.DecimalFormat;
import java.util.ArrayList;

import word.utils.Utils;

import com.pn.view.invoice.bean.InvoiceBean;
import com.pn.view.invoice.bean.InvoiceDetail;

public class CreateWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CreateWord a  = new CreateWord();		
		InvoiceBean invoiceBean = new InvoiceBean();
		invoiceBean.setNgay("10");
		invoiceBean.setThang("12");
		invoiceBean.setNam("2017");
		invoiceBean.setTenNguoiMuaHang("Công ty TNHH TM dich vụ phuong nam");
		invoiceBean.setTenDonVi("Cty tnhh tm dich vụ văn phòng phẩm phuong nam");
		invoiceBean.setMaSoThue("02020212121212");
		invoiceBean.setDiaChi("355 Nguyen trai, phuong3 5 qu 9, HCM");
		invoiceBean.setThueSuatGTGT(10);
		ArrayList l = new ArrayList();
		InvoiceDetail a1 = new InvoiceDetail();
		a1.setTenHangHoa("giấy excel a1");
		a1.setDonViTinh("ream");
		a1.setSoLuong(Double.valueOf(10));
		a1.setDonGia(Double.valueOf(10222));
		a1.setThanhTien(a1.getSoLuong()*a1.getDonGia());
		l.add(a1);
		InvoiceDetail a2 = new InvoiceDetail();
        a2.setTenHangHoa("giấy excel a1");
        a2.setDonViTinh("ream");
        a2.setSoLuong(Double.valueOf(10));
        a2.setDonGia(Double.valueOf(11110));
        a2.setThanhTien(a2.getSoLuong()*a2.getDonGia());
        l.add(a2);       
		invoiceBean.setInvoiceDetails(l);
		invoiceBean.formatInvoice(invoiceBean);
		TestUtils.createLocalDoc(a.createWordTemplate(invoiceBean, "HoaDonGTGTTemplate.xml"));
//		PNConstant a = new PNConstant();
//		System.out.println(a.docSoSangChu(Double.valueOf(101101)));
	}

    public void addTextToTable(String xmlTemplate, int i, String nSoTT, String nTenHang, String nDVT, String nSoLuong, String nDonGia, String nTien) {
	    xmlTemplate = replacePh(xmlTemplate, "nS" + i, nSoTT);    
        xmlTemplate = replacePh(xmlTemplate, "nTenHang" + i, nDVT);  
        xmlTemplate = replacePh(xmlTemplate, "nDVT" + i, nDVT);  
        xmlTemplate = replacePh(xmlTemplate, "nSL" + i, nSoLuong);   
        xmlTemplate = replacePh(xmlTemplate, "nDG" + i, nDonGia);   
        xmlTemplate = replacePh(xmlTemplate, "nTien" + i, nTien);
	}
    public String createWordTemplate(InvoiceBean invoiceBean, String wordTemplateFile) {
        String xmlTemplate = Utils.readFile(wordTemplateFile);
        
        xmlTemplate = replacePh(xmlTemplate, "nNgay", invoiceBean.getNgay() + "");
        xmlTemplate = replacePh(xmlTemplate, "nThang", invoiceBean.getThang() + "");
        xmlTemplate = replacePh(xmlTemplate, "nNam", invoiceBean.getNam() + "");
        
        xmlTemplate = replacePh(xmlTemplate, "nTenMuaHang", invoiceBean.getTenNguoiMuaHang());
        xmlTemplate = replacePh(xmlTemplate, "nTenDonVi", invoiceBean.getTenDonVi());
        xmlTemplate = replacePh(xmlTemplate, "nMaSoThue", invoiceBean.getMaSoThue());
        xmlTemplate = replacePh(xmlTemplate, "nDiaChi", invoiceBean.getDiaChi());
        xmlTemplate = replacePh(xmlTemplate, "nHinhThucTT", invoiceBean.getHinhThucThanhToan());
        xmlTemplate = replacePh(xmlTemplate, "nSoTK", invoiceBean.getSoTaiKhoan());
        double tongtien = 0;
        DecimalFormat dFormat = new DecimalFormat("####,###,###");
        for (int i = 1; invoiceBean.getInvoiceDetails() != null && i < invoiceBean.getInvoiceDetails().size()+1 && i<=11; i++) {
            InvoiceDetail invoiceDetail =  new InvoiceDetail();
            if (invoiceBean.getInvoiceDetails().size() > i-1) {
                invoiceDetail =  (InvoiceDetail)invoiceBean.getInvoiceDetails().get(i-1);                    
            }
            String text = (i>9?"_":"") + i;
            if(invoiceBean.getIsKemBangKe()) {
            	tongtien = invoiceBean.getCongTienHang();
                if(i == 1) {
                    xmlTemplate = replacePh(xmlTemplate, "nTenHang" + text, invoiceBean.getBangKeText());
                    xmlTemplate = replacePh(xmlTemplate, "nTien" + text, dFormat.format(tongtien) + "");
                }                
            } else {
                if (invoiceDetail.getTenHangHoa() != null && !"".equals(invoiceDetail.getTenHangHoa().trim())) {
                    xmlTemplate = replacePh(xmlTemplate, "nS" + text, i + "");    
                    xmlTemplate = replacePh(xmlTemplate, "nTenHang" + text, invoiceDetail.getTenHangHoa().trim());  
                    xmlTemplate = replacePh(xmlTemplate, "nDVT" + text, invoiceDetail.getDonViTinh().trim());  
                    xmlTemplate = replacePh(xmlTemplate, "nSL" + text, dFormat.format(invoiceDetail.getSoLuong()) + "");   
                    xmlTemplate = replacePh(xmlTemplate, "nDG" + text, dFormat.format(invoiceDetail.getDonGia()) + "");   
                    xmlTemplate = replacePh(xmlTemplate, "nTien" + text, dFormat.format(invoiceDetail.getSoLuong() * invoiceDetail.getDonGia()) + "");
                    tongtien = tongtien + invoiceDetail.getSoLuong() * invoiceDetail.getDonGia();
                } else {
                    xmlTemplate = replacePh(xmlTemplate, "nS" + text, "");    
                    xmlTemplate = replacePh(xmlTemplate, "nTenHang" + text, "");  
                    xmlTemplate = replacePh(xmlTemplate, "nDVT" + text, "");  
                    xmlTemplate = replacePh(xmlTemplate, "nSL" + text,  "");   
                    xmlTemplate = replacePh(xmlTemplate, "nDG" + text, "");   
                    xmlTemplate = replacePh(xmlTemplate, "nTien" + text, "");                    
                }
            }
        }  
        int tienThue = (int)Math.round(tongtien * invoiceBean.getThueSuatGTGT() / 100);
        xmlTemplate = replacePh(xmlTemplate, "nCongTien", dFormat.format(tongtien) + "");
        xmlTemplate = replacePh(xmlTemplate, "nThueSuat", dFormat.format(invoiceBean.getThueSuatGTGT()) + "");
        if (tienThue > 0) {
			xmlTemplate = replacePh(xmlTemplate, "nTienThue", dFormat.format(tienThue) + "");			
		} else {
			xmlTemplate = replacePh(xmlTemplate, "nTienThue", "");
		}
        xmlTemplate = replacePh(xmlTemplate, "nTongCong", dFormat.format(tongtien + tienThue) + "");        
        xmlTemplate = replacePh(xmlTemplate, "nSoTienBangChu", ReadNumber.numberToString(tongtien + tienThue));

        
//        
//        
//        Table tbl = new Table();
//
//        tbl.addTableEle(TableEle.TD, "J2W-1234", "Read Templates nicelly");
//        
//        tbl.addTableEle(TableEle.TD, "J2W-9999", "Make Java2word funky!!!");
//
//        xmlTemplate = replacePh(xmlTemplate, "phTableIssues", tbl.getContent());
//        
//        Paragraph p01 = Paragraph.with("1) Stop the server").create();
//        Paragraph p02 = Paragraph.with("2) Run the script to deploy the app xxx").create();
//        Paragraph p03 = Paragraph.with("3) Start the server").create();
//        Paragraph p04 = Paragraph.with("4) Hope for the best").create();
//        
//        String instructions = p01.getContent() + p02.getContent() + p03.getContent() + p04.getContent();
//        
//        //Workaround: phInstructions is already inside a 'text' fragment. 
//        //If you know the template, you can remove the whole element and add all Paragraphs
//        //* Table above doesn't need workaround because table can be normally inside a paragraph.
//        xmlTemplate = replacePh(xmlTemplate, "phInstructions", instructions); 
//        
//        xmlTemplate = replacePh(xmlTemplate, "phDateTime", new Date().toString());
        
        return xmlTemplate;
//        TestUtils.createLocalDoc(xmlTemplate);        
    }

    /***
     * Does the Place Holder replacement but LOGS when can not find place holder. 
     * This method is here to show how you could eventually replace placeholders. It is not in the library.
     * @param base Base String that contains the big XML with all placeholders
     * @param placeHolder the actual place holder
     * @param value value to take place
     * @return the new string with place holder replaced
     */
    private String replacePh(String base, String placeHolder, String value) {
        if(!base.contains(placeHolder)) {
            //don't want to use log now because I want to keep it simple...
            System.out.println("### WARN: couldn't find the place holder: " + placeHolder);
            return base;
        }        
        return base.replace(placeHolder, value);
    }

}
