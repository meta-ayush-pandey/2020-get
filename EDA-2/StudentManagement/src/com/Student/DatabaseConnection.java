package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class DatabaseConnection {
	
	public static Statement createConnection(String db_name,String user_name,String password)
	{
		Statement stmt = null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/"+db_name,user_name,password);  
			stmt=con.createStatement();
			
		
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return stmt;  
}
}