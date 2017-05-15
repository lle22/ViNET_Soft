package com.pn.view.commentCustomer.controller;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pn.model.Customer.CustomerPotential;
import com.pn.model.dmEmployee.Employee;
import com.pn.service.User.EmployeeService;
import com.pn.service.chungtu.ChungtuService;
import com.pn.service.commentCustomer.CommentCustomerService;
import com.pn.util.EmailClient;
import com.pn.util.Ultil;
import com.pn.view.commentCustomer.bean.CommentCustomerBean;
import com.pn.view.commentCustomer.bean.FileUploadForm;
@Controller
public class CommentCustomerController {
	@Autowired
	private CommentCustomerService commentCustomerService;
	
	@Autowired 
	EmployeeService employeeService;
	
	@Autowired 
	ChungtuService chungtuService;
	
	@Autowired
    private EmailClient emailSender;
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String getCustomerInfor(@RequestParam("id") Integer id) throws Exception {
		commentCustomerService.deleteCommentCustomer(id);
		return "commentList";
	}
	
	@RequestMapping(value="/viewSendEmail", method=RequestMethod.GET)
	public String viewSendEmail(@ModelAttribute("fileUploadForm") FileUploadForm bean, Model model, HttpSession session,
			@RequestParam("id") Integer id) throws Exception {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		CustomerPotential cp = commentCustomerService.getCommentCustomerById(id);
		bean.setNguoiGiaoDich(cp.getNguoiGiaoDich());
		bean.setEmailContent(getContentEmail(bean, session));
		bean.setEmailTo(cp.getEmail());
		bean.setId(id);	
		return "emailAttachment";
	}
	private String getContentEmail(FileUploadForm bean, HttpSession session) throws UnsupportedEncodingException{
		Employee emp = (Employee)session.getAttribute("employee");
		String header = "<b>Dear " + bean.getNguoiGiaoDich() + ",</b><br><br>";
		String footer = emp.getTenNhanVienKD() + "<br>" + bean.getFooter();
		String dai_tu = "chị";
		String Dai_tu = "Chị";
		if(bean.getNguoiGiaoDich() != null && (bean.getNguoiGiaoDich().trim().startsWith("anh") || bean.getNguoiGiaoDich().trim().startsWith("Anh"))){
			dai_tu = "anh";
			Dai_tu = "Anh";
		}
		String content = bean.getEmailContent().replaceAll("dai_tu", dai_tu).replaceAll("Dai_tu", Dai_tu);	
		return header + content + footer;
	}
	private void updateCommentwithSentEmail(CustomerPotential cp, HttpSession session, String emailTo) throws Exception{
		Employee employee = (Employee)session.getAttribute("employee");
		String ghiChu = Ultil.dateTimeToString(new Date());
		ghiChu = "[" + ghiChu + "-" + employee.getId() + "] Đã gởi email đến " + emailTo;
		if (cp.getGhiChu() != null) {
			ghiChu = ghiChu + "\n" + cp.getGhiChu().trim();
		}
		cp.setGhiChu(ghiChu);
		cp.setUpdatedBy(employee.getId());
		try {
			commentCustomerService.updateComentCustomer(cp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	@RequestMapping(value="/sendEmail", method=RequestMethod.POST)
	public String sendEmail(@ModelAttribute("fileUploadForm") FileUploadForm bean, Model model, HttpSession session) throws Exception {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		emailSender.sendMail(bean);
		model.addAttribute("message", "Email đã được gửi đến " + bean.getEmailTo());
		try {
			CustomerPotential cp = commentCustomerService.getCommentCustomerById(bean.getId());
			String emailDistribule = " To: " + bean.getEmailTo() + " Cc: " + bean.getEmailCc();
			if(bean.getEmailBcc() !=null && !"".equals(bean.getEmailBcc())){
				emailDistribule = emailDistribule + " Bcc: " + bean.getEmailBcc();
			}
			updateCommentwithSentEmail(cp, session, emailDistribule);
			CommentCustomerBean bean1 = new CommentCustomerBean(cp);
			model.addAttribute("commentCustomerBean", bean1);
			model.addAttribute("rates", commentCustomerService.getRatePotential());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "emailAttachment";
	}
	@RequestMapping(value="/viewCommentCustomer", method=RequestMethod.GET)
	public String createCommentView(@ModelAttribute("commentCustomerBean") CommentCustomerBean bean, Model model, HttpSession session) throws Exception {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		session.setAttribute("pageBack", "createComment");
		CommentCustomerBean beanSearch = new CommentCustomerBean();
		beanSearch.setCreateDate(Ultil.dateToString(new Date()));
		model.addAttribute("list", search(beanSearch, null));
		model.addAttribute("rates", commentCustomerService.getRatePotential());
		session.setAttribute("menuItem", "viewCommentCustomer");
		return "createComment";
	}
	@RequestMapping(value="/modifyComment", method=RequestMethod.GET)
	public String retriveComment(@RequestParam("id") Integer id, Model model, HttpSession session) {
		try {
			CustomerPotential cp = commentCustomerService.getCommentCustomerById(id);
			CommentCustomerBean bean = new CommentCustomerBean(cp);
			model.addAttribute("commentCustomerBean", bean);
			model.addAttribute("rates", commentCustomerService.getRatePotential());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "modifyComment";
	}
	@RequestMapping(value = "/createComment", method=RequestMethod.POST)
	public String saveComment(@ModelAttribute("commentCustomerBean") CommentCustomerBean bean, Model model, HttpSession session) throws Exception {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		if(commentCustomerService.getCommentCustomerByName(bean.getName().trim()) == null){
			Employee employee = (Employee)session.getAttribute("employee");
			bean.setCreateDate(Ultil.dateToString(new Date()));
			bean.setEmployeeId(employee.getId());			
			
			Integer id = commentCustomerService.saveComentCustomer(new CustomerPotential(bean, employee));
			bean.setId(id);
	
			CustomerPotential cp = commentCustomerService.getCommentCustomerById(bean.getId());
			bean.setEmployeeName(cp.getEmployee().getTenNhanVienKD());
			bean.setCreateDate(Ultil.dateToString(cp.getCreateDate()));
	
			model.addAttribute("commentCustomerBean", bean);
			model.addAttribute("message", "Khách hàng đã lưu thành công.");
		} else {
			model.addAttribute("message", "Tên khách hàng đã tồn tại.");
		}
		CommentCustomerBean beanSearch = new CommentCustomerBean();
		beanSearch.setCreateDate(Ultil.dateToString(new Date()));
		model.addAttribute("list", search(beanSearch, null));
		model.addAttribute("rates", commentCustomerService.getRatePotential());
		return "/createComment";
	}
	@RequestMapping(value = "/updateComment", method=RequestMethod.POST)
	public String updateComment(@ModelAttribute("commentCustomerBean") CommentCustomerBean bean, Model model, HttpSession session) throws Exception {
		model.addAttribute("commentCustomerBean", bean);
		model.addAttribute("rates", commentCustomerService.getRatePotential());
		try {
			Employee emp = (Employee)session.getAttribute("employee");
			commentCustomerService.updateComentCustomer(new CustomerPotential(bean, emp));
			model.addAttribute("message", "Khách hàng đã cập nhật thành công.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new Exception(e);
		}
		return "/modifyComment";
	}
	
	@RequestMapping(value = "/viewSearchComment", method=RequestMethod.GET)
	public String searchCommentView(@ModelAttribute("commentCustomerBean") CommentCustomerBean bean, Model model, HttpSession session) {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		model.addAttribute("listEmployees", employeeService.listEmployee());
		model.addAttribute("rates", commentCustomerService.getRatePotential());
		session.setAttribute("menuItem", "viewSearchComment");
		return "/searchComment";
	}	
	@RequestMapping(value = "/searchComment", method=RequestMethod.POST)
	public String searchComment(@ModelAttribute("commentCustomerBean") CommentCustomerBean bean, Model model, HttpSession session) throws Exception {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		session.setAttribute("commentCustomerBean", bean);
		session.setAttribute("pageBack", "searchComment");
		Employee emp = (Employee)session.getAttribute("employee");
		model.addAttribute("employee", emp);
		model.addAttribute("list", search(bean, model));
		return "/searchComment";
	}
	@RequestMapping(value = "/sortComment", method=RequestMethod.POST)
	public String sortComment(@ModelAttribute("commentCustomerBean") CommentCustomerBean bean, Model model, HttpSession session) throws Exception {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		bean.setOrderBy("ASC".equals(session.getAttribute("orderBy"))?"DESC":"ASC");
		if(bean.getSortColumn() != null && !bean.getSortColumn().equals(session.getAttribute("sortColumn"))){
			bean.setOrderBy("ASC");
		} 	
		session.setAttribute("sortColumn", bean.getSortColumn());		
		session.setAttribute("orderBy", bean.getOrderBy());
		
		session.setAttribute("commentCustomerBean", bean);
		session.setAttribute("pageBack", "searchComment");
		Employee emp = (Employee)session.getAttribute("employee");
		model.addAttribute("employee", emp);
		model.addAttribute("list", search(bean, model));
		return "/searchComment";
	}
	@RequestMapping(value = "/backSearchComment", method=RequestMethod.GET)
	public String backSearchComment(@ModelAttribute("commentCustomerBean") CommentCustomerBean bean, Model model, HttpSession session) throws Exception {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		String pageBack = (String)session.getAttribute("pageBack");
		if ("createComment".equals(pageBack)) {
			CommentCustomerBean beanSearch = new CommentCustomerBean();
			beanSearch.setCreateDate(Ultil.dateToString(new Date()));
			model.addAttribute("list", search(beanSearch, null));
			model.addAttribute("rates", commentCustomerService.getRatePotential());
			session.setAttribute("menuItem", "viewSearchComment");
		} else if ("searchComment".equals(pageBack)){
			if (session.getAttribute("commentCustomerBean") != null) {
				bean = (CommentCustomerBean)session.getAttribute("commentCustomerBean");
				model.addAttribute("list", search(bean, model));
				model.addAttribute("commentCustomerBean", bean);
			}
			Employee emp = (Employee)session.getAttribute("employee");
			model.addAttribute("employee", emp);
			session.setAttribute("menuItem", "viewSearchComment");
		}		
		return ("/" + pageBack);
	}
	@RequestMapping(value = "/retrieveComments", method=RequestMethod.GET)
	public String retrieveComments(@ModelAttribute("commentCustomerBean") CommentCustomerBean bean,
			Model model, HttpSession session, @RequestParam("filter") String filterCondition) throws Exception {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		if ("remindOver".equals(filterCondition)) {
			bean.setRemindDate(Ultil.dateToString(new Date()));
		} else if("inMonth".equals(filterCondition)) {
			Employee emp = (Employee)session.getAttribute("employee");
			bean.setCreateDate(Ultil.firstDayOfMonth());
			bean.setEmployeeId(emp.getId());
		}
		session.setAttribute("menuItem", "viewSearchComment");
		session.setAttribute("pageBack", "searchComment");
		session.setAttribute("commentCustomerBean", bean);
		model.addAttribute("list", search(bean, model));
		return "/searchComment";
	}	
	private List search(CommentCustomerBean bean, Model model) throws Exception{
		if (model != null) {
			model.addAttribute("rates", commentCustomerService.getRatePotential());
			model.addAttribute("listEmployees", employeeService.listEmployee());
		}
		List<CustomerPotential> list = null;
		try {
			list = commentCustomerService.searchCommentCustomer(bean);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new Exception(e);
		}
		return list;
	}
}
