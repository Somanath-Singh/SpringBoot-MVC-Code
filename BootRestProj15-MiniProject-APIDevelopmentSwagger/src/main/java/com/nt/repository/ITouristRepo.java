package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

	//custome method
	@Query("from Tourist where budget>=:start and budget<=:end")
	public List<Tourist> searchTouristsByBudgetRange(double start,double end);
	
	@Query("delete from Tourist where packageType=:type")
	@Modifying
@Transactional
	public int deleteTouristsByPackageType(String type);
	
}
