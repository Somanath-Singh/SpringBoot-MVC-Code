package com.nt.model;

import java.util.List;
import java.util.Map;

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
	private List<Company> companiesList;
	private List<Map<String,Object>> familyIds;
	
}
