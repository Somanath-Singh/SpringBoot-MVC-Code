package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataRenderingController {
	
	@GetMapping("/report")
	public String showReportData(Map<String,Object> map) {
		//add simple values as the model attribute
		map.put("name", "Raja");
		map.put("age", 30);
		map.put("addrs", "hyd");
		//return LVN
		return "show_report";
	}
	
	/*@GetMapping("/report")
	public String showReportData(Map<String,Object> map) {
		//add simple values as the model attribute
		map.put("favColors", new String[]{"red	","green","blue","yellow","black"});
		map.put("nickNames", List.of("raja","maharaja","king","prince"));
		map.put("phoneNumbers", Set.of(9632587412L,8521479632L,5214789632L));
		map.put("idDetails", Map.of("aadhar",966167218377L,"voterid",58235165165L,"panNo","FGRDTR5255"));
		//return LVN
		return "show_report";
	}*/
	
	
	/*@GetMapping("/report")
	public String showReportData(Map<String ,Object> map) {
		//create Model class object having data(Generaly this object comes from DAO,service classes)
		//having db table record
		Product prod=new Product(1001,"sofa",58264.0,1.0);
		//make model class obj as the model attribute
		map.put("prodData", prod);
		//return LVN
		return "show_report";
	}*/
	
	
	/*@GetMapping("/report")
	public String showReportData(Map<String ,Object> map) {
		//create list of model class object as the model attribute
		List<Product> list=List.of(new Product(1001,"sofa",58264.0,1.0),new Product(1002,"Chair",5264.0,2.0));
		map.put("prodList", list);
		//return LVN
		return "show_report";
	}*/
	
	
	
	

}
