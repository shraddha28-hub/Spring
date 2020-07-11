package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.comp.Student;

public class Setter_ConstructorInjectionTest {
   public static void main(String[] args) {
	   System.out.println("Setter_ConstructorInjectionTest.main()");
		BeanFactory factory=null;
		Student stud=null;
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		
		stud=factory.getBean("stud",Student.class);
		System.out.println(stud);
	}

}
