package com.nt.servlet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperatinController {

	@GetMapping("/report")
	public ResponseEntity<String> showReport() {
		System.out.println("CustomerOperatinController.showReport()");
		return new ResponseEntity<String>("Report Operation", HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer() {
		System.out.println("CustomerOperatinController.registerCustomer()");
		return new ResponseEntity<String>("Customer Registration Operation", HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomer(){
		System.out.println("CustomerOperatinController.updateCustomer()");
		return new ResponseEntity<String>("Customer Update Operation",HttpStatus.OK);
	}
	
	@PatchMapping("/pupdate")
	public ResponseEntity<String> patchUpdateCustomer(){
		System.out.println("CustomerOperatinController.patchUpdateCustomer()");
		return new ResponseEntity<String>("Customer Patch Update Operation",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer(){
		System.out.println("CustomerOperatinController.deleteCustomer()");
		return new ResponseEntity<String>("Customer Delete Operation",HttpStatus.OK);
	}

}
