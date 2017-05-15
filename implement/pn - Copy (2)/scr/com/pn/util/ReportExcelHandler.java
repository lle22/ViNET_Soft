package com.pn.util;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.WritableFont.FontName;
import jxl.write.biff.RowsExceededException;
/**
 * 
 * @author lle22
 *
 */
public class ReportExcelHandler{
	//NOTEDEV Hoang Quang Doan 15 JULY 2011  *- Start
//	private WritableCellFormat cf;
//	/**
//	 * Format cell
//	 * @param fn the Font name
//	 * @param ps the point size
//	 * @param isBold 
//	 * @param alignment
//	 * @param border
//	 * @param borderLineStyle
//	 * @param bgColour
//	 * @param wrap
//	 * @throws WriteException
//	 */
//	public WritableCellFormat cellFormat(FontName fn, int ps, boolean  isBold, Alignment alignment, Border border, BorderLineStyle borderLineStyle, Colour bgColour, boolean wrap) throws WriteException{
//		WritableFont wf = new WritableFont(fn, ps, isBold?WritableFont.BOLD:WritableFont.NO_BOLD);
//		WritableCellFormat cf = new WritableCellFormat(wf);
//		if(alignment != null){
//			cf.setAlignment(alignment);
//		}
//		if (borderLineStyle != null) {
//			cf.setBorder(border, borderLineStyle);
//		}
//		if (bgColour != null) {
//			cf.setBackground(bgColour);
//		}
//		cf.setWrap(wrap); 
//		return cf;
//	}
//	/**
//	 * 
//	 * @param fn the font name	
//	 * @param ps the point size	
//	 * @param isBold 
//	 * @param fontColour text color
//	 * @param isItalic 
//	 * @param underlineStyle
//	 * @param alignment
//	 * @param border
//	 * @param borderLineStyle
//	 * @param bgColour cell color
//	 * @param wrap
//	 * @throws WriteException
//	 */
//	public WritableCellFormat cellFormat(FontName fn, int ps, boolean isBold, Colour fontColour,
//			boolean isItalic, UnderlineStyle underlineStyle, Alignment alignment, Border border,
//			BorderLineStyle borderLineStyle, Colour bgColour, boolean wrap)	throws WriteException {
//		
//		WritableFont wf = new WritableFont(fn, ps, isBold?WritableFont.BOLD:WritableFont.NO_BOLD, isItalic, underlineStyle, fontColour); 
//		WritableCellFormat cf = new WritableCellFormat(wf);
//		if(alignment != null){
//			cf.setAlignment(alignment);
//		}
//		if (borderLineStyle != null) {
//			cf.setBorder(border, borderLineStyle);
//		}
//		if (bgColour != null) {
//			cf.setBackground(bgColour);
//		}
//		cf.setWrap(wrap);
//		return cf;
//	}
//
//	private final int rowStart = 1;
//	private final int colStart = 0;
//
//	private void scrReportRequestGenerate(RequestContext rc) {
//		String reportType = rc.getRequestParameter("ReportType").toString();
//		HttpServletResponse response = rc.getResponse();
//		WritableWorkbook w = null;
//		try {
//			response.setContentType("application/vnd.ms-excel");
//			response.setHeader("Content-Disposition", "attachment; filename=" + reportType + "Report.xls");
//			w = Workbook.createWorkbook(response.getOutputStream());
//			WritableSheet s = w.createSheet("Sheet", 0);			
//			Vector vec;
//			if ("SCR".equalsIgnoreCase(reportType)) {
//				 vec = getScrReportData(rc);
//			} else {
//				vec = getVdnReportData(rc);
//			}
//			addHeaderScrVdnRequest(vec, s, reportType);
//			addBodyScrVdnRequest(vec, s, reportType);
//			w.write();			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				w.close();
//			} catch (WriteException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}
//	private Vector getVdnReportData(RequestContext rc) throws AppException {
//		Vector vec = null;
//		try {
//			String year = null;
//			if (rc.getRequest().getParameter("year") != null && !"0".equals(rc.getRequest().getParameter("year"))) {
//				year = rc.getRequest().getParameter("year").toString();
//			}
//			VdnSearchMgrHome searchVdnHome = (VdnSearchMgrHome) AccessCache.lookup(JNDIConstants.VDN_SEARCH);
//			VdnSearchMgr vdnSearchMgrRemote = searchVdnHome.create();
//			vec = vdnSearchMgrRemote.getVdnReportData(year);
//		} catch (AppException ae) {		
//			throw ae;
//		} catch (CreateException ce) {
//			AppException ae = new AppException("MSG000003");
//			ae.setAsSystemException();
//			throw ae;
//		} catch (RemoteException re) {
//			AppException ae = new AppException();
//			ae.setAsSystemException();
//			ErrorVO errVO = new ErrorVO();
//			errVO.setErrMsg(new ErrorMessage().getErrorMessage("MSG000003"));
//			errVO.setPageHeading("VdnReport");
//			errVO.setScreenId("VdnReport");
//			rc.getRequest().setAttribute("ErrorVO", errVO);
//			throw ae;
//			
//		} catch (Exception e) {
//			Logger.log(this.getClass().getName(),Logger.SEVERE,	userObject.getUserId(),	e.getMessage(),	e);
//		}
//		return vec;
//	}
//	private Vector getScrReportData(RequestContext rc) throws AppException {
//		Vector vec = null;
//		try {
//			String year = null;
//			if (rc.getRequest().getParameter("year") != null && !"0".equals(rc.getRequest().getParameter("year"))) {
//				year = rc.getRequest().getParameter("year").toString();
//			}
//			ScrSearchMgrHome searchScrHome = (ScrSearchMgrHome) AccessCache.lookup(JNDIConstants.SCR_SEARCH);
//			ScrSearchMgr scrSearchMgrRemote = searchScrHome.create();
//			vec = scrSearchMgrRemote.getScrReportData(year);
//		} catch (AppException ae) {		
//			throw ae;
//		} catch (CreateException ce) {
//			AppException ae = new AppException("MSG000003");
//			ae.setAsSystemException();
//			throw ae;
//		} catch (RemoteException re) {
//			AppException ae = new AppException();
//			ae.setAsSystemException();
//			ErrorVO errVO = new ErrorVO();
//			errVO.setErrMsg(new ErrorMessage().getErrorMessage("MSG000003"));
//			errVO.setPageHeading("ScrReport");
//			errVO.setScreenId("ScrReport");
//			rc.getRequest().setAttribute("ErrorVO", errVO);
//			throw ae;
//			
//		} catch (Exception e) {
//			Logger.log(this.getClass().getName(),Logger.SEVERE,	userObject.getUserId(),	e.getMessage(),	e);
//		}
//		return vec;
//	}
//	private void addHeaderScrVdnRequest(Vector vec, WritableSheet s, String scrOrVdn) throws RowsExceededException, WriteException{
//		int col = colStart, row = rowStart;
//	    /* Format the Font */ 
//		WritableCellFormat cf = cellFormat(WritableFont.ARIAL, 10, true, Colour.WHITE, false, UnderlineStyle.NO_UNDERLINE, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, Colour.TEAL2, false);
//		createCell(s, cf, col++, row, new Integer(8), scrOrVdn + " #");//new Integer(0) is set Auto, null don't set anything
//		createCell(s, cf, col++, row, new Integer(0), "Product Type");
//		createCell(s, cf, col++, row, new Integer(0), "INC");
//		createCell(s, cf, col++, row, new Integer(0), "Parity");
//		createCell(s, cf, col++, row, new Integer(0), "Quantity");
//		createCell(s, cf, col++, row, new Integer(0), "Approver ID");
//		createCell(s, cf, col++, row, new Integer(30), "Approver Name");
//		createCell(s, cf, col++, row, new Integer(0), "Region");
//	}
//	private void addBodyScrVdnRequest(Vector vec, WritableSheet s, String reportType) throws RowsExceededException, WriteException{
//		ScrVdnReportVO vo;
//		int col = 0 , row = rowStart;
//		double totalAmout = 0.0;
//		WritableCellFormat cf_center_bold = cellFormat(WritableFont.ARIAL, 10, true, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, Colour.LIGHT_ORANGE, false);
//		WritableCellFormat cf_left = cellFormat(WritableFont.ARIAL, 10, false, Alignment.LEFT, Border.ALL, BorderLineStyle.THIN, null, false);
//		WritableCellFormat cf_left1 = cellFormat(WritableFont.ARIAL, 10, false, Alignment.LEFT, Border.ALL, BorderLineStyle.THIN, Colour.LIGHT_TURQUOISE2, false);
//		WritableCellFormat cf_center = cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, null, false);
//		WritableCellFormat cf_center1 = cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, Colour.LIGHT_TURQUOISE2, false);
//		WritableCellFormat tempCenter = cf_center;
//		WritableCellFormat templeft = cf_center;
//    	DecimalFormat df = new DecimalFormat("#.##");
//		for(int i = 0; vec != null && i < vec.size(); i++){
//			col = colStart;
//			row = row + 1;
//			vo = (ScrVdnReportVO )vec.elementAt(i);
//			s.addCell(new Number(col++, row, Double.parseDouble(vo.getScrVdnNumber()), tempCenter));
//			s.addCell(new Label(col++, row, vo.getProductTypeDesc() + "  ", templeft));
//			s.addCell(new Number(col++, row, Double.parseDouble(vo.getIncentive()), tempCenter));
//			s.addCell(new Number(col++, row, Double.parseDouble(vo.getParity()), tempCenter));
//			s.addCell(new Number(col++, row, Double.parseDouble(vo.getQuantity()), tempCenter));
//			s.addCell(new Label(col++, row, vo.getTsoID(), cf_center));
//			s.addCell(new Label(col++, row, vo.getTsoName(), cf_left));
//			s.addCell(new Number(col++, row, Double.parseDouble(vo.getRegion()), cf_center));
//			totalAmout = totalAmout + (Double.parseDouble(vo.getIncentive()) + Double.parseDouble(vo.getParity())) * Double.parseDouble(vo.getQuantity());
//			if (i == vec.size()-1 || (i < vec.size() - 1 && !vo.getTsoID().equals(((ScrVdnReportVO )vec.elementAt(i+1)).getTsoID()))) {
//				row = row + 1;
//				col = 0;
//				Label l = new Label(col++, row, "Total approved dollar amouts by " + vo.getTsoID() + " is " + df.format(totalAmout), cf_center_bold);
//			    s.mergeCells(0, row, 7, row);
//			    s.addCell(l);
//				totalAmout = 0.0;
//			}
//			if (i == vec.size()-1 || (i < vec.size() - 1 && !vo.getScrVdnNumber().equals(((ScrVdnReportVO )vec.elementAt(i+1)).getScrVdnNumber()))) {
//				tempCenter = (tempCenter.getBackgroundColour() == cf_center.getBackgroundColour())?cf_center1:cf_center;
//				templeft = (templeft.getBackgroundColour() == cf_left.getBackgroundColour())?cf_left1:cf_left;
//			}
//		}		
//	}
//	
//	/**
//	 * LOILE
//	 */
//	private void closePendingRefreshRegion(RequestContext rc) {
//		if (rc.getRequestParameter("region") != null && !rc.getRequestParameter("region").equals("")){
//			rc.setRequestAttribute("region", rc.getRequestParameter("region"));
//		} else {
//			//rc.setRequestAttribute("region", "0");
//		}
//		if(rc.getRequestParameter("territory")!=null && !rc.getRequestParameter("territory").equals("") ){
//			rc.setRequestAttribute("territory", rc.getRequestParameter("territory"));		
//		} else {
//			//rc.setRequestAttribute("territory", "0");
//		}
//		if(rc.getRequestParameter("year")!=null && !rc.getRequestParameter("year").equals("") ){
//			rc.setRequestAttribute("year", rc.getRequestParameter("year"));		
//		}		
//	}
//	//Modified By Vyas june 22nd to overcome Region NUll issue
//	private RequestContext refreshScreenForRegion(RequestContext rc) {
//		SearchCriteriaVO criteria = setToSession(rc);
//		// rc.getRequest().setAttribute(ScreenConstants.Scr.SCR_SEARCH_VO, scrVO);
//		return rc;
//	}
//	private void getData(RequestContext rc) throws AppException {
//
//		HttpSession session = rc.getRequest().getSession(false);
//		ScrSearchMgr scrSearchMgrRemote = null;
//		ValueListDataVO listData = null;
//		int lastStartIndex = 0;
//		try {
//			lastStartIndex = Integer.parseInt(rc.getRequest().getParameter("STARTINDEX"));
//			scrSearchMgrRemote = (ScrSearchMgr) session.getAttribute("SCRSEARCHLIST");
//			if (rc.getActionTag().equals("NextPage")) {
//				listData = scrSearchMgrRemote.getNext(lastStartIndex);
//			} else {
//				listData = scrSearchMgrRemote.getPrevious(lastStartIndex);
//			}
//			//get the max number of records that can be displayed in one screenful using the bean getCount() method
//			int maxRecords = scrSearchMgrRemote.getCount();
//			//set the listData and the maxRecords to the request object
//			rc.getRequest().setAttribute("PAGEDATA", listData);
//			rc.getRequest().setAttribute("MAXRECORDS", String.valueOf(maxRecords));
//
//		} catch (Exception ae) {
//			//Log this exception.
//			ae.printStackTrace();
//			throw new AppException();
//		}
//		catch (Throwable t) {
//			t.printStackTrace();
//		}
//	}
//	/**
//	 * LOILE Closed pending
//	 * @param rc
//	 */
//	private void closedPendingExportToExcel(RequestContext rc) {
//		HttpServletResponse response = rc.getResponse();
//		WritableWorkbook w = null;
//		try {
//			response.setContentType("application/vnd.ms-excel");
//			response.setHeader("Content-Disposition", "attachment; filename=ClosedPending.xls");
//			w = Workbook.createWorkbook(response.getOutputStream());
//			WritableSheet s = w.createSheet("Sheet", 0);
//			Vector vec = getClosedPendingData(rc);
//			addHeaderClosedPending(vec, s);
//			addBodyClosePending(vec, s);
//			w.write();			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				w.close();
//			} catch (WriteException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	private void addBodyClosePending(Vector vec, WritableSheet s) throws RowsExceededException, WriteException{
//		ClosedPendingVO cp;
//		int col = 0 , row = 0;
//		CacheManager cm = EatonCache.getCacheManager();
//		CallReasonLookup callReasonLookup =  cm.getCallReason();
//		FNameLNameLookup nameLookup = cm.getNames();
//		WlmLookup wlmlookup =cm.getWlmCode();
//		for(int i = 0; vec != null && i < vec.size(); i++){
//			WritableCellFormat cfTextCenter = cellFormat(WritableFont.ARIAL, 8, false, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, null, true);
//			WritableCellFormat cfTextLeft = cellFormat(WritableFont.ARIAL, 8, false, Alignment.LEFT, Border.ALL, BorderLineStyle.THIN, null, true);
//			WritableCellFormat cf_status = cellFormat(WritableFont.ARIAL, 8, false, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, null, true);
//			col = colStart;
//			row = i + rowStart + 1;
//			cp = (ClosedPendingVO )vec.elementAt(i);
//			s.addCell(new Label(col++, row, cp.getRegion() + "-" + cp.getTerrritory(), cfTextCenter));
//			if(cp.getSubTerrritory() != null) {
//				s.addCell(new Number(col++, row, Double.parseDouble(cp.getSubTerrritory()), cfTextCenter));
//			} else {
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}
//		    s.addCell(new Number(col++, row, Double.parseDouble(cp.getAcctNumber()), cfTextCenter));
//			s.addCell(new Label(col++, row, cp.getAcctName(), cfTextLeft));
//			s.addCell(new Label(col++, row, cp.getTargetDesc(), cfTextLeft));
//			s.addCell(new Label(col++, row, cp.getModelNumber(), cfTextLeft));
//			if ("VDN".equalsIgnoreCase(cp.getScrORvdn())) {
//				s.addCell(new Number(col++, row, Double.parseDouble(cp.getVdnOrSCRNumber()), cfTextCenter));
//			} else {
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}
//			if(cp.getVdnStatusDesc() != null){
//				s.addCell(new Label(col++, row, cp.getVdnStatusDesc(), cfTextLeft));
//			}else{
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}
//			//HOANGDOAN: added for issue#159 - Start
//			if(cp.getVdnWlmCode() != null){
//				s.addCell(new Label(col++, row, wlmlookup.getWLMDesc(cp.getVdnWlmCode()), cfTextCenter));
//			}else{
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}
//			/*if (cp.getVdnAtRisk() != null) {
//				s.addCell(new Label(col++, row, cp.getVdnAtRisk(), cfTextCenter));
//			}else {
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}
//			if (cp.getVdnAtGrowth() != null) {
//				s.addCell(new Label(col++, row, cp.getVdnAtGrowth(), cfTextCenter));
//			}else {
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}*/
//			if (cp.getScrGrowthPFPDesc() != null) {
//				s.addCell(new Label(col++, row, cp.getScrGrowthPFPDesc(), cfTextCenter));
//			}else {
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}
//			//HOANGDOAN: added for issue#159 - End
//			//CUONGBUI: added for issue#138 - Start
//			if ("VDN".equalsIgnoreCase(cp.getScrORvdn())) {
//				s.addCell(new Number(col++, row, Double.parseDouble(cp.getVdnQtySCRAvailQty()), cfTextCenter));
//			}else {
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}				
//			//CUONGBUI: added for issue#138 - End
//			if ("SCR".equalsIgnoreCase(cp.getScrORvdn())) {
//				s.addCell(new Number(col++, row, Double.parseDouble(cp.getVdnOrSCRNumber()), cfTextCenter));
//			} else if ("VDN".equalsIgnoreCase(cp.getScrORvdn()) && cp.getScrUsedOnVDN() != null && cp.getScrStatusDesc() != null) {
//				s.addCell(new Number(col++, row, Double.parseDouble(cp.getScrUsedOnVDN()), cfTextCenter));
//			}else{
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}
//			if(cp.getScrStatusDesc() != null ){
//				s.addCell(new Label(col++, row, cp.getScrStatusDesc(), cfTextLeft));
//			}else{
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}
//			//HOANGDOAN: added for issue#159 - Start
//			if(cp.getScrWlmCode() != null){
//				s.addCell(new Label(col++, row, wlmlookup.getWLMDesc(cp.getScrWlmCode()), cfTextCenter));
//			}else{
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}
//			if (cp.getScrAtRisk() != null) {
//				s.addCell(new Label(col++, row, cp.getScrAtRisk(), cfTextCenter));
//			}else {
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}
//			if (cp.getScrAtGrowth() != null) {
//				s.addCell(new Label(col++, row, cp.getScrAtGrowth(), cfTextCenter));
//			}else {
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}
//			//HOANGDOAN: added for issue#175- End
//			//HOANGDOAN: added for issue#175 - End
//			//HOANGDOAN: added for issue#159 - End
//			//CUONGBUI: added for issue#138 - Start
//			if ("SCR".equalsIgnoreCase(cp.getScrORvdn())) {
//				s.addCell(new Number(col++, row, Double.parseDouble(cp.getVdnQtySCRAvailQty()), cfTextCenter));
//			}else if ("VDN".equalsIgnoreCase(cp.getScrORvdn()) && cp.getScrTotalQty() != null) {
//				s.addCell(new Number(col++, row, Double.parseDouble(cp.getScrTotalQty()), cfTextCenter));
//			}else{
//				s.addCell(new Label(col++, row, "", cfTextCenter));
//			}				
//			//CUONGBUI: added for issue#138 - End
//		    if(cp.getCcrId() == null || "".equals(cp.getCcrId())){
//		    	s.addCell(new Label(col++, row, "", cfTextCenter));	
//		    } else {
//		    	s.addCell(new Number(col++, row, Double.parseDouble(cp.getCcrId()), cfTextCenter));
//		    }
//			if("QV".equals(cp.getCallReason())){
//				cf_status.setBackground(Colour.GOLD);
//			} else if("OM".equals(cp.getCallReason())){
//				cf_status.setBackground(Colour.CORAL);
//			} else if("OA".equals(cp.getCallReason())){
//				cf_status.setBackground(Colour.BRIGHT_GREEN);
//			} else if("OR".equals(cp.getCallReason())){
//				cf_status.setBackground(Colour.RED);
//			} else if("TT".equals(cp.getCallReason())){
//				cf_status.setBackground(Colour.YELLOW2);
//			}
//			String state = cp.getCallReason() == null?"": callReasonLookup.getReasonDesc(cp.getCallReason());
//			s.addCell(new Label(col++, row, state!=null?state:"", cf_status));
//			//HOANGDOAN: added for issue#159 - Start
//			/*s.addCell(new Label(col++, row, cp.getVscrAtRisk() != null ? cp.getVscrAtRisk():"", cfTextCenter));
//			s.addCell(new Label(col++, row, cp.getVscrAtGrowth() != null ? cp.getVscrAtGrowth():"", cfTextCenter));*/
//			//HOANGDOAN: added for issue#159 - End
//			//CUONGBUI: added for issue#138 - Start			
//			s.addCell(new Label(col++, row, cp.getCallDate() != null ? cp.getCallDate():"", cfTextCenter));			
//			//CUONGBUI: added for issue#138 - End
//			s.addCell(new Label(col++, row, cp.getVscrCreatedBy() != null ?nameLookup.getFirstLastName(cp.getVscrCreatedBy()):"", cfTextCenter));
//	
//		}		
//	}
//	/**
//	 * Loile 3 Oct 2010 Create Cell
//	 * @param s
//	 * @param cf
//	 * @param col
//	 * @param row
//	 * @param size
//	 * @param value
//	 * @throws WriteException
//	 */
//	private void createCell(WritableSheet s, WritableCellFormat cf, int col, int row, Integer size, Object value) throws WriteException{
//		if (value instanceof Double) {
//			s.addCell(new Number(col, row, Double.parseDouble(value.toString()), cf));
//		} else {
//			s.addCell(new Label(col, row, value.toString(), cf));
//		}
//		CellView cell=s.getColumnView(col);
//		if (size != null) {
//			if (size.intValue() == 0) {
//				cell.setAutosize(true);
//				s.setColumnView(col, cell);
//			} else {
//				s.setColumnView(col, size.intValue());
//			}
//		}
//	}
//	/**
//	 * LOILE 13 Oct 2010 add Header for Excel file
//	 * @param vec
//	 * @param s
//	 * @throws WriteException
//	 */
//	private void addHeaderClosedPending(Vector vec, WritableSheet s) throws WriteException {
//		int col = colStart, row = rowStart;
//	    /* Format the Font */ 
//		WritableCellFormat cf = cellFormat(WritableFont.ARIAL, 8, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.CENTRE, Border.ALL, BorderLineStyle.THIN, Colour.PALE_BLUE, true);
//		WritableCellFormat cf_date = cellFormat(WritableFont.ARIAL, 8, true, Colour.BLACK, false, UnderlineStyle.NO_UNDERLINE, Alignment.LEFT, null, null, null, false);
//	    s.addCell(new Label(0, row-1, "Date:", cf_date));
//	    SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");  
//	    Date newDate = new Date();
//	    String newdate = dateformat.format(newDate);	    
//	    s.addCell(new Label(1, row-1, newdate, cf_date));
//		createCell(s, cf, col++, row, new Integer(4), "Ter");//new Integer(0) is set Auto, null don't set anything
//		createCell(s, cf, col++, row, new Integer(4), "Sub");
//		createCell(s, cf, col++, row, new Integer(0), "Acct #");
//		createCell(s, cf, col++, row, new Integer(22), "ACCT NAME");
//		createCell(s, cf, col++, row, new Integer(24), "Target Product");
//		createCell(s, cf, col++, row, new Integer(15), " MODEL # ");
//		createCell(s, cf, col++, row, new Integer(0), " VDN # ");
//		createCell(s, cf, col++, row, new Integer(10), "VDN Status");
//		//CUONGBUI: added for issue#138 - Start
//		//HOANGDOAN: added for issue#159 - Start
//		createCell(s, cf, col++, row, new Integer(10), "VDN WLM");
//		/*createCell(s, cf, col++, row, new Integer(6), "VDN AtRisk");
//		createCell(s, cf, col++, row, new Integer(9), "VDN AtGrowth");*/
//		createCell(s, cf, col++, row, new Integer(13), "Growth Profitability PFP");
//		//HOANGDOAN: added for issue#159 - End
//		createCell(s, cf, col++, row, new Integer(4), "VDN Qty");
//		//CUONGBUI: added for issue#138 - End		
//		createCell(s, cf, col++, row, new Integer(0), "SCR #");
//		createCell(s, cf, col++, row, new Integer(10), "SCR Status");
//		//CUONGBUI: added for issue#138
//		//HOANGDOAN: added for issue#159 - Start
//		createCell(s, cf, col++, row, new Integer(10), "SCR WLM");
//		createCell(s, cf, col++, row, new Integer(6), "SCR AtRisk");
//		createCell(s, cf, col++, row, new Integer(9), "SCR AtGrowth");
//		//HOANGDOAN: added for issue#159 - End
//		createCell(s, cf, col++, row, new Integer(5), "SCR AvailQty");
//		//CUONGBUI: added for issue#138 - End
//		createCell(s, cf, col++, row, new Integer(0), "VSCR #");
//		createCell(s, cf, col++, row, new Integer(15), "VSCR Status");
//		//CUONGBUI: added for issue#138 - Start
//		//HOANGDOAN: added for issue#159 - Start
//		/*createCell(s, cf, col++, row, new Integer(6), "VSCR AtRisk");
//		createCell(s, cf, col++, row, new Integer(9), "VSCR AtGrowth");*/
//		//HOANGDOAN: added for issue#159 - End
//		createCell(s, cf, col++, row, new Integer(10), "Call Date");
//		//CUONGBUI: added for issue#138 - End
//		createCell(s, cf, col++, row, new Integer(10), "Author");
//	}
//	/**
//	 * LOILE 13 Oct 2010 get data for Closed Pending
//	 * @param rc
//	 * @return
//	 * @throws AppException
//	 */
//	private Vector getClosedPendingData(RequestContext rc) throws AppException {
//		Vector vec = null;				
//		ScrSearchMgr scrSearchMgrRemote = null;
//		int year = Calendar.getInstance().get(Calendar.YEAR);
//		String region = null;
//		String territory = null;
//		if (rc.getRequest().getParameter("year") != null) {
//			year = Integer.parseInt(rc.getRequest().getParameter("year").toString());
//		}
//		if (rc.getRequestParameter("region") != null && !rc.getRequestParameter("region").equals("")){
//			region = rc.getRequestParameter("region");
//		} 
//		if(rc.getRequestParameter("territory")!=null && !rc.getRequestParameter("territory").equals("") ){
//			territory = rc.getRequestParameter("territory");
//		}
//		try {
//			ScrSearchMgrHome searchScrHome = (ScrSearchMgrHome) AccessCache.lookup(JNDIConstants.SCR_SEARCH);
//			scrSearchMgrRemote = searchScrHome.create();
//			vec = scrSearchMgrRemote.getClosedPendingData(year, region, territory);
//		} catch (AppException ae) {		
//			throw ae;
//		} catch (CreateException ce) {
//			AppException ae = new AppException("MSG000003");
//			ae.setAsSystemException();
//			throw ae;
//		} catch (RemoteException re) {
//			AppException ae = new AppException();
//			ae.setAsSystemException();
//			ErrorVO errVO = new ErrorVO();
//			errVO.setErrMsg(new ErrorMessage().getErrorMessage("MSG000003"));
//			errVO.setPageHeading("ScrSearch");
//			errVO.setScreenId("ScrSearch");
//			errVO.setActionType("List");
//			rc.getRequest().setAttribute("ErrorVO", errVO);
//			throw ae;
//			
//		} catch (Exception e) {
//			Logger.log(this.getClass().getName(),Logger.SEVERE,	userObject.getUserId(),	e.getMessage(),	e);
//		}
//		return vec;
//	}
//	private void generateSCRReport(RequestContext rc) {
//		Vector vec = null;
//		try {
//			vec = getScrList(rc);
//		} catch (AppException e) {
//			e.printStackTrace();
//		}
//		rc.getRequest().setAttribute("SCR_QUALYFYING_REPORT", vec);
//	}
//	private void displayReport(RequestContext rc) {
//		rc.getRequest().getSession().removeAttribute(ScreenConstants.Scr.SCR_SEARCH_VO);
//	}
//	private void exportToExcel(RequestContext rc) {
//		HttpServletResponse response = rc.getResponse();
//		WritableWorkbook w = null;
//		try {
//			response.setContentType("application/vnd.ms-excel");
//			response.setHeader("Content-Disposition", "attachment; filename=VSCRReport.xls");
//			w = Workbook.createWorkbook(response.getOutputStream());
//			WritableSheet s = w.createSheet("Sheet", 0);
//			Vector vec = getScrList(rc);
//			addHeader(vec, s);
//			addBody(vec, s);
//			addFooter(vec, s);
//			w.write();			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				w.close();
//			} catch (WriteException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	private void addHeader(Vector vec, WritableSheet s) throws RowsExceededException, WriteException{
//		int col = colStart, row = rowStart;
//	    /* Format the Font */ 
//	    WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
//	    WritableCellFormat cf = new WritableCellFormat(wf);
//	    cf.setBackground(Colour.TEAL2);
//	    cf.setAlignment(Alignment.CENTRE);
//		createCell(s, cf, col++, row, new Integer(0), "Ter");//new Integer(0) is set Auto, null don't set anything
//		createCell(s, cf, col++, row, new Integer(0), "Sub");
//		createCell(s, cf, col++, row, new Integer(20), "Customer Name");
//		createCell(s, cf, col++, row, new Integer(0), "Acct #");
//		createCell(s, cf, col++, row, new Integer(24), "Target Prod");
//		createCell(s, cf, col++, row, new Integer(0), "SCR #");
//		createCell(s, cf, col++, row, new Integer(0), "VSCR #");
//		createCell(s, cf, col++, row, new Integer(0), "Call Date");
//		createCell(s, cf, col++, row, new Integer(15), "Author");
//		createCell(s, cf, col++, row, new Integer(24), "VSCR Status");
//	}
//	private void addBody(Vector vec, WritableSheet s) throws RowsExceededException, WriteException{
//		CacheManager cm = EatonCache.getCacheManager();
//		FNameLNameLookup name = cm.getNames();
//		ScrSearchResultsVO scr;
//		int col = 0 , row = 0;
//		for(int i = 0; vec != null && i < vec.size(); i++){
//			WritableCellFormat cf1 = cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, null, null, null, false);
//			col = colStart;
//			row = i + rowStart + 1;
//			scr = (ScrSearchResultsVO )vec.elementAt(i);
//			CcrVO ccrVO = scr.getVscrVO();
//			s.addCell(new Label(col++, row, scr.getRegion() + "-" + scr.getTerritory(), cf1));
//			try {
//				s.addCell(new Number(col++, row, Double.parseDouble(scr.getSubTer()), cf1));
//			} catch (Exception e) {
//				s.addCell(new Label(col, row, scr.getSubTer(), cf1));
//			}
//			WritableCellFormat cf_customer = cellFormat(WritableFont.ARIAL, 10, false, Alignment.LEFT, null, null, null, true);
//			s.addCell(new Label(col++, row, scr.getCustomerName(), cf_customer));
//			s.addCell(new Number(col++, row, Double.parseDouble(scr.getAccNo()), cf1));
//			Vector target = scr.getTargetProdDes();			
//			Iterator itr = (Iterator) (target != null ?target.iterator(): null);
//			String targetDes = "";
//		    while(itr != null && itr.hasNext()){
//		    	targetDes = targetDes + ("".equals(targetDes)?"":"\n") + (String) itr.next();
//		    }
//		    WritableCellFormat cf_target = cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, null, null, null, true);
//			s.addCell(new Label(col++, row, targetDes, cf_target));
//			s.addCell(new Number(col++, row, Double.parseDouble(scr.getScrNumber().toString()), cf1));
//			WritableCellFormat cf_ccr = cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, null, null, null, false);
//			s.addCell(new Number(col++, row, Double.parseDouble(ccrVO.getCcrId()), cf_ccr));
//			s.addCell(new Label(col++, row, ccrVO.getCallDate(), cf1));
//			s.addCell(new Label(col++, row, name.getFirstLastName(ccrVO.getCreatedBy()), cf_customer));
//			WritableCellFormat cf_status = cellFormat(WritableFont.ARIAL, 10, false, Alignment.CENTRE, null, null, null, false);
//			if(ccrVO!=null && ccrVO.getState() != null){
//				if("QV".equals(ccrVO.getState())){
//					cf_status.setBackground(Colour.GOLD);
//				} else if("OM".equals(ccrVO.getState())){
//					cf_status.setBackground(Colour.CORAL);
//				} else if("OA".equals(ccrVO.getState())){
//					cf_status.setBackground(Colour.BRIGHT_GREEN);
//				} else if("OR".equals(ccrVO.getState())){
//					cf_status.setBackground(Colour.RED);
//				} else if("TT".equals(ccrVO.getState())){
//					cf_status.setBackground(Colour.YELLOW2);
//				}
//			}
//			s.addCell(new Label(col++, row, ccrVO!=null?ccrVO.getVscrState():"", cf_status));
//		}		
//	}
//	private WritableFont getCellFormat(FontName fn, int ps, boolean  isBold, Alignment alignment, Border border, BorderLineStyle borderLineStyle, Colour bgColour, boolean wrap) {
//		WritableCellFormat cf = null;
//		WritableFont wf = new WritableFont(fn, ps, isBold?WritableFont.BOLD:WritableFont.NO_BOLD);
//		cf = new WritableCellFormat(wf);
//		
//			try {
//				if(alignment != null){
//				cf.setAlignment(alignment);
//				}
//				if (borderLineStyle != null) {
//					cf.setBorder(border, borderLineStyle);
//				}
//				if (bgColour != null) {
//					cf.setBackground(bgColour);
//				}
//				cf.setWrap(wrap);	
//			} catch (WriteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		return wf;
//	}
//	
//	private void addFooter(Vector vec, WritableSheet s) throws RowsExceededException, WriteException{	
//
//	}
}
