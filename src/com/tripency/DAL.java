package com.tripency;

import java.sql.*;
import java.util.*;

public class DAL {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/tripency";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "Admin1!";

	public ArrayList<Attraction> getAttractionWeightCollection(String userCategories) {
		
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Attraction> attractionCollection = new ArrayList<Attraction>();
		int currentAttractionID = 0;
		Attraction attraction = new Attraction();
		boolean hasAttraction = false;

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);			

			// STEP 4: Execute a query			
			stmt = conn.createStatement();

			String sql = "SELECT * FROM themeweight WHERE themeid in ("+ userCategories +")";
			ResultSet rs = stmt.executeQuery(sql);
			// STEP 5: Extract data from result set
			
			while (rs.next()) {
				
				
				int attractionid = rs.getInt("attractionid");
				int themeid = rs.getInt("themeid");
				double weighting = rs.getDouble("weighting");

				if (currentAttractionID != attractionid){
					
					if (hasAttraction){
						attractionCollection.add(attraction);
					} 
					
					attraction = new Attraction();
					attraction.setId(attractionid);
					
				}
				
				attraction.addCategoryWeight(themeid, weighting);				
				currentAttractionID = attractionid;
				hasAttraction = true;
				

			}
			rs.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try

		
		return attractionCollection;

	}// end main

	public void executeInsert(String value) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection		
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String sql = "INSERT into comment(content)"
						 + "VALUES (?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, value);
			stmt.executeUpdate();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		
	}// end main

	public void executeDelete(String value) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection		
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			// STEP 4: Execute a query			
			String sql = "DELETE FROM comment "
					 + "WHERE id = ?";
		
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, value);
			stmt.executeUpdate();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		
	}// end main
	
	public void executeTruncate() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection		
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String sql = "truncate table comment";
			
			// STEP 4: Execute a query			
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		
	}// end main
	
}// end JDBCExample