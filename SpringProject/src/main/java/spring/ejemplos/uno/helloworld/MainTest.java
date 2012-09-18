package spring.ejemplos.uno.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	
	public static void main(String arg[]){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/uno/helloworld/SpringHelloWorld.xml");
		Spring3HelloWorld b = (Spring3HelloWorld) context.getBean("Spring3HelloWorldBean");
		b.sayHello();
		
	}

}
