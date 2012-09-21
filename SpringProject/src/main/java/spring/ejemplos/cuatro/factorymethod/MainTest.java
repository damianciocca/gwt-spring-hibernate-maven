package spring.ejemplos.cuatro.factorymethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://www.inmensia.com/articulos/spring/beans_instanciacion_dependencias.html
 * 
 * @author dciocca
 *
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/cuatro/factorymethod/SpringIoC.xml");
		//o bien => XmlBeanFactory context = new XmlBeanFactory(new ClassPathResource("spring/ejemplos/dos/ioc/xml/SpringIoC.xml"));
		
		EmpleadoBean empleado1 = (EmpleadoBean) context.getBean("empleadoBean");
		System.out.println("Empleado 1 => " + empleado1);
		
		EmpleadoBean empleado2 = (EmpleadoBean) context.getBean("empleadoBean");
		System.out.println("Empleado 2 => " + empleado2);

		EmpleadoBean empleado3 = (EmpleadoBean) context.getBean("empleadoBean");
		System.out.println("Empleado 3 => " + empleado3);
		
		EmpleadoBean empleado4 = (EmpleadoBean) context.getBean("empleadoBean2");
		System.out.println("Empleado 4 => " + empleado4);
		
		EmpleadoBean empleado5 = (EmpleadoBean) context.getBean("empleadoBean2");
		System.out.println("Empleado 5 => " + empleado5);

	}
}


