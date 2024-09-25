package com.nt.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.IWishService;


@Controller
public class WishMessegeOperationController {

	@Autowired
	private IWishService service;
	
	@GetMapping("/")
	public String showHomePage() {
		//return LVN
		return "welcome";
	}
		
	
	//best
	@GetMapping("/wish")
	public String fetchWishMessege(Map<String,Object> map) {
		System.out.println("shared memory object class name::"+map.getClass());
		//use servicefo
		String msg=service.generateWishMessage();
		//keep data into model attribute
		map.put("wMsg", msg);
		map.put("sysDate", new Date());
		//return MAV
		return "show_result";
		
	}
	

	
}
