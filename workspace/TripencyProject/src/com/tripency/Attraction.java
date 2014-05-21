package com.tripency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Attraction implements Comparable<Attraction>{

	//MEMBERS
	int id;
	int recommendedTime;
	double ratingWithRespectToUser;
	double ratingWithRespectToUserPercent;
	
	//should refactor categoryWeights and themes into a single member, if time allows
	Map<Integer, Double> categoryWeights = new HashMap<Integer, Double>();
	ArrayList<Theme> themes = new ArrayList<Theme>(); 
	//
	
	String name;
	double rating;
	String imgPath;
	String description;
	String nearestPublicTrans;
	double cost;
	String contactNo;
	String address;
	String locationLat;
	String locationLong;
	
	
	
	//GETTERS & SETTERS
	public int getRecommendedTime() {
		return recommendedTime;
	}
	public void setRecommendedTime(int getRecommendedTime) {
		this.recommendedTime = getRecommendedTime;
	}	
	
	public double getRatingWithRespectToUser() {
		return ratingWithRespectToUser;
	}
	
	public void setRatingWithRespectToUser(double ratingWithRespectToUser) {
		this.ratingWithRespectToUser = ratingWithRespectToUser;
	}
	
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNearestPublicTrans() {
		return nearestPublicTrans;
	}
	public void setNearestPublicTrans(String nearestPublicTrans) {
		this.nearestPublicTrans = nearestPublicTrans;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getLocationLat() {
		return locationLat;
	}
	public void setLocationLat(String locationLat) {
		this.locationLat = locationLat;
	}
	public String getLocationLong() {
		return locationLong;
	}
	public void setLocationLong(String locationLong) {
		this.locationLong = locationLong;
	}
	
	public double getRatingWithRespectToUserPercent() {
		return ratingWithRespectToUserPercent;
	}
	public void setRatingWithRespectToUserPercent(
			double ratingWithRespectToUserPercent) {
		this.ratingWithRespectToUserPercent = ratingWithRespectToUserPercent;
	}
	
	//METHODS
	
	public void addCategoryWeight(int categoryID, double categoryWeight){
		
		categoryWeights.put(categoryID, categoryWeight);
		
	}
	
	public double getCategoryWeightById(int id){
	
			return categoryWeights.get(id);
	
	}
	
	public ArrayList getThemes(){
		
		return themes;
		
	}

	public void addTheme(Theme newTheme){
		
	
		themes.add(newTheme);				
		
				
	}
	


	@Override
	public int compareTo(Attraction a) {

		
		if (this.ratingWithRespectToUser < a.getRatingWithRespectToUser()) {
		
			return -1;
			
		}
		

		if (this.ratingWithRespectToUser > a.getRatingWithRespectToUser()) {
			
			return 1;
			
		}
		
		return 0;

	}
	
}
