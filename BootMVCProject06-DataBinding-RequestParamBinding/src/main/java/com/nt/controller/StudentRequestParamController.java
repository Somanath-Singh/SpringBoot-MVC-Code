package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentRequestParamController {
	
	
	/*@GetMapping("/data")
	public String process(@RequestParam("sno") int no,@RequestParam("sname") String name) {
		System.out.println(no+"  "+name);
		//return LVN
		return "show_result";
	}*/
	
	/*@GetMapping("/data")
	public String process(@RequestParam int sno,@RequestParam String sname) {
		System.out.println(sno+"  "+sname);
		//return LVN
		return "show_result";
	}*/
	
	
	@GetMapping("/data")
	public String process(@RequestParam int sno,@RequestParam String sname,@RequestParam("sadd") String addrs[],@RequestParam("sadd") List<String> saddList,@RequestParam("sadd") Set<String>saddSet) {
		System.out.println(sno+"  "+sname+"   "+Arrays.toString(addrs)+"   "+saddList+"    "+saddSet);
		//return LVN
		return "show_result";
	}
	
	
	
	

}
