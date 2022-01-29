package com.training.user.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;
import com.training.user.config.DatabaseConfig;

public class UserService {
	
	DatabaseConfig con = new DatabaseConfig();
	Connection conn;
	Statement stmt;
	CallableStatement cstmt;
	ResultSet rs;
	
	public String getUserById(int userId) {
		
		String QUERY = "CALL P_getUserRecord(?)";
		
		JSONObject response = new JSONObject();
		
		try {
			
			conn = con.setDBConnection();
			cstmt =conn.prepareCall(QUERY);
			cstmt.setInt(1, userId);
			
			rs = cstmt.executeQuery(); 
			// Extract data from result set
			if(rs.next()) {
				
			    // Retrieve by column name
				response.put("user_d",rs.getInt("user_id"));
				response.put("fname", rs.getString("first_name"));
				response.put("lname", rs.getString("last_name"));
				response.put("code", 200);
				response.put("status","success");
				response.put("message","user record exsits" );
				
			}else {
				response.put("code", 500);
				response.put("status","error" );
				response.put("message","user record dose not exsits" );
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response.toString();
		
	}
	
	public void getUserByName() {
		
	}
	
	public void addUser() {
		
	}
	
	public void updateUser(int userId) {
		
	}
	
	public void deleteUser(int userId) {
		
	}

}
