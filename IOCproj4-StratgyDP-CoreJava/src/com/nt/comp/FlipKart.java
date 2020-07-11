package com.nt.comp;

import java.util.Arrays;
import java.util.Random;

public final class FlipKart {
	//property
       private Courier courier=null;

	public void setCourier(Courier courier) {
		this.courier = courier;
	}
	public FlipKart()
	{
		System.out.println("FlipKart::0-param constructor");
	}
       
       //b.method
	public String shopping(String[] items,float[] prices) {
		float billAmt=0.0f;
		int oid=0;
		String msg=null;
		//calculate bill amount
		for(float p:prices)
			billAmt+=p;
		//generate order id dynamically as random number
		oid=new Random().nextInt(10000);
		//use courier service to deliver the products
		msg=courier.deliver(oid);
		
		return Arrays.deepToString(items)+"are purchased having prices"+ Arrays.toString(prices)+"with bill amount"+billAmt+"===="+msg;
		
		
	} 
}
