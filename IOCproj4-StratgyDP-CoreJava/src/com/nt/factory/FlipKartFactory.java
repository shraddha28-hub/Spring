package com.nt.factory;

import com.nt.comp.BlueDart;
import com.nt.comp.Courier;
import com.nt.comp.DTDC;
import com.nt.comp.FlipKart;

public class FlipKartFactory {
              public static FlipKart getInstance(String courierName)
              {
            	  Courier courier=null;
            	  FlipKart fpkt=null;
            	  //create dependent class object
            	  if(courierName.equalsIgnoreCase("dtdc"))
            		  courier=new DTDC();
            	  else  if(courierName.equalsIgnoreCase("blueDart"))
            		  courier=new BlueDart();
            	  else
            		  throw new IllegalArgumentException("invalid argument");
            	  fpkt=new FlipKart();
            	  //assign dependent class object to target class object
            	  fpkt.setCourier(courier);
            	  return fpkt;
              }
}
