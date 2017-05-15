package com.pn.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import jxl.CellView;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableFont.FontName;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * 
 * @author lle22
 *
 */
public class ExcelFormat{
	/**
	 * Format number
	 * @param fn
	 * @param ps
	 * @param isBold
	 * @param alignment
	 * @param border
	 * @param borderLineStyle
	 * @param bgColour
	 * @param wrap
	 * @param numberFormat
	 * @return
	 * @throws WriteException
	 */
	public static WritableCellFormat cellFormat(FontName fn, int ps, boolean  isBold, Alignment alignment, Border border, BorderLineStyle borderLineStyle, Colour bgColour, boolean wrap, String numberFormat) throws WriteException{
		NumberFormat nf = new NumberFormat(numberFormat);
		WritableFont font = new WritableFont(fn, ps, isBold?WritableFont.BOLD:WritableFont.NO_BOLD);
		WritableCellFormat cf = new WritableCellFormat(font, nf);
		if(alignment != null){
			cf.setAlignment(alignment);
		}
		if (borderLineStyle != null) {
			cf.setBorder(border, borderLineStyle);
		}
		if (bgColour != null) {
			cf.setBackground(bgColour);
		}
		cf.setWrap(wrap); 
		return cf;
	}
	/**
	 * Format cell
	 * @param fn the Font name
	 * @param ps the point size
	 * @param isBold 
	 * @param alignment
	 * @param border
	 * @param borderLineStyle
	 * @param bgColour
	 * @param wrap
	 * @throws WriteException
	 */
	public static WritableCellFormat cellFormat(FontName fn, int ps, boolean  isBold, Alignment alignment, Border border, BorderLineStyle borderLineStyle, Colour bgColour, boolean wrap) throws WriteException{
		WritableFont wf = new WritableFont(fn, ps, isBold?WritableFont.BOLD:WritableFont.NO_BOLD);
		WritableCellFormat cf = new WritableCellFormat(wf);
		if(alignment != null){
			cf.setAlignment(alignment);
		}
		if (borderLineStyle != null) {
			cf.setBorder(border, borderLineStyle);
		}
		if (bgColour != null) {
			cf.setBackground(bgColour);
		}
		cf.setWrap(wrap); 
		return cf;
	}
	/**
	 * 
	 * @param fn the font name	
	 * @param ps the point size	
	 * @param isBold 
	 * @param fontColour text color
	 * @param isItalic 
	 * @param underlineStyle
	 * @param alignment
	 * @param border
	 * @param borderLineStyle
	 * @param bgColour cell color
	 * @param wrap
	 * @throws WriteException
	 */
	public static WritableCellFormat cellFormat(FontName fn, int ps, boolean isBold, Colour fontColour,
			boolean isItalic, UnderlineStyle underlineStyle, Alignment alignment, Border border,
			BorderLineStyle borderLineStyle, Colour bgColour, boolean wrap)	throws WriteException {
		
		WritableFont wf = new WritableFont(fn, ps, isBold?WritableFont.BOLD:WritableFont.NO_BOLD, isItalic, underlineStyle, fontColour); 
		WritableCellFormat cf = new WritableCellFormat(wf);
		if(alignment != null){
			cf.setAlignment(alignment);
		}
		if (borderLineStyle != null) {
			cf.setBorder(border, borderLineStyle);
		}
		if (bgColour != null) {
			cf.setBackground(bgColour);
		}
		cf.setWrap(wrap);
		return cf;
	}
		
