package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	private Date date; //Spring bean property

	//setter method to support setter injection process
	public void setDate(Date date) {
		this.date = date;
	}
	
	//business logic using the injected date class object 
	
	public String generateWishMessage(String user) {
		int hour=0;
		//get current hour of the day
		hour=date.getHours(); // gives in 24 hour format
		
		// business logic to generate wish message
		if(hour<12)
			System.out.println("GOOD MORNING::"+user);
		else if(hour<16)
			System.out.println("GOOD AFTERNOON::"+user);
		else if(hour<20)
			System.out.println("GOOD EVENING::"+user);
		else
					System.out.println("GOOD NIGHT::"+user);
		return user;
		
	}//main
	

}//class
