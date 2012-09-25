package spring.ejemplos.dos.ioc.xml;

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
		
		System.out.println("**********INICIALIZACION CONTEXTO SPRING*********");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/dos/ioc/xml/SpringIoC.xml");
		//o bien => XmlBeanFactory context = new XmlBeanFactory(new ClassPathResource("spring/ejemplos/dos/ioc/xml/SpringIoC.xml"));
		
		System.out.println("**********FIN INICIALIZACION CONTEXTO SPRING*********");
		
		System.out.println("*******************************");
		
		// Una forma de inyectar las dependencias mediante setters
		EmpleadoBean empleado = (EmpleadoBean) context.getBean("empleadoBean");
		CuentaBean cuenta = empleado.getCuenta();
		System.out.println("Empleado => " + empleado);
		System.out.println("Cuenta 	 => " + cuenta);
		
		// Usando ALIAS
		CuentaBean cuenta1 = (CuentaBean) context.getBean("a");
		System.out.println("Cuenta con alias => " + cuenta1);
		
		CuentaBean cuenta2 = (CuentaBean) context.getBean("alias1");
		System.out.println("Cuenta con alias => " + cuenta2);
		
		System.out.println("*******************************");
		
		// Otra forma de inyectar las dependencias mediante constructor
		EmpleadoBean empleado2 = (EmpleadoBean) context.getBean("empleadoBean2");
		CuentaBean cuenta3 = empleado2.getCuenta();
		System.out.println("Empleado2 (otra referencia en memoria) => " + empleado2);
		System.out.println("Cuenta2 (otra referencia en memoria)  => " + cuenta3);
		
		System.out.println("*******************************");
		// Scope Prototype
		PruebaBean pruebaBean = (PruebaBean) context.getBean("pruebaBean");
		System.out.println("PruebaBean  => " + pruebaBean);
		PruebaBean pruebaBean1 = (PruebaBean) context.getBean("pruebaBean");
		System.out.println("PruebaBean (otra referencia en memoria)  => " + pruebaBean1);
		PruebaBean pruebaBean2 = (PruebaBean) context.getBean("pruebaBean");
		System.out.println("PruebaBean (otra referencia en memoria)  => " + pruebaBean2);
		PruebaBean pruebaBean3 = (PruebaBean) context.getBean("pruebaBean");
		System.out.println("PruebaBean (otra referencia en memoria)  => " + pruebaBean3);
		
		System.out.println("*******************************");
		// Inicializacion Perezosa
		EjemploBean eb1 = (EjemploBean) context.getBean("ejemploBean");
		System.out.println("EjemploBean  => " + eb1);
		
		System.out.println("*******************************");
		// Autowiring por tipo 
		ZooBean zoo = (ZooBean) context.getBean("zooBean");
		PruebaBean bean = zoo.getBean();
		System.out.println("ZooBean  => " + zoo);
		System.out.println("PruebaBean  => " + bean);
	}
}


