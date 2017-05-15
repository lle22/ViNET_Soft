package com.pn.view.invoice.controller;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.pn.util.CreateWord;
import com.pn.util.Ultil;
import com.pn.view.invoice.bean.InvoiceBean;
@Controller
public class InvoiceController {
    @Autowired
    private BCTongHopService bCTongHopService;
    @RequestMapping(value = "/getDocInvoice", method = RequestMethod.POST)
    public String exportCongNoKhachHang(@ModelAttribute("invoiceBean") InvoiceBean invoiceBean, HttpSession session, Model model
    		, HttpServletRequest request, HttpServletResponse response) {
        String target = Ultil.checkPermission(session, model);
        if (target != null) {
//            return target;
        }
        this.setModel(model);
        target = "printInvoice";
        try {
        	response.setContentType("application/msword; charset=UTF-8"); 
        	response.setHeader("Content-disposition", "inline;filename=" + invoiceBean.getMaCty() + "_GTGT.doc");
        	String mayIn = ".xml";
        	if (invoiceBean.getIsInCanon()) {
        		mayIn = "Canon.xml";
			}
            String wordTemplateFile = "D:\\phuongnam\\PhanMemKeToan\\implement\\pn\\HoaDonGTGTTemplate" + mayIn;
            if (invoiceBean.getIsKemBangKe()) {
                wordTemplateFile = "D:\\phuongnam\\PhanMemKeToan\\implement\\pn\\HoaDonGTGTBKTemplate" + mayIn;
            }
            CreateWord createWord = new CreateWord();            
            String wordTemplate = createWord.createWordTemplate(invoiceBean, wordTemplateFile);
            PrintWriter writer = response.getWriter(); 
            writer.println(wordTemplate); 
            writer.flush(); 
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getCause());
        }
        return target;      
    } 
   
    @RequestMapping(value = "/viewInvoiceDetail", method = RequestMethod.POST)
    public String exportCongNoKhachHang(@ModelAttribute("invoiceBean") InvoiceBean invoiceBean, HttpSession session, Model model){
        List<BCTongHop> bcCongNo = null;
        if (invoiceBean.getSoChungTu() != null && !"".equals(invoiceBean.getSoChungTu().trim())) {        	
        	bcCongNo = bCTongHopService.getBaoCaoTheoSoChungTu(invoiceBean.getSoChungTu());
        	if (bcCongNo.size() > 0) {
        		BCTongHop bc = bcCongNo.get(0);
        		invoiceBean.setDiaChi(bc.getDiaChi());
        		invoiceBean.setMaCty(bc.getDoiTuongCongNoID());
        		invoiceBean.setMaSoThue(bc.getMaSothue());
        		invoiceBean.setTenDonVi(bc.getTenDoiTuongCongNo());
        		invoiceBean.setdTCongNo(bc.getDoiTuongCongNoID());
			}
		} else {
			bcCongNo = bCTongHopService.getBaoCaoTheoCongTy(invoiceBean.getMaCty(), invoiceBean.getTuNgay(), invoiceBean.getDenNgay());
		}
        if (bcCongNo.size() == 0) {
            model.addAttribute("message", "Dữ liệu không tồn tại.");
        }
        invoiceBean.setInvoiceDetailsFromBcCongNo(bcCongNo);
        model.addAttribute("reportBean", invoiceBean);
        this.setModel(model);
        return "printInvoice";
    }
    
    @RequestMapping(value="/viewWordPrint", method = RequestMethod.GET) 
    public String viewExport(@ModelAttribute("invoiceBean") InvoiceBean invoiceBean,   
            Model model, HttpSession session) {
        String target = Ultil.checkPermission(session, model);
        if (target != null) {
            return target;
        }
        this.setModel(model);
        session.setAttribute("menuItem", "viewWordPrint");
        return "printInvoice";
    }
    @RequestMapping(value = "/tonghop1", method = RequestMethod.POST)    
    public String tongHopData(@ModelAttribute("invoiceBean") InvoiceBean invoiceBean,
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
        model.addAttribute("khachHang", khachHang);
    }   
}
