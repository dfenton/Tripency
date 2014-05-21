package com.tripency;

public class Theme {

	int attractionID;
	int themeID;
	String name;
	double weight;

	
	
	//constructor
	
	public Theme(){
		
	}
	

	public Theme(String name, double weight){
		
		this.name = name;
		this.weight = weight;
		
	}
	
	//getters and setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public int getAttractionID() {
		return attractionID;
	}
	public void setAttractionID(int attractionID) {
		this.attractionID = attractionID;
	}
	public int getThemeID() {
		return themeID;
	}
	public void setThemeID(int themeID) {
		this.themeID = themeID;
	}
	
	
	
}
