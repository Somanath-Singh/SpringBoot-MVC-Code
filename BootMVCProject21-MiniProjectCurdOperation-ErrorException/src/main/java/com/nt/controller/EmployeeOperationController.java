package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/report")
	public String showEmployeeReport(Map<String,Object> map) {
		System.out.println("EmployeeOperationController.showEmployeeReport()");
		//use service
		List<Employee> list=service.getAllEmployee();
		//put the results in model attributes
		map.put("empsData",list);
		//return LVN
		return "emp_report1";
	}
	
	
	//lunching add emp form page
	@GetMapping("/addEmp")
	public String showAddEmpFormPage(@ModelAttribute("emp")Employee emp) {
		System.out.println("EmployeeOperationController.showAddEmpFormPage()");
		emp.setJob("CLERK");//initiallly value to display in form comp as initial value
		//return LVN
		return "employee_register";
	}
	
	//msg not showing
	/*@PostMapping("/addEmp")
	public String addEmployee(Map<String ,Object> map,@ModelAttribute("emp")Employee emp) {
		System.out.println("EmployeeOperationController.addEmployee()");
		//use service
		String result=service.registerEmployee(emp);
		//keep results in model attribute(RedirectAttribute)
		map.put("resultMsg",result);
		//return LVN
		return "redirect:report";
	}*/
	
	//msg shown and after refresh it will gone
	@PostMapping("/addEmp")
	public String addEmployee(RedirectAttributes attrs,@ModelAttribute("emp")Employee emp) {
		System.out.println("EmployeeOperationController.addEmployee()");
		//use service
		String result=service.registerEmployee(emp);
		//keep results in model attribute(RedirectAttribute)
		attrs.addFlashAttribute("resultMsg",result);
		//return LVN
		return "redirect:report";
	}
	
	
	@GetMapping("/edit")
	public String showEditEmployeeForm(@RequestParam("no") int no,@ModelAttribute("emp")Employee emp) {
		
		//get Employee deails dynamicaly based on the given emp no
		Employee emp1=service.getEmployeeByNo(no);
		//emp==emp1
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "employee_edit";
		
	}
	
	@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attrs) {
		
		//use service
		String msg=service.editEmployee(emp);
		//keeps results as flashAttributes attributes in Redirect scope
		attrs.addFlashAttribute("resultMsg",msg);
		//return LVN
		return "redirect:report";
	}
	
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no,RedirectAttributes attrs) {
		
		//use service
				String msg=service.deleteEmployee(no);
				List<Employee> list=service.getAllEmployee();
				//keeps results as flashAttributes attributes in Redirect scope
				attrs.addFlashAttribute("resultMsg",msg);
				//return LVN
				return "redirect:report";
	}
		
}
