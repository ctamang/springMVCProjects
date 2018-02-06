package com.practice.springmvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.practice.validation.ValidField;

public class User {

	private String id;
	
	private String title;
	
	@NotNull(message="required")
	@ValidField(value="CHAN", message="must start with CHAN")
	private String name;
	
	@NotNull(message="required")
	private String age;
	
	@NotNull(message="required")
	private String emailId;
	
	@NotNull(message="required")
	@Size(max=10, min=10, message="must be equal to 10 digits")
	private String phoneNumber;
	
	private String country;
	
	private String[] hobbies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	
	
}
