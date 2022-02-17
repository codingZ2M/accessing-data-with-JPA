package com.codingz2m.accessingdatawithJPA.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import com.codingz2m.accessingdatawithJPA.entity.VacationPlace;
import com.codingz2m.accessingdatawithJPA.repository.VacationRepository;


@Service (value="vs")
@Transactional
public class VacationServiceImpl implements VacationService {

	VacationRepository vacationRepository;
	
	@Autowired
	public VacationServiceImpl(VacationRepository vacationRepository) {
		super();
		this.vacationRepository = vacationRepository;
	}
     
	@Override
	public VacationPlace addVacationPlace(VacationPlace vacationPlace) {
		vacationPlace = vacationRepository.save(vacationPlace);
		return vacationPlace;
	}

	@Override
	public List<VacationPlace> findAllVacationPlaces() {
	Iterable <VacationPlace> allVacationPlaces = vacationRepository.findAll();
		return (List<VacationPlace>) allVacationPlaces;
	}

	@Override
	public List<VacationPlace> findVacationPlacesByCountry(String country) {
		List<VacationPlace> vacationPlacesByCountry = vacationRepository.findByCountry(country);
		return vacationPlacesByCountry;
	}

	@Override
	public int updateVacationPlace(UUID id, String placeName) {
		int updateCount =  vacationRepository.updateVacationPlace(id, placeName);
		return updateCount;
	}
	
	@Override
	public VacationPlace findVactionPlaceById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	


}
