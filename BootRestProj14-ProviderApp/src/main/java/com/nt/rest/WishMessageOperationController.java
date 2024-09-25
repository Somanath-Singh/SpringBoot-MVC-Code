package com.nt.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;

@RestController
@RequestMapping("/wish-api")
public class WishMessageOperationController {
	
	@GetMapping("/wish")
	public ResponseEntity<String> showWishMessage(){
		return new ResponseEntity<String>("Good Morning",HttpStatus.OK);
	}
	
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> showWishMessage1(@PathVariable int id,@PathVariable String name){
		return new ResponseEntity<String>("Good Morning "+id+" "+name,HttpStatus.OK);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		return new ResponseEntity<String>(actor.toString(),HttpStatus.OK);
	}
	
	@GetMapping("/report")
	public ResponseEntity<Actor> showReport(){
		Actor actor=new Actor(1001,"Somanath","hyd",89000.6);
		return new ResponseEntity<Actor>(actor,HttpStatus.OK);
	}
	
	@GetMapping("/reportAll")
	public ResponseEntity<List<Actor>> showReportAll(){
		Actor actor1=new Actor(1001,"Somanath","hyd",89000.6);
		Actor actor2=new Actor(1001,"Banty","hyd",89000.6);
		Actor actor3=new Actor(1001,"Rahul","hyd",89000.6);
		List<Actor> list=List.of(actor1,actor2,actor3);
		return new ResponseEntity<List<Actor>>(list,HttpStatus.OK);
	}
	
	
}
