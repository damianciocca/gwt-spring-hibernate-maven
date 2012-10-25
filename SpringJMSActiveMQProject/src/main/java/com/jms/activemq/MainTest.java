package com.jms.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String arg[]){

		ApplicationContext context = new ClassPathXmlApplicationContext("com/jms/activemq/applicationContext-jms.xml");
	}	
}
