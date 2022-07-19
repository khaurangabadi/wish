package com.Dao;

import java.sql.SQLException;
import java.util.Date;

public interface BookingData {
	void show_booking(int p_id,int st_id,int city_id,int center_id,int sl_id,Date f_dose)throws SQLException;
   void confirmation(int p_id,int center_id,int sl_id)throws SQLException;
}
