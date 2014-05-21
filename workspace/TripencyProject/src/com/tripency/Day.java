package com.tripency;

import java.util.ArrayList;

public class Day {

	ArrayList<Attraction> attractions = new ArrayList<Attraction>(); 
	
	//constructor
	public Day(){
		
	}
	
	//getters and setters
	
	
	public ArrayList<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(ArrayList<Attraction> attractions) {
		this.attractions = attractions;
	}

	//members
	
	public void addAttraction(Attraction attraction){
		
		attractions.add(attraction);
		
	}
	
}
