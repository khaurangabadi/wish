package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.utility.DBConnection;

public class PersonDaoImplement implements person {
	
	Connection con;
	PreparedStatement st,st1;
	ResultSet rs,rs1;
	int p_id;
	
	 String aadhar;
	@Override
	public void person_details(String name,String date,String aadhar,String phone,String add) throws SQLException {
		con=DBConnection.getConnection();
		String sql="insert into person(p_name,p_dob,p_adhar,p_phno,p_address) values(?,?,?,?,?)";
	PreparedStatement ps=	con.prepareStatement(sql);
	ps.setString(1, name);
	ps.setString(2, date);
	ps.setString(3, aadhar);
	ps.setString(4, phone);
	ps.setString(5, add);
	
	ps.executeUpdate();
		
	}

	@Override
	public int person_id(String aadhar) throws SQLException {
		
		
		String sql="select p_id from person where p_adhar=?";
	PreparedStatement ps=	con.prepareStatement(sql);
	ps.setString(1, aadhar);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
	 p_id=rs.getInt(1);
	}
	return p_id;
		
	}
	}


