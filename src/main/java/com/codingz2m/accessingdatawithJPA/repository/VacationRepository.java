package com.codingz2m.accessingdatawithJPA.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.codingz2m.accessingdatawithJPA.entity.VacationPlace;
import org.springframework.data.repository.query.Param;

public interface VacationRepository extends CrudRepository<VacationPlace, Long> {
	
   //  Optional<VacationPlac> findById(ID id);    // Built-In method...
  //  Iterable<VacationPlac> findAll();           // Built-In method...
  //  VacationPlace save(VacationPlace entity);
	
	  List<VacationPlace> findByCountry(String country); // Custom method...
	  
	  
	// Custom Queries with @Query Annotation
	// Creating JPA-based repository layer, using Spring Data JPA
		
	// JPQL Update @Query
	    @Modifying
		@Query("UPDATE VacationPlace vp SET vp.placeName = :placeName WHERE "
		 		                           + "vp.id = :id")
	    int updateVacationPlace(@Param("id") UUID id, @Param("placeName") String placeName);
  
 }
