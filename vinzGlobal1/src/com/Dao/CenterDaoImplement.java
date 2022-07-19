package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.utility.DBConnection;

public class CenterDaoImplement implements center{
	Connection con;
	PreparedStatement st,st1;
	ResultSet rs,rs1;
	int center_id,flag=0;
	Date d1;
	Scanner sc=new Scanner(System.in);
	@Override
	public void showCenter(String city) throws SQLException {
		System.out.println("***Select Respective vaccine center for that city******");
		
		
		  con=DBConnection.getConnection();
		
			
			
			System.out.println("........Select your center....");
			
			 
			
			String sql="select center_name from center c inner join city ct on c.city_id=ct.city_id where ct.c_name=?";
			st=con.prepareStatement(sql);
			st.setString(1, city);
			
			rs=st.executeQuery();
				
			while(rs.next())
			{
				
				String center_name=rs.getString(1);
				System.out.println("......."+center_name+"..........");
				
			}
	}
			
		
	

	@Override
	public int showCenterId(String center)  {
		String sql="select * from center where center_name=?";
		
			try(PreparedStatement st1=con.prepareStatement(sql);)
					{
				
				st1.setString(1, center);
				rs1=st1.executeQuery();
				while(rs1.next())
				{
					 center_id=rs1.getInt(1);
					
				}
				
						
					
			
	}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return center_id;
		
	
	}




	@Override
	public void showDate(String date1) throws SQLException, ParseException 
	{
		
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		
	      d1 = sdformat.parse(date1); 
		  
		 Connection  con=DBConnection.getConnection();
		   Statement st= con.createStatement();
		   ResultSet rs=st.executeQuery("select * from holiday");
		   while(rs.next()) {
			 int x=rs.getDate(3).compareTo(d1);
			   
			   if(x==0)
			   {
				 String s=  rs.getString(2);
				 System.out.println("please choose another as it is public holiday due to"+s);
				 date1=sc.next();
			       d1 = sdformat.parse(date1);
			       flag=1;
				   
			   }
			   if(x!=0)
			    {
			    	flag=0;
			    }
			   
			    
		   }
		   if(flag==0)
		   {
			   TimeSlotDao t=new TimeSlotDao();
			   t.showTimeSlot();
			  
		   }
		    
				
	}
		
	




	@Override
	public Date returnDate() {
		return d1;
		
	}
}


