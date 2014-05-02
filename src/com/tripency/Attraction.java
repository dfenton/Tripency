package com.tripency;

import java.util.HashMap;
import java.util.Map;

public class Attraction {

	int id;
	Map<Integer, Double> categoryWeights = new HashMap<Integer, Double>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map<Integer, Double> getCategoryWeights() {
		return categoryWeights;
	}
	
	public void setCategoryWeights(HashMap categoryWeights) {
		this.categoryWeights = categoryWeights;
	}
	
	
	public void addCategoryWeight(int categoryID, double categoryWeight){
		
		categoryWeights.put(categoryID, categoryWeight);
		
	}
	
	public double getCategoryWeightById(int id){
	
			return categoryWeights.get(id);
	
	}
	
	
}
