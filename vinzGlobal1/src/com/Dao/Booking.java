package com.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import com.utility.DBConnection;

public class Booking implements BookingData{
	Connection con;
	Date d;
	PreparedStatement ps;
	
	
	
	@Override
	public void show_booking(int p_id, int st_id, int city_id, int center_id, int sl_id, Date f_dose) throws SQLException {
		con=DBConnection.getConnection();
		String sq1="{?=call dateadd(?)}";
		CallableStatement cs=con.prepareCall(sq1);
		cs.registerOutParameter(1, Types.DATE);
		cs.setDate(2,new java.sql.Date(f_dose.getTime()));
		boolean b=cs.execute();
		if(b!=true)
		{
			 d=cs.getDate(1);
			
		}
		
		String sql="insert into booking(p_id,st_id,city_id,center_id,sl_id,dose1_date,dose2_Date)values(?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,p_id);
		ps.setInt(2,st_id);
		ps.setInt(3,city_id);
		ps.setInt(4,center_id);
		ps.setInt(5,sl_id);
		ps.setDate(6, new java.sql.Date(f_dose.getTime()));
		ps.setDate(7,new java.sql.Date(d.getTime()));
       	ps.executeUpdate();
		
	}

	@Override
public void confirmation(int p_id, int center_id, int sl_id) throws SQLException {
		
		String sql="select p_name,center_name,dose1_date from booking b inner join person p on b.p_id=p.p_id inner join center ct on b.center_id=ct.center_id inner join slot sl on b.sl_id=sl.sl_id where b.p_id=? and b.center_id=? and b.sl_id=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1,p_id);
		ps.setInt(2,center_id);
		ps.setInt(3,sl_id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
		System.out.println(" congragulations."+rs.getString(1)+" Your boking is confirmed for center..."+rs.getString(2)+"on Date.."+" "+rs.getDate(3));
		
	}
	}
}


