package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	private Date date; //Spring bean property

	static {
		System.out.println("WishMessageGenerator.enclosing_method()");
	}
	//business logic using the injected date class object 
	
	public WishMessageGenerator(Date date) {
		System.out.println("1-param constructor");
		this.date = date;
	}

	public void setDate(Date date) {
		System.out.println("WishMessageGenerator::setDate()");
		this.date = date;
	}

	@SuppressWarnings("deprecation")
	public String generateWishMessage(String user) {
		System.out.println("WishMessageGenerator.generateWishMessage() date=="+date);
		int hour=0;
		//get current hour of the day
		hour=date.getHours(); // gives in 24 hour format
		
		// business logic to generate wish message
		if(hour<12)
			System.out.println("GOOD MORNING::"+user);
		else if(hour<16)
			System.out.println("GOOD AFTERNOON::"+user);		else if(hour<20)
			System.out.println("GOOD EVENING::"+user);
		else
					System.out.println("GOOD NIGHT::"+user);
		return user;
		
	}//main
	

}//class
