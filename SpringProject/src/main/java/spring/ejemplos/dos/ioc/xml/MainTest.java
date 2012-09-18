package spring.ejemplos.dos.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	
public static void main(String arg[]){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/dos/ioc/xml/SpringIoC.xml");
		//o bien => XmlBeanFactory context = new XmlBeanFactory(new ClassPathResource("spring/ejemplos/dos/ioc/xml/SpringIoC.xml"));
		EmpleadoBean empleado = (EmpleadoBean) context.getBean("empleadoBean");
		CuentaBean cuenta = empleado.getCuenta();
		System.out.println("Empleado => " + empleado);
		System.out.println("Cuenta 	 => " + cuenta);
	}
}


