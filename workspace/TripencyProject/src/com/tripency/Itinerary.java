package com.tripency;

import java.util.ArrayList;

public class Itinerary {

	ArrayList<Day> days = new ArrayList<Day>(); 

	//constructor
	
	public Itinerary() {

	}

	public Itinerary(ArrayList<Attraction> attractions) {
		
		addAttractionsToDays(attractions);

	}
	
	//getters and setters
	
	public ArrayList<Day> getDays() {
		return days;
	}

	public void setDays(ArrayList<Day> days) {
		this.days = days;
	}

	//methods
	
	private void addAttractionsToDays(ArrayList<Attraction> attractions){
		
		Day day = new Day();
		int dayDurationLimit = 480; //9 hours in minutes
		int dayDuration = 0;
		
		
		
		for (Attraction attraction : attractions){
			
			dayDuration = dayDuration + attraction.getRecommendedTime();
			
			if (dayDuration <= dayDurationLimit){
				
				day.addAttraction(attraction);
				
			} else {
				
				days.add(day);
				
				day = new Day();
				dayDuration = 0;
				day.addAttraction(attraction);
				
			}
			
		}
		
		days.add(day);

		
	}

}
