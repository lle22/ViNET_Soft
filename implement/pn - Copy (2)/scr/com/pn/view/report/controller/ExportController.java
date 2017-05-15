package com.pn.view.report.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pn.model.BCTongHop;
import com.pn.model.Customer.DTCongNo;
import com.pn.service.bcTongHop.BCTongHopService;
import com.pn.util.PNConstant;
import com.pn.util.Ultil;
import com.pn.view.report.bean.ReportCongNoKHBean;

@Controller
public class ExportController{
	private String pathServer = "";
	@Autowired
	private BCTongHopService bCTongHopService;
	@RequestMapping(value = "/congnokhachhang", method = RequestMethod.POST)
	public String exportCongNoKhachHang(@ModelAttribute("reportCongNoKHBean") ReportCongNoKHBean reportBean, HttpSession session, Model model) {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		this.setModel(model);
		List<BCTongHop> bcCongNo = null;
		List<Object> allCusInMonth = null;
		target = "export";
		try {
			if(reportBean.getIsBangKe() || reportBean.getIsCongNo() || reportBean.getIsTongHopMatHang()){
				if(!"0".equals(reportBean.getDTCongNo())){
					bcCongNo = bCTongHopService.getBaoCaoTheoCongTy(reportBean.getMaCty(), reportBean.getTuNgay(), reportBean.getDenNgay());
				} else if("".equals(reportBean.getMaCty())){
					bcCongNo = bCTongHopService.getBaoCaoTheoThang(reportBean.getTuNgay(), reportBean.getDenNgay());
				}
			}
			if (reportBean.getIsTongSoKHtrongThang()) {
				allCusInMonth = bCTongHopService.getAllCustomerInMonth(reportBean.getTuNgay(), reportBean.getDenNgay());
			}
			if (bcCongNo != null && bcCongNo.size() > 0 || allCusInMonth != null && allCusInMonth.size() > 0) {
				map.put("reportBean", reportBean);
				map.put("bcCongNo", bcCongNo);
				map.put("allCusInMonth", allCusInMonth);
				//export on server site
				if ("0".equals(reportBean.getDTCongNo()) && "".equals(reportBean.getMaCty()) && bcCongNo != null && bcCongNo.size() > 0) {
					ExcelReportView excel = new ExcelReportView();
					excel.createReport_CNO_BKE_ForAllCustomer(map);
					model.addAttribute("message", "Tạo files báo cáo công nợ thành công và đã đuợc lưu tại server.");
				} else {//download back to client 
					model.addAttribute("model", map);
					target = "excelCongNoKhachHang";
				}
			} else {
				model.addAttribute("message", "Đữ liệu không tồn tại.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getCause());
		}
		return target;		
	}	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public @ResponseBody DTCongNo getCustomerInfor(@RequestParam String customerID) {
		List<DTCongNo>  customers = bCTongHopService.getListDoiTuongCongNo();
		DTCongNo customer = new DTCongNo();
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getId().equals(customerID)) {
				customer = customers.get(i);
				break;
			}
		}
		return customer;
	}
	@RequestMapping(value="viewExport", method = RequestMethod.GET)	
	public String viewExport(@ModelAttribute("reportCongNoKHBean") ReportCongNoKHBean reportBean,	
			Model model, HttpSession session) {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		this.setModel(model);
		session.setAttribute("menuItem", "viewExport");
		return "export";
	}
	@RequestMapping(value = "/tonghop", method = RequestMethod.POST)	
	public String tongHopData(@ModelAttribute("reportCongNoKHBean") ReportCongNoKHBean reportBean,
			HttpSession session, Model model) {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		this.setModel(model);
		int isError = bCTongHopService.tongHopData();
		if (isError != 0) {
			model.addAttribute("message", "Tổng hợp dữ liệu không thàng công.</br>Vui lòng tổng hợp lại.");
		} else {
			model.addAttribute("message", "Tổng hợp dữ liệu thàng công.");
		}
		return "export";
	}
	/**
	 * SetModel
	 * @param model
	 */
	private void setModel(Model model){
		List<DTCongNo> khachHang = bCTongHopService.getListDoiTuongCongNo();
		pathServer = PNConstant.pathCongNo + PNConstant.getDayFormat(new Date(), "dd-MM-yyyy");
		model.addAttribute("khachHang", khachHang);
		model.addAttribute("pathServer", pathServer);		
	}	
}