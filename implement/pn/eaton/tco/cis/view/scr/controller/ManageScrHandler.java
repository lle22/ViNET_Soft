package com.eaton.tco.cis.view.scr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eaton.tco.cis.entity.productType.ProductType;
import com.eaton.tco.cis.entity.scr.Scr;
import com.eaton.tco.cis.entity.vehicleClass.VehicleClass;
import com.eaton.tco.cis.service.productType.ProductTypeService;
import com.eaton.tco.cis.service.scr.ScrService;
import com.eaton.tco.cis.service.vehicleClassService.VehicleClassService;

@Controller
@RequestMapping(value="/scr")
public class ManageScrHandler {
	
	@Autowired
	private ScrService scrService;
	@Autowired
	private VehicleClassService vehicleClassService;
	@Autowired
	private ProductTypeService productTypeService;

	
	
	@RequestMapping(method=RequestMethod.GET)
	public String addSCR(Model model) {
		Scr scr = scrService.getScr(100);
		model.addAttribute(scr);
		List<VehicleClass> vehicles = vehicleClassService.getAllVehicleClass();
		model.addAttribute("vehicleClass", vehicles);
		return "scr/addSCR";
	}
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public @ResponseBody List<ProductType> getTime(@RequestParam String name) {
		List<ProductType> pt = productTypeService.getAllProductType();
		return pt;
	}

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Scr scr = null; 
		model.addAttribute(scr);
		return "scr/view";
	}
	public static void main(String[] args) {
		  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		  ctx.scan("com.eaton");
		  ctx.refresh();
		  ScrService myService = ctx.getBean(ScrService.class);
		}
}
