package com.Dao;

import java.sql.SQLException;

public interface Time {
	
	void showTimeSlot()throws SQLException ;
	int showTimeId(int sl_id);
	void availabilty(int center_id,int sl_id)throws SQLException;
	

}
