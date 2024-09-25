package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validation.EmployeeValidator;

@Controller
public class EmployeeOperationController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@Autowired
	private EmployeeValidator empValidator;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	//
	@GetMapping("/report")
	public String showEmployeeReport(@PageableDefault(page=0,size=3,sort="job",direction=Sort.Direction.ASC) Pageable pageable,Map<String,Object> map) {
		System.out.println("EmployeeOperationController.showEmployeeReport()");
		//use service
		Page<Employee> page=service.getEmployeePageData(pageable);
		//put the results in model attributes
		map.put("empsData",page);
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
	public String addEmployee(RedirectAttributes attrs,@ModelAttribute("emp")Employee emp,BindingResult error) {
		
		System.out.println("EmployeeOperationController.addEmployee()");
		
		//enable server side form validations only when client side form validations are not done
		if(emp.getVflag().equalsIgnoreCase("no")) {
			
			//checking for type missmatch errors
			if(error.hasFieldErrors())
				return "employee_register";
			
			//checking form validation errors
			if(empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, error);//T
				if(error.hasErrors())
					return "employee_register";
			}
			
		}
		
		//application errors
		if(emp.getJob().equalsIgnoreCase("hacker")) {
			error.rejectValue("job","job.reject");
			return "employee_register";
		}
		
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
	public String editEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attrs,BindingResult errors) {
		
		//enable server side form validations only when client side form validations are not done
				if(emp.getVflag().equalsIgnoreCase("no")) {
					
					//checking for type missmatch errors
					if(errors.hasFieldErrors())
						return "employee_edit";
					
					//form validation errors
				if(empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, errors);//T
				if(errors.hasErrors())
					return "employee_edit";
				}
				
				}
		
		//application errors
		if(emp.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job","job.reject");
			return "employee_edit";
		}
		
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
				//List<Employee> list=service.getAllEmployee();
				//keeps results as flashAttributes attributes in Redirect scope
				attrs.addFlashAttribute("resultMsg",msg);
				//return LVN
				return "redirect:report";
	}
		
}
