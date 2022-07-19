package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utility.DBConnection;

public class CityDaoImplements implements city{
	Connection con;
	PreparedStatement st,st1;
	ResultSet rs,rs1;
	int city_id;
	String city;
	static int c_id;
	@Override
	public void showCity(String state) throws SQLException {
		
			
			System.out.println("........Displaying city...");
		
		
			con=DBConnection.getConnection();
			String sql="select c_name from city c inner join state st on c.st_id=st.st_id where st.st_name=?";
			
			st=con.prepareStatement(sql);
			st.setString(1, state);
		ResultSet rs=st.executeQuery();
			
			 
			while(rs.next())
			{
			
				 city=rs.getString(1);
				System.out.println("........"+city+"..........");
				
			}
		
		
	}

	@Override
	public int showCityId(String city) throws SQLException {
		String sql="select * from city where c_name=?";
		st1=con.prepareStatement(sql);
		st1.setString(1, city);
		rs1=st1.executeQuery();
		while(rs1.next())
		{
			 city_id=rs1.getInt(1);
			
		}
	return city_id;
	}

}
