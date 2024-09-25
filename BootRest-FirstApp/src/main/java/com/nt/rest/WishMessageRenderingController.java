package com.nt.rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message-api")
public class WishMessageRenderingController {
	
	
	//operation
	@GetMapping("/wish")
	public ResponseEntity<String> showMessage(){
		//get system date and time
		LocalDateTime ldt=LocalDateTime.now();
		//get current hour of the day
		int hour=ldt.getHour();//24 hour format
		String msg=null;
		if(hour<12) {
			msg="Good Morning";
		}
		else if(hour<16) {
			msg="Good Afternoon";
		}
		else if(hour<20) {
			msg="Good Evening";
		}
		else {
			msg="Good Night";
		}
		
		//create and return response entity object
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}

}
