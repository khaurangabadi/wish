package com.Dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public interface center {
	public void showCenter(String city)throws SQLException;
	int showCenterId(String city)throws SQLException;
	
	void showDate(String date1)throws SQLException,ParseException;
	Date returnDate();
	
	

}
