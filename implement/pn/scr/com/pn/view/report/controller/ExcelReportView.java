package com.pn.view.report.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.springframework.web.servlet.view.document.AbstractJExcelView;

import com.pn.model.BCTongHop;
import com.pn.model.ThongTinKhachHang;
import com.pn.util.ExcelFormat;
import com.pn.util.PNConstant;
import com.pn.view.report.bean.ReportCongNoKHBean;

public class ExcelReportView extends AbstractJExcelView{
	private final int rowStart = 1;
	private final int colStart = 0;
	@SuppressWarnings("unchecked")
	@Override	
	//base on customer id and from date to date
	protected void buildExcelDocument(Map model, WritableWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> revenueData = (Map<String,Object>) model.get("model");
		List<BCTongHop> bcCongNo = (List<BCTongHop>)revenueData.get("bcCongNo");
		List<Object> allCusInMonth = (List<Object>)revenueData.get("allCusInMonth");
		ReportCongNoKHBean reportBean = (ReportCongNoKHBean)revenueData.get("reportBean");
		String fileName = "DS_KH_TRONG_KY";
		String nameSheet = "";
		if(reportBean.getIsBangKe() || reportBean.getIsCongNo() || reportBean.getIsTongHopMatHang()){
			fileName = bcCongNo.get(0).getDoiTuongCongNoID() + "_T" + (reportBean.getDenNgay().split("/"))[1] + ".xls";
			nameSheet = bcCongNo.get(0).getDoiTuongCongNoID();		
		}
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		int index = 0;
		int rowNext = 0;
		if(reportBean.getIsCongNo()){
			WritableSheet sheetCN = workbook.createSheet("CONGNO_" + nameSheet, 0);
			rowNext = addHeaderCongNo(bcCongNo.get(index), reportBean, sheetCN);
			addHBodyCongNo(bcCongNo, sheetCN, index, rowNext, reportBean);
		} 
		if(reportBean.getIsBangKe()){
			WritableSheet sheetBK = workbook.createSheet("BANGKE_" + nameSheet, 1);
			rowNext = addHeaderBangKe(bcCongNo.get(index), reportBean, sheetBK);
			addHBodyBangKe(bcCongNo, sheetBK, index, rowNext, reportBean);
		}
		if(reportBean.getIsTongHopMatHang()){
			WritableSheet sheetTH = workbook.createSheet("CK_MAT_HANG_" + nameSheet, 2);
			rowNext = addHeaderMatHang(bcCongNo.get(index), reportBean, sheetTH);
			addHBodyMatHang(bcCongNo, reportBean, sheetTH, index, rowNext);
		}
		if(reportBean.getIsTongSoKHtrongThang()){
			WritableSheet sheetTH = workbook.createSheet("DS_KH_TRONG_KY", 3);
			rowNext = addHeaderAllCusInMonth(reportBean, sheetTH);
			addHBodyAllCusInMonth(allCusInMonth, reportBean, sheetTH, rowNext);
		}
	}

