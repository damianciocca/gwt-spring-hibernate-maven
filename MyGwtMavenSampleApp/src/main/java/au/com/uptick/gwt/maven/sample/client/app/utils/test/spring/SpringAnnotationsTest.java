package au.com.uptick.gwt.maven.sample.client.app.utils.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityService;

public class SpringAnnotationsTest {
	
	public static void main(String[] args){

		ApplicationContext context = new ClassPathXmlApplicationContext("/au/com/uptick/gwt/maven/sample/client/app/utils/test/spring/applicationContext.xml");
		
		Component1 c1 = (Component1)context.getBean("C1");
				
		System.out.println("COMPONENT 1: " + c1);
		System.out.println("COMPONENT 2: " + c1.getComponent());
	}

}
