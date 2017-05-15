package com.pn.view.chungtu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pn.model.chungtu.ChiTietChungTu;
import com.pn.service.chungtu.ChungtuService;
import com.pn.util.Ultil;
import com.pn.view.chungtu.bean.ChungTuBean;

@Controller
public class ChungTuController {
	@Autowired
	private ChungtuService chungtuService;
	
	@RequestMapping(value="/viewChungTu", method=RequestMethod.GET)
	public String viewChungTu(@ModelAttribute("chungTuBean") ChungTuBean bean, Model model, HttpSession session) throws Exception {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		return "chungtu";
	}
	@RequestMapping(value = "/searchChungTu", method=RequestMethod.POST)
	public String searchChungTu(@ModelAttribute("chungTuBean") ChungTuBean bean,
			Model model, HttpSession session) throws Exception {
		String target = Ultil.checkPermission(session, model);
		if (target != null) {
			return target;
		}
		String soPhieu = "PN-HDBH";
		if(bean.getChungTuId() != null && !"".equals(bean.getChungTuId().toString())){
			List<ChiTietChungTu> detail = chungtuService.getAllChungTuBaseSoPhieu( soPhieu + "-" + (bean.getChungTuId()+1), bean.getThang());
			model.addAttribute("list", detail);
		}
		return "/chungtu";
	}	
}
