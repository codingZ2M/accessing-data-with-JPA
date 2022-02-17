package com.codingz2m.accessingdatawithJPA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="vacation_place")

public class VacationPlace {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private UUID id;
  @Column(nullable=false, length=200)
  private String placeName;
  @Column(nullable=false, length=150)
  private String country;

  protected VacationPlace() {
	  
  }

  public VacationPlace(UUID id, String placeName, String country) {
	  super();
	  this.id = id;
	  this.placeName = placeName;
	  this.country = country;
  }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}