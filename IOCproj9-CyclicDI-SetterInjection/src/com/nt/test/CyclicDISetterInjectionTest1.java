package com.nt.test;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.A;
import com.nt.beans.B;

public class CyclicDISetterInjectionTest1 {
	
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader=null;
		
		
		A a1 = null;
		B  b1=null;
		//Create  [IoC] container
		factory = new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Beans class object
		a1 = factory.getBean("a1", A.class);
		System.out.println(a1);
		b1=factory.getBean("b1",B.class);
		System.out.println(b1);
		
	} 

}
