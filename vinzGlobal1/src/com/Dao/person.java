package com.Dao;

import java.sql.SQLException;

public interface person {
	
	void person_details(String name,String date,String aadhar,String ph_no,String add)throws SQLException;
	int person_id(String aadhar)throws SQLException;

}
