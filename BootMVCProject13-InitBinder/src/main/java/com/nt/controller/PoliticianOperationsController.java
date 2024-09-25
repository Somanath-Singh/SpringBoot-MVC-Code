package com.nt.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.PoliticianProfile;

@Controller
public class PoliticianOperationsController {

	
	@GetMapping("/")
	public String showHome() {
		//return LVN
		return "home";
	}
	
	@GetMapping("/register")
	public String showFormPage(@ModelAttribute("pp") PoliticianProfile profile) {
		System.out.println("PoliticianOperationsController.showFormPage()");
		//return LVN
		return "politician_register";
	}
	
	@PostMapping("/register")
	public String registerPolitician(@ModelAttribute("pp") PoliticianProfile profile) {
		System.out.println("PoliticianOperationsController.registerPolitician()");
		System.out.println("model class object data:"+profile);
		//by invoking service class u can execute b.logic
		return "show_result";
	}
	
	
	@InitBinder
	public void mydateBinder(WebDataBinder binder) {
		System.out.println("PoliticianOperationsController.mydateBinder()");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class,new CustomDateEditor(sdf,true));
	}
	
	
}
