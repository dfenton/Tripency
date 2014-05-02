package com.tripency;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONObject;




public class WeightingManager {

	public  ArrayList<Attraction> getAttractionWeightings(String userCategories){
		
		DAL db = new DAL();
		
				
		return db.getAttractionWeightCollection(userCategories);
		
		
	}
    
	public ArrayList<ThemeWeight> getUserWeightingFromJson(String userPrefs){
		
		ArrayList<ThemeWeight> themeWeightCollection = new ArrayList<ThemeWeight>();
		ThemeWeight themeWeight;
		int themeID;
		double weight; 
		
		
		try{
		
			JSONObject jsonObj = new JSONObject(userPrefs);
			
		    Iterator<String> keys = jsonObj.keys();
		    
		    while(keys.hasNext()){
		    	
		        String key = keys.next();
		        
		        try{
		        	
		        	themeID = Integer.parseInt(key);   
		        	weight = jsonObj.getDouble(key);
		            
		        	
		        	themeWeight = new ThemeWeight();
		        	themeWeight.setThemeID(themeID);
		        	themeWeight.setWeight(weight);
		        	
		        	themeWeightCollection.add(themeWeight);
		        	
		             
		        }catch(Exception e){
		            e.printStackTrace();
		        }

		    }
			
			
		} catch (Exception e) {

		}
		
		return themeWeightCollection;
		
		
	}
	
	public String getUserCategoriesFromJson(String userPrefs){
		
		StringBuilder sb = new StringBuilder();
		
		try{
		
			JSONObject jsonObj = new JSONObject(userPrefs);
			
		    Iterator<String> keys = jsonObj.keys();
		    
		    while(keys.hasNext()){
		    	
		        String key = keys.next();
		        
		        sb.append(key);
		        sb.append(",");

		    }
			
			
		} catch (Exception e) {

		}
		
		return sb.substring(0,sb.length()-1);
		
		
	}
	
}
