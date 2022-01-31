package com.training.user.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.json.JSONObject;
import com.training.user.config.DatabaseConfig;
import com.training.user.enumConstant.CommonMessageEnum;

public class UserService {
	
	DatabaseConfig con = new DatabaseConfig();
	Connection conn;
	Statement stmt;
	CallableStatement cstmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public String getUserById(int userId) {
		
		String QUERY = "CALL P_getUserRecord(?)";
		JSONObject response = new JSONObject();
		
		try {
			
			conn = con.setDBConnection();
			cstmt =conn.prepareCall(QUERY);
			cstmt.setInt(1, userId);
			
			rs = cstmt.executeQuery(); 
			// Extract data from result set if record exists
			if(rs.next()) {
				
			    // Retrieve by column name
				response.put("user_d",rs.getInt("user_id"));
				response.put("fname", rs.getString("first_name"));
				response.put("lname", rs.getString("last_name"));
				response.put("code", 200);
				response.put("status","success");
				response.put("message","user record exsits" );
				
			}else {
				response.put("code", 404);
				response.put("status","error" );
				response.put("message","user record dose not exsits" );
			}
			
			rs.close();
			cstmt.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response.toString();
		
	}
	
	
	public String addUser(String payload) {
		
		JSONObject request = new JSONObject(payload);
		JSONObject response = new JSONObject();

		String QUERY = "CALL P_addUserRecord(?, ?, ?, ?);";
		 
		try {
			
			conn  = con.setDBConnection();
			cstmt =conn.prepareCall(QUERY);
			
			cstmt.setString(1, request.getString("fname"));
			cstmt.setString(2, request.getString("lname"));
			cstmt.setString(3, request.getString("email"));
			cstmt.registerOutParameter(4, Types.INTEGER);
			
			 boolean status = cstmt.execute();
			 
			 if (status) {
				 
				 response.put("code", 200);
			     response.put("status", "success");
			     response.put("user_id",cstmt.getInt(4));
			     response.put("message", CommonMessageEnum.RECORD_INSER_SUCCESS.getValue());
	                
	            }else {
	            	
	             response.put("code", 500);
	    		 response.put("status", "error");
	    		 response.put("message", "Error inserting user record");

	            }
			 
			cstmt.close();
			conn.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
	    return response.toString();
		
	}
	
	public String updateUser(int userId, String payload) {
		
		String QUERY = "CALL P_updateUeserRecord(?,?)";
		JSONObject request = new JSONObject(payload);
		JSONObject response = new JSONObject();
		
		try {
			
			conn = con.setDBConnection();
			cstmt =conn.prepareCall(QUERY);
			cstmt.setInt(1, userId);
			cstmt.setString(2, request.getString("email"));
			
			int status = cstmt.executeUpdate();
			// Extract data from result set
			if(status > 0) {
				
			    // Retrieve by column name
				response.put("code", 200);
				response.put("status","success");
				response.put("message","user record updated successfully" );
				
			}else {
				response.put("code", 500);
				response.put("status","error" );
				response.put("message","error updating user record" );
			}
			
			cstmt.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response.toString();
		
	}
	
	public String deleteUser(int userId) {
		
		String QUERY = "DELETE FROM sys_user_m WHERE user_id = ?";
		JSONObject response = new JSONObject();
		
		try {
			
			conn = con.setDBConnection();
			pstmt=conn.prepareStatement(QUERY);
			pstmt.setInt(1, userId);
			
			int status = pstmt.executeUpdate();
			// Extract data from result set
			if(status > 0) {
				
				response.put("code", 200);
				response.put("status","success");
				response.put("message","user record deleted successfully" );
				
			}else {
				response.put("code", 404);
				response.put("status","error" );
				response.put("message","error deleteing user record" );
			}
			
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response.toString();
		
	}

}
