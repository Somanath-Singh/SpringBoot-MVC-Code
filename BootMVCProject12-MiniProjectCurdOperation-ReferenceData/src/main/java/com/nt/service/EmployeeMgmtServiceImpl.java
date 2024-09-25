package com.nt.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;
	
	
	@Override
	public List<Employee> getAllEmployee() {

		return empRepo.findAll();
		
	}
	
	@Override
	public String registerEmployee(Employee emp) {
		
		int idVal=empRepo.save(emp).getEmpno();
		return "Employee is Saved with the id value::"+idVal;
		
	}

	
	@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp=empRepo.findById(no).get();
		return emp;
	}
	
	@Override
	public String editEmployee(Employee emp) {
		
		int idVal=empRepo.save(emp).getEmpno();//save(-) method can perform both save/edit operation
		return idVal+" Employee is updated ";
	}
	
	
	@Override
	public String deleteEmployee(int no) {
		
		empRepo.deleteById(no);
		return no+" emp no is deleted";
	}
	
	@Override
	public Set<String> getAllCountries() {
		//get all Locales of the world
		Locale locales[]=Locale.getAvailableLocales();
		Set<String> countrySet=new TreeSet();
		for(Locale l:locales) {
			if(l!=null)
				countrySet.add(l.getDisplayCountry());
		}
		return countrySet;
	}
	
	
	@Autowired
	private Environment env;
	
	@Override
	public List<String> getStatesByCountry(String country) {
		//get states of country through Environment obj
		String stateInfo=env.getRequiredProperty(country);
		//convert comma seperated values into List collecting using "," as delimeter
		List<String> stateList=Arrays.asList(stateInfo.split(","));
		//sort collection
		Collections.sort(stateList);
		return stateList;
	}
	
}
