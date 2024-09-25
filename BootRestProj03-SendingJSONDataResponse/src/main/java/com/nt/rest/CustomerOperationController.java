package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationController {
	
	@GetMapping("/report")
	public ResponseEntity<Customer> showCustomer(){
		//create model class object
		Customer cust = new Customer(1001,"Somanath","Hyd",83.55f);
		//return response object
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}

}
