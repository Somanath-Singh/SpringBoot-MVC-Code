package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test-operations")
public class TestController {

	
	@GetMapping("/all")
	public String getAllTestData() {
		return "show_report1";
	}
}
