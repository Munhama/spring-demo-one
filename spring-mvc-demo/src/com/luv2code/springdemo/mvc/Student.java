package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.List;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystem;
	
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	
	public Student() {
		// populate favorite language options
		favoriteLanguageOptions = new LinkedHashMap<String, String>();
		
		// parameter order: value, display label
		favoriteLanguageOptions.put("Java", "Java");
		favoriteLanguageOptions.put("C", "C");
		favoriteLanguageOptions.put("Go", "Go");
		favoriteLanguageOptions.put("Python", "Python");
		favoriteLanguageOptions.put("PHP", "PHP");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
}
