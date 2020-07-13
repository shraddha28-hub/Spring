package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.Employee;
import com.nt.beans.Marks;
import com.nt.beans.Student;

public class CResolvingConstructorInjectionTest {
                    public static void main(String[] args) {
						System.out.println("CResolvingConstructorInjectionTest.main()");
						
						BeanFactory factory=null;
						Marks mrk=null;
						Employee emp=null;
						Student stud=null;
						factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
						
						mrk=factory.getBean("mrk",Marks.class);
						System.out.println(mrk);			
						System.out.println("======================================");
						emp=factory.getBean("emp",Employee.class);
						System.out.println(emp);
						System.out.println("=======================================");
						stud=factory.getBean("stud",Student.class);
						System.out.println(stud);
						}
}
