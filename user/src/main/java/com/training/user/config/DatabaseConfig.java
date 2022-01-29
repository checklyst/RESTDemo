package com.training.user.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.training.user.enumConstant.EnumConstant;

public class DatabaseConfig {
	
	public Connection setDBConnection() throws Exception{	
		
		Connection con  = null ;
		
		try
		{
		  		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection(EnumConstant.DB_URL.getValue(), EnumConstant.USER.getValue(), EnumConstant.PASS.getValue());
		
		}
		catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
           e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
        }
		
		return con;
	}


}
