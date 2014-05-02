package com.tripency;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MatchManager {
	
	ArrayList<ThemeWeight> weightCollectionByID = new ArrayList<ThemeWeight>();
	double userAttractionWeight;
	int userAttractionWeightID;
	double attractionWeight;
	double attractionMatrixPoints = 0;
	Map<Integer, Double> attractionsWithRespectToUser = new HashMap<Integer, Double>();

	public void getMatchingAttractionsInOrder(ArrayList<ThemeWeight> userWeights, ArrayList<Attraction> attractionCollection){
			
		for (Attraction attraction : attractionCollection){
		
			for (ThemeWeight userWeight : userWeights){
			
				userAttractionWeight = userWeight.getWeight();
				userAttractionWeightID = userWeight.getThemeID();
				
				attractionWeight = attraction.getCategoryWeightById(userAttractionWeightID);
				
				attractionMatrixPoints = attractionMatrixPoints + (Math.pow((userAttractionWeight - attractionWeight), 2));
				
			}
			
			System.out.println(attraction.getId() + " " +  Math.sqrt(attractionMatrixPoints));
			
			attractionsWithRespectToUser.put(attraction.getId(), Math.sqrt(attractionMatrixPoints));
			attractionMatrixPoints = 0;
			
		}
		

		
	}
	

	
	
}
