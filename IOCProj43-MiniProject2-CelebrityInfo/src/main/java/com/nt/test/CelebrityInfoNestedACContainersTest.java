package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nr.controller.CelebrityInfoMainController;
import com.nt.vo.CelebrityVO;

public class CelebrityInfoNestedACContainersTest {

	public static void main(String[] args) {
		ApplicationContext parentCtx=null,childCtx=null;
		CelebrityInfoMainController controller=null;
		List<CelebrityVO> listVO=null;
		//create parent IOC container
		parentCtx=new ClassPathXmlApplicationContext("com/nt/cfgs/business-beans.xml");
		//create child IOC container
		childCtx=new ClassPathXmlApplicationContext(new String[] {"com/nt/cfgs/presentation-beans.xml"},parentCtx);
		//get Controller class object
		controller=childCtx.getBean("controller",CelebrityInfoMainController.class);
		//invoke method
		System.out.println("...................................................");
		try {
			listVO=controller.gatherCelebrityByDesgs("mumbai","goa", "Banglore");
			//display results
			for(CelebrityVO vo: listVO) {
				System.out.println(vo);
			}
		}//try
		catch(Exception e){
			e.printStackTrace();
		}

		//close containers
		((AbstractApplicationContext) parentCtx).close();
		((AbstractApplicationContext) childCtx).close();

	}//main
}//class