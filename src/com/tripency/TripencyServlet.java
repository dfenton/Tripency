package com.tripency;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TripencyServlet
 */
public class TripencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    // Set response content type
	    response.setContentType("text/html");
			    
	    System.out.println("---in server---");
	    
    
	    
		RequestDispatcher rd = request.getRequestDispatcher("home.html"); 
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("---in server---");
		String userCategories;
		
		ArrayList<ThemeWeight> userWeightingCollection;
		ArrayList<Attraction> attractionWeightingCollection;
		
	    // Set response content type
	    response.setContentType("text/html");
		
	    String jsonStr = request.getParameter("data");	    
	    
	    System.out.println(jsonStr);
	    
	    WeightingManager weightingMgr = new WeightingManager();
	    
	    userWeightingCollection = weightingMgr.getUserWeightingFromJson(jsonStr);	 
	    userCategories = weightingMgr.getUserCategoriesFromJson(jsonStr);
	    attractionWeightingCollection = weightingMgr.getAttractionWeightings(userCategories);
	    
	    MatchManager matchMgr = new MatchManager();
	    matchMgr.getMatchingAttractionsInOrder(userWeightingCollection, attractionWeightingCollection);
	    
		RequestDispatcher rd = request.getRequestDispatcher("home.html"); 
		rd.forward(request, response);
	}

}
