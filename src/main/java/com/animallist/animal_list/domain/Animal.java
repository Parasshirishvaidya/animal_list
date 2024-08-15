package com.animallist.animal_list.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id; 
    private String name;
    private String category;
    private byte[] image;
    private String description;
    private String lifeExpectancy;
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Animal(Long id, String name, String category, byte[] image, String description, String lifeExpectancy) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.image = image;
		this.description = description;
		this.lifeExpectancy = lifeExpectancy;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLifeExpectancy() {
		return lifeExpectancy;
	}
	public void setLifeExpectancy(String lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

    
    
}