	private final int rowStart = 1;
	private final int colStart = 0;
	/*
	private void scrReportRequestGenerate(RequestContext rc) {
		String reportType = rc.getRequestParameter("ReportType").toString();
		HttpServletResponse response = rc.getResponse();
		WritableWorkbook w = null;
		try {
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=" + reportType + "Report.xls");
			w = Workbook.createWorkbook(response.getOutputStream());
			WritableSheet s = w.createSheet("Sheet", 0);			
			Vector vec;
			if ("SCR".equalsIgnoreCase(reportType)) {
				 vec = getScrReportData(rc);
			} else {
				vec = getVdnReportData(rc);
			}
			addHeaderScrVdnRequest(vec, s, reportType);
			addBodyScrVdnRequest(vec, s, reportType);
			w.write();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				w.close();
			} catch (WriteException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}*/
/*
	private void addBodyScrVdnRequest(Vector vec, WritableSheet s, String reportType) throws RowsExceededException, WriteException{
		ScrVdnReportVO vo;
		int col = 0 , row = rowStart;
		double totalAmout = 0.0;
		WritableCellFormat cf_center_bold = cellFormat(WritableFont.ARIAL, 10, true, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, Colour.LIGHT_ORANGE, false);
		WritableCellFormat cf_left = cellFormat(WritableFont.ARIAL, 10, false, Alignment.LEFT, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_left1 = cellFormat(WritableFont.ARIAL, 10, false, Alignment.LEFT, Border.ALL, BorderLineStyle.THIN, Colour.LIGHT_TURQUOISE2, false);
		WritableCellFormat cf_center = cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, null, false);
		WritableCellFormat cf_center1 = cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, Colour.LIGHT_TURQUOISE2, false);
		WritableCellFormat tempCenter = cf_center;
		WritableCellFormat templeft = cf_center;
    	DecimalFormat df = new DecimalFormat("#.##");
		for(int i = 0; vec != null && i < vec.size(); i++){
			col = colStart;
			row = row + 1;
			s.addCell(new Number(col++, row, Double.parseDouble(vo.getScrVdnNumber()), tempCenter));
			s.addCell(new Label(col++, row, vo.getProductTypeDesc() + "  ", templeft));
			s.addCell(new Number(col++, row, Double.parseDouble(vo.getIncentive()), tempCenter));
			s.addCell(new Number(col++, row, Double.parseDouble(vo.getParity()), tempCenter));
			s.addCell(new Number(col++, row, Double.parseDouble(vo.getQuantity()), tempCenter));
			s.addCell(new Label(col++, row, vo.getTsoID(), cf_center));
			s.addCell(new Label(col++, row, vo.getTsoName(), cf_left));
			s.addCell(new Number(col++, row, Double.parseDouble(vo.getRegion()), cf_center));
			totalAmout = totalAmout + (Double.parseDouble(vo.getIncentive()) + Double.parseDouble(vo.getParity())) * Double.parseDouble(vo.getQuantity());
			if (true) {
				row = row + 1;
				col = 0;
				Label l = new Label(col++, row, "Total approved dollar amouts by " + vo.getTsoID() + " is " + df.format(totalAmout), cf_center_bold);
			    s.mergeCells(0, row, 7, row);
			    s.addCell(l);
				totalAmout = 0.0;
			}
		}		
	}

	/**
	 * Loile 3 Oct 2010 Create Cell
	 * @param s
	 * @param cf
	 * @param col
	 * @param row
	 * @param size
	 * @param value
	 * @throws WriteException
	 */
	public static void createCell(WritableSheet s, WritableCellFormat cf, int col, int row, Integer size, Object value) throws WriteException{
		if (value instanceof Double) {
			s.addCell(new Number(col, row, Double.parseDouble(value.toString()), cf));
		} else {
			s.addCell(new Label(col, row, value.toString(), cf));
		}
		CellView cell=s.getColumnView(col);
		if (size != null) {
			if (size.intValue() == 0) {
				cell.setAutosize(true);
				s.setColumnView(col, cell);
			} else {
				s.setColumnView(col, size.intValue());
			}
		}
	}
	/**
	 * LOILE 13 Oct 2010 add Header for Excel file
	 * @param vec
	 * @param s
	 * @throws WriteException
	 */
	private void addHeaderClosedPending(Vector vec, WritableSheet s) throws WriteException {
		int col = colStart, row = rowStart;
	    /* Format the Font */ 
		WritableCellFormat cf = cellFormat(WritableFont.ARIAL, 8, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, Colour.PALE_BLUE, true);
		WritableCellFormat cf_date = cellFormat(WritableFont.ARIAL, 8, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.LEFT, null, null, null, false);
	    s.addCell(new Label(0, row-1, "Date:", cf_date));
	    SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");  
	    Date newDate = new Date();
	    String newdate = dateformat.format(newDate);	    
	    s.addCell(new Label(1, row-1, newdate, cf_date));
		createCell(s, cf, col++, row, new Integer(4), "Ter");//new Integer(0) is set Auto, null don't set anything
		createCell(s, cf, col++, row, new Integer(4), "Sub");
		createCell(s, cf, col++, row, new Integer(0), "Acct #");
		createCell(s, cf, col++, row, new Integer(22), "ACCT NAME");
		createCell(s, cf, col++, row, new Integer(24), "Target Product");
		createCell(s, cf, col++, row, new Integer(15), " MODEL # ");
		createCell(s, cf, col++, row, new Integer(0), " VDN # ");
		createCell(s, cf, col++, row, new Integer(10), "VDN Status");
		//CUONGBUI: added for issue#138 - Start
		//HOANGDOAN: added for issue#159 - Start
		createCell(s, cf, col++, row, new Integer(10), "VDN WLM");
		/*createCell(s, cf, col++, row, new Integer(6), "VDN AtRisk");
		createCell(s, cf, col++, row, new Integer(9), "VDN AtGrowth");*/
		createCell(s, cf, col++, row, new Integer(13), "Growth Profitability PFP");
		//HOANGDOAN: added for issue#159 - End
		createCell(s, cf, col++, row, new Integer(4), "VDN Qty");
		//CUONGBUI: added for issue#138 - End		
		createCell(s, cf, col++, row, new Integer(0), "SCR #");
		createCell(s, cf, col++, row, new Integer(10), "SCR Status");
		//CUONGBUI: added for issue#138
		//HOANGDOAN: added for issue#159 - Start
		createCell(s, cf, col++, row, new Integer(10), "SCR WLM");
		createCell(s, cf, col++, row, new Integer(6), "SCR AtRisk");
		createCell(s, cf, col++, row, new Integer(9), "SCR AtGrowth");
		//HOANGDOAN: added for issue#159 - End
		createCell(s, cf, col++, row, new Integer(5), "SCR AvailQty");
		//CUONGBUI: added for issue#138 - End
		createCell(s, cf, col++, row, new Integer(0), "VSCR #");
		createCell(s, cf, col++, row, new Integer(15), "VSCR Status");
		//CUONGBUI: added for issue#138 - Start
		//HOANGDOAN: added for issue#159 - Start
		/*createCell(s, cf, col++, row, new Integer(6), "VSCR AtRisk");
		createCell(s, cf, col++, row, new Integer(9), "VSCR AtGrowth");*/
		//HOANGDOAN: added for issue#159 - End
		createCell(s, cf, col++, row, new Integer(10), "Call Date");
		//CUONGBUI: added for issue#138 - End
		createCell(s, cf, col++, row, new Integer(10), "Author");
	}	
	
	private void addFooter(Vector vec, WritableSheet s) throws RowsExceededException, WriteException{	

	}	
}
