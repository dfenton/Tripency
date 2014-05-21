package com.tripency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MatchManager {

	double userAttractionWeight;
	int userAttractionWeightID;
	double attractionWeight;
	double attractionMatrixPoints = 0;
	boolean timeRemaining = true;
	int userTotalTime; //in minutes
	ArrayList<Attraction> attractionCollection;
	ArrayList<Theme> userWeights;
	Attraction attraction;

	public ArrayList<Attraction> getMatchingAttractionsInOrder(ArrayList<Theme> userWeights, ArrayList<Attraction> attractionCollection) {

		this.attractionCollection = (attractionCollection);
		this.userWeights = userWeights;


		calcRatingWSTUser();
		print();
		sort();
		filterByTime();
		
		
		return attractionCollection;

	}

	public void setUserTotalTime(int numDays) {

		this.userTotalTime = numDays * 8 * 60; //8 hours a day, 60 minutes in an hour
	}

	// calcaulate rating with respect to user using the euclidean distance matrix formula
	private void calcRatingWSTUser() {

		for (Attraction attraction : attractionCollection) {

			for (Theme userWeight : userWeights) {

				userAttractionWeight = userWeight.getWeight();
				userAttractionWeightID = userWeight.getThemeID();

				attractionWeight = attraction.getCategoryWeightById(userAttractionWeightID);

				attractionMatrixPoints = attractionMatrixPoints	+ (Math.pow((userAttractionWeight - attractionWeight), 2));

			}

			attraction.setRatingWithRespectToUser(Math.sqrt(attractionMatrixPoints));
			attraction.setRatingWithRespectToUserPercent(100 - ((Math.sqrt(attractionMatrixPoints)*100) / 7.0710678118654755));

			attractionMatrixPoints = 0;

		}

	}

	private void sort() {

		Collections.sort(attractionCollection);
		

	}


	private void filterByTime() {
		

		int totalAttractionTime = 0;

		Iterator<Attraction> it = attractionCollection.iterator();

		while (it.hasNext()) {

			attraction = it.next();

			totalAttractionTime = totalAttractionTime + attraction.getRecommendedTime();

			if (totalAttractionTime > userTotalTime) {

				it.remove();

			}

		}
		
	}

	// iterate and print

	private void print() {
		for (Attraction attraction : attractionCollection){

			System.out.print(attraction.getName());
			System.out.print(" - ");
			System.out.print(attraction.getRatingWithRespectToUser());
			System.out.print(" - ");
			System.out.println(attraction.getRecommendedTime());
			
		}

	}

}
