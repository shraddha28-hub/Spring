package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.comp.FlipKart;

public class StratgyDPTest {
                 public static void main(String[] args) {
					BeanFactory factory=null;
					Resource res=null;
					FlipKart fpkt=null;
					
					//hold spring bean cfg file
					res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");
					
					//create IOC container
				   factory =new XmlBeanFactory(res);
				   //get target bean object
				   fpkt=factory.getBean("fpkt",FlipKart.class);
				   //invoke the method
				   System.out.println(fpkt.shopping(new String[] {"PPEkit","MASK","Senitizer"},
						                                                                   new  float[] {400,300,200})
						                               );
				}
}
