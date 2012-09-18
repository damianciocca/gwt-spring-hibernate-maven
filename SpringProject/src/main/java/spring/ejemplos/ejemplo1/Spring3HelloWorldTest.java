package spring.ejemplos.ejemplo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring3HelloWorldTest {
	
	public static void main(String arg[]){
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("/src/main/java/spring/ejemplos/ejemplo1/SpringHelloWorld.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringHelloWorld.xml");
		Spring3HelloWorld b = (Spring3HelloWorld) context.getBean("Spring3HelloWorldBean");
		b.sayHello();
		
	
	}

}
