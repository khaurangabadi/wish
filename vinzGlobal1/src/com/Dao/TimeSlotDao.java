package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.utility.DBConnection;

public class TimeSlotDao implements Time {
	 Scanner sc=new Scanner(System.in);
		Connection con;
		 Statement st2;
		 PreparedStatement st,st1;
		ResultSet rs,rs1;
	     int sl_id,flag=0;
	     String sql;
	@Override
	public void showTimeSlot() throws SQLException {
		con=DBConnection.getConnection();
		
		
		System.out.println("Availabl time slot");
		String sql="select * from slot"; 
	st2=	con.createStatement();
	ResultSet rs=st2.executeQuery(sql);
	
	while(rs.next())
	{
		
		System.out.println(rs.getInt(1)+" "+rs.getTime(2)+" "+rs.getTime(3));
		
		
		
	}
	}
	
	public void availabilty(int center_id,int sl_id) throws SQLException
	
	{
		con=DBConnection.getConnection();
		try(Statement st=con.createStatement();)
		{
			String s="select center_id,sl_id  from booking where center_id=center_id and sl_id=sl_id";
		    rs= st.executeQuery(s);
		 
			   
			   if(rs==null)
			   {
				   flag=1;
				   
			   }
		   
		   
		   if(flag==1)
		   {
			   System.out.println("This slot is already booked....");
			   System.out.println("plz select from available slot");
		   }
		   else
		   {
			   showTimeSlot();
		   }
				   
		
		
		 
		 
	
			 System.out.println("Availabl time slot");
			 System.out.println(sl_id);
				String sql2="select * from slot where sl_id not in(select sl_id from booking where sl_id=sl_id)";
			
			 rs1=st.executeQuery(sql2);
			
			
			
			while(rs1.next())
			{
				
				System.out.println(rs1.getInt(1)+" "+rs1.getTime(2)+" "+rs1.getTime(3));
				
				
				
			}
			
	}catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

	
				   
		 
		
		
	
	
		
	

	@Override
	public int showTimeId(int sl_id) {
		
		  return sl_id;	
	}

}