	private void addHBodyAllCusInMonth(List<Object> bcCongNo, ReportCongNoKHBean reportBean, WritableSheet s, int rowNext) throws RowsExceededException, WriteException {
		int col = 0;
		WritableCellFormat cf_right_border_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, true, Alignment.RIGHT, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_left_border = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.LEFT, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_center_border = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_number_right = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.RIGHT, Border.ALL, BorderLineStyle.THIN, null, false, "#,##");
		WritableCellFormat cf_number_right_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, true, Alignment.RIGHT, Border.ALL, BorderLineStyle.THIN, null, false, "#,##");
    	int row = rowNext;
    	int rowStartSum = row +2;
		for(int i = 0; i < bcCongNo.size(); i++){
			double sum = 0;
			Object[] data = (Object[])bcCongNo.get(i); 
			col = colStart;
			row = row + 1;
			s.addCell(new Number(col++, row, i + 1, cf_center_border));
			s.addCell(new Label(col++, row, data[0].toString(), cf_left_border));
			s.addCell(new Label(col++, row, data[1].toString(), cf_left_border));
			if(data[2] != null){
				sum = Double.parseDouble(data[2].toString());
			}
			s.addCell(new Number(col++, row, sum, cf_number_right));
			s.addCell(new Label(col++, row, "", cf_left_border));
		}		
		int rowEndSum = row + 1;

		s.mergeCells(0, ++row, 2, row);
	    s.addCell(new Label(0, row, "Tổng cộng: ", cf_right_border_bold));
	    Formula tongTien = new Formula(col-2, row, "SUM(D" + rowStartSum + ":D" + rowEndSum +")", cf_number_right_bold);
	    s.addCell(tongTien);
	    s.addCell(new Label(col-1, row, "", cf_right_border_bold));

	}
	private int addHeaderAllCusInMonth(ReportCongNoKHBean reportBean, WritableSheet s) throws WriteException {
		int col = colStart, row = rowStart;
	    /* Format the Font */ 
		WritableCellFormat cf_center_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 13, true, Alignment.CENTRE, null, null, null, false);
		WritableCellFormat cf_center_bold_10 = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, null, null, null, false);
		WritableCellFormat cf = ExcelFormat.cellFormat(WritableFont.ARIAL, 12, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, Colour.PALE_BLUE, true);
		WritableCellFormat cf_cty_center = ExcelFormat.cellFormat(WritableFont.ARIAL, 16, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.CENTRE, null, null, null, false);

		//Phuong Nam - START
	    s.mergeCells(0, row, 4, row);
	    s.addCell(new Label(0, row++, "CÔNG TY TNHH TM DV VĂN PHÒNG PHẨM PHƯƠNG NAM", cf_cty_center));

	    row += 1;
	    s.mergeCells(0, row, 4, row);
	    s.addCell(new Label(col, row++, "TỒNG SỐ KHÁCH HÀNG TRONG KỲ", cf_center_bold));
	    
	    s.mergeCells(0, row, 4, row);
	    s.addCell(new Label(col, row++, "(Tổng hợp từ ngày " + reportBean.getTuNgay() + " đến " + reportBean.getDenNgay() +")", cf_center_bold_10));

	    //Khach hang Start
	    row += 1;
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(7), "STT");//new Integer(0) is set Auto, null don't set anything
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(0), "    Mã KH    ");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(0), "Tên KH");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(0), "Doanh số");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(0), "Ghi chú");
	    return row++;
	}

	private int addHBodyMatHang(List<BCTongHop> bcs, ReportCongNoKHBean reportBean, WritableSheet s, int index, int row) throws RowsExceededException, WriteException {
		int col = 0;
		WritableCellFormat cf_right_border_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, true, Alignment.RIGHT, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_left_border = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.LEFT, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_center_border = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_number_right = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.RIGHT, Border.ALL, BorderLineStyle.THIN, null, false, "#,##");
		WritableCellFormat cf_number_right_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, true, Alignment.RIGHT, Border.ALL, BorderLineStyle.THIN, null, false, "#,##");
    	BCTongHop bc = null;
    	String dtCongNoId = bcs.get(index).getDoiTuongCongNoID();
    	int i = index, k =index, stt = 1;
    	int ck = 0;
    	if (reportBean.getChietKhau() != null && !"".equals(reportBean.getChietKhau())) {
			ck = Integer.parseInt(reportBean.getChietKhau());
		}
    	int rowStartSum = row + 2;
		for(; bcs != null && i < bcs.size() && dtCongNoId.equals(bcs.get(i).getDoiTuongCongNoID()); i++){
			bc = bcs.get(i);
			dtCongNoId = bcs.get(i).getDoiTuongCongNoID();
			if(bc.getSoLuong()!= null && bc.getSoLuong() > 0 && bc.getDonGia()!= null && bc.getDonGia()>0){
				String tenVatTu = bc.getTenVatTu();
				boolean isExist = false;
				int soLuong = 0;
				for (int j = k ; bcs != null && j < bcs.size() && !isExist
				 && dtCongNoId.equals(bcs.get(j).getDoiTuongCongNoID()); j++) {
					BCTongHop bcTemp = bcs.get(j);		
					if(tenVatTu.equals(bcTemp.getTenVatTu())){
						soLuong += bcTemp.getSoLuong();
						if(j < i) {
							isExist = true;
						}
					}
				}
				if (!isExist) {
					col = colStart;
					row = row + 1;
					int rowf = row + 1;
					s.addCell(new Number(col++, row, stt++, cf_center_border));
					s.addCell(new Label(col++, row, bc.getTenVatTu(), cf_left_border));
					s.addCell(new Label(col++, row, bc.getdVT(), cf_center_border));
					s.addCell(new Number(col++, row, soLuong, cf_center_border));
					s.addCell(new Number(col++, row, bc.getDonGia(), cf_number_right));
					Formula thanhTien = new Formula(col++, row, "D"+ rowf + "*E" + rowf, cf_number_right);
					s.addCell(thanhTien);
					s.addCell(new Number(col++, row, ck, cf_number_right));
					Formula tienCk = new Formula(col++, row, "IF(G" + rowf + "<50,G" + rowf +  "/100*F" + rowf + ",G" + rowf +  "*D" + rowf + ")", cf_number_right);
					s.addCell(tienCk);
				}
			}
		}		
		int rowEndSum = row + 1;
		col = col - 3;
		s.mergeCells(0, ++row, 4, row);	    
	    s.addCell(new Label(0, row, "Tổng cộng: ", cf_right_border_bold));
	    Formula tongTien = new Formula(col++, row, "SUM(F" + rowStartSum + ":F" + rowEndSum +")", cf_number_right_bold);
	    s.addCell(tongTien);

	    
	    s.addCell(new Label(col++, row, "Tộng tiền CK:", cf_right_border_bold));
	    
	    Formula tongCKTheoTien = new Formula(col++, row, "SUM(H" + rowStartSum + ":H" + rowEndSum +")", cf_number_right_bold);
	    s.addCell(tongCKTheoTien);

		WritableCellFormat cf_center_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, true, Alignment.CENTRE, null, null, null, false);

	    row += 2;
	    s.mergeCells(6, row, 7, row);
	    s.addCell(new Label(6, row++, "Người lập phiếu", cf_center_bold));
	    
	    s.mergeCells(6, row, 7, row);
	    s.addCell(new Label(6, row, "(Ký, ghi rõ họ tên)", cf_center_bold));
	    
	    row += 4;
	    s.mergeCells(6, row, 7, row);
	    s.addCell(new Label(6, row, "Lê Thị Kim Anh", cf_center_bold));
	    
		return i;
		
	}

	private int addHeaderMatHang(BCTongHop bc, ReportCongNoKHBean reportBean, WritableSheet s) throws WriteException {
		int col = colStart, row = rowStart;
		ThongTinKhachHang pn = bc.getThongTinKhachHang();
	    /* Format the Font */ 
		WritableCellFormat cf_center_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 16, true, Alignment.CENTRE, null, null, null, false);
		WritableCellFormat cf_center_bold_10 = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, null, null, null, false);
		WritableCellFormat cf = ExcelFormat.cellFormat(WritableFont.ARIAL, 12, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, Colour.PALE_BLUE, true);
		WritableCellFormat cf_cty_center = ExcelFormat.cellFormat(WritableFont.ARIAL, 13, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.CENTRE, null, null, null, false);
		WritableCellFormat cf_dchi_center = ExcelFormat.cellFormat(WritableFont.ARIAL, 12, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.CENTRE, null, null, null, false);
		WritableCellFormat cf_cty_left = ExcelFormat.cellFormat(WritableFont.ARIAL, 12, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.LEFT, null, null, null, false);

		//Phuong Nam - START
	    s.mergeCells(0, row, 5, row);
	    s.addCell(new Label(0, row++, "CÔNG TY TNHH TM DV VĂN PHÒNG PHẨM PHƯƠNG NAM", cf_cty_center));

	    s.mergeCells(0, row, 5, row);
	    s.addCell(new Label(0, row++, "Địa chỉ: P5-06, KDC Phi Long, Nguyễn Văn Linh, Bình Hưng, Bình Chánh, HCM" , cf_dchi_center));
	    
	    s.mergeCells(0, row, 5, row);
	    s.addCell(new Label(0, row++, "MST: " + pn.getMasoThue(), cf_cty_center));

	    //Tieu de - Start
	    row += 2;
	    s.mergeCells(0, row, 5, row);
	    s.addCell(new Label(col, row++, "CHIẾT KHẤU THEO DANH MỤC HÀNG HÓA", cf_center_bold));
	    
	    s.mergeCells(0, row, 5, row);
	    s.addCell(new Label(col, row++, "(Tổng hợp từ ngày " + reportBean.getTuNgay() + " đến " + reportBean.getDenNgay() +")", cf_center_bold_10));


	    //Khach hang Start
	    row += 2;
	    //s.addCell(new Label(0, row++, "Họ tên người mua hàng: " + bc.getTenDoiTuongCongNo(), cf_cty_left));
	    s.addCell(new Label(0, row++, "Tên đơn vị: " + bc.getTenDoiTuongCongNo(), cf_cty_left));
	    s.addCell(new Label(0, row++, "Điạ chỉ: " + bc.getDiaChi(), cf_cty_left));
	    s.addCell(new Label(0, row++, "MST: " + bc.getMaSothue(), cf_cty_left));

	    ExcelFormat.createCell(s, cf, col++, row, new Integer(7), "STT");//new Integer(0) is set Auto, null don't set anything
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(35), "Tên hàng");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(8), "ĐVT");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(8), "Tổng SL");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(13), "Đơn giá");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(14), "Thành tiền");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(26), "Chiết khấu tiền or % (số < 50 là %)");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(17), "Thành tiền CK");
	    return row++;
	}

	private int addHBodyCongNo(List<BCTongHop> bcs, WritableSheet s, int index, int row, ReportCongNoKHBean reportBean) throws RowsExceededException, WriteException {
		int col = 0;
		WritableCellFormat cf_right_border_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, true, Alignment.RIGHT, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_left_border = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.LEFT, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_center_border = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_center_border_wrap = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, null, true);
		WritableCellFormat cf_number_right_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, true, Alignment.RIGHT, Border.ALL, BorderLineStyle.THIN, null, false, "#,##");
		WritableCellFormat cf_number_right = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.RIGHT, Border.ALL, BorderLineStyle.THIN, null, false, "#,##");
		
    	BCTongHop bc = null;
    	String oldCT = "";
    	String dtCongNoId = bcs.get(index).getDoiTuongCongNoID();
    	double thanhTien = 0;
    	double tongCong = 0;
    	int i = index, rowStartSession = 0;
    	int rowStartSum = row + 2;
    	String column = "G";
		int columnIndex = 5;
		if (reportBean.getIsShowMaHang()) {
			columnIndex = 6;
			column = "H";
		}
		for(; bcs != null && i < bcs.size() && dtCongNoId.equals(bcs.get(i).getDoiTuongCongNoID()); i++){
			bc = bcs.get(i);
			dtCongNoId = bcs.get(i).getDoiTuongCongNoID();
			if(bc.getSoLuong()!= null && bc.getSoLuong() > 0 && bc.getDonGia()!= null && bc.getDonGia()>0){
				col = colStart;
				row = row + 1;
				int rowf = row + 1;
				String dateCT = PNConstant.getDayFormat(bc.getNgayNhap(), "dd/MM/yyyy");
				if (!oldCT.equals(bc.getSoCT())) {
					oldCT = bc.getSoCT();
					String ct = bc.getSoCT();
					if(bc.getvAT_Seri() != null && !"".equals(bc.getvAT_Seri())){
						ct = ct + "\n" + bc.getvAT_Seri();
						cf_center_border = cf_center_border_wrap;
					}
					s.addCell(new Label(col++, row, dateCT, cf_center_border));
					s.addCell(new Label(col++, row, ct, cf_center_border));
					thanhTien = 0;
					rowStartSession = row + 1;
				} else {
					s.addCell(new Label(col++, row, " ", cf_center_border));
					s.addCell(new Label(col++, row, " ", cf_center_border));
				}
				thanhTien = thanhTien + bc.getSoLuong()*bc.getDonGia();
				tongCong += bc.getSoLuong()*bc.getDonGia();
				if (reportBean.getIsShowMaHang()) {
					s.addCell(new Label(col++, row, bc.getVatTuID(), cf_left_border));
				}
				s.addCell(new Label(col++, row, bc.getTenVatTu(), cf_left_border));
				s.addCell(new Label(col++, row, bc.getdVT(), cf_center_border));
				s.addCell(new Number(col++, row, bc.getSoLuong(), cf_center_border));
				s.addCell(new Number(col++, row, bc.getDonGia(), cf_number_right));
				Formula thanhTienRow = null;
				if (reportBean.getIsShowMaHang()) {
					thanhTienRow = new Formula(col++, row, "F"+ rowf + "*G" + rowf, cf_number_right);
				} else {
					thanhTienRow = new Formula(col++, row, "E"+ rowf + "*F" + rowf, cf_number_right);
				}
				s.addCell(thanhTienRow);
				if ((i < bcs.size()-1  && !oldCT.equals(bcs.get(i+1).getSoCT()) || i == bcs.size() - 1)) {
					row +=1;
					s.mergeCells(0, row, columnIndex + 1, row);
					s.addCell(new Label(0, row, " ", cf_center_border));
					Formula tongTienSession = new Formula(0, row, "SUM(" + column + rowStartSession + ":" + column + row +")", cf_number_right_bold);
					s.addCell(tongTienSession);
				}
			}
		}		
		int rowEndSum = row + 1;
		s.mergeCells(0, ++row, columnIndex, row);
	    s.addCell(new Label(0, row, "Cộng: ", cf_right_border_bold));
		Formula tongCKTheoTien = new Formula(col-1, row, "SUM(" + column + rowStartSum + ":" + column + rowEndSum +")", cf_number_right_bold);
	    s.addCell(tongCKTheoTien);

	    s.mergeCells(0, ++row, columnIndex, row);
	    s.addCell(new Label(0, row, "VAT 10%: ", cf_right_border_bold));
	    Formula tienVat  = new Formula(col-1, row, column + row + "*0.1", cf_number_right_bold);
		s.addCell(tienVat);

		s.mergeCells(0, ++row, columnIndex, row);	    
	    s.addCell(new Label(0, row, "Tổng cộng: ", cf_right_border_bold));	    
	    Formula tongCongTien  = new Formula(col-1, row ++ , column + (row - 2) + "+" + column  + (row - 1), cf_number_right_bold);
	    s.addCell(tongCongTien);

		//Add Footer
		WritableCellFormat cf_left = ExcelFormat.cellFormat(WritableFont.ARIAL, 12, false, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.LEFT, null, null, null, false);
		WritableCellFormat cf_center = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, null, null, null, false);
	    s.addCell(new Label(0, row++, "Quý công ty xem xét công nợ như trên. Mọi thắc mắc xin vui lòng liên hệ: " + (bcs.get(0)).getThongTinKhachHang().getDienThoai(), cf_left));

		row = row + 1;
	    s.mergeCells(0, row, 1, row);
	    s.addCell(new Label(0, row, "Khách hàng xác nhận", cf_center));	    

	    s.mergeCells(2, row, 3, row);
	    s.addCell(new Label(2, row, "Kế toán", cf_center));
	    
	    s.mergeCells(4, row, 6, row);
	    s.addCell(new Label(4, row, "Người lập phiếu", cf_center));
		return i;
	}

	private int addHeaderCongNo(BCTongHop bc, ReportCongNoKHBean reportBean, WritableSheet s) throws WriteException {
		int col = colStart, row = rowStart;
		ThongTinKhachHang pn = bc.getThongTinKhachHang();
	    /* Format the Font */ 
		WritableCellFormat cf_center_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 16, true, Alignment.CENTRE, null, null, null, false);
		WritableCellFormat cf_center = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, null, null, null, false);
		WritableCellFormat cf = ExcelFormat.cellFormat(WritableFont.ARIAL, 12, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, Colour.PALE_BLUE, true);
		WritableCellFormat cf_cty = ExcelFormat.cellFormat(WritableFont.ARIAL, 12, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.LEFT, null, null, null, false);
		WritableCellFormat cf_cty_left = ExcelFormat.cellFormat(WritableFont.ARIAL, 13, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.LEFT, null, null, null, false);
		//Phuong Nam - START
	    s.addCell(new Label(0, row-1, "CÔNG TY TNHH TM DV VĂN PHÒNG PHẨM PHƯƠNG NAM", cf_cty_left));
	    s.addCell(new Label(0, row++, "Điạ chỉ: " + pn.getDiaChi(), cf_cty));
	    s.addCell(new Label(0, row++, "Điện thoại: " + pn.getDienThoai(), cf_cty));
	    s.addCell(new Label(0, row++, "MST: " + pn.getMasoThue(), cf_cty));
	    //Tieu de - Start
	    Label l = new Label(col, row, "BẢNG CHI TIẾT CÔNG NỢ PHẢI THU", cf_center_bold);
	    s.mergeCells(0, row, 6, row++);
	    s.addCell(l);
	    Label lThang = new Label(col, row, "Từ ngày "+ reportBean.getTuNgay() + " đến ngày " + reportBean.getDenNgay(), cf_center);
	    s.mergeCells(0, row, 6, row++);
	    s.addCell(lThang);
	    //Khach hang Start
	    s.addCell(new Label(0, row++, bc.getTenDoiTuongCongNo(), cf_cty_left));
	    s.addCell(new Label(0, row++, "Điạ chỉ: " + bc.getDiaChi(), cf_cty));
	    s.addCell(new Label(0, row++, "Điện thoại: " + bc.getDienThoai(), cf_cty));
	    s.addCell(new Label(0, row++, "Người giao dịch: " + bc.getNguoiGiaoDich(), cf_cty));
	    
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(10), "Ngày");//new Integer(0) is set Auto, null don't set anything
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(13), "Số CT");
	    if (reportBean.getIsShowMaHang()) {
	    	ExcelFormat.createCell(s, cf, col++, row, new Integer(15), "Mã hàng");
		}
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(40), "Tên hàng");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(8), "ĐVT");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(8), "SL");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(13), "Đơn giá");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(14), "Thành Tiền");
	    return row++;
	}
	private int addHeaderBangKe(BCTongHop bc, ReportCongNoKHBean reportBean, WritableSheet s) throws WriteException {
		int col = colStart, row = rowStart;
		Calendar toDay = Calendar.getInstance();
		int year = toDay.get(Calendar.YEAR);
		ThongTinKhachHang pn = bc.getThongTinKhachHang();
	    /* Format the Font */ 
		WritableCellFormat cf_center_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 16, true, Alignment.CENTRE, null, null, null, false);
		WritableCellFormat cf_center = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, null, null, null, false);
		WritableCellFormat cf = ExcelFormat.cellFormat(WritableFont.ARIAL, 12, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, Colour.PALE_BLUE, true);
		WritableCellFormat cf_cty_center = ExcelFormat.cellFormat(WritableFont.ARIAL, 13, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.CENTRE, null, null, null, false);
		WritableCellFormat cf_dchi_center = ExcelFormat.cellFormat(WritableFont.ARIAL, 12, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.CENTRE, null, null, null, false);
		WritableCellFormat cf_cty_left = ExcelFormat.cellFormat(WritableFont.ARIAL, 12, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.LEFT, null, null, null, false);
		//Phuong Nam - START
	    s.mergeCells(0, row, 5, row);
	    s.addCell(new Label(0, row++, "CÔNG TY TNHH TM DV VĂN PHÒNG PHẨM PHƯƠNG NAM", cf_cty_center));

	    s.mergeCells(0, row, 5, row);
	    s.addCell(new Label(0, row++, "Địa chỉ: P5-06, KDC Phi Long, Nguyễn Văn Linh, Bình Hưng, Bình Chánh, HCM" , cf_dchi_center));
	    
	    s.mergeCells(0, row, 5, row);
	    s.addCell(new Label(0, row++, "MST: " + pn.getMasoThue(), cf_cty_center));

	    //Tieu de - Start
	    row += 2;
	    s.mergeCells(0, row, 5, row);
	    s.addCell(new Label(col, row++, "BẢNG KÊ DANH MỤC HÀNG HÓA", cf_center_bold));
	    
	    s.mergeCells(0, row, 5, row);
	    s.addCell(new Label(col, row++, "(Xuất kèm HĐGTGT số :  PN/11P  -  000    Ngày  0  tháng  0  năm " + year + ")", cf_center));


	    //Khach hang Start
	    row += 2;
	    //s.addCell(new Label(0, row++, "Họ tên người mua hàng: " + bc.getTenDoiTuongCongNo(), cf_cty_left));
	    s.addCell(new Label(0, row++, "Tên đơn vị: " + bc.getTenDoiTuongCongNo(), cf_cty_left));
	    s.addCell(new Label(0, row++, "Điạ chỉ: " + bc.getDiaChi(), cf_cty_left));
	    s.addCell(new Label(0, row++, "MST: " + bc.getMaSothue(), cf_cty_left));

	    ExcelFormat.createCell(s, cf, col++, row, new Integer(7), "STT");//new Integer(0) is set Auto, null don't set anything
	    if (reportBean.getIsShowMaHang()) {
	    	ExcelFormat.createCell(s, cf, col++, row, new Integer(15), "Mã hàng");
		}
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(35), "Tên hàng");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(8), "ĐVT");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(8), "SL");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(13), "Đơn giá");
	    ExcelFormat.createCell(s, cf, col++, row, new Integer(14), "Thành Tiền");
	    return row++;
	}
	private int addHBodyBangKe(List<BCTongHop> bcs, WritableSheet s, int index, int row, ReportCongNoKHBean reportBean) throws RowsExceededException, WriteException {
		int col = 0;
		WritableCellFormat cf_right_border_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, true, Alignment.RIGHT, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_left_border = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.LEFT, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_center_border = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_number_right = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, false, Alignment.RIGHT, Border.ALL, BorderLineStyle.THIN, null, false, "#,##");
		WritableCellFormat cf_number_right_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, true, Alignment.RIGHT, Border.ALL, BorderLineStyle.THIN, null, false, "#,##");
		WritableCellFormat cf_center_bold = ExcelFormat.cellFormat(WritableFont.ARIAL, 10, true, Alignment.CENTRE, null, null, null, false);
    	BCTongHop bc = null;
    	String dtCongNoId = bcs.get(index).getDoiTuongCongNoID();
    	int i = index;
    	int rowStartSum = row +2;
    	String column = "F";
		int columnIndex = 4;
		if (reportBean.getIsShowMaHang()) {
			columnIndex = 5;
			column = "G";
		}
		for(; bcs != null && i < bcs.size() && dtCongNoId.equals(bcs.get(i).getDoiTuongCongNoID()); i++){
			bc = bcs.get(i);
			dtCongNoId = bcs.get(i).getDoiTuongCongNoID();
			if(bc.getSoLuong()!= null && bc.getSoLuong() > 0 && bc.getDonGia()!= null && bc.getDonGia()>0){
				col = colStart;
				row = row + 1;
				int rowf = row + 1;
				s.addCell(new Number(col++, row, i + 1, cf_center_border));
				if (reportBean.getIsShowMaHang()) {
					s.addCell(new Label(col++, row, bc.getVatTuID(), cf_left_border));
				}
				s.addCell(new Label(col++, row, bc.getTenVatTu(), cf_left_border));
				s.addCell(new Label(col++, row, bc.getdVT(), cf_center_border));
				s.addCell(new Number(col++, row, bc.getSoLuong(), cf_center_border));
				s.addCell(new Number(col++, row, bc.getDonGia(), cf_number_right));
				Formula thanhTien = null;
				if (reportBean.getIsShowMaHang()) {
					thanhTien = new Formula(col++, row, "E"+ rowf + "*F" + rowf, cf_number_right);
				} else {
					thanhTien = new Formula(col++, row, "D"+ rowf + "*E" + rowf, cf_number_right);
				}
				s.addCell(thanhTien);
			}
		}		
		int rowEndSum = row + 1;

		s.mergeCells(0, ++row, columnIndex, row);
	    s.addCell(new Label(0, row, "Cộng: ", cf_right_border_bold));
	    Formula tongTien = new Formula(col-1, row, "SUM(" + column + rowStartSum + ":"+ column + rowEndSum +")", cf_number_right_bold);
	    s.addCell(tongTien);

	    s.mergeCells(0, ++row, columnIndex, row);
	    s.addCell(new Label(0, row, "VAT 10%: ", cf_right_border_bold));

	    Formula tienVat  = new Formula(col-1, row, column + row + "*0.1", cf_number_right_bold);
	    s.addCell(tienVat);

		s.mergeCells(0, ++row, columnIndex, row);	    
	    s.addCell(new Label(0, row, "Tổng cộng: ", cf_right_border_bold));	    
	    Formula tongCongTien  = new Formula(col-1, row ++ , column + (row - 2) + "+" + column + (row - 1), cf_number_right_bold);
	    s.addCell(tongCongTien);

	    row += 2;
	    s.mergeCells(4, row, 5, row);
	    s.addCell(new Label(4, row++, "Người lập phiếu", cf_center_bold));
	    
	    s.mergeCells(4, row, 5, row);
	    s.addCell(new Label(4, row, "(Ký, ghi rõ họ tên)", cf_center_bold));
	    
	    row += 4;
	    s.mergeCells(4, row, 5, row);
	    s.addCell(new Label(4, row, "Lê Thị Kim Anh", cf_center_bold));
	    
		return i;
	}
	@SuppressWarnings("unchecked")
	//base on from date to date
	public void createReport_CNO_BKE_ForAllCustomer(Map<String, Object> model) {
		List<BCTongHop> bcCongNo = (List<BCTongHop>) model.get("bcCongNo");
		ReportCongNoKHBean reportBean = (ReportCongNoKHBean) model.get("reportBean");
		try {
			WorkbookSettings ws = new WorkbookSettings();
			ws.setLocale(new Locale("vi", "VN"));
			String month = (reportBean.getDenNgay().split("/"))[1];
			int index = 0;
			String path = PNConstant.pathCongNo + PNConstant.getDayFormat(new Date(), "dd-MM-yyyy") + "\\";
			File file = new File(path);
			file.mkdirs();
			int rowNext = 0;
			while (index < bcCongNo.size()) {
				int i = index;
				String fileName = path + bcCongNo.get(i).getDoiTuongCongNoID() + "_T"+ month + ".xls";
				WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName), ws);
				String nameSheet = bcCongNo.get(i).getDoiTuongCongNoID();

//				WritableSheet sheet = workbook.createSheet(nameSheet, sheetIndex++);
//				rowNext = addHeaderCongNo(bcCongNo.get(i), reportBean, sheet);
//				index = addHBodyCongNo(bcCongNo, sheet, i, rowNext);
				
				if(reportBean.getIsCongNo()){
					WritableSheet sheetCN = workbook.createSheet("CONGNO_" + nameSheet, 0);
					rowNext = addHeaderCongNo(bcCongNo.get(i), reportBean, sheetCN);
					index = addHBodyCongNo(bcCongNo, sheetCN, i, rowNext, reportBean);
				} 
				if(reportBean.getIsBangKe()){
					WritableSheet sheetBK = workbook.createSheet("BANGKE_" + nameSheet, 1);
					rowNext = addHeaderBangKe(bcCongNo.get(i), reportBean, sheetBK);
					index = addHBodyBangKe(bcCongNo, sheetBK, i, rowNext, reportBean);
				}
				
				
				workbook.write();
				workbook.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	//base on from date to date
	public void createReportBangKeForAllCustomer(Map<String, Object> model) {
		List<BCTongHop> bcCongNo = (List<BCTongHop>) model.get("bcCongNo");
		ReportCongNoKHBean reportBean = (ReportCongNoKHBean) model.get("reportBean");
		try {
			WorkbookSettings ws = new WorkbookSettings();
			ws.setLocale(new Locale("vi", "VN"));
			String month = (reportBean.getDenNgay().split("/"))[1];
			int index = 0;
			int sheetIndex = 0;
			String path = PNConstant.pathCongNo + PNConstant.getDayFormat(new Date(), "dd-MM-yyyy") + "\\";
			File file = new File(path);
			file.mkdirs();
			int rowNext = 0;
			while (index < bcCongNo.size()) {
				String fileName = path + "B_KE_HĐ_" + bcCongNo.get(index).getDoiTuongCongNoID() + "_T"+ month + ".xls";
				WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName), ws);
				String nameSheet = bcCongNo.get(index).getDoiTuongCongNoID();
				WritableSheet sheet = workbook.createSheet(nameSheet, sheetIndex++);
				rowNext = addHeaderBangKe(bcCongNo.get(index), reportBean, sheet);
				index = addHBodyBangKe(bcCongNo, sheet, index, rowNext, reportBean);
				workbook.write();
				workbook.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
}