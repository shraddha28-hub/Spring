package com.nt.test;

import com.nt.comp.FlipKart;
import com.nt.factory.FlipKartFactory;

public class StratgyDPTest {
                   public static void main(String[] args) {
	                 FlipKart fpkt=null;
	                 try {
	                	 //get target class object using factory
	                 fpkt=FlipKartFactory.getInstance();
	                 }catch(Exception e) {
	                	 e.printStackTrace();
	                 }
	                 //invoke b. method
	                 System.out.println(fpkt.shopping(new String[] {"rain coat","umbrella","flu tablet"},
	                		                                                                         new float[] {5000,2000,450})
	                		                            );
}//main
}//class
