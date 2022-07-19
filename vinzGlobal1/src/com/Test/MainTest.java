package com.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import com.Dao.Booking;
import com.Dao.BookingData;
import com.Dao.CenterDaoImplement;
import com.Dao.CityDaoImplements;
import com.Dao.PersonDaoImplement;
import com.Dao.StateDaoImplement;
import com.Dao.Time;
import com.Dao.TimeSlotDao;
import com.Dao.center;
import com.Dao.city;
import com.Dao.person;
import com.Dao.state;

public class MainTest {

	public static void main(String[] args) throws SQLException, ParseException {
		Scanner sc=new Scanner(System.in);
		
		
		state s=new StateDaoImplement();
		s.showStateDetails();
		System.out.println("Enter state");
		String state=sc.next();
		int state_id=s.stateId(state);
		
		city c=new CityDaoImplements();
		c.showCity(state);
		System.out.println("Enter city");
		String city=sc.next();
		int city_id=c.showCityId(city);
		
		
		center ct=new CenterDaoImplement();
		ct.showCenter(city);
		System.out.println("Enter center");
	     String center =sc.next();
		int center_id=ct.showCenterId(center);
		System.out.println(center_id);
		
	
		System.out.println("Pass a date in given format YYYY-MM-DD");
		System.out.println("Enter date");
		String date1=sc.next();
		ct.showDate(date1);
		Date d1=ct.returnDate();
		Time t=new TimeSlotDao();
		
		
		
		System.out.println("Enter given slot id");
		int sl_id=sc.nextInt();
		t.availabilty(center_id, sl_id);
		
		t.showTimeId(sl_id);
		
		
		
		System.out.println("Enter your name");
		String name=sc.next();
		System.out.println("Enter date_of_birth");
		String date=sc.next();
		System.out.println("Enter aadhar card number");
	 String aadhar=sc.next();
	 System.out.println("Enter phone number");
		String phone=sc.next();
		System.out.println("Enter address");
		String add=sc.next();
		person p=new PersonDaoImplement();
		p.person_details(name,date,aadhar,phone,add);
		int p_id=p.person_id(aadhar);
		System.out.println(p_id);
		BookingData b=new Booking();
		b.show_booking(p_id, state_id,city_id, center_id, sl_id, d1);
	    b.confirmation(p_id, center_id, sl_id);
		
		

	}

}
