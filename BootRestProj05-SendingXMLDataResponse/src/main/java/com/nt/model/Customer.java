package com.nt.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	private Integer cno;
	private String cname;
	private String cadd;
	private Float billAmt;
	//array
	private String[] nickNames;
	//collection
	private List<String> friends;
	private Set<Long> phNo;
	private Map<String,Integer> idDetails;
	//HAS-A property
	private Company company;
	//date type
	private LocalDateTime dob;
	//boolean type
	private boolean isIndian;
	
	

}
