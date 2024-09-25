package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationController {
	
	/*	@GetMapping("/report/{cno}/{cname}")
		public ResponseEntity<String> showReport(@PathVariable("cno") int no,@PathVariable String cname){
			
			System.out.println(no+"   "+cname);
			
			return new ResponseEntity<String>(no+" "+cname,HttpStatus.OK);
		}*/
	
	/*@GetMapping("/report/{cno}/{cname}")
	public ResponseEntity<String> showReport(@PathVariable(name="cno" ,required=false) int no,@PathVariable(required=false) String cname){
		
		System.out.println(no+"   "+cname);
		
		return new ResponseEntity<String>(no+" "+cname,HttpStatus.OK);
	}*/
	
	@GetMapping("/report/{cno}/{cname}")
	public ResponseEntity<String> showReport1(@PathVariable(name="cno") int no,@PathVariable String cname){
		
		System.out.println(no+"   "+cname);
		
		return new ResponseEntity<String>("form showReport1",HttpStatus.OK);
	}
	
	@GetMapping("/report/cno/cname")
	public ResponseEntity<String> showReport2(@PathVariable(name="cno") int no,@PathVariable String cname){
		
		System.out.println(no+"   "+cname);
		
		return new ResponseEntity<String>("form showReport2",HttpStatus.OK);
	}
	
	@GetMapping("/report/cno/{cname}")
	public ResponseEntity<String> showReport3(@PathVariable(name="cno") int no,@PathVariable String cname){
		
		System.out.println(no+"   "+cname);
		
		return new ResponseEntity<String>("form showReport3",HttpStatus.OK);
	}
	
	@GetMapping("/report/{cno}/cname")
	public ResponseEntity<String> showReport4(@PathVariable(name="cno") int no,@PathVariable String cname){
		
		System.out.println(no+"   "+cname);
		
		return new ResponseEntity<String>("form showReport4",HttpStatus.OK);
	}

}
