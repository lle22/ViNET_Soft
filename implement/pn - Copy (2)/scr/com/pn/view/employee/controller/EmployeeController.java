package com.pn.view.employee.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pn.model.Customer.CustomerPotential;
import com.pn.model.dmEmployee.Employee;
import com.pn.service.User.EmployeeService;
import com.pn.service.commentCustomer.CommentCustomerService;
import com.pn.util.Ultil;
import com.pn.view.commentCustomer.bean.CommentCustomerBean;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService userService;
	@Autowired
	CommentCustomerService commentCustomerService;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getReminder(Model model, HttpSession session) throws Exception {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		Employee emp = (Employee)session.getAttribute("employee");
		getReminders(model, emp.getId());
		session.setAttribute("menuItem", "home");
		return "home";
	}
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String viewLoginPage(@ModelAttribute("employee") Employee employee) {
		return "/login";
	}
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(@ModelAttribute("employee") Employee employee, HttpSession session) {
		session.setAttribute("employee", null);
		session.setAttribute("menuItem", null);
		return "/login";
	}
	@RequestMapping(value = "/viewChangePassword", method=RequestMethod.GET)
	public String viewChangePassword(@ModelAttribute("employee") Employee employee, Model model, HttpSession session) {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		String employeeId = ((Employee)session.getAttribute("employee")).getId();
		employee.setId(employeeId);
		session.setAttribute("menuItem", null);
		return "/changePassword";
	}
	@RequestMapping(value = "/changePassword", method=RequestMethod.POST)
	public String changePassword(@ModelAttribute("employee") Employee employee, Model model, HttpSession session) {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		employee = userService.changePassword(employee);		
		session.setAttribute("employee", employee);
		model.addAttribute("message", "Changed Password success!");
		return "/changePassword";
	}
	@RequestMapping(value = "/employeeLogin", method=RequestMethod.POST)
	public String employeeLogin(@ModelAttribute("employee") Employee employee, Model model, HttpSession session) throws Exception {
		String targetPage = "/login";
		Employee emp = userService.employeeLogin(employee);
		if (emp != null && emp.getPassWord().equals(employee.getPassWord())) {
			session.setAttribute("employee", emp);
			getReminders(model,emp.getId());
			targetPage = "/home";
			session.setAttribute("menuItem", "home");
		} else {
			model.addAttribute("message", "Username or Password invalid.");
		}
		session.getAttribute("employee");
		return targetPage;
	}
	private void getReminders(Model model, String employeeId) throws Exception{
		CommentCustomerBean beanRemind = new CommentCustomerBean();
		beanRemind.setRemindDate(Ultil.dateToString(new Date()));
		List<CustomerPotential> list = commentCustomerService.searchCommentCustomer(beanRemind);
		int size = list != null?list.size():0;		
		model.addAttribute("countRemindOver", size);

		CommentCustomerBean beanFirstMonth = new CommentCustomerBean();
		beanFirstMonth.setCreateDate(Ultil.firstDayOfMonth());
		beanFirstMonth.setEmployeeId(employeeId);
		List<CustomerPotential> list1 = commentCustomerService.searchCommentCustomer(beanFirstMonth);
		int size1 = list1 != null?list1.size():0;		
		model.addAttribute("countInMonth", size1);
	}
}
