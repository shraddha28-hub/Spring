package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.PatientVO;

public class CoronaPatientRegisterTest {
                  public static void main(String[] args) {
	                Scanner sc=null;
	                String Patient_name=null,Patient_Address=null,Hospital_Name=null,Patient_Age=null,No_Day=null;
	                String result=null;
	                DefaultListableBeanFactory factory=null;
	                XmlBeanDefinitionReader reader=null;
	                MainController controller=null;
	                PatientVO vo=null;
	                
	                sc=new Scanner(System.in);
	                System.out.println("CORONA REGISTRATION DETAILS::::::::::::");
	                System.out.println("Patient's Name===");
	               Patient_name=sc.next(); 
	                System.out.println("Patient's Address===");
	                Patient_Address=sc.next();
	                System.out.println("Hospital Name===");
	               Hospital_Name= sc.next();
	               System.out.println("Patient's Age===");
	                Patient_Age=sc.next();
	                System.out.println("No of Days Patient in hospital===");
	                No_Day=sc.next();
	                
	                //store input in vo class
	                vo=new PatientVO();
	                vo.setPatient_Name(Patient_name);
	                vo.setPatient_Address(Patient_Address);
	                vo.setHospital_Name(Hospital_Name);
	                vo.setPatient_Age(Patient_Age);
	                vo.setNo_Day(No_Day);
	                
	                //create ioc Container
	               factory=new DefaultListableBeanFactory();
	               reader=new XmlBeanDefinitionReader(factory);
	               reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
	               //get controller class bean object
                   controller=factory.getBean("controller",MainController.class);
                   //invoke method
                   try {
                	   result=controller.processPatient(vo);
                	   System.out.println(result);
                   }catch(Exception e) {
                	   System.out.println("Internal Problem=========");
                	   e.printStackTrace();
                   }
	}
}
