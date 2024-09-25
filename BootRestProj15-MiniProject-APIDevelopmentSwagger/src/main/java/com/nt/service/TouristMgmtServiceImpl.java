package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.error.TouristNotFoundException;
import com.nt.model.Tourist;
import com.nt.repository.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo touristRepo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		
		int idVal = touristRepo.save(tourist).getTid();
		
		return "Tourist is registered with id value "+idVal;
	}

	/*@Override
	public List<Tourist> showAllTourists() {
		
		return touristRepo.findAll();
		
	}*/
	
	@Override
	public List<Tourist> showAllTourists() {
		
		List<Tourist> list = touristRepo.findAll();
//		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		list.sort((t1,t2)->t1.getTname().compareTo(t2.getTname()));
		return list;
		
		
	}

	@Override
	public List<Tourist> showTouristByBudgetRange(double start, double end) {
		
		return touristRepo.searchTouristsByBudgetRange(start, end);
		
	}

	@Override
	public Tourist showTouristById(int id) throws TouristNotFoundException {

		return touristRepo.findById(id).orElseThrow(()->new TouristNotFoundException(id+ "Tourist not found"));
	}

	@Override
	public String modifyTourist(Tourist tourist) {
		//find tourist
		Optional<Tourist> opt=touristRepo.findById(tourist.getTid());
		if(opt.isPresent()) {
			touristRepo.save(tourist);
			return tourist.getTid()+" Tourist is Updated";
		}
		return tourist.getTid()+" Tourist is not found for Updation";
	}
	
	@Override
	public String modifyTouristBudgetById(int id, double hikePercentage) {
		//find tourist
		/*Optional<Tourist> opt=touristRepo.findById(id);
		if(opt.isPresent()) {
			//get tourist object
			Tourist tur=opt.get();
			tur.setBudget(tur.getBudget()+tur.getBudget()*hikePercentage/100.f);
			touristRepo.save(tur);
			return id+"Budget Updated";
		}
		return id+"Tourist not found";*/
		
		//or
		
		Tourist tur=touristRepo.findById(id).get();
		tur.setBudget(tur.getBudget()+tur.getBudget()*hikePercentage/100.f);
		if(tur.getTid()==id) {
			touristRepo.save(tur);
			return id+"Budget Updated";
		}
		
		return id+"Tourist not found";
	}
	
	@Override
	public String removeTouristById(int id) {
		
		Tourist tur=touristRepo.findById(id).get();
		if(tur.getTid()==id) {
			touristRepo.deleteById(id);
			return id+"Tourist Deleted";
		}
		
		return id+"Tourist not found";
		
	}
	
	@Override
	public String removeTouristByPackageType(String type) {
	
		int count = touristRepo.deleteTouristsByPackageType(type);
		return count+" no of tourist are removed";
	}

}
