package spring.ejemplos.dos.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	
public static void main(String arg[]){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/dos/ioc/xml/SpringIoC.xml");
		//o bien => XmlBeanFactory context = new XmlBeanFactory(new ClassPathResource("spring/ejemplos/dos/ioc/xml/SpringIoC.xml"));
		EmpleadoBean b = (EmpleadoBean) context.getBean("empleadoBean");
		
	}


}


