package spring.ejemplos.ejemplo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring3HelloWorldTest {
	
	public static void main(String arg[]){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/ejemplo1/SpringHelloWorld.xml");
		Spring3HelloWorld b = (Spring3HelloWorld) context.getBean("Spring3HelloWorldBean");
		b.sayHello();
		
	}

}
