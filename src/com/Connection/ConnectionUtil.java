package com.Connection;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionUtil {
	
	public static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/krishna";
		 Connection conn=DriverManager.getConnection(url,"root","krishna");
		return  conn;
		
	}

}
