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
		
		emp.setJob("CLERK");//initiallly value to display in form comp as initial value
		//return LVN
		return "employee_register";
	}
	
	
	@PostMapping("/addEmp")
	public String addEmployee(Map<String,Object> map,@ModelAttribute("emp")Employee emp) {
		
		//use service
		String result=service.registerEmployee(emp);
		List<Employee> list = service.getAllEmployee();
		//keep results in model attribute
		map.put("resultMsg",result);
		map.put("empsData", list);
		//return LVN
		return "emp_report1";
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
	public String editEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
		
		//use service
		String msg=service.editEmployee(emp);
		List<Employee> list=service.getAllEmployee();
		//keeps results in model attributes
		map.put("resultMsg", msg);
		map.put("empsData", list);
		//return LVN
		return "emp_report1";
	}
	
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no,Map<String ,Object> map) {
		
		//use service
				String msg=service.deleteEmployee(no);
				List<Employee> list=service.getAllEmployee();
				//keeps results in model attributes
				map.put("resultMsg", msg);
				map.put("empsData", list);
				//return LVN
				return "emp_report1";
	}
		
}
