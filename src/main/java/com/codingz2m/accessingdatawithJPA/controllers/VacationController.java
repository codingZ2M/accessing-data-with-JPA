package com.codingz2m.accessingdatawithJPA.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.codingz2m.accessingdatawithJPA.entity.VacationPlace;
import com.codingz2m.accessingdatawithJPA.service.VacationService;

@RestController
@RequestMapping("vacation-place")
public class VacationController {

	private VacationService vacationService;

	@Autowired
	public VacationController(@Qualifier("vs")VacationService vacationService) {
		this.vacationService = vacationService;
	} 
	
	@PostMapping
	public ResponseEntity<VacationPlace> addVacationPlace( @RequestBody VacationPlace vacationPlace) {

		vacationPlace = vacationService.addVacationPlace(vacationPlace);
		return ResponseEntity.status(HttpStatus.CREATED).body(vacationPlace);
	  }
	
	@GetMapping 
	public ResponseEntity <List<VacationPlace>> getAllVacationPlaces(){
		List <VacationPlace> allVacationPlaces = vacationService.findAllVacationPlaces();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(allVacationPlaces);
	}
	
	@GetMapping (path ="/{country}")
	public ResponseEntity <List<VacationPlace>>getVacationPlacesByCountry (
			@PathVariable(value="country")String country) {
		List <VacationPlace> vacationPlacesByCountry = vacationService.findVacationPlacesByCountry(country);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(vacationPlacesByCountry);
	}
	
	@PutMapping(path ="/{id}/{placeName}")
	public int updateVacationPlace(
			@PathVariable(value="id")UUID id, 
			@PathVariable(value="placeName")String placeName) { 
		int updateCount = vacationService.updateVacationPlace(id, placeName);
		
		return updateCount;
	}
}
