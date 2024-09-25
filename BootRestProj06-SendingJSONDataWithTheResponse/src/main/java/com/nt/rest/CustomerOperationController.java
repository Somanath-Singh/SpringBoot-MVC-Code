package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationController {

	@PostMapping("/register")
	public ResponseEntity<Customer> sregisterCustomer(@RequestBody Customer cust) {

		System.out.println(cust);
		Customer cus=new Customer();
		cus.setBillAmt(cust.getBillAmt()+100);

		// return response object
		return new ResponseEntity<Customer>(cus, HttpStatus.OK);
	}

}
