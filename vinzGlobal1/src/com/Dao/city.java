package com.Dao;

import java.sql.SQLException;

public interface city {
	
	void showCity(String state) throws SQLException ;
	int showCityId(String city) throws SQLException;

}
