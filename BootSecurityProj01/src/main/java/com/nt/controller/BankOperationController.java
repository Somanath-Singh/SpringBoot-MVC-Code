package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class BankOperationController {
	
	/*@GetMapping("/")
	public String showHome() {
		//return lvn
		return "welcome";
		
	}
	*/
	
	@GetMapping("/")
	public String showHome(HttpSession session) {
		
		//specify max idle time period
		//after 2 min home page session is expired
		session.setMaxInactiveInterval(120); //120 sec = 2 min
		//return lvn
		return "welcome";
		
	}
	
	
	
	@GetMapping("/offers")
	public String showOffers() {
		//return lvn
		return "offers";
		
	}
	
	@GetMapping("/balance")
	public String showBalance(Map<String,Object> map) {
		
		//make the balance is the model attribute value
		map.put("balance", new Random().nextInt(200000));
		//return lvn
		return "balance";
		
	}
	
	@GetMapping("/loanapprove")
	public String showApproveLoan(Map<String,Object> map) {
		
		//keep the aproved loan ammount as the model attribute
		map.put("amount", new Random().nextInt(100000));
		//return lvn
		return "approveloan";
		
	}

}
