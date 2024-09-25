package com.nt.rest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationController {

	@GetMapping("/report")
	public ResponseEntity<Customer> showCustomer() {
		// create model class object
		Customer cust = new Customer();
		cust.setCno(1001);
		cust.setCname("Somanath");
		cust.setBillAmt(96.58f);
		cust.setNickNames(new String[] { "raj", "maharaj", "king" });
		cust.setFriends(List.of("raja", "ravi", "suresh"));
		cust.setPhNo(Set.of(1234567895L, 7894561235L, 5829637415L));
		cust.setIdDetails(Map.of("aadhar", 856932, "passport", 524785, "voterid", 963258));
		cust.setDob(LocalDateTime.of(1991, 10, 2, 6, 7, 10));
		Company com = new Company(1234, "HCL", "Hyd", 100);
		cust.setCompany(com);
		cust.setIndian(true);
		// return response object
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}

	@GetMapping("/creport")
	public Customer showCustomerDetails() {
		// create model class object
		Customer cust = new Customer();
		cust.setCno(1001);
		cust.setCname("Somanath");
		cust.setBillAmt(96.58f);
		cust.setNickNames(new String[] { "raj", "maharaj", "king" });
		cust.setFriends(List.of("raja", "ravi", "suresh"));
		cust.setPhNo(Set.of(1234567895L, 7894561235L, 5829637415L));
		cust.setIdDetails(Map.of("aadhar", 856932, "passport", 524785, "voterid", 963258));
		cust.setDob(LocalDateTime.of(1991, 10, 2, 6, 7, 10));
		Company com = new Company(1234, "HCL", "Hyd", 100);
		cust.setCompany(com);
		cust.setIndian(true);
		// return response object
		return cust;
	}

	@GetMapping("/report1")
	public ResponseEntity<List<Customer>> showCustomer1() {

		// create model class object
		Customer cust = new Customer();
		cust.setCno(1001);
		cust.setCname("Somanath");
		cust.setBillAmt(96.58f);
		cust.setNickNames(new String[] { "raj", "maharaj", "king" });
		cust.setFriends(List.of("raja", "ravi", "suresh"));
		cust.setPhNo(Set.of(1234567895L, 7894561235L, 5829637415L));
		cust.setIdDetails(Map.of("aadhar", 856932, "passport", 524785, "voterid", 963258));
		cust.setDob(LocalDateTime.of(1991, 10, 2, 6, 7, 10));
		Company com = new Company(1234, "HCL", "Hyd", 100);
		cust.setCompany(com);
		cust.setIndian(true);

		// create model class object
		Customer cust1 = new Customer();
		cust1.setCno(1001);
		cust1.setCname("Somanath");
		cust1.setBillAmt(96.58f);
		cust1.setNickNames(new String[] { "raj", "maharaj", "king" });
		cust1.setFriends(List.of("raja", "ravi", "suresh"));
		cust1.setPhNo(Set.of(1234567895L, 7894561235L, 5829637415L));
		cust1.setIdDetails(Map.of("aadhar", 856932, "passport", 524785, "voterid", 963258));
		cust1.setDob(LocalDateTime.of(1991, 10, 2, 6, 7, 10));
		Company com1 = new Company(1234, "HCL", "Hyd", 100);
		cust1.setCompany(com1);
		cust1.setIndian(true);

		List<Customer> list = List.of(cust, cust1);

		// return response object
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}

}
