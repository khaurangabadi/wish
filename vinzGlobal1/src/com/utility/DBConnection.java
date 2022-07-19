package com.utility;
import java.sql.*;

public class DBConnection {
	
	static Connection dbConnect;
	public static final String url="jdbc:mysql://localhost:3306/vaccines?"+"autoReconnect=true&useSSL=false";
	public static final String user="root";
	public static final String password="khadija";
		
		public static Connection getConnection() {
			
			
			try {
				//Class c=new Class();
				String s="com.mysql.cj.jdbc.Driver";
				Class.forName(s);
				//System.out.println(c);
				
				dbConnect=DriverManager.getConnection(url, user, password);
				//System.out.println("connection established");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dbConnect;
		
			
		
		}
		
		


}
