package com.nt.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishService;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;


@Controller
//@RequestMapping("/wish-operations")
public class WishMessegeOperationController {

	@Autowired
	private IWishService service;
	
	/*@Autowired
	private ServletContext sc;
	@Autowired
	private ServletConfig cg;
	@Autowired
	private HttpSession sec;*/
	
	
	/*@RequestMapping("/")
	public String showHomePage() {
		//return LVN
		return "welcome";
	}*/
	
	/*@RequestMapping
	public String showHomePage() {
		//return LVN
		return "welcome";
	}*/
	
	@GetMapping("/all")
	public String showAllData() {
		
		System.out.println("WishMessegeOperationController.showAllData()");
		
		/*System.out.println("web application name::"+sc.getContextPath());
		System.out.println("session id ::"+sec.getId());
		System.out.println("DS logical name::"+cg.getServletName());*/
		
		return "show_report";
	}
	
	@GetMapping
	public String showHomePage1(/* not in the list ServletContext sc,ServletConfig cg,*/HttpSession sec) {
		System.out.println("WishMessegeOperationController.showHomePage1()");
		
		//System.out.println("web application name::"+sc.getContextPath());
		System.out.println("session id ::"+sec.getId());//only this is present
		//System.out.println("DS logical name::"+cg.getServletName());
		
		//return LVN
		//return "welcome";
//		return "forward:wish-operations/all";
		//return "forward:all";
		return "redirect:all";
	}
	
	@PostMapping
	public String showHomePage2() {
		//return LVN
		return "welcome";
	}
	
	
	/*	@RequestMapping("/wish")
		public ModelAndView fetchWishMessege() {
			
			//use servicefo
			String msg=service.generateWishMessage();
			//keep result and other data as Model attributes in MAV object
			ModelAndView mav=new ModelAndView();
			mav.addObject("wMsg",msg);//attribute name, value
			mav.addObject("sysDate",new Date());//attribute name, value
			mav.setViewName("show_result");
			//return MAV
			return mav;
			
		}*/
	
	
	/*@RequestMapping("/wish")
	public String fetchWishMessege(HashMap<String,Object> map) {
		System.out.println("shared memory object class name::"+map.getClass());
		//use servicefo
		String msg=service.generateWishMessage();
		//keep data into model attribute
		map.put("wMsg", msg);
		map.put("sysDate", new Date());
		//return MAV
		return "show_result";
		
	}*/
	
	
	/*@RequestMapping("/wish")
	public String fetchWishMessege(Model model) {
		System.out.println("shared memory object class name::"+model.getClass());
		//use servicefo
		String msg=service.generateWishMessage();
		//keep data into model attribute
		model.addAttribute("wMsg", msg);
		model.addAttribute("sysDate", new Date());
		//return MAV
		return "show_result";
		
	}*/
	
	/*@RequestMapping("/wish")
	public String fetchWishMessege(ModelMap map) {
		System.out.println("shared memory object class name::"+map.getClass());
		//use servicefo
		String msg=service.generateWishMessage();
		//keep data into model attribute
		map.addAttribute("wMsg", msg);
		map.addAttribute("sysDate", new Date());
		//return MAV
		return "show_result";
		
	}*/
	
	//best
	@RequestMapping("/wish")
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
	
	
	//usefull in file handling concept
	/*@RequestMapping("/wish")
	public String fetchWishMessege(HttpServletResponse res)throws Exception {
	
		//use service
		String msg=service.generateWishMessage();
		
		//get PrintWriter from response object
		PrintWriter pw=res.getWriter();
		//write output to response object
		pw.println("<b>Wish Messege is::"+msg+"</b><br>");
		pw.println("<b>system date and time  is::"+new Date()+"</b>");
		return null;
	}*/
	
	
	//@RequestMapping(value="/report" , method=RequestMethod.GET) (or)
	@GetMapping("/report")
	public String showReport()throws Exception {
		System.out.println("WishMessegeOperationController.showReport()");
		return "show_report";
	}
	
	//@RequestMapping(value="/report" , method=RequestMethod.POST) (or)
	@PostMapping("/report")
	public String showReport1()throws Exception {
		System.out.println("WishMessegeOperationController.showReport1()");
		return "show_report1";
	}
	
	
}
