package com.codingz2m.accessingdatawithJPA.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.query.Param;

import com.codingz2m.accessingdatawithJPA.entity.VacationPlace;

public interface VacationService {
	
	VacationPlace addVacationPlace(VacationPlace vacationPlace);
	
	List<VacationPlace> findAllVacationPlaces(); 
	
	List<VacationPlace> findVacationPlacesByCountry(String country);

	VacationPlace findVactionPlaceById(long id);
	
	int updateVacationPlace (UUID id, String placeName);
	
}
