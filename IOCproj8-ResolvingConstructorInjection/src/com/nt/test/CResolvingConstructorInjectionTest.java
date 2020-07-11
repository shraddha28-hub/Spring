package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.Marks;

public class CResolvingConstructorInjectionTest {
                    public static void main(String[] args) {
						System.out.println("CResolvingConstructorInjectionTest.main()");
						
						BeanFactory factory=null;
						Marks mrk=null;
						
						factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
						
						mrk=factory.getBean("mrk",Marks.class);
						System.out.println(mrk);			
						}
}
