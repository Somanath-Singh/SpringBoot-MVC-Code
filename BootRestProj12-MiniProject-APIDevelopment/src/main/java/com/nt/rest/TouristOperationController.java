package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Tourist;
import com.nt.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist-api")
public class TouristOperationController {

	@Autowired
	private ITouristMgmtService touristService;

	@PostMapping("/save")
	public ResponseEntity<String> saveTourist(@RequestBody Tourist tourist) {

		try {
			String resultMsg = touristService.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
		} catch (Exception se) {
			return new ResponseEntity<String>(se.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// ? means it can be changed as you want
	@GetMapping("report")
	public ResponseEntity<?> showTourist() {

		try {
			List<Tourist> list = touristService.showAllTourists();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
			
		} catch (Exception se) {
			return new ResponseEntity<String>(se.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report/{start}/{end}")
	public ResponseEntity<?> showReportByBudgetRange(@PathVariable double start,@PathVariable double end){
		
		try {
			List<Tourist> list = touristService.showTouristByBudgetRange(start, end);
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		} catch (Exception se) {
			return new ResponseEntity<String>(se.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable Integer id){
		try {
			Tourist tourist=touristService.showTouristById(id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		}
		catch(Exception se) {
			return new ResponseEntity<String>(se.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist){
		try {
			String resultMsg = touristService.modifyTourist(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.OK);
		} catch (Exception se) {
			return new ResponseEntity<String>(se.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/update/{id}/{budget}")
	public ResponseEntity<String> updateTouristBudget(@PathVariable int id,@PathVariable double budget){
		try {
			String resultMsg = touristService.modifyTouristBudgetById(id, budget);
			return new ResponseEntity<String>(resultMsg, HttpStatus.OK);
		} catch (Exception se) {
			return new ResponseEntity<String>(se.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTourist(@PathVariable int id){
		try {
			String resultMsg = touristService.removeTouristById(id);
			return new ResponseEntity<String>(resultMsg, HttpStatus.OK);
		} catch (Exception se) {
			return new ResponseEntity<String>(se.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/remove/{type}")
	public ResponseEntity<String> deleteTouristByPackageType(@PathVariable String type){
		try {
			String resultMsg = touristService.removeTouristByPackageType(type);
			return new ResponseEntity<String>(resultMsg, HttpStatus.OK);
		} catch (Exception se) {
			return new ResponseEntity<String>(se.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
