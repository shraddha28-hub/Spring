package com.nt.test;

import java.lang.reflect.Constructor;

public class NewInstanceTest1 {
               public static void main(String[] args) {
            	   Class c1=null;
            	   Object obj1=null;
            	   Constructor cons[]=null;
            	   try {
            		   //load the class
            		   c1=Class.forName(args[0]);
            		   //get all constructor of the loaded class
            		   
            		   //instantsiate the loaded class
            		 cons=c1.getDeclaredConstructors();
            		   //create object
            		   obj1=cons[0].newInstance(10,20,30);
            		   System.out.println(obj1);
            	   }
            	   catch(InstantiationException ie) {
           			ie.printStackTrace();
           		}
           		catch(ClassNotFoundException cnf) {
           		cnf.printStackTrace();
           		}
           		catch(Exception e) {
           			e.printStackTrace();
           		}
	
}
}
