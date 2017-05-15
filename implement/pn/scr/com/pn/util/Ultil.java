package com.pn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.pn.model.dmEmployee.Employee;

public class Ultil {
	 public static Date stringToDate(String stringDate) {
		 Date date = null;
		 if (!"".equals(stringDate) && stringDate != null) {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			 try {
				 date = dateFormat.parse(stringDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		 }
		return date;
	 }
	 public static String dateToString(Date date) {
		 String stringDate = null;
		 if (date != null) {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			 stringDate  = dateFormat.format(date);
		 }
		return stringDate;
	 }
	 public static String dateTimeToString(Date date) {
		 String stringDate = null;
		 if (date != null) {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			 stringDate  = dateFormat.format(date);
		 }
		return stringDate;
	 }
	 public static String firstDayOfMonth() {
		 Calendar cal = Calendar.getInstance();
		 return "01/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
	 }
	 public static String checkPermission(HttpSession session, Model model) {
		 String targetpage = null;
			Employee emp = (Employee)session.getAttribute("employee");
			if (emp == null) {
				model.addAttribute("employee", new Employee());
				targetpage = "login";
			}
			return targetpage;
	 }
}
