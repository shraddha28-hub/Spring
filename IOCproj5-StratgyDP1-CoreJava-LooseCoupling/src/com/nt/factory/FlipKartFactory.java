package com.nt.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.nt.comp.BlueDart;
import com.nt.comp.Courier;
import com.nt.comp.DTDC;
import com.nt.comp.FlipKart;

public class FlipKartFactory {
	private static Properties props;
	  static {
		  InputStream is=null;
		  try {
			  //locate properties using Streams
			  is=new FileInputStream("src/com/nt/commons/info.properties");
			  //load properties file into java.util.properties object
			  props=new Properties();
			  props.load(is);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
              public static FlipKart getInstance() throws Exception
              {
            	  
            	  Courier courier=null;
            	  FlipKart fpkt=null;
            	  //get dependent class and create  class object
            	  courier=(Courier)Class.forName(props.getProperty("sdp.dependent")).newInstance();
            	  
            	  fpkt=new FlipKart();
            	  //assign dependent class object to target class object
            	  fpkt.setCourier(courier);
            	  return fpkt;
              }
}
