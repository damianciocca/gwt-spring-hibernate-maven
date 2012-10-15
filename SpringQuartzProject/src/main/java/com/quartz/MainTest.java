package com.quartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://www.mkyong.com/spring/spring-quartz-scheduler-example/
 * http://www.dosideas.com/wiki/Quartz_Con_Spring
 * 
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String args[]){
		
		new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

}
