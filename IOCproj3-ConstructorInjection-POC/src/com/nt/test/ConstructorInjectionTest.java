package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenerator;

public class ConstructorInjectionTest {
	public static void main(String[] args) {
		System.out.println("ConstructorInjectionTest.main()");
		Resource res=null;
		BeanFactory factory =null;
		WishMessageGenerator generator=null;
		
		//hold name and location of spring bean cfg file
		
		//res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//res= new FileSystemResource("E:\\WorkSpace\\SpringProject\\Spring_Core\\IOCproj3-ConstructorInjection-POC\\src\\com\\nt\\cfgs\\applicationContext.xml");
		res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		// create bean factory IOC container
		factory=new XmlBeanFactory(res);
		//typecasting
		generator= factory.getBean("wmg",WishMessageGenerator.class);
		//invoke b.logic method
		System.out.println(generator.generateWishMessage("shraddha farkiya"));

	}

}
