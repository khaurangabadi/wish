package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.utility.DBConnection;

public class StateDaoImplement implements state {
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs,rs1;
	 int state_id;
	 
	Scanner sc=new Scanner(System.in);
	@Override
	public void  showStateDetails() throws SQLException {
		System.out.println("........Select your state....");
		con=DBConnection.getConnection();
		 st=con.createStatement();
		 
		 rs=st.executeQuery("select * from state ");
		while(rs.next())
		{
			System.out.println("          "+rs.getString(2));
		}
	}
	
	
		
		
		
		@Override
		public int stateId(String state) throws SQLException {
			String sql="select * from state where st_name=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, state);
			rs1=ps.executeQuery();
			while(rs1.next())
			{
				 state_id=rs1.getInt(1);
				
			}
		return state_id;
		
		
	}

}
