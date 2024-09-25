package com.nt.service;

import java.util.List;

import com.nt.error.TouristNotFoundException;
import com.nt.model.Tourist;

public interface ITouristMgmtService {
	
	public String registerTourist(Tourist tourist);
	
	public List<Tourist> showAllTourists();
	
	public List<Tourist> showTouristByBudgetRange(double start,double end);
	
	public Tourist showTouristById(int id)throws TouristNotFoundException;
	
	public String modifyTourist(Tourist tourist);
	
	public String modifyTouristBudgetById(int id,double hikePercentage);
	
	public String removeTouristById(int id);

	public String removeTouristByPackageType(String type);
	
}
