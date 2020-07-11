package com.nt.factory;

import com.nt.comp.ApolloTyre;
import com.nt.comp.BudgetCar;
import com.nt.comp.CEATTyre;
import com.nt.comp.Car;
import com.nt.comp.LuxoryCar;
import com.nt.comp.MRFTyre;
import com.nt.comp.SportsCar;
import com.nt.comp.Tyre;

public class CarFactory {

	//factory method
	public static Car getInstance(String type) {
		Tyre tyre=null;
		Car car=null;
		if(type.equalsIgnoreCase("Luxory")) {
			tyre=new CEATTyre();
			car=new LuxoryCar(tyre);
		}
		else if(type.equalsIgnoreCase("Sports")) {
			tyre=new MRFTyre();
			car=new SportsCar(tyre);
		}
		else if(type.equalsIgnoreCase("budget")) {
			tyre=new ApolloTyre();
			car=new BudgetCar(tyre);
		}
		else 
			throw new IllegalArgumentException("invalid credential");
		
		return car;
	}
}
