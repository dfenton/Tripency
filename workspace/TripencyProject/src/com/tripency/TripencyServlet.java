package com.tripency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

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
		
	    // Set response content type
	    response.setContentType("text/html");		
	    String jsonStr = request.getParameter("data"); 
	    int numDays = Integer.parseInt(request.getParameter("duration"));
	    System.out.println(jsonStr);
	    
	    
	    WeightingManager weightingMgr = new WeightingManager();	    
	    ArrayList<Theme> userWeightings = weightingMgr.getUserWeightingFromJson(jsonStr); //get user categories weights from JSON string	 
	    userCategories = weightingMgr.getUserCategoriesFromJson(jsonStr); //get user categories from JSON string
	    ArrayList<Attraction> allAttractions = weightingMgr.getAttractionWeightings(userCategories); //get attraction details from the db and their weightings for the categories selected by user
	    
	    
	    MatchManager matchMgr = new MatchManager();
	    matchMgr.setUserTotalTime(numDays);
	    
	    ArrayList<Attraction> itineraryAttractions = matchMgr.getMatchingAttractionsInOrder(userWeightings, allAttractions); //build list of attractions for the user based on user weights
	    Itinerary itinerary = new Itinerary(itineraryAttractions); //add those attractions to an itinerary		
		
	    
	    request.setAttribute("itinerary", itinerary); //send itinerary object to VIEW
	    
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		response.setHeader("Pragma", "no-cache"); 
		response.setDateHeader("Expires", 0); 
		
		
		
		request.getRequestDispatcher("itineraryViewer.jsp").forward(request,response);
		
		
	}

}
